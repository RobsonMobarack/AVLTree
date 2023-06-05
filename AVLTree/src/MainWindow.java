import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Graphics;

import javax.swing.*;

public class MainWindow implements ActionListener{
	JButton button;
	JTextField textField;
	JPanel treePanel;
	CRD crd = new CRD();
	AVLTree tree = new AVLTree();
	
	public static final int WINDOW_WIDTH = 1024;
	public static final int WINDOW_HEIGHT = 700;
	public static final int NODE_WIDTH = 30;
	public static final int NODE_GAP = 30;
	
	public MainWindow() {
		JFrame frame = new JFrame("Árvore AVL");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		
		JPanel inputPanel = new JPanel();		
		inputPanel.setBounds(0, 0, WINDOW_WIDTH, 36);
		frame.add(inputPanel);
		
		treePanel = new JPanel() {
			public void paint(Graphics g) {
				super.paint(g);
				drawTree(g, tree.getRoot(), WINDOW_WIDTH/2 - NODE_WIDTH/2, WINDOW_HEIGHT/3 - NODE_WIDTH/2, 9, 45);
			}
			
			private void drawTree(Graphics g, Node node, int positionX, int positionY, int horizontalSpace, int verticalSpace) {
				if (node == null)
					return;
				
				int xAdjust = 12;
				if(node.getValue() > 9)
					xAdjust = 8;
				if(node.getValue() > 99)
					xAdjust = 5;
				if(node.getValue() > 999)
					xAdjust = 2;
				
				g.drawOval(positionX, positionY, NODE_WIDTH, NODE_WIDTH);
				g.drawString(Integer.toString(node.getValue()), positionX + xAdjust, positionY + 20);
				
				if(node.getLeft() != null) {
					g.drawLine(positionX + 5, positionY + 25, (int)(positionX - horizontalSpace*Math.pow(2, tree.countHeight(tree.getRoot(), 1) - 1) + 12), positionY + verticalSpace);
					drawTree(g, node.getLeft(), (int)(positionX - horizontalSpace*Math.pow(2, tree.countHeight(tree.getRoot(), 1) - 1)), positionY + verticalSpace, horizontalSpace, verticalSpace);
				}
				if(node.getRight() != null) {
					g.drawLine(positionX + 25, positionY + 25, (int)(positionX + horizontalSpace*Math.pow(2, tree.countHeight(tree.getRoot(), 1) - 1) + 18), positionY + verticalSpace);
					drawTree(g, node.getRight(), (int)(positionX + horizontalSpace*Math.pow(2, tree.countHeight(tree.getRoot(), 1) - 1)), positionY + verticalSpace, horizontalSpace, verticalSpace);
				}
			}
		};

		treePanel.setBackground(Color.white);
		treePanel.setBounds(0, 36, WINDOW_WIDTH, 664);
		
		frame.add(treePanel);
		
		textField = new JTextField();
		textField.setPreferredSize(new Dimension(200, 25));
		inputPanel.add(textField);
		
		textField.addKeyListener(new KeyAdapter() {
		    @Override
		    public void keyPressed(KeyEvent arg0) {
		        if(arg0.getKeyCode() == KeyEvent.VK_ENTER) {
		        	creatReadDelete();
		        }
		    }
		});
		
		button = new JButton("Executa");
		button.addActionListener(this);
		inputPanel.add(button);
		
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == button) {
			creatReadDelete();
		}
	}
	
	public void creatReadDelete() {
		try {
			crd.command(textField, tree);
			textField.setText("");
			treePanel.repaint();
		} catch (Exception e) {
			textField.setText("");
			JOptionPane.showMessageDialog(null, e);
		}
	}
}
