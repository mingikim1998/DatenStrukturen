package assignment6;


public class VoteList {
   
   
   private Node head;      // what is the first node?
    private Node tail;      // no tail -> last node
    private int size = 0;   // how many nodes are there
    
    
    
    public VoteList(Node head) {      
      this.head = null;    
      } // head reset (?)

   public Node getHead() {
      return head;
   }

   public void setHead(Node head) {
      this.head = head;
   }


   // . Note that the end of the list should be marked by the final Node’s ’next’ attribute pointing to null. 
   // I have problems understanding this sentence.
   
    
    public void add(Object input) {
       
       try {
          Node newNode = new Node(input);
     
          newNode.getNext();  //I am not sure why error appears here.
          head = newNode;         // new node is the head
                        // addFirst -> making the first value
          size++;               
//      
//          if(head.next == null) {
//             tail = head;      // head's next value is the same, then there is one node only        
//             }
          System.out.println("true");    // if no error -> true
          
          } catch(Exception e) {
             System.out.println("false");   // if error false
             }
     }
}     

