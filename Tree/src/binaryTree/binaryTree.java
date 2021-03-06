package binaryTree;

import java.util.Iterator;

import queue.ListQueue;
import stack.ListStack;

public class binaryTree<T extends Comparable<T>> { // <T> generisch
	private TreeNode<T> root; // wo beginnt der Baum

	public binaryTree(TreeNode<T> root) {
		super();
		this.root = null;
	}
	
	public binaryTree() {
		root = null;
	}

	public TreeNode<T> getRoot() {
		return root;
	}

	public void setRoot(TreeNode<T> root) {
		this.root = root;
	}
	
	public void printTreeInOrder() {
		printTreeInOrder(this.root); // btree.printTreeInOrder() 하면 노드 하나씩 들어가나?
	}
	
	private void printTreeInOrder(TreeNode<T> n) {
		if (n != null) {
			printTreeInOrder(n.getLeft());
//			System.out.println(n.toString());
			System.out.print(n.toString());
			printTreeInOrder(n.getRight());
		}
	}
//	public void printTreeInOrder(TreeNode<T> n) {
//		printTreeInOrder(n.getLeft());
//		System.out.println(n.toString());
//		printTreeInOrder(n.getRight());
//	}
	
	public TreeNode<T> findElementRecursive(TreeNode<T> node, T element){
		if (node==null) { return null;}
		int compareResult = Integer.signum(node.getElement().compareTo(element));
		switch(compareResult) {
		case 0:
			return node;
		case 1:
			return findElementRecursive(node.getLeft(), element);
		case -1:
			return findElementRecursive(node.getRight(), element);
		default:
			return null;
		}
	}
	
	public TreeNode<T> findElementIterative(T element){
		TreeNode<T> node = this.root;
		while (node != null) {
			int compareResult = Integer.signum(node.getElement().compareTo(element));
			switch(compareResult) {
			case 0:
				return node;
			case 1:
				return node = node.getLeft();
				break;
			case -1:
				return node = node.getRight();
				break;
			}
		}
		return null;
	}
	
}
