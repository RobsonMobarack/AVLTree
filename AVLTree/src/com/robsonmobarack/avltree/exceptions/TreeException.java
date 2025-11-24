package com.robsonmobarack.avltree.exceptions;

/**
 * Generic tree-related exception.
 */
public class TreeException extends RuntimeException {

  public TreeException() {
    super();
  }

  public TreeException(String message) {
    super(message);
  }

  public TreeException(String message, Throwable cause) {
    super(message, cause);
  }

  public TreeException(Throwable cause) {
    super(cause);
  }
}
