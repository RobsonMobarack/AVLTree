package com.robsonmobarack.avltree.service.commands;

import com.robsonmobarack.avltree.model.Tree;

/**
 * Command to insert a value into the tree.
 */
public class InsertCommand<T extends Comparable<T>> implements Command {

  private final Tree<T> tree;
  private final T value;
  private boolean executed;

  public InsertCommand(Tree<T> tree, T value) {
    this.tree = tree;
    this.value = value;
    this.executed = false;
  }

  @Override
  public void execute() {
    executed = tree.insert(value);
  }

  @Override
  public void undo() {
    if (executed) {
      tree.remove(value);
    }
  }

  @Override
  public String name() {
    return "Insert " + value;
  }
}
