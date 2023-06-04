import javax.swing.JTextField;

public class CRD {
	AVLTree tree = new AVLTree();
	
	public void command(JTextField textField) {
		String userInput = textField.getText();
		
		String[] userInputArray = userInput.split(" ");
		userInput = userInputArray[0].toLowerCase();
		int value = Integer.parseInt(userInputArray[1]);
		
		switch(userInput) {
			case "insert":
				tree.insert(tree.getRoot(), value);
				tree.printTree(tree.getRoot());
				break;
			case "remove":
				// tree.remove(tree.getRoot(), value);
				System.out.println("Removing " + value);
				break;
			case "search":
				Node searchResult = tree.search(tree.getRoot(), value);
				if(searchResult != null)
					System.out.println("Resultado da busca do valor " + value + " = " + searchResult.getValue());
				else
					System.out.println("Resultado da busca do valor " + value + " = null");
				break;
		}
	}
}
