package com.robsonmobarack.avltree.model.impl;

import com.robsonmobarack.avltree.model.*;
import com.robsonmobarack.avltree.model.balance.Balancer;
import com.robsonmobarack.avltree.model.node.AvlNode;
import com.robsonmobarack.avltree.model.traversal.TraversalOrder;

import java.util.Optional;
import java.util.function.Consumer;

/**
 * AVL tree implementation with balancing and rotation.
 */
public class AvlTree<T extends Comparable<T>> implements Tree<T> {

  private Node<T> root;
  private final Balancer<T> balancer;

  public AvlTree(Balancer<T> balancer) {
    this.balancer = balancer;
  }

  @Override
  public boolean insert(T value) {
    root = insertRecursive(root, value);
    return true;
  }

  private Node<T> insertRecursive(Node<T> node, T value) {
    if (node == null)
      return new AvlNode<>(value);
    // TODO: implement AVL insertion
    return node;
  }

  @Override
  public boolean remove(T value) {
    // TODO: implement AVL removal
    return false;
  }

  @Override
  public Optional<T> find(T value) {
    // TODO: implement search
    return Optional.empty();
  }

  @Override
  public int size() {
    // TODO
    return 0;
  }

  @Override
  public boolean isEmpty() {
    return root == null;
  }

  @Override
  public void clear() {
    root = null;
  }

  @Override
  public void traverse(TraversalOrder order, Consumer<T> action) {
    // TODO: delegate to traversal strategies
  }
}
