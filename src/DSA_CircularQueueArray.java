// Java program to implement a circular queue using an array
class ArrayCircularQueue {
    private int front, rear, capacity;
    private int queue[];
    private int size=0;
 
    public ArrayCircularQueue(int c)
    {
        front = rear = 0;
        capacity = c;
        queue = new int[capacity];
    }
 
    // function to insert an element
    // at the rear of the queue
    public void enqueue(int data)
    {
        // check queue is full or not
        if ((capacity == rear && front==0) || (rear == front && front!=0) ) {
            System.out.println("Queue is full");
            return;
        }
        // insert element at the rear
        if(rear==capacity) {
        		rear=0;
        }
        queue[rear] = data;
        System.out.println(data+" is added in Queue");
        rear++;
        size++;
    }
 
    // function to delete an element
    // from the front of the queue
    public void dequeue()
    {
        // if queue is empty
        if (size==0) {
            System.out.println("Queue is empty");
            return;
        }
        if(front==capacity) {
	        	front=0;
	    }
        int value=queue[front];
        front++;
        size--;
        System.out.println(value+" is removed from Queue");
    }
 
    // print queue elements
    public void traverse()
    {
        if (front==0 && rear==0) {
            System.out.println("Queue is empty");
            return;
        }
        // traverse queue elements
        System.out.println("Queue Elements are:");
        if(front<rear) {
	        for (int i = front; i < rear; i++) {
	            System.out.println(queue[i]);
	        }
        }else {
        		for (int i = front; i < capacity; i++) {
	            System.out.println(queue[i]);
	        }
        		for (int i = 0; i < rear; i++) {
    	            System.out.println(queue[i]);
    	        }
        }
    }
 
}

public class DSA_CircularQueueArray {
	public static void main(String[] args) {
		// Create a queue of capacity 4
		ArrayCircularQueue q = new ArrayCircularQueue(4);
 
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.enqueue(40);
        // print Queue elements
        q.traverse();
        
        q.dequeue();
        q.dequeue();
        q.enqueue(50);
        q.enqueue(60);
        // print Queue elements
        q.traverse();
        
        q.dequeue();
        q.enqueue(70);
        q.dequeue();
        q.dequeue();
        
        // print Queue elements
        q.traverse();
 
	}
}
