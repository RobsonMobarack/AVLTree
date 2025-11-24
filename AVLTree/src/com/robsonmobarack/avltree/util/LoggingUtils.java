package com.robsonmobarack.avltree.util;

/**
 * Minimal logging helper. Replace with a logging framework later.
 */
public final class LoggingUtils {

  private LoggingUtils() {
  }

  public static void info(String msg) {
    System.out.println("[INFO] " + msg);
  }

  public static void error(String msg) {
    System.err.println("[ERROR] " + msg);
  }
}
