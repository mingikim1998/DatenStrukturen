package binaryTree;

public class TreeNode<T> {
	private TreeNode<T> right;
	private TreeNode<T> left;
	private T element;
	
	
	public TreeNode(T element) {
		this.element = element;
		this.right = null;
		this.left = null;
	}
	public TreeNode<T> getRight() {
		return right;
	}
	public void setRight(TreeNode<T> right) {
		this.right = right;
	}
	public TreeNode<T> getLeft() {
		return left;
	}
	public void setLeft(TreeNode<T> left) {
		this.left = left;
	}
	public T getElement() {
		return element;
	}
	public void setElement(T element) {
		this.element = element;
	}
	@Override
	public String toString() {
		return "[" + element + "]";
	}
}
