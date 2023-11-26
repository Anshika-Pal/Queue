// Java program to implement a priority queue 
class QueuePriority {
	
	private class Node{
		int data;
		int priority;
		Node next;
		Node(int data,int priority){
			this.data=data;
			this.priority=priority;
			this.next=null;
		}
	}
	
    private Node front, rear;
    private int size;
 
    public QueuePriority()
    {
        front = rear = null;
        size = 0;
    }
 
    public int getSize() {
    	return size;
    }
    
    // function to insert an element at the rear of the queue
    public void enqueue(int data,int priority)
    {
        Node newNode=new Node(data,priority);
        size++;
        if(front==null) {
        	front=rear=newNode;
        }else {
        	if(newNode.priority < front.priority) {
        		newNode.next=front;
        		front=newNode;
        	}else if(newNode.priority > rear.priority) {
        		rear.next=newNode;
        		rear=newNode;
        	}else {
        		Node currentNode=front;
        		do {
        			if(newNode.priority==currentNode.priority) {
        				System.out.println("Priority Already Exist!");
        				break;
        			}
        			if(newNode.priority<currentNode.next.priority) {
        				newNode.next=currentNode.next;
        				currentNode.next=newNode;
        				break;
        			}
        			currentNode=currentNode.next;
        		}while(currentNode!=rear);
        	}
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
    
 // function to delete an element from the queue according to priority
    public void dequeue(int priority)
    {
        // if queue is empty
        if (front == null) {
            System.out.println("Queue is empty");
            return;
        }
        if(priority==front.priority) {
    		front=front.next;
    		return;
    	}
        Node currentNode=front.next;
        Node prevNode=front;
        do {
        	if(priority==currentNode.priority) {
        		prevNode.next=currentNode.next;
        		if(currentNode==rear) {
        			rear=prevNode;
        		}
        		System.out.println(currentNode.data+" is removed from Queue");
        		break;
        	}
        	prevNode=currentNode;
        	currentNode=currentNode.next;
        	
		}while(currentNode!=null);
        
        
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
        do {
        	System.out.println(currentNode.data);
        	currentNode=currentNode.next;
        }while(currentNode!=null);
    }
 
}

public class DSA_PriorityQueue {
	public static void main(String[] args) {
		// Create a queue
		QueuePriority q = new QueuePriority();
 
        // print Queue elements
        q.traverse();
 
        // inserting elements in the queue
        q.enqueue(10,1);
        q.enqueue(20,5);
        q.enqueue(30,2);
        q.enqueue(40,8);
        q.enqueue(50,9);
        q.enqueue(60,3);
        q.enqueue(70,3);
 
        // print Queue elements
        q.traverse();
        
        // removing elements from the queue
        q.dequeue();
        q.dequeue(8);
        
        System.out.println("after two node deletion");
 
        // print Queue elements
        q.traverse();
	}
}
