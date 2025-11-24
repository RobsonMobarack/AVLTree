package com.robsonmobarack.avltree.model;

/**
* Represents a node in a binary tree.
*/
public interface Node<T> {

  T getValue();

  Node<T> getLeft();
  Node<T> getRight();

  int getHeight();

  void setLeft(Node<T> left);
  void setRight(Node<T> right);
  void setHeight(int height);
}
