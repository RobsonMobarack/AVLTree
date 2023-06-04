import java.util.LinkedList;
import java.util.Queue;

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
			return;
		}
		
		Queue<Node> nodeQueue = new LinkedList<Node>();
		_insert(node, value, nodeQueue);
	}
	
	private void _insert(Node node, int value, Queue<Node> nodeQueue) {
		Node aux = null;
		if (value < node.getValue()) {
			if (node.getLeft() == null) {
				node.setLeft(new Node(value));
				nodeQueue.add(node);
				checkBalanceFactor(nodeQueue, aux);
				checkRotation(root);
				return;
			}
			
			nodeQueue.add(node);
			checkBalanceFactor(nodeQueue, aux);
			checkRotation(root);
			_insert(node.getLeft(), value, nodeQueue);
		}
		
		else if (value > node.getValue()) {
			if (node.getRight() == null) {
				node.setRight(new Node(value));
				nodeQueue.add(node);
				checkBalanceFactor(nodeQueue, aux);
				checkRotation(root);
				return;
			}
			
			nodeQueue.add(node);
			checkBalanceFactor(nodeQueue, aux);
			checkRotation(root);
			_insert(node.getRight(), value, nodeQueue);
		}
		else
			System.out.println("O valor já existe na árvore");
	}
	
	private void checkBalanceFactor(Queue<Node> nodeQueue, Node node) {
		if (root == null)
			return;
		
		_checkBalanceFactor(nodeQueue, node);
	}
	
	private void _checkBalanceFactor(Queue<Node> nodeQueue, Node node) {		
		node = nodeQueue.poll();
		int leftSubtreeHeight;
		int rightSubtreeHeight;
		
		if(node.getLeft() != null)
			leftSubtreeHeight = countHeight(node.getLeft(), 1);
		else 
			leftSubtreeHeight = 0;
		
		if(node.getRight() != null)
			rightSubtreeHeight = countHeight(node.getRight(), 1);
		else
			rightSubtreeHeight = 0;
		
		System.out.println("Node " + node.getValue() + " - FB " + (leftSubtreeHeight - rightSubtreeHeight));
		node.setBalanceFactor(leftSubtreeHeight - rightSubtreeHeight);
		
		_checkBalanceFactor(nodeQueue, node);
	}
	
	private int countHeight(Node node, int height) {
		if (node == null)
			return 0;
			
		if (node.getLeft() != null)
			return countHeight(node.getLeft(), height + 1);
		
		if (node.getRight() != null)
			return countHeight(node.getRight(), height + 1);
		
		return height;
	}
	
	private void checkRotation(Node node) {
		System.out.println("FB node" + node.getBalanceFactor());
		System.out.println("FB esq node" + node.getLeft().getBalanceFactor());
		System.out.println("Entrou no primeiro if");
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
