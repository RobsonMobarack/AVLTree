package com.robsonmobarack.avltree.events;

/**
 * Listener for tree changes to update the UI.
 */
public interface TreeChangeListener<T> {

  void nodeInserted(T value);

  void nodeRemoved(T value);

  void treeCleared();

  void treeChanged();
}
