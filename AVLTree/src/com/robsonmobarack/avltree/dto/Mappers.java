package com.robsonmobarack.avltree.dto;

import com.robsonmobarack.avltree.model.Node;
import com.robsonmobarack.avltree.model.Tree;
import com.robsonmobarack.avltree.model.traversal.TraversalOrder;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Utility mapper converting domain nodes/tree to DTOs.
 * NOTE: Simple strategy using IN_ORDER traversal to collect values.
 */
public class Mappers {

  public static <T extends Comparable<T>> TreeDto toDto(Tree<T> tree) {
    var nodes = new ArrayList<NodeDto>();
    tree.traverse(TraversalOrder.IN_ORDER, value -> {
      var id = UUID.randomUUID().toString();
      nodes.add(new NodeDto(id, String.valueOf(value), null, null));
    });
    return new TreeDto(nodes, tree.size(), 0);
  }

  // For richer mapping, traverse Node<T> structure and record left/right ids.
}
