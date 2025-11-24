package test.java.com.robsonmobarack.avltree.model;

import com.robsonmobarack.avltree.model.balance.AvlBalancer;
import com.robsonmobarack.avltree.model.balance.AvlRotator;
import com.robsonmobarack.avltree.model.impl.AvlTree;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Basic tests for AvlTree skeleton.
 */
public class AvlTreeTest {

  @Test
  public void testInsertAndFind() {
    var rotator = new AvlRotator<Integer>();
    var balancer = new AvlBalancer<Integer>(rotator);
    var tree = new AvlTree<Integer>(balancer);

    tree.insert(10);
    // TODO: implement find in AvlTree before assertion
    Assertions.assertFalse(tree.isEmpty());
  }
}
