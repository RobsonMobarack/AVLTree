package com.robsonmobarack.avltree.model.node;

import com.robsonmobarack.avltree.model.Node;

/**
 * Concrete AVL node implementation.
 */
public class AvlNode<T extends Comparable<T>> implements Node<T> {

  private T value;
  private Node<T> left;
  private Node<T> right;
  private int height;

  public AvlNode(T value) {
    this.value = value;
    this.height = 1;
  }

  @Override
  public T getValue() {
    return value;
  }

  @Override
  public Node<T> getLeft() {
    return left;
  }

  @Override
  public Node<T> getRight() {
    return right;
  }

  @Override
  public int getHeight() {
    return height;
  }

  @Override
  public void setLeft(Node<T> left) {
    this.left = left;
  }

  @Override
  public void setRight(Node<T> right) {
    this.right = right;
  }

  @Override
  public void setHeight(int height) {
    this.height = height;
  }
}
