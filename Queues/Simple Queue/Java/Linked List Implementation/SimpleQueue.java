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
     * <pre>
     * Inserts a new node at the end of the queue
     * 
     * Runtime: O(1)
     * </pre>
     * 
     * @param data The value that the new node will hold
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
     * <pre>
     * Removes the head of the queue and returns it. If the queue is empty, it returns null
     * 
     * Runtime: O(1) : because only rearranging a few pointers is required
     * </pre>
     * 
     * @return The first {@code Node} in the list of type {@code SimpleQueue.Node}
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
     * <pre>
     * Returns the head (front) of the queue without removing it.
     * 
     * Runtime: O(1) : because it just returns a pointer that's readily available
     * </pre>
     * 
     * @return The first {@code Node} in the queue if it exits, else returns null. 
     * The node will be of type {@code SimpleQueue.Node}
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
     * <pre>
     * Returns the current size of the queue
     * 
     * Runtime: O(1) : because it just returns the value of a private variable
     * </pre>
     * @
     * @return the number of {@code elements} currently in the queue
     */
    public int size() {
        return this.size;
    }

    /**
     * <pre>
     * Verifies if the queue is currently empty
     * 
     * Runtime: O(1) : because it just does a simple boolean comparison
     * </pre>
     * 
     * @return {@code true} if the queue contains no {@code Nodes},
     * else returns {@code false}
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