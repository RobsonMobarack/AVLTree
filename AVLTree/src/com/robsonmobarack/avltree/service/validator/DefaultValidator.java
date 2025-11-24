package com.robsonmobarack.avltree.service.validator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Basic validator: no nulls allowed. Extendable to check duplicates, ranges,
 * etc.
 */
public class DefaultValidator<T> implements Validator<T> {

  @Override
  public List<String> validate(T value) {
    List<String> errors = new ArrayList<>();
    if (Objects.isNull(value))
      errors.add("Value cannot be null");
    // extend with duplicate check if Tree reference is provided
    return errors;
  }
}
