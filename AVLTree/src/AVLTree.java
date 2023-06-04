import java.util.Stack;

public class AVLTree extends Node{
	private Node root;
	
	public AVLTree() {
		super();
	}

	public AVLTree(Node root) {
		super();
		this.root = root;
	}

	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}
	
	public Node search(Node node, int value) {
		if (node == null)
			return null;
		else if (node.getValue() == value)
			return node;
		else if (value > node.getValue() && node.getRight() != null)
			return search(node.getRight(), value);
		else if (value < node.getValue() && node.getRight() != null)
			return search(node.getLeft().getLeft(), value);
		
		return null;
	}
	
	public void insert(Node node, int value) {
		if (root == null) {
			root = new Node(value);
			root.setBalanceFactor(0);
		}
		
		Stack<Node> nodeStack = new Stack<Node>();
		_insert(node, value, nodeStack);
	}
	
	private void _insert(Node node, int value, Stack<Node> nodeStack) {
		Node aux = null;
		if (value < node.getValue()) {
			if (node.getLeft() == null) {
				node.setLeft(new Node(value));
				checkBalanceFactor(nodeStack, aux);
				return;
			}
			
			nodeStack.push(node);
			System.out.println("nodeStack = " + nodeStack.lastElement().getValue());
			_insert(node.getLeft(), value, nodeStack);
		}
		
		else if (value > node.getValue()) {
			if (node.getRight() == null) {
				node.setRight(new Node(value));
				checkBalanceFactor(nodeStack, aux);
				return;
			}
			
			nodeStack.push(node);
			System.out.println("nodeStack = " + nodeStack.lastElement().getValue());
			_insert(node.getRight(), value, nodeStack);
		}
		else
			System.out.println("O valor já existe na árvore");
	}
	
	public void checkBalanceFactor(Stack<Node> nodeStack, Node node) {
		if (root == null)
			return;
		
		_checkBalanceFactor(nodeStack, node);
	}
	
	private void _checkBalanceFactor(Stack<Node> nodeStack, Node node) {
		// int[] decideRotation = new int[2];
		if(!nodeStack.isEmpty())
			return;
		
		System.out.println("_checkBalanceFactor");
		node = nodeStack.pop();
		System.out.println("POPed - " + node.getValue());
		
		System.out.println("FB - " + (countHeight(node.getLeft(), 1) - countHeight(node.getRight(), 1)));
		node.setBalanceFactor(countHeight(node.getLeft(), 1) - countHeight(node.getRight(), 1));
		
		_checkBalanceFactor(nodeStack, node);
		
		// decideRotation[0] = node.getBalanceFactor();
		
		// if (node.getBalanceFactor() > 1 || node.getBalanceFactor() < -1) {
		//	 System.out.println("Rotação simples");
		// }
	}
	
	public int countHeight(Node node, int height) {
		if (node == null)
			return 0;
			
		if (node.getLeft() != null)
			countHeight(node.getLeft(), height + 1);
		
		if (node.getRight() != null)
			countHeight(node.getRight(), height + 1);
		
		return height;
	}
	
	public void printTree(Node node) {
		if (node.getLeft() != null)
			printTree(node.getLeft());
		
		System.out.print("Valor " + node.getValue());
		System.out.print(" - FB " + node.getBalanceFactor());
		if (node.getLeft() != null)
			System.out.print(" - Left " + node.getLeft().getValue());
		if (node.getRight() != null)
			System.out.print(" - Right " + node.getRight().getValue());
		
		System.out.println();
		
		if (node.getRight() != null)
			printTree(node.getRight());
	}
}
