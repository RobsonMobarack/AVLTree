package com.robsonmobarack.avltree.service.commands;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Simple command handler keeping undo/redo stacks.
 */
public class CommandHandlerImpl implements CommandHandler {

  private final Deque<Command> undoStack = new ArrayDeque<>();
  private final Deque<Command> redoStack = new ArrayDeque<>();

  @Override
  public void execute(Command cmd) {
    cmd.execute();
    undoStack.push(cmd);
    redoStack.clear();
  }

  @Override
  public boolean canUndo() {
    return !undoStack.isEmpty();
  }

  @Override
  public void undo() {
    if (!canUndo())
      return;
    var cmd = undoStack.pop();
    cmd.undo();
    redoStack.push(cmd);
  }

  @Override
  public boolean canRedo() {
    return !redoStack.isEmpty();
  }

  @Override
  public void redo() {
    if (!canRedo())
      return;
    var cmd = redoStack.pop();
    cmd.execute();
    undoStack.push(cmd);
  }
}
