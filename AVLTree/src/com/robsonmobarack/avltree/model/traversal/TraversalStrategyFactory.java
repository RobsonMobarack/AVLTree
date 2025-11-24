package com.robsonmobarack.avltree.model.traversal;

import java.util.Objects;

public class TraversalStrategyFactory<T extends Comparable<T>> {

  private final TraversalStrategy<T> inOrder;
  private final TraversalStrategy<T> preOrder;
  private final TraversalStrategy<T> postOrder;
  private final TraversalStrategy<T> levelOrder;

  public TraversalStrategyFactory(
      TraversalStrategy<T> inOrder,
      TraversalStrategy<T> preOrder,
      TraversalStrategy<T> postOrder,
      TraversalStrategy<T> levelOrder) {
    this.inOrder = Objects.requireNonNull(inOrder);
    this.preOrder = Objects.requireNonNull(preOrder);
    this.postOrder = Objects.requireNonNull(postOrder);
    this.levelOrder = Objects.requireNonNull(levelOrder);
  }

  public TraversalStrategy<T> of(TraversalOrder order) {
    return switch (order) {
      case IN_ORDER -> inOrder;
      case PRE_ORDER -> preOrder;
      case POST_ORDER -> postOrder;
      case LEVEL_ORDER -> levelOrder;
    };
  }
}
