package com.robsonmobarack.avltree.controller;

import com.robsonmobarack.avltree.model.traversal.TraversalOrder;

/**
 * Defines the operations triggered by the View.
 */
public interface Controller {

  void onInsert(String input);

  void onRemove(String input);

  void onClear();

  void onTraverse(TraversalOrder order);

  void onSave();

  void onLoad();
}
