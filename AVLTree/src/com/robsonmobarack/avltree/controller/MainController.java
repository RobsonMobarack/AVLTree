package com.robsonmobarack.avltree.controller;

import com.robsonmobarack.avltree.model.traversal.TraversalOrder;
import com.robsonmobarack.avltree.service.TreeService;

/**
 * Main controller connecting View and Service.
 */
public class MainController implements Controller {

  private final TreeService<Integer> service;

  public MainController(TreeService<Integer> service) {
    this.service = service;
  }

  @Override
  public void onInsert(String input) {
    try {
      service.insert(Integer.valueOf(input));
    } catch (NumberFormatException ex) {
      System.err.println("Invalid input: " + input);
    }
  }

  @Override
  public void onRemove(String input) {
    try {
      service.remove(Integer.valueOf(input));
    } catch (NumberFormatException ex) {
      System.err.println("Invalid input: " + input);
    }
  }

  @Override
  public void onClear() {
    service.clear();
  }

  @Override
  public void onTraverse(TraversalOrder order) {
    service.traverse(order);
  }

  @Override
  public void onSave() {
    service.save();
  }

  @Override
  public void onLoad() {
    service.load();
  }
}
