package com.robsonmobarack.avltree.persistence.serialization;

import com.robsonmobarack.avltree.model.Tree;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Serializes/deserializes a Tree to/from streams.
 */
public interface TreeSerializer<T extends Comparable<T>> {

  void serialize(Tree<T> tree, OutputStream out) throws IOException;

  Tree<T> deserialize(InputStream in) throws IOException;

  String toString(Tree<T> tree);

  Tree<T> fromString(String s) throws IOException;
}
