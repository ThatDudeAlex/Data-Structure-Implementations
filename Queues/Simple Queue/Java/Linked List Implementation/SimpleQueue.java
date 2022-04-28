/**
 * An implementation of a Queue using a Singly Linked List.
 * 
 * @author Alex Nunez 
 */
public class SimpleQueue {    
    private Node front;
    private Node back;
    private int size;

    /**
     * Initializes an empty queue
     */
    SimpleQueue() {
        this.front = null;
        this.back = null;
        this.size = 0;
    }

    /**
     * Initializes a queue that with 1 {@code element} holding the value that was given
     * 
     * @param data the value of the first {@code element} in the queue
     */
    SimpleQueue(int data) {
        initFirtstNodeInQueue(data);
    }

    /**
     * Inserts a new value at the end of the queue
     * 
     * @param data The value that the new node will hold
     * 
     * @Runtime {@code O(1)} - because its not affected by the size of the queue, since it just 
     * directly updates a single index in the queue array
     */
    public boolean enqueue(int data) {
        if (isEmpty()) 
            return initFirtstNodeInQueue(data);

        Node newNode =  new Node(data);
        this.back = this.back.nextNode = newNode;

        this.size++;
        return true;
    }

    /**
     * Removes the head of the queue and returns it. If the queue is empty, it returns null
     * 
     * @return The first {@code element} in the list
     * 
     * @Runtime {@code O(1)} - because its not affected by the size of the queue, since it just adds +1 
     * to the value of the front index
     */
    public Integer dequeue() {
        if (isEmpty())
            return null;

        Node deletedHead = this.front;

        if (this.size == 1) {
            this.front = this.back = null;
        } else {
            this.front = deletedHead.nextNode;
            deletedHead.nextNode = null;
        }
        this.size--;
        return deletedHead.data;
    }

    /**
     * Returns the head (front) of the queue without removing it.
     * 
     * @return The first {@code element} in the queue if it exits, else returns null
     * 
     * @Runtime {@code O(1)} - because its not affected by the size of the queue
     */
    public Integer peek() {
        return (isEmpty()) ? null : this.front.data;
    }

    /* 
        =======================
            Utility Methods
        =======================
    */

    /**
     * Returns the current size of the queue
     * 
     * @return the number of {@code elements} currently in the queue
     * 
     * @Runtime {@code O(1)}
     */
    public int size() {
        return this.size;
    }

    /**
     * Verifies if the queue is currently empty
     * 
     * @return {@code true} if the queue contains no {@code Values}, else returns {@code false}
     * 
     * @Runtime {@code O(1)} - because it just does a simple boolean comparison
     */
    public boolean isEmpty() {
        return this.front == null && this.back == null && size == 0;
    }


    // handles the initialization & configurations of adding the first node into the queue
    private boolean initFirtstNodeInQueue(int data) {
        this.front = this.back = new Node(data);
        this.size = 1;
        return true;
    }

    /**
     * A standard {@code Singly Linked List Node}, that holds an integer value and points to 
     * next & previous {@code Nodes} in the list
     */
    class Node {
        int data;
        Node nextNode = null;
    
        public Node(int data) {
            this.data = data;
            this.nextNode = null;
        }
    }
}