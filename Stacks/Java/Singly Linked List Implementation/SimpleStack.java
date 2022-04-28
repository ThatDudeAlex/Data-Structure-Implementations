/**
 * An implementation of a Stack using a Singly Linked List.
 * 
 * @author Alex Nunez 
 */
public class SimpleStack {    
    private Node head;
    private Node tail;
    private int size;

    /**
     * Initializes an empty stack
     */
    SimpleStack() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    /**
     * Initializes a stack that with 1 {@code element} holding the value that was given
     * 
     * @param data the value of the first {@code element} in the stack
     */
    SimpleStack(int data) {
        initFirtstNodeInStack(data);
    }

    /**
     * Inserts a new value at the top of the stack
     * 
     * @param data The value that the new node will hold
     * 
     * @Runtime {@code O(1)} - because its not affected by the size of the stack, since it just 
     * directly adds a new pointer from the current top of the stack to the new node
     */
    public boolean push(int data) {
        if (isEmpty()) 
            return initFirtstNodeInStack(data);

        Node newNode =  new Node(data);
        this.tail = this.tail.nextNode = newNode;

        this.size++;
        return true;
    }

    /**
     * Removes the top of the stack and returns it. If the stack is empty, it returns null
     * 
     * @return The {@code element} that's currently on top of the stack 
     * 
     * @Runtime {@code O(N)} - because the stack needs to be traversed to set the new top 
     */
    public Integer pop() {
        if (isEmpty())
            return null;

        Node deletedTail = this.tail;

        if (this.size == 1) {
            this.head = this.tail = null;
        } else {
            this.tail = getNewTail();
            this.tail.nextNode = null;
        }

        this.size--;
        return deletedTail.data;
    } 

    private Node getNewTail() {
        Node currHead = this.head;

        while (currHead.nextNode.nextNode != null)
            currHead = currHead.nextNode;
        return currHead;
    }

    /**
     * Returns the top of the stack without removing it.
     * 
     * @return The value of the {@code element} that's currently on top of the stack. If the stack is empty returns 
     * 
     * @Runtime {@code O(1)} - because its not affected by the size of the queue
     */
    public Integer peek() {
        return (isEmpty()) ? null : this.tail.data;
    }

    /* 
        =======================
            Utility Methods
        =======================
    */

   /**
     * Returns the current size of the stack
     * 
     * @return the number of {@code elements} currently in the stack
     * 
     * @Runtime {@code O(1)}
     */
    public int size() {
        return this.size;
    }

    /**
     * Verifies if the stack is currently empty
     * 
     * @return {@code true} if the stack contains no {@code elements}, else returns {@code false}
     * 
     * @Runtime {@code O(1)} - because its not affected by the size of the queue, it just does a simple boolean comparison
     */
    public boolean isEmpty() {
        return this.head == null && this.tail == null && size == 0;
    }


    // handles the initialization & configurations of adding the first node into the stack
    private boolean initFirtstNodeInStack(int data) {
        this.head = this.tail = new Node(data);
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