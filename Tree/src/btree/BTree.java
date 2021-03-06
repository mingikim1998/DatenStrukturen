package btree;

import java.util.Vector;

public class BTree {
	class Node{
		// KnotenTypen
		public static final int LEAF_PAGE = 0;
		public static final int NODE_PAGE = 1;
		
		// SucherErgibnisse
		public static final int KEY_FOUND = -1;
		public static final int KEY_NOT_FOUND = -2;
		
		Node parent = null;
		Vector<Comparable> elements;
		Vector<Node> pointers;
		int nodetype;
		
		public Node (int nodetype) {
			this.nodetype = nodetype;
			elements = new Vector<Comparable>();
			pointers = (nodetype == NODE_PAGE ? new Vector<Node>(): null);
		}
		
		public void setNodeType(int nodetype) {
			this.nodetype = nodetype;
			if (pointers == null && nodetype == NODE_PAGE)
				pointers = new Vector<Node>();
		}
		
		public Comparable getElement(int index) {
			return elements.get(index);
		}
		
		public Node getPointer(int index) {
			return pointers.get(index);
		}
		public int getNumElements() {
			return elements.size();
		}
		public Node getParent() {
			return parent;
		}
		public boolean insertIntoNode(Comparable element, Node leftNode, Node rightNode) {
			boolean done = false;
			for (int i=0; i<elements.size(); i++) {
				int result = elements.get(i).compareTo(element);
				if (result == 0) {
					done = true;
					break;
				} else if (result > 0){
					elements.insertElementAt(element,i);
					if (rightNode != null) {
						pointers.insertElementAt(rightNode, i+1);
						rightNode.parent = this;
					}
					done = true;
					break;
				}
			}
			if (!done)
				// element kommt ans Ende
			if (leftNode != null && pointers.isEmpty()) {
				pointers.add(leftNode);
				leftNode.parent = this;
			}
			if (rightNode != null) {
				pointers.add(rightNode);
				rightNode.parent = this;
			}
			return elements.size() > degree*2;
			
		}
		public int findKeyInNode(Comparable element, Comparable[] key) {
			for (int i =0; i<elements.size(); i++) {
				int result = elements.get(i).compareTo(element);
				if (result == 0) {
					key[0] = elements.get(i);
					return KEY_FOUND;
				}
				else if (result > 0) {
					return nodetype == NODE_PAGE ? i : KEY_NOT_FOUND;
				}
			}
			return (nodetype == NODE_PAGE ? elements.size() : KEY_NOT_FOUND);
		}

		public Node split() {
			int position = getNumElements() / 2;
			Node sibling = new Node(nodetype);
			for (int i =position +1; i<getNumElements(); i++) {
				sibling.elements.add(this.getElement(i));
				if (nodetype == Node.NODE_PAGE)
					sibling.pointers.add(this.getPointer(i));
			}
			if (nodetype == Node.NODE_PAGE)
				sibling.pointers.add(this.getPointer(getNumElements()));
			for (int i = getNumElements() - 1; i>= position; i--) {
				elements.remove(position);
				if (nodetype == Node.NODE_PAGE)
					pointers.remove(position+1);
			}
			return sibling;
		}
		public void print(int depth) {
			for (int i=0; i<depth;  i++) {
				System.out.println(" ");
			}
			for (int i=0; i < elements.size(); i++) {
				System.out.print("|" + elements.get(i));
			}
			System.out.println("|" + (pointers != null ? "size=" + pointers.size() : ""));
			if (nodetype == NODE_PAGE) {
				for (int i=0; i<pointers.size(); i++) {
					Node n = pointers.get(i);
					n.print(depth + 1);
				}
			}
		}
	}
	
	private int degree;
	private Node root = null;
	public BTree(int degree) {
		this.degree = degree;
		root = new Node(Node.LEAF_PAGE);
	}
	
	
	public void insert(Comparable element) {
		Node leftSibling = null;
		Node rightSibling = null;
		
		Node node = findLeafNode(element);
		
		while (node.insertIntoNode(element, leftSibling, rightSibling)){
			int position = node.getNumElements()/2;
			element = node.getElement(position);
			Node parent = node.getParent();
			if (parent == null) {
				parent = new Node(Node.NODE_PAGE);
			}
			leftSibling = node;
			rightSibling = node.split();
			
			if (root == node) {
				root = parent;
			}
			
			node = parent;
			node.setNodeType(Node.NODE_PAGE);
		}
		
	}
	private Node findLeafNode(Comparable element) {
		Node node = root;
		Comparable[] key = {null};
		
		while (node.nodetype != Node.LEAF_PAGE) {
			assert(!node.pointers.isEmpty());
			node = node.getPointer(node.findKeyInNode(element, key));
			
		}
		return node;
	}
	
	public void printTree() {
		root.print(0);
	}
}
