package binaryTree;

public class test {

	public static void main(String[] args) {
		TreeNode<String> n1 = new TreeNode<String> ("B");
		n1.setLeft(new TreeNode<String> ("A"));
		n1.setRight(new TreeNode<String> ("C"));
		

		TreeNode<String> n2 = new TreeNode<String> ("F");
		n2.setLeft(new TreeNode<String> ("E"));
		n2.setRight(new TreeNode<String> ("G"));


		TreeNode<String> n0 = new TreeNode<String> ("D"); // 바이너리 서치를 위해 중간거를 넣었음
		
		n0.setLeft(n1);
		n0.setRight(n2);

		binaryTree<String> btree = new binaryTree<String>();
		btree.setRoot(n0);
		
		btree.printTreeInOrder();
	}

}
