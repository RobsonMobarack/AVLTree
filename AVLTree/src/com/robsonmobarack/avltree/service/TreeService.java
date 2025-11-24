package com.robsonmobarack.avltree.service;

import com.robsonmobarack.avltree.events.TreeChangeListener;
import com.robsonmobarack.avltree.model.traversal.TraversalOrder;

import java.util.List;

/**
 * High level facade for tree operations used by controllers.
 */
public interface TreeService<T extends Comparable<T>> {

  boolean insert(T value);

  boolean remove(T value);

  List<T> traverse(TraversalOrder order);

  void clear();

  void save();

  void load();

  void registerListener(TreeChangeListener<T> listener);

  void unregisterListener(TreeChangeListener<T> listener);
}
