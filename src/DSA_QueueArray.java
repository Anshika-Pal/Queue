// Java program to implement a queue using an array
class ArrayQueue {
    private int front, rear, capacity;
    private int queue[];
 
    public ArrayQueue(int c)
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
        if (capacity == rear) {
            System.out.println("Queue is full");
            return;
        }
        // insert element at the rear
        queue[rear] = data;
        rear++;
    }
 
    // function to delete an element
    // from the front of the queue
    public void dequeue()
    {
        // if queue is empty
        if (front == rear) {
            System.out.println("Queue is empty");
            return;
        }
        int value=queue[front];
        front++;
        System.out.println(value+" is removed from Queue");
    }
 
    // print queue elements
    public void traverse()
    {
        if (front == rear) {
            System.out.println("Queue is empty");
            return;
        }
        // traverse queue elements
        System.out.println("Queue Elements are:");
        for (int i = front; i < rear; i++) {
            System.out.println(queue[i]);
        }
    }
 
}

public class DSA_QueueArray {
	public static void main(String[] args) {
		// Create a queue of capacity 4
		ArrayQueue q = new ArrayQueue(4);
 
        // print Queue elements
        q.traverse();
 
        // inserting elements in the queue
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.enqueue(40);
        q.enqueue(50);//Queue is full
 
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
