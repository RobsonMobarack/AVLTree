package com.robsonmobarack.avltree.model;

import java.util.Optional;
import java.util.function.Consumer;

import com.robsonmobarack.avltree.model.traversal.TraversalOrder;

/**
 * Represents a generic binary search tree.
 */
public interface Tree<T extends Comparable<T>> {

  boolean insert(T value);

  boolean remove(T value);

  Optional<T> find(T value);

  int size();

  boolean isEmpty();

  void clear();

  void traverse(TraversalOrder order, Consumer<T> action);
}
