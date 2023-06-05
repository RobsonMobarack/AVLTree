import java.util.LinkedList;
import java.util.Queue;
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
		
		if (node.getValue() == value)
			return node;
		else if (value > node.getValue() && node.getRight() != null)
			return search(node.getRight(), value);
		else if (value < node.getValue() && node.getLeft() != null)
			return search(node.getLeft(), value);
		
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
		if (value < node.getValue()) {
			if (node.getLeft() == null) {
				node.setLeft(new Node(value));
				nodeQueue.add(node);
				checkBalanceFactor(nodeQueue);
				emergencyAlgorithm(value);
				return;
			}
			
			nodeQueue.add(node);
			_insert(node.getLeft(), value, nodeQueue);
		}
		
		else if (value > node.getValue()) {
			if (node.getRight() == null) {
				node.setRight(new Node(value));
				nodeQueue.add(node);
				checkBalanceFactor(nodeQueue);
				emergencyAlgorithm(value);
				return;
			}
			
			nodeQueue.add(node);
			_insert(node.getRight(), value, nodeQueue);
		}
		else
			System.out.println("O valor já existe na árvore");
	}
	
	private void checkBalanceFactor(Queue<Node> nodeQueue) {
		if (root == null)
			return;
		
		Node node = null;
		_checkBalanceFactor(nodeQueue, node);
	}
	
	private void _checkBalanceFactor(Queue<Node> nodeQueue, Node node) {		
		node = nodeQueue.poll();
		int leftSubtreeHeight;
		int rightSubtreeHeight;
		
		if(node.getLeft() != null) {
			leftSubtreeHeight = countLeftHeight(node.getLeft(), 1);
		}
		else 
			leftSubtreeHeight = 0;
		
		if(node.getRight() != null) {
			rightSubtreeHeight = countRightHeight(node.getRight(), 1);
		}
		else
			rightSubtreeHeight = 0;
		
		node.setBalanceFactor(leftSubtreeHeight - rightSubtreeHeight);
		//System.out.print("  Node " + node.getValue() + " - BF " + node.getBalanceFactor());
		
		if(!nodeQueue.isEmpty())
			_checkBalanceFactor(nodeQueue, node);
		
		return;
	}
	
	public int countLeftHeight(Node node, int height) {
		if (node == null)
			return 0;
			
		if (node.getLeft() != null)
			return countLeftHeight(node.getLeft(), height + 1);
		
		if (node.getRight() != null)
			return countLeftHeight(node.getRight(), height + 1);
		
		return height;
	}
	
	public int countRightHeight(Node node, int height) {
		if (node == null)
			return 0;
			
		if (node.getRight() != null)
			return countRightHeight(node.getRight(), height + 1);
		
		if (node.getLeft() != null)
			return countRightHeight(node.getLeft(), height + 1);
		
		return height;
	}
	
	public int countHeight(Node node, int height) {
		if (node == null)
			return 0;
			
		if (node.getLeft() != null)
			return countHeight(node.getLeft(), height + 1);
		
		if (node.getRight() != null)
			return countHeight(node.getRight(), height + 1);
		
		return height;
	}
	
	private void checkRotation(Node node, Stack<Node> stack) {
		Node parent = null;
		
		if (!stack.isEmpty())
			parent = stack.pop();
		
		if(node.getBalanceFactor() > 1) {
			if(node.getLeft().getBalanceFactor() > 0) {
				if(parent != null)
					parent.setLeft(rightRotation(node));
				else
					rightRotation(node);
				System.out.println();
				System.out.println();
				//printTree(root);
				return;
			}
		}
		
		if(node.getBalanceFactor() < -1) {
			if(node.getRight().getBalanceFactor() < 0) {
				if (parent != null)
					parent.setRight(leftRotation(node));
				else
					leftRotation(node);
				System.out.println();
				System.out.println();
				//printTree(root);
				return;
			}
		}
		
		if (node.getBalanceFactor() > 1) {
			if (node.getLeft().getBalanceFactor() < 0) {
				doubleRightRotation(node);
				System.out.println();
				System.out.println();
				//printTree(root);
				return;
			}
		}
		
		if (node.getBalanceFactor() < -1) {
			if (node.getRight().getBalanceFactor() > 0) {
				doubleLeftRotation(node);
				System.out.println();
				System.out.println();
				//printTree(root);
				return;
			}
		}
	}
	
	private Node leftRotation(Node node) {
		System.out.println("\n\nRotação a esquerda porque FB é negativo e seu filho a direita também tem FB negativo");
		Node aux = node.getRight();
		
		if(aux.getLeft() == null)
			node.setRight(null);
		else
			node.setRight(aux.getLeft());
		
		aux.setLeft(node);
		//node.setRight(null);
		
		if(node == root)
			root = aux;

		return aux;
	}
	
	private Node rightRotation(Node node) {
		System.out.println("\n\nRotação a direita porque FB é positivo e seu filho a esquerda também tem FB positivo");
		Node aux = node.getLeft();
		
		if(aux.getRight() == null)
			node.setLeft(null);
		else
			node.setLeft(aux.getRight());
		
		aux.setRight(node);
		//node.setLeft(null);
		
		
		if(node == root)
			root = aux;

		return aux;
	}
	
	private Node doubleLeftRotation(Node node) {
		System.out.println("\n\nRotação a dupla a esquerda porque FB é negativo e seu filho a direita também tem FB positivo");
		node.setRight(rightRotation(node.getRight()));
		return leftRotation(node);
	}
	
	private Node doubleRightRotation(Node node) {
		System.out.println("\n\nRotação a dupla a esquerda porque FB é positivo e seu filho a esquerda também tem FB negativo");
		node.setLeft(leftRotation(node.getLeft()));
		return rightRotation(node);
	}
	
	private void emergencyAlgorithm(int value) {
		Node node = root;
		Stack<Node> stack = new Stack<Node>();
		
		_emergencyAlgorithm(value, node, stack);
	}
	
	private void _emergencyAlgorithm(int value, Node node, Stack<Node> stack) {
		if (node == null)
			return;
		
		if (value < node.getValue() && node.getLeft() != null) {
			stack.push(node);
			_emergencyAlgorithm(value, node.getLeft(), stack);
		} else if (value > node.getValue() && node.getRight() != null) {
			stack.push(node);
			_emergencyAlgorithm(value, node.getRight(), stack);
		}
		
		stackTreatment(stack);
	}
	
	private void stackTreatment(Stack<Node> stack) {
		if(stack.isEmpty())
			return;
		
		Node node = stack.pop();
		
		if (node.getBalanceFactor() > 1 || node.getBalanceFactor() < -1) {
			checkRotation(node, stack);
		}
		
		stackTreatment(stack);
	}
	
	public void remove(int value) {
		Node node = root;
		
		if(search(node, value) == null) {
			System.out.println("O valor digitado não está na árvore!");
			return;
		}
		
		if(node.getValue() == value) {
			root = null;
			return;
		}
		
		_remove(value, node);
	}
	
	private void _remove(int value, Node node) {		
		if(node.getLeft() != null)
			if(value < node.getLeft().getValue()) {
				_remove(value, node.getLeft());
			} else if (value == node.getLeft().getValue()) {
				if(node.getLeft().getRight() == null)
					node.setLeft(null);
				else
					node.setLeft(node.getLeft().getRight());
			}
		
		if(node.getRight() != null)
			if(value > node.getRight().getValue()) {
				_remove(value, node.getRight());
			} else if (value == node.getRight().getValue()) {
				if(node.getRight().getRight() == null)
					node.setRight(null);
				else
					node.setRight(node.getRight().getRight());
			}
				
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
