package com.robsonmobarack.avltree.view;

import com.robsonmobarack.avltree.controller.Controller;
import com.robsonmobarack.avltree.dto.TreeDto;
import com.robsonmobarack.avltree.events.TreeChangeListener;

/**
 * Generic view interface. Concrete implementations should be Swing/JavaFX
 * windows.
 */
public interface View<T extends Comparable<T>> extends TreeChangeListener<T> {

  void setController(Controller controller);

  void showMessage(String message);

  void showTree(TreeDto dto);
}
