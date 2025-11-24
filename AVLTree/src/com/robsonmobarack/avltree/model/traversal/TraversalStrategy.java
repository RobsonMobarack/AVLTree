package com.robsonmobarack.avltree.model.traversal;

import java.util.List;

import com.robsonmobarack.avltree.model.Node;

public interface TraversalStrategy<T extends Comparable<T>> {
  List<T> traverse(Node<T> root);
}
