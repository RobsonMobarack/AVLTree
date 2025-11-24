package com.robsonmobarack.avltree.service.commands;

/**
 * Command pattern for undoable operations.
 */
public interface Command {

  void execute();

  void undo();

  String name();
}
