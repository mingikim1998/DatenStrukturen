package assignment6;


public class Node {
	private Vote data;
	private Node next;
	
	// Constructor
	public Node(Object input) {
		this.data = (Vote) input;
	}
	
	public void getData() {
		System.out.println(data);
	}
	
	public void getNext() {
		System.out.println(next);
	}
}

    