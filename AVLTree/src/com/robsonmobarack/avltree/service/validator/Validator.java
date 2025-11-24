package com.robsonmobarack.avltree.service.validator;

import java.util.List;

/**
 * Validates a candidate value for insertion/removal.
 */
public interface Validator<T> {

  /**
   * Returns a list of error messages; empty if valid.
   */
  List<String> validate(T value);
}
