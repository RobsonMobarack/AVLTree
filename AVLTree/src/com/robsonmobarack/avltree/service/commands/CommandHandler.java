package com.robsonmobarack.avltree.service.commands;

/**
 * Handler for executing commands and managing undo/redo stacks.
 */
public interface CommandHandler {

  void execute(Command cmd);

  boolean canUndo();

  void undo();

  boolean canRedo();

  void redo();
}
