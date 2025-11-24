package com.robsonmobarack.avltree.persistence;

import com.robsonmobarack.avltree.model.Tree;
import com.robsonmobarack.avltree.persistence.serialization.TreeSerializer;

import java.io.*;
import java.util.Optional;

/**
 * File-based repository using a serializer.
 */
public class FileTreeRepository<T extends Comparable<T>> implements TreeRepository<T> {

  private final File file;
  private final TreeSerializer<T> serializer;

  public FileTreeRepository(String path, TreeSerializer<T> serializer) {
    this.file = new File(path);
    this.serializer = serializer;
  }

  @Override
  public void save(Tree<T> tree) throws IOException {
    try (var out = new FileOutputStream(file)) {
      serializer.serialize(tree, out);
    }
  }

  @Override
  public Optional<Tree<T>> load() throws IOException {
    if (!file.exists())
      return Optional.empty();
    try (var in = new FileInputStream(file)) {
      return Optional.of(serializer.deserialize(in));
    }
  }

  @Override
  public boolean exists() {
    return file.exists();
  }

  @Override
  public void delete() throws IOException {
    if (file.exists() && !file.delete()) {
      throw new IOException("Failed to delete file: " + file.getAbsolutePath());
    }
  }
}
