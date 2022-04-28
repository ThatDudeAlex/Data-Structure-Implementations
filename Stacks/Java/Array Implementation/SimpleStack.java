/**
 * An implementation of a Queue using an integer array.
 * 
 * @author Alex Nunez 
 */
public class SimpleStack {    
    private int[]   stack;
    private int     top;
    private int     size;

    /**
     * Initializes an empty stack
     */
    SimpleStack(int capacity) {
        this.stack = new int[capacity];
        this.top   = -1;
        this.size  =  0;
    }

    /**
     * Initializes a stack with 1 {@code element}
     * 
     * @param data the value of the first {@code element} in the stack
     */
    SimpleStack(int capacity, int data) {
        this.stack = new int[capacity];
        this.stack[0] = data;
        this.top      = 0;
        this.size     = 1;
    }

    /**
     * Inserts a new value at the top of the stack
     * 
     * @param data The value that the new node will hold
     * 
     * @Runtime {@code O(1)} - because its not affected by the size of the stack, since it just 
     * directly updates a single index in the stack array
     */
    public boolean push(int data) {
        if (isFull())
            return false;
        
        this.stack[++this.top] = data;
        this.size++;
        return true;
    }

    /**
     * Removes the top of the stack and returns it. If the stack is empty, it returns null
     * 
     * @return The top {@code element} currently in the stack
     * 
     * @Runtime {@code O(1)} - because its not affected by the size of the stack, since it just substrack +1 
     * to the value of the top index
     */
    public Integer pop() {
        if (isEmpty())
            return null;

        this.size--;
        return this.stack[this.top--];
    }

    /**
     * Returns the head (top) of the stack without removing it.
     * 
     * @return The first {@code element} in the stack if it exits, else returns null
     * 
     * @Runtime {@code O(1)} - because its not affected by the size of the stack
     */
    public Integer peek() {
        return (isEmpty()) ? null : this.stack[this.top];
    }

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
     * @return {@code true} if the stack contains no {@code Values}, else returns {@code false}
     * 
     * @Runtime {@code O(1)} - because it just does a simple boolean comparison
     */
    public boolean isEmpty() {
        return this.size == 0;
    }

    /**
     * Verifies if the stack is currently full
     * 
     * @return {@code true} if the stack no open slots, else returns {@code false}
     * 
     * @Runtime {@code O(1)} - because it just does a simple boolean comparison
     */
    public boolean isFull() {
        return this.size == this.stack.length && this.top == this.stack.length - 1;
    }
}