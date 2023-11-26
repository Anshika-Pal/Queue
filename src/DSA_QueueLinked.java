// Java program to implement a queue using an Linked
class LinkedQueue {
	
	private class Node{
		int data;
		Node next;
		Node(int data){
			this.data=data;
			this.next=null;
		}
	}
	
    private Node front, rear;
    private int size;
 
    public LinkedQueue()
    {
        front = rear = null;
        size = 0;
    }
 
    public int getSize() {
    	return size;
    }
    
    // function to insert an element at the rear of the queue
    public void enqueue(int data)
    {
        Node newNode=new Node(data);
        size++;
        if(front==null) {
        	front=rear=newNode;
        }else {
        	rear.next=newNode;
        	rear=newNode;
        }
        System.out.println(data+" is added to Queue");
    }
 
    // function to delete an element from the front of the queue
    public void dequeue()
    {
        // if queue is empty
        if (front == null) {
            System.out.println("Queue is empty");
            return;
        }
        int value=front.data;
        front=front.next;
        size--;
        System.out.println(value+" is removed from Queue");
    }
 
    // print queue elements
    public void traverse()
    {
        if (front == null) {
            System.out.println("Queue is empty");
            return;
        }
        // traverse queue elements
        System.out.println("Queue Elements are:");
        Node currentNode=front;
        while(currentNode!=null) {
        	System.out.println(currentNode.data);
        	currentNode=currentNode.next;
        }
    }
 
}
public class DSA_QueueLinked {
	public static void main(String[] args) {
		// Create a queue
		LinkedQueue q = new LinkedQueue();
 
        // print Queue elements
        q.traverse();
 
        // inserting elements in the queue
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.enqueue(40);
        q.enqueue(50);
 
        // print Queue elements
        q.traverse();
        
        // removing elements from the queue
        q.dequeue();
        q.dequeue();
        
        System.out.println("after two node deletion");
 
        // print Queue elements
        q.traverse();
	}
}
