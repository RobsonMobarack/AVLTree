package com.robsonmobarack.avltree.model.traversal;

/**
 * Defines traversal orders for a tree.
 */
public enum TraversalOrder {
  IN_ORDER,
  PRE_ORDER,
  POST_ORDER,
  LEVEL_ORDER;

  public static TraversalOrder fromString(String s) {
    if (s == null)
      throw new IllegalArgumentException("order is null");
    return TraversalOrder.valueOf(s.trim().toUpperCase());
  }
}
