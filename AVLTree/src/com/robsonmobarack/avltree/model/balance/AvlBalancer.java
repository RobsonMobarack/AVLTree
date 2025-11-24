package com.robsonmobarack.avltree.model.balance;

import com.robsonmobarack.avltree.model.Node;

/**
 * Implements AVL balancing logic.
 */
public class AvlBalancer<T extends Comparable<T>> implements Balancer<T> {

  private final Rotator<T> rotator;

  public AvlBalancer(Rotator<T> rotator) {
    this.rotator = rotator;
  }

  @Override
  public Node<T> balance(Node<T> node) {
    // TODO: implement AVL balancing (heights, rotations)
    return node;
  }
}
