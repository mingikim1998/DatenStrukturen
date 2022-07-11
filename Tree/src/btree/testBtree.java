package btree;

public class testBtree {
	public static void main(String[] args){
		BTree btree = new BTree(2);
		btree.insert(new Integer(1));
		btree.insert(new Integer(2));
		btree.insert(new Integer(3));
		btree.insert(new Integer(8));
		btree.insert(new Integer(4));
		btree.printTree();
		btree.insert(new Integer(5));
		btree.insert(new Integer(6));
		btree.insert(new Integer(7));
		btree.insert(new Integer(9));
		btree.insert(new Integer(10));
		btree.insert(new Integer(11));
		btree.insert(new Integer(12));
		btree.insert(new Integer(13));
		btree.insert(new Integer(14));
		btree.insert(new Integer(15));
		btree.insert(new Integer(16));
		System.out.println("----------");
		btree.printTree();
		System.out.println("----------");
		btree.insert(new Integer(17));
		System.out.println("----------");
		btree.printTree();
		
		
	}
}
