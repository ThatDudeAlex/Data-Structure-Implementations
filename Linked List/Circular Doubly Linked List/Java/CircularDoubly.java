
/**
 * An implementation of a Circular Doubly Linked List.
 * 
 * @author Alex Nunez 
 */

public class CircularDoubly {
    private Node last;
    private int size;

    /**
     * Initializes an empty list
     */
    CircularDoubly() {
        this.last = null;
        this.size = 0;
    }

    /**
     * Initializes a list that with 1 {@code Node} holding the value that was given
     * 
     * @param data the value the {@code Node} will hold
     */
    CircularDoubly(int data) {
        initFirtstNodeInList(data);
    }

    /**
     * Inserts a new {@code Node} at the beginning of the list
     * 
     * @return {@code true} to show the {@code Node} was inserted
     * 
     * @Runtime {@code O(1)} - because its not affected by the size of the list
     */
    public boolean insertFirst(int data) {
        if (isEmpty())
            return initFirtstNodeInList(data);
        
        Node newHead =  new Node(data);
        Node currHead = getFirstNode();
        Node lastNode = getLastNode();

        newHead.nextNode = currHead;
        newHead.prevNode = lastNode;
        lastNode.nextNode = newHead;

        if (this.size == 1) {
            lastNode.prevNode = newHead;
        } else {
            currHead.prevNode = newHead;
        }
    
        this.size++;
        return true;
    }

    /**
     * Inserts a new {@code Node} at the end of the list
     * 
     * @return {@code true} to show the {@code Node} was inserted
     * 
     * @Runtime {@code O(1)} - because its not affected by the size of the list
     */
    public boolean insertLast(int data) {
        if (isEmpty()) 
            return initFirtstNodeInList(data);
       
        Node newLastNode =  new Node(data);
        Node lastNode = this.last;

        newLastNode.nextNode = lastNode.nextNode;
        newLastNode.prevNode = lastNode;
        lastNode.nextNode = newLastNode;

        if (this.size == 1) {
            lastNode.prevNode = newLastNode;
        } else {
            newLastNode.nextNode.prevNode = newLastNode;
        }

        this.last = newLastNode;
        
        this.size++;
        return true;
    }

    /**
     * Inserts a new {@code Node} at the given index
     * 
     * @return {@code true} if the {@code Node} was inserted in a valid index, else
     *  returns {@code false}
     * 
     * @Runtime {@code O(N)} - because it needs to iterate through the list
     */
    public boolean insertAtIndex(int index, int data) {
        if (isEmpty() && index == 0) 
            return initFirtstNodeInList(data);
        else if (index == 0) 
            return insertFirst(data);
        else if (isOutOfBoundsIndex(index))
            return false;
        
        Node prevHead = this.last;
        Node currHead = this.last.nextNode;
        Node newNode = new Node(data);

        for (int i = 0; i < index; i++) {
            prevHead = currHead;
            currHead = currHead.nextNode;
        }
        prevHead.nextNode = newNode;
        newNode.nextNode = currHead;
        newNode.prevNode = prevHead;
        currHead.prevNode = newNode;
        
        this.size++;
        return true;
    }

    /**
     * Deletes the first {@code Node} in the linked list
     * 
     * @return The first {@code Node} in the list of type {@code CircularDoubly.Node}
     * 
     * @Runtime {@code O(1)} - because its not affected by the size of the list
     */
    public Node deleteFirstNode() {
        if (isEmpty())
            return null;
        else if (this.size == 1)
            return handleNodeRemoval();
        else if (this.size == 2)
            return handleNodeRemoval(getLastNode(), getFirstNode());

        Node nodeToRemove = getFirstNode();
        Node lastNode = getLastNode();

        lastNode.nextNode = nodeToRemove.nextNode;
        nodeToRemove.nextNode.prevNode = nodeToRemove.prevNode;
    
        return handleNodeRemoval(nodeToRemove);
    }

    /**
     * Deletes the last {@code Node} in the linked list
     *
     * @return The last {@code Node} in the list of type {@code CircularDoubly.Node}
     * 
     * @Runtime {@code O(N)} - because it needs to iterate through the list
     */
    public Node deleteLastNode() {
        if (isEmpty())
            return null;
        else if (this.size == 1) 
            return handleNodeRemoval();
        else if (this.size == 2)
            return handleNodeRemoval(getFirstNode(), getLastNode());

        Node nodeToRemove = getLastNode();
        Node newLastNode = getNodeAtIndex(this.size - 2);

        newLastNode.nextNode = nodeToRemove.nextNode;
        nodeToRemove.nextNode.prevNode = newLastNode;
        this.last = newLastNode;

        return handleNodeRemoval(nodeToRemove);
    }

    /**
     * Deletes the {@code Node} located at the given index if it exist
     * 
     * @param index the location of a {@code Node} in the linked list
     * 
     * @return The {@code Node} located at given index if it exitst else returns null. 
     * The node will be of type {@code CircularDoubly.Node}
     * 
     *@Runtime {@code O(N)} - because it needs to iterate through the list 
     */
    public Node deleteNodeAtIndex(int index) {
        if (isOutOfBoundsIndex(index) || isEmpty())
            return null;
        else if (index == 0) 
            return deleteFirstNode();
        else if (index == this.size - 1)
            return deleteLastNode();
        
        Node prevHead = this.last;
        Node currHead = this.last.nextNode;

        for (int i = 0; i < index; i++) {
            prevHead = currHead;
            currHead = currHead.nextNode;
        }
        prevHead.nextNode = currHead.nextNode;
        currHead.nextNode.prevNode = prevHead;

        return handleNodeRemoval(currHead);
    }

