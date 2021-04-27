import java.util.ArrayList;
/**
 *Class: CMSC204 CRN 32461
 *Program: Assignment 5
 *Instructor: Farnaz Eivazi
 *Summary of Description: A generic linked binary tree which inherits from the LinkedConverterTreeInterface
 *Due Date: 04/28/21
 *Integrity Pledge: I pledge that I have completed the programming assignment independently.
 *I have not copied the code from a student or any source.
 *@author Wengel
 */
 class MorseCodeTree implements LinkedConverterTreeInterface<String> {
	public TreeNode<String> root;
	/**
	 * A constructor that calls the build tree method
	 */
	public MorseCodeTree() {
		buildTree();
	}
	/**
	 * A method that returns a reference to the root
	 * @return root the root node
	 */

	@Override
	public TreeNode<String> getRoot() {
		return root;
	}
	/**
	 * A method that sets the root
	 * @param newNode the node to be set
	 */

	@Override
	public void setRoot(TreeNode<String> newNode) {
		root=newNode;

	}
	@Override
	/**
	 * A method used to insert a node
	 * @param code the code being converted
	 * @param result the result of the code converted
	 * @return the morse code tree
	 */
	public MorseCodeTree insert(String code, String result) {
		if (this.root==null) {
			root=new TreeNode<>(result);
		}
		else {
			addNode(root,code,result);
		}

		return this;
	}
	/**
	 * A method to add a a node 
	 * @param root the tree node
	 * @param code the code to be converted
	 * @param letter the letter that has been converted
	 */
	@Override
	public void addNode(TreeNode<String> root, String code, String letter) {
		
		if (code.length()>1) {
			if (code.charAt(0)=='.') {
				addNode(root.left,code.substring(1),letter);
			}
			else {
				addNode(root.right,code.substring(1),letter);
			}
			
		}
		else
		if (code.equals(".")) {
			root.left=new TreeNode<String>(letter);
		}
		else if(code.equals("-")) {
			root.right=new TreeNode<String>(letter);
		}

	}
	/**
	 * A method that calls the fetchNode method
	 * @param code the code 
	 * @return the data of the tree node
	 */
	@Override
	public String fetch(String code) {
		return fetchNode(root,code);
	}
	/**
	 * A method that fetches the data of the tree node 
	 * @param root the root node
	 * @param code the code
	 * @return the data of the tree node
	 */
	@Override
	public String fetchNode(TreeNode<String> root, String code) {
		if (code.length()>1) {
			if(code.charAt(0)=='.') {
				return fetchNode(root.left,code.substring(1));
			}
			else {
				return fetchNode(root.right,code.substring(1));
			}
		}
		else {
			if(code.equals(".")) {
				return root.left.getData();
			}
			else {
				return root.right.getData();
			}
		}

		
	}
	/**
	 * This method is unsupported for this class
	 * @param data the data being passed
	 * @throws UnsupportedOperationException the exception being thrown 
	 */
	@Override
	public MorseCodeTree delete(String data) throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}
	/**
	 * This method is unsupported for this class
	 * @throws UnsupportedOperationException the exception being thrown 
	 */
	@Override
	public MorseCodeTree update() throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}
	/**
	 * A method to build the tree using the insert method
	 */
	@Override
	public void buildTree() {
		insert("","");
		insert(".","e"); insert("-","t");
		insert("..","i"); insert(".-","a"); insert("-.","n"); insert("--","m");
		insert("...","s"); insert("..-","u"); insert(".-.","r");insert(".--","w");insert("-..", "d");insert("-.-","k");insert("--.","g");insert("---","o");
		insert("....","h"); insert("...-","v");insert("..-.","f");insert(".-..","l");insert(".--.","p");insert(".---","j");insert("-...","b");insert("-..-","x");insert("-.-.","c");insert("-.--","y");insert("--..","z");insert("--.-","q");
		


	}
	/**
	 * A method to convert the tree to an Array list using the LNR method
	 * @return str the Array list of the items
	 */
	@Override
	public ArrayList<String> toArrayList() {
		ArrayList<String> str=new ArrayList<>();
		 LNRoutputTraversal(root,str);
		 return str;
		 
	}
	/**
	 * A method to put the tree into an array list
	 * @param root the root node 
	 * @param list the array list 
	 */
	@Override
	public void LNRoutputTraversal(TreeNode<String> root, ArrayList<String> list) {
		if(root==null) {
			return;
		}
		LNRoutputTraversal(root.left,list);
		list.add(root.getData());
		LNRoutputTraversal(root.right,list);
	}


}
