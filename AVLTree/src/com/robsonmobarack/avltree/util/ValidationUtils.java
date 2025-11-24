package com.robsonmobarack.avltree.util;

import java.util.Objects;

/**
 * General validation helpers.
 */
public final class ValidationUtils {

  private ValidationUtils() {
  }

  public static boolean notNull(Object o) {
    return !Objects.isNull(o);
  }
}
