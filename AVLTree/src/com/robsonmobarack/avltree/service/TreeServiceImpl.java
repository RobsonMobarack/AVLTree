package com.robsonmobarack.avltree.service;

import com.robsonmobarack.avltree.events.TreeChangeListener;
import com.robsonmobarack.avltree.model.traversal.TraversalOrder;
import com.robsonmobarack.avltree.model.Tree;
import com.robsonmobarack.avltree.persistence.TreeRepository;
import com.robsonmobarack.avltree.service.commands.CommandHandler;
import com.robsonmobarack.avltree.service.validator.Validator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Default implementation of TreeService.
 */
public class TreeServiceImpl<T extends Comparable<T>> implements TreeService<T> {

  private final Tree<T> tree;
  private final Validator<T> validator;
  private final CommandHandler commandHandler;
  private final TreeRepository<T> repository;
  private final List<TreeChangeListener<T>> listeners = new CopyOnWriteArrayList<>();

  public TreeServiceImpl(Tree<T> tree,
      Validator<T> validator,
      CommandHandler commandHandler,
      TreeRepository<T> repository) {
    this.tree = tree;
    this.validator = validator;
    this.commandHandler = commandHandler;
    this.repository = repository;
  }

  @Override
  public boolean insert(T value) {
    var errors = validator.validate(value);
    if (!errors.isEmpty()) {
      // notify or log - for now we print
      errors.forEach(System.err::println);
      return false;
    }
    boolean ok = tree.insert(value);
    if (ok)
      notifyInserted(value);
    return ok;
  }

  @Override
  public boolean remove(T value) {
    boolean ok = tree.remove(value);
    if (ok)
      notifyRemoved(value);
    return ok;
  }

  @Override
  public List<T> traverse(TraversalOrder order) {
    var result = new ArrayList<T>();
    tree.traverse(order, result::add);
    return result;
  }

  @Override
  public void clear() {
    tree.clear();
    notifyCleared();
  }

  @Override
  public void save() {
    try {
      repository.save(tree);
    } catch (IOException e) {
      throw new RuntimeException("Failed to save tree", e);
    }
  }

  @Override
  public void load() {
    try {
      repository.load().ifPresent(loaded -> {
        // Simple replace strategy: clear and insert all nodes from loaded traverse
        tree.clear();
        loaded.traverse(TraversalOrder.IN_ORDER, tree::insert);
        notifyChanged();
      });
    } catch (IOException e) {
      throw new RuntimeException("Failed to load tree", e);
    }
  }

  @Override
  public void registerListener(TreeChangeListener<T> listener) {
    listeners.add(listener);
  }

  @Override
  public void unregisterListener(TreeChangeListener<T> listener) {
    listeners.remove(listener);
  }

  private void notifyInserted(T value) {
    for (var l : listeners)
      l.nodeInserted(value);
  }

  private void notifyRemoved(T value) {
    for (var l : listeners)
      l.nodeRemoved(value);
  }

  private void notifyCleared() {
    for (var l : listeners)
      l.treeCleared();
  }

  private void notifyChanged() {
    for (var l : listeners)
      l.treeChanged();
  }
}
