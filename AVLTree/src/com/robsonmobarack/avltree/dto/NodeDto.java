package com.robsonmobarack.avltree.dto;

import java.util.Objects;

/**
 * DTO representing a node for the view layer.
 */
public class NodeDto {

  private final String id;
  private final String value;
  private final String leftId;
  private final String rightId;

  public NodeDto(String id, String value, String leftId, String rightId) {
    this.id = id;
    this.value = value;
    this.leftId = leftId;
    this.rightId = rightId;
  }

  public String getId() {
    return id;
  }

  public String getValue() {
    return value;
  }

  public String getLeftId() {
    return leftId;
  }

  public String getRightId() {
    return rightId;
  }

  @Override
  public String toString() {
    return "NodeDto{" +
        "id='" + id + '\'' +
        ", value='" + value + '\'' +
        ", leftId='" + leftId + '\'' +
        ", rightId='" + rightId + '\'' +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;

    var nodeDto = (NodeDto) o;
    return Objects.equals(id, nodeDto.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }
}
