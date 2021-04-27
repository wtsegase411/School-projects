/**
 *Class: CMSC204 CRN 32461
 *Program: Assignment 5
 *Instructor: Farnaz Eivazi
 *Summary of Description:This generic Tree node class is used in the MorseCodeTree classes
 *Due Date: 04/28/21
 *Integrity Pledge: I pledge that I have completed the programming assignment independently.
 *I have not copied the code from a student or any source.
 *@author Wengel
 *@param <T> the object to be passed
 */

public class TreeNode<T> {
	public T dataNode;
	public TreeNode<T> left;
	public TreeNode<T> right;

	/**
	 * A constructor that sets the attributes
	 * @param dataNode the data for the current data
	 */
	public TreeNode(T dataNode) {
		this.dataNode=dataNode;
		left=null;
		right=null;
		
	}
	/**
	 * A constructor that makes a deep copy of the current,left and right node 
	 * @param node the node being copied
	 */
	public TreeNode(TreeNode<T> node) {
		left=new TreeNode(node.left.getData());
		right=new TreeNode(node.right.getData());
		dataNode=node.getData();
		
	}
	/**
	 * Returns the data of the current node
	 * @return the data of the current node
	 */
	public T getData() {
		return dataNode;
	}

}
