package com.robsonmobarack.avltree.dto;

import java.util.List;

/**
 * DTO representing the whole tree for the view.
 */
public class TreeDto {

  private final List<NodeDto> nodes;
  private final int size;
  private final int height;

  public TreeDto(List<NodeDto> nodes, int size, int height) {
    this.nodes = nodes;
    this.size = size;
    this.height = height;
  }

  public List<NodeDto> getNodes() {
    return nodes;
  }

  public int getSize() {
    return size;
  }

  public int getHeight() {
    return height;
  }
}
