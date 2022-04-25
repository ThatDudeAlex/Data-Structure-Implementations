/**
 * An implementation of a standard Circular Singly Linked List.
 * 
 * @author Alex Nunez 
 */

public class CircularSingly {
    private Node last;
    private int size;

    /**
     * Initializes an empty list
     */
    CircularSingly() {
        this.last = null;
        this.size = 0;
    }

    /**
     * Initializes a list that with 1 {@code Node} holding the value that was given
     * 
     * @param data the value the {@code Node} will hold
     */
    CircularSingly(int data) {
        initFirtstNodeInList(data);
    }

    /**
     * <pre>
     * Inserts a new {@code Node} at the beginning of the list
     * 
     * Runtime: O(1) : because only rearranging a few pointers is required
     * </pre>
     * 
     * @return {@code true} to show the {@code Node} was inserted
     */
    public boolean insertFirst(int data) {
        if (isEmptyList())
            return initFirtstNodeInList(data);
        
        Node newHead =  new Node(data);
        Node lastNode = this.last;

        newHead.nextNode = lastNode.nextNode;
        lastNode.nextNode = newHead;
    
        this.size++;
        return true;
    }

    /**
     * <pre>
     * Inserts a new {@code Node} at the end of the list
     * 
     * Runtime: O(1) : because only rearranging a few pointers is required
     * </pre>
     * 
     * @return {@code true} to show the {@code Node} was inserted
     */
    public boolean insertLast(int data) {
        if (isEmptyList()) 
            return initFirtstNodeInList(data);
       
        Node newLastNode =  new Node(data);
        Node lastNode = this.last;

        newLastNode.nextNode = lastNode.nextNode;
        lastNode.nextNode = newLastNode;
        this.last = newLastNode;
        
        this.size++;
        return true;
    }

    /**
     * <pre>
     * Inserts a new {@code Node} at the given index
     * 
     * Runtime: O(N) : because it needs to iterate through the list
     * </pre>
     * 
     * @return {@code true} if the {@code Node} was inserted in a valid index, else
     *  returns {@code false}
     */
    public boolean insertAtIndex(int index, int data) {
        if (isEmptyList() && index == 0) 
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
        
        this.size++;
        return true;
    }

    /**
     * <pre>
     * Deletes the first {@code Node} in the linked list
     * 
     * Runtime: O(1) : because only rearranging a few pointers is required
     * </pre>
     * 
     * @return The first {@code Node} in the list of type {@code CircularSinglyImplementation.Node}
     */
    public Node deleteFirstNode() {
        if (isEmptyList())
            return null;

        Node deletedHead = this.last.nextNode;

        if (this.size == 1) {
            deletedHead.nextNode = null;
            this.last = null;
        } else {
            Node lastNode = this.last;
            lastNode.nextNode = deletedHead.nextNode;
            deletedHead.nextNode = null;
        }
        this.size--;
        return deletedHead;
    }

    /**
     * <pre>
     * Deletes the last {@code Node} in the linked list
     * 
     * Runtime: O(N) : because it needs to iterate through the list
     * </pre>
     * 
     * @return The last {@code Node} in the list of type {@code CircularSinglyImplementation.Node}
     */
    public Node deleteLastNode() {
        if (isEmptyList())
            return null;

        Node deletedLastNode = null;

        if (this.size == 1) {
            deletedLastNode = this.last;
            deletedLastNode.nextNode = null;
            this.last = null;
        } else {
            Node newLastNode = getNodeAtIndex(this.size - 2);
            deletedLastNode = this.last;
            newLastNode.nextNode = deletedLastNode.nextNode;
            deletedLastNode.nextNode = null;
            this.last = newLastNode;
        }
        this.size--;
        return deletedLastNode;
    }

    /**
     * <pre>
     * Deletes the {@code Node} located at the given index if it exist
     * 
     * Runtime: O(N) : because it needs to iterate through the list 
     * </pre>
     * 
     * @param index the location of a {@code Node} in the linked list
     * 
     * @return The {@code Node} located at given index if it exitst else returns null. 
     * The node will be of type {@code CircularSinglyImplementation.Node}
     */
    public Node deleteNodeAtIndex(int index) {
        if (isOutOfBoundsIndex(index) || isEmptyList())
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
        currHead.nextNode = null;

        this.size--;
        return currHead;
    }

    /**
     * <pre>
     * Returns the head of the list, or null if the list is empty
     * 
     * Runtime: O(1) : because it just returns a pointer that's readily available
     * </pre>
     * 
     * @return The first {@code Node} in the list if it exits, else returns null. 
     * The node will be of type {@code CircularSinglyImplementation.Node}
     */
    public Node getFirstNode() {
        if (isEmptyList())
            return null;
        return this.last.nextNode;
    }

    /**
     * <pre>
     * Returns the last node of the list, or null if the list is empty
     * 
     * Runtime: O(1) : because it just returns a pointer that's readily available
     * </pre>
     * 
     * @return The last {@code Node} in the list if it exits, else returns null. 
     * The node will be of type {@code CircularSinglyImplementation.Node}
     */
    public Node getLastNode() {
        return this.last;
    }

    /**
     * <pre>
     * Returns the {@code Node} at the given index if it exist, else returns null
     * 
     * Runtime: O(N) : because it needs to iterate the list
     * </pre>
     * 
     * @param index the location of a {@code Node} in the list
     * 
     * @return The {@code Node} located at the given index
     */
    public Node getNodeAtIndex(int index) {
        if (isOutOfBoundsIndex(index) || isEmptyList()) 
            return null;
        else if (index == 0)
            return getFirstNode();

        Node currHead = this.last;

        // Starts at i = -1 to because we start at the end of the list instead of the beginning
        for (int i = -1; i < index; i++)
            currHead = currHead.nextNode;

        return currHead;
    }

    /**
     * <pre> 
     * Searches the list to see if it contains a {@code Node} with the given value
     * 
     * Runtime: O(N) : because it needs to iterate the list
     * </pre>
     * 
     * @param value to search the list for
     * 
     * @return {@code true} if the list contains a {@code Node} with the given value,
     * else returns {@code false}
     */
    public boolean search(int value) {
        if (isEmptyList())
            return false;

        Node currHead = this.last;

        while (currHead.nextNode != this.last && currHead.data != value)
            currHead = currHead.nextNode;

        return currHead.data == value;
    }

    // Utility Methods
    // =======================

     /**
     * <pre>
     * Returns the current size of the List
     * 
     * Runtime: O(1) : because it just returns the value of a private variable
     * </pre>
     * @
     * @return the number of {@code Nodes} currently in the list
     */
    public int getSize() {
        return this.size;
    }

    /**
     * <pre>
     * Returns the current size of the Linked List
     * 
     * Runtime: O(1) : because it just does a simple boolean comparison
     * </pre>
     * 
     * @return {@code true} if the list contains no {@code Nodes},
     * else returns {@code false}
     */
    public boolean isEmptyList() {
        return this.last == null && this.size == 0;
    }
    
    /**
     * <pre>
     * prints the entire list to the console
     * 
     * Runtime: O(N) : because it needs to iterate the list
     * </pre>
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
        this.last.nextNode = this.last;
        this.size = 1;
        return true;
    }

    /**
     * A standard {@code Singly Linked List Node}, that holds an integer value and points to next {@code Node} in the list
     */
    class Node {
        int data;
        Node nextNode;
    
        public Node(int data) {
            this.data = data;
            this.nextNode = null;
        }
    }
}