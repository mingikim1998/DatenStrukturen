package G23;

public class Node {

	private char character;
	
	private float prob;
	
	private Node left;
	private Node right;
	
	private boolean leaf = false;
	
	public Node(char[] chars, float[] probs, float totalP, int index) {
		//System.out.println("new Node branch");
		//System.out.println("chars[" + index + "] = " + chars[index] + " | probs[" + index + "] = " + probs[index] + " | totalP = " + totalP);
		//new branch node and 1 new leaf node, or 2 new leaf nodes?
		if(index < chars.length - 2) {
			if(probs[index] >= totalP - probs[index]) {
				left = new Node(chars, probs, totalP - probs[index], index + 1);
				right = new Node(chars[index], probs[index]);
			}else {
				right = new Node(chars, probs, totalP - probs[index], index + 1);
				left = new Node(chars[index], probs[index]);
			}
		}else {	
			left = new Node(chars[index + 1], probs[index + 1]);
			right = new Node(chars[index], probs[index]);
		}
	}
	
	public Node(char character, float prob) {
		//System.out.println("new Node leaf");
		this.character = character;
		this.prob = prob;
		leaf = true;
	}

	public boolean isLeaf() {
		return leaf;
	}

	public Node getLeft() {
		return left;
	}

	public Node getRight() {
		return right;
	}

	public char getCharacter() {
		return character;
	}
}
