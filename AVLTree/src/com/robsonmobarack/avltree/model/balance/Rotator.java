package com.robsonmobarack.avltree.model.balance;

import com.robsonmobarack.avltree.model.Node;

/**
 * Defines left/right rotations.
 */
public interface Rotator<T extends Comparable<T>> {

  Node<T> rotateLeft(Node<T> node);

  Node<T> rotateRight(Node<T> node);
}
