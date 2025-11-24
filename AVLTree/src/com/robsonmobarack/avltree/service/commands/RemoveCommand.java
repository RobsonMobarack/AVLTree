package com.robsonmobarack.avltree.service.commands;

import com.robsonmobarack.avltree.model.Tree;

/**
 * Command to remove a value from the tree.
 * NOTE: to fully undo a remove you'd need to persist the removed subtree/value.
 */
public class RemoveCommand<T extends Comparable<T>> implements Command {

  private final Tree<T> tree;
  private final T value;
  private boolean executed;

  public RemoveCommand(Tree<T> tree, T value) {
    this.tree = tree;
    this.value = value;
  }

  @Override
  public void execute() {
    executed = tree.remove(value);
  }

  @Override
  public void undo() {
    if (executed) {
      tree.insert(value); // simple approach; loses original structure
    }
  }

  @Override
  public String name() {
    return "Remove " + value;
  }
}
