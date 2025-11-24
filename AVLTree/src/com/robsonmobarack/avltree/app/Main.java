package com.robsonmobarack.avltree.app;

import com.robsonmobarack.avltree.controller.MainController;
import com.robsonmobarack.avltree.model.impl.AvlTree;
import com.robsonmobarack.avltree.model.balance.AvlBalancer;
import com.robsonmobarack.avltree.model.balance.AvlRotator;
import com.robsonmobarack.avltree.service.TreeServiceImpl;
import com.robsonmobarack.avltree.service.commands.CommandHandlerImpl;
import com.robsonmobarack.avltree.service.validator.DefaultValidator;
import com.robsonmobarack.avltree.persistence.FileTreeRepository;
import com.robsonmobarack.avltree.persistence.serialization.JsonTreeSerializer;
import com.robsonmobarack.avltree.view.MainWindow;

public class Main {

  /**
   * Entry point. Performs manual dependency injection.
   */
  public static void main(String[] args) {

    var rotator = new AvlRotator<Integer>();
    var balancer = new AvlBalancer<Integer>(rotator);
    var avlTree = new AvlTree<Integer>(balancer);

    var validator = new DefaultValidator<Integer>();
    var cmdHandler = new CommandHandlerImpl();
    var serializer = new JsonTreeSerializer<Integer>();
    var repo = new FileTreeRepository<Integer>("tree.json", serializer);

    var service = new TreeServiceImpl<>(avlTree, validator, cmdHandler, repo);

    var controller = new MainController(service);

    var view = new MainWindow();
    view.setController(controller);

    service.registerListener(view);
  }
}
