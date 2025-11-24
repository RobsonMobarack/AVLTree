package com.robsonmobarack.avltree.exceptions;

/**
 * Thrown when a node is not found during an operation.
 */
public class NodeNotFoundException extends TreeException {

  public NodeNotFoundException() {
    super();
  }

  public NodeNotFoundException(String message) {
    super(message);
  }
}
