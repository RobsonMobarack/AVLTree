import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class MainWindow implements ActionListener{
	JButton button;
	JTextField textField;
	CRD crd = new CRD();
	
	public static final int WINDOW_WIDTH = 1024;
	public static final int WINDOW_HEIGHT = 700;
	public static final int NODE_WIDTH = 30;
	public static final int NODE_GAP = 30;
	
	public MainWindow(Node root) {
		JFrame frame = new JFrame("Árvore AVL");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		
		// JPanel backGroundPanel = new JPanel();
		// backGroundPanel.setBackground(Color.darkGray);
		// frame.add(backGroundPanel);
		
		JPanel inputPanel = new JPanel();
		inputPanel.setBackground(Color.darkGray);
		inputPanel.setBounds(0, 0, WINDOW_WIDTH, 36);
		frame.add(inputPanel);
		
		JPanel treePanel = new JPanel();
		treePanel.setBackground(Color.blue);
		treePanel.setBounds(0, 36, WINDOW_WIDTH, 664);
		frame.add(treePanel);
		
		textField = new JTextField();
		textField.setBackground(new Color(30, 30, 30));
		textField.setForeground(Color.white);
		textField.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.gray));
		textField.setPreferredSize(new Dimension(200, 25));
		textField.setCaretColor(Color.white);
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
			crd.command(textField);
			textField.setText("");
			// tree.Panel.repaint();
		} catch (Exception e) {
			textField.setText("");
			JOptionPane.showMessageDialog(null, "Digite um comando válido!");
		}
	}
}
