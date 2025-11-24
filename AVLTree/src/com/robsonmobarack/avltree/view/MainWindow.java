package com.robsonmobarack.avltree.view;

import com.robsonmobarack.avltree.controller.Controller;
import com.robsonmobarack.avltree.dto.TreeDto;

import java.awt.Color;

import javax.swing.*;

/**
 * Basic Swing window skeleton. Implement UI wiring here.
 */
public class MainWindow implements View<Integer> {

  public static final int WINDOW_WIDTH = 1024;
	public static final int WINDOW_HEIGHT = 700;
	public static final int NODE_WIDTH = 30;
	public static final int NODE_GAP = 30;

  private Controller controller;
  private JFrame frame;
  private JPanel inputPanel;

  public MainWindow() {
    initUI();
  }

  private void initUI() {
    frame = new JFrame("AVL Tree");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
    frame.setResizable(false);
    frame.setLocationRelativeTo(null);

    // TODO: layout controls, TreePanel, input fields, buttons
    inputPanel = new JPanel();
    inputPanel.setBackground(Color.white);
    inputPanel.setBounds(0, 0, WINDOW_WIDTH, 36);  // 36 is a magic number
    frame.add(inputPanel);

    frame.setVisible(true);
  }

  @Override
  public void setController(Controller controller) {
    this.controller = controller;
    // wire buttons to controller events
  }

  @Override
  public void showMessage(String message) {
    JOptionPane.showMessageDialog(frame, message);
  }

  @Override
  public void showTree(TreeDto dto) {
    // TODO: render DTO in TreePanel
    System.out.println("Tree DTO: " + dto);
  }

  // TreeChangeListener methods (simple delegation)
  @Override
  public void nodeInserted(Integer value) {
    showMessage("Inserted: " + value);
  }

  @Override
  public void nodeRemoved(Integer value) {
    showMessage("Removed: " + value);
  }

  @Override
  public void treeCleared() {
    showMessage("Tree cleared");
  }

  @Override
  public void treeChanged() {
    showMessage("Tree changed");
  }
}
