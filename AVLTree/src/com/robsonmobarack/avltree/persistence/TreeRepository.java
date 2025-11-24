package com.robsonmobarack.avltree.persistence;

import com.robsonmobarack.avltree.model.Tree;

import java.io.IOException;
import java.util.Optional;

/**
 * Repository abstraction for Tree persistence.
 */
public interface TreeRepository<T extends Comparable<T>> {

  void save(Tree<T> tree) throws IOException;

  Optional<Tree<T>> load() throws IOException;

  boolean exists();

  void delete() throws IOException;
}