    /**
     * Handles the removal and cleanup of the only {@code Node} in a list of size 1. 
     * 
     * @return the {@code Node} that was deleted if the list is of size 1, returns null
     * if the list is of a different size
     */
    private Node handleNodeRemoval() {
        return (this.size == 1) ? handleNodeRemoval(getFirstNode()) : null;
    }

    /**
     * Handles the removal and cleanup of a {@code Node} in a list of size 2.
     *  
     * @param nodeRemaining the {@code Node} that will remain in the list
     * 
     * @param nodeToRemove the {@code Node} you want to remove from the list
     * 
     * @return the {@code Node} that was deleted if the list is of size 2, returns null
     * if the list is of a different size
     */
    private Node handleNodeRemoval(Node nodeRemaining, Node nodeToRemove) {
        if (this.size != 2)
            return null;
            
        nodeRemaining.nextNode = nodeToRemove.nextNode;
        nodeRemaining.prevNode = nodeToRemove.prevNode;
        return handleNodeRemoval(nodeToRemove);
    }

    /** 
     * Handles the removal and cleanup of a node to be removed
     */
    private Node handleNodeRemoval(Node nodeToRemove) {      
        if (this.size == 1)
            this.last = null;
        else if (this.size == 2)
            this.last = nodeToRemove.nextNode;
        
        this.size--;
        nodeToRemove.nextNode = nodeToRemove.prevNode = null;
        return nodeToRemove;
    }

    /**
     * Returns the head of the list, or null if the list is empty
     * 
     * @return The first {@code Node} in the list if it exits, else returns null. 
     * The node will be of type {@code CircularDoubly.Node}
     * 
     * @Runtime {@code O(1)} - because it just returns a pointer that's readily available
     */
    public Node getFirstNode() {
        if (isEmpty())
            return null;
        return this.last.nextNode;
    }

    /**
     * Returns the last node of the list, or null if the list is empty
     * 
     * @return The last {@code Node} in the list if it exits, else returns null. 
     * The node will be of type {@code CircularDoubly.Node}
     * 
     * @Runtime {@code O(1)} - because it just returns a pointer that's readily available
     */
    public Node getLastNode() {
        return this.last;
    }

    /**
     * 
     * Returns the {@code Node} at the given index if it exist, else returns null
     *
     * @param index the location of a {@code Node} in the list
     * 
     * @return The {@code Node} located at the given index
     * 
     * @Runtime {@code O(N)} - because it needs to iterate the list
     */
    public Node getNodeAtIndex(int index) {
        if (isOutOfBoundsIndex(index) || isEmpty()) 
            return null;
        else if (index == 0)
            return getFirstNode();
        else if (index == this.size - 1)
            return getLastNode();
        else if (index == this.size - 2)
            return getLastNode().prevNode;

        Node currHead = this.last;

        // Starts at i = -1 to because we start at the end of the list instead of the beginning
        for (int i = -1; i < index; i++)
            currHead = currHead.nextNode;

        return currHead;
    }

    /**
     * Searches the list to see if it contains a {@code Node} with the given value
     *
     * @param value to search the list for
     * 
     * @return {@code true} if the list contains a {@code Node} with the given value,
     * else returns {@code false}
     * 
     * @Runtime {@code O(N)} - because it needs to iterate the list
     */
    public boolean search(int value) {
        if (isEmpty())
            return false;

        Node currHead = this.last;

        while (currHead.nextNode != this.last && currHead.data != value)
            currHead = currHead.nextNode;

        return currHead.data == value;
    }

     /**
     * Returns the current size of the List
     * 
     * @return the number of {@code Nodes} currently in the list
     * 
     * @Runtime {@code O(1)} - because it just returns the value of a private variable
     */
    public int size() {
        return this.size;
    }

    /**
     * Returns the current size of the Linked List
     * 
     * @return {@code true} if the list contains no {@code Nodes},
     * else returns {@code false}
     * 
     * @Runtime {@code O(1)} - because it just does a simple boolean comparison
     */
    public boolean isEmpty() {
        return this.last == null && this.size == 0;
    }
    
    /**
     * prints the entire list to the console
     * 
     * @Runtime {@code O(N)} - because it needs to iterate the list
     */
    public void printLinkedList() {
        if (this.last == null) {
            System.out.println("EMPTY LIST");
            return;
        }

        Node currHead = this.last;

        while (currHead != null) {
            System.out.printf("%d -> ", currHead.data);
            currHead = currHead.nextNode;
        }
        System.out.print("NULL\n\n");
    }

    private boolean isOutOfBoundsIndex(int index) {
        return (index >= this.size || index < 0);
    }

    // handles the initialization & configurations of adding the first node into the list
    private boolean initFirtstNodeInList(int data) {
        this.last = new Node(data);
        this.last.nextNode = this.last.prevNode = this.last;
        this.size = 1;
        return true;
    }

    /**
     * A standard {@code Doubly Linked List Node}, that holds an integer value and points to next & previous {@code Nodes} in the list
     */
    class Node {
        int data;
        Node nextNode;
        Node prevNode;
    
        public Node(int data) {
            this.data = data;
            this.nextNode = null;
            this.prevNode = null;
        }
    }
}