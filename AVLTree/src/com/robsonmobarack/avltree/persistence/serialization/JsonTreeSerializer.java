package com.robsonmobarack.avltree.persistence.serialization;

import com.robsonmobarack.avltree.model.Tree;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * JSON serializer skeleton. Integrate Jackson/Gson as needed.
 */
public class JsonTreeSerializer<T extends Comparable<T>> implements TreeSerializer<T> {

  @Override
  public void serialize(Tree<T> tree, OutputStream out) throws IOException {
    // TODO: implement using a JSON library
    throw new UnsupportedOperationException("JSON serialization not implemented");
  }

  @Override
  public Tree<T> deserialize(InputStream in) throws IOException {
    // TODO: parse JSON, construct a Tree (e.g., AvlTree)
    throw new UnsupportedOperationException("JSON deserialization not implemented");
  }

  @Override
  public String toString(Tree<T> tree) {
    // TODO
    return "";
  }

  @Override
  public Tree<T> fromString(String s) throws IOException {
    // TODO
    throw new UnsupportedOperationException("Not implemented");
  }
}
