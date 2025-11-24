package com.robsonmobarack.avltree.util;

import com.robsonmobarack.avltree.model.Node;

/**
 * Helper utilities for Node operations.
 */
public class NodeUtils {

  public static <T extends Comparable<T>> int height(Node<T> node) {
    return node == null ? 0 : node.getHeight();
  }

  public static <T extends Comparable<T>> int balanceFactor(Node<T> node) {
    if (node == null)
      return 0;
    return height(node.getLeft()) - height(node.getRight());
  }
}
