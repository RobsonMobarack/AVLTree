package com.robsonmobarack.avltree.events;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Simple synchronous event bus for TreeChangeListener events.
 */
public class EventBus<T> {

  private final List<TreeChangeListener<T>> listeners = new CopyOnWriteArrayList<>();

  public void register(TreeChangeListener<T> listener) {
    listeners.add(listener);
  }

  public void unregister(TreeChangeListener<T> listener) {
    listeners.remove(listener);
  }

  public void fireInserted(T value) {
    for (var l : listeners)
      l.nodeInserted(value);
  }

  public void fireRemoved(T value) {
    for (var l : listeners)
      l.nodeRemoved(value);
  }

  public void fireCleared() {
    for (var l : listeners)
      l.treeCleared();
  }

  public void fireChanged() {
    for (var l : listeners)
      l.treeChanged();
  }
}
