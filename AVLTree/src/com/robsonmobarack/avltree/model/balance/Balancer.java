package com.robsonmobarack.avltree.model.balance;

import com.robsonmobarack.avltree.model.Node;

/**
 * Responsible for balancing nodes in AVL logic.
 */
public interface Balancer<T extends Comparable<T>> {

  Node<T> balance(Node<T> node);
}
