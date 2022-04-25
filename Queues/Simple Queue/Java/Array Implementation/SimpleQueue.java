/**
 * An implementation of a Queue using an integer array.
 * 
 * @author Alex Nunez 
 */
public class SimpleQueue {    
    private int[]   queue;
    private int     front;
    private int     back;
    private int     size;

    /**
     * Initializes an empty queue
     */
    SimpleQueue(int capacity) {
        this.queue = new int[capacity];
        this.front = 0;
        this.back  = 0;
        this.size  = 0;
    }

    /**
     * Initializes a queue with 1 {@code element}
     * 
     * @param data the value of the first {@code element} in the queue
     */
    SimpleQueue(int capacity, int data) {
        this.queue = new int[capacity];
        this.queue[0] = data;
        this.front    = 0;
        this.back     = 1 % capacity;
        this.size     = 1;
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
        if (isFull())
            return false;
        
        this.queue[this.back] = data;
        this.back = (this.back + 1) % this.queue.length;
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

        int head = this.queue[this.front];
        this.front = (this.front + 1) % this.queue.length;
        this.size--;

        return head;
    }

    /**
     * Returns the head (front) of the queue without removing it.
     * 
     * @return The first {@code element} in the queue if it exits, else returns null
     * 
     * @Runtime {@code O(1)} - because its not affected by the size of the queue
     */
    public Integer peek() {
        return (isEmpty()) ? null : this.queue[this.front];
    }

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
        return this.size == 0 && front == back;
    }

    /**
     * Verifies if the queue is currently full
     * 
     * @return {@code true} if the queue no open slots, else returns {@code false}
     * 
     * @Runtime {@code O(1)} - because it just does a simple boolean comparison
     */
    public boolean isFull() {
        return this.size == this.queue.length - 1;
    }
}