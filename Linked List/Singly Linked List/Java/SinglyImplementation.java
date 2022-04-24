/**
 * An implementation of a standard Singly Linked List.
 * 
 * @author Alex Nunez
 */

public class SinglyImplementation {
    private Node head;
    private Node tail;
    private int size;

    /**
     * Initializes an empty list
     */
    SinglyImplementation() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    /**
     * Initializes a list that with 1 {@code Node} holding the value that was given
     * 
     * @param data the value the {@code Node} will hold
     */
    SinglyImplementation(int data) {
        initFirtstNodeInList(data);
    }

    /**
     * <pre>
     * Inserts a new node at the beginning of the list
     * 
     * Runtime: O(1)
     * </pre>
     * 
     * @param data The value that the new node will hold
     */
    public boolean insertFirst(int data) {
        if (isEmptyList())
            return initFirtstNodeInList(data);

        Node newNode = new Node(data);
        newNode.nextNode = this.head;
        this.head = newNode;

        this.size++;
        return true;
    }

    /**
     * <pre>
     * Inserts a new node at the end of the list
     * 
     * Runtime: O(1)
     * </pre>
     * 
     * @param data The value that the new node will hold
     */
    public boolean insertLast(int data) {
        if (isEmptyList())
            return initFirtstNodeInList(data);

        this.tail = this.tail.nextNode = new Node(data);
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
     *         returns {@code false}
     */
    public boolean insertAtIndex(int index, int data) {
        if (isEmptyList() && index == 0)
            return initFirtstNodeInList(data);
        else if (index == 0)
            return insertFirst(data);
        else if (isOutOfBoundsIndex(index))
            return false;

        Node prevHead = null;
        Node currHead = this.head;
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
     * Returns the node at the given index if it exist, else returns null
     * 
     * Runtime: O(N)
     * </pre>
     * 
     * @param index the location of a node in the linked list
     * 
     * @return The node located at the given index
     */
    public Node getNodeAtIndex(int index) {
        Node currHead = this.head;

        if (isOutOfBoundsIndex(index) || isEmptyList())
            return null;
        else if (index == 0)
            return this.head; // if is head index returns head
        else if (index == this.size - 1)
            return this.tail; // if is tail index returns tail

        for (int i = 1; i <= index; i++)
            currHead = currHead.nextNode;

        return currHead;
    }

    /**
     * <pre>
     * Deletes the first {@code Node} in the linked list
     * 
     * Runtime: O(1) : because only rearranging a few pointers is required
     * </pre>
     * 
     * @return The first {@code Node} in the list of type
     *         {@code SinglyImplementation.Node}
     */
    public Node deleteFirstNode() {
        if (isEmptyList())
            return null;

        Node deletedHead = this.head;

        if (this.size == 1) {
            this.head = this.tail = deletedHead.nextNode = null;
        } else {
            this.head = deletedHead.nextNode;
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
     * @return The last {@code Node} in the list of type
     *         {@code SinglyImplementation.Node}
     */
    public Node deleteLastNode() {
        if (isEmptyList())
            return null;

        Node deletedLastNode = null;

        if (this.size == 1) {
            deletedLastNode = this.head;
            this.head = this.tail = deletedLastNode.nextNode = null;
        } else {
            Node newLastNode = getNodeAtIndex(this.size - 2);
            deletedLastNode = this.tail;
            newLastNode.nextNode = deletedLastNode.nextNode;
            deletedLastNode.nextNode = null;
            this.tail = newLastNode;
        }
        this.size--;
        return deletedLastNode;
    }

    /**
     * <pre>
     * Deletes the node located at the given index if it exist
     * 
     * Runtime: O(N)
     * </pre>
     * 
     * @param index the location of a node in the linked list
     * 
     * @return A boolean stating whether or not a node was deleted
     */
    public Node deleteNodeAtIndex(int index) {
        if (isOutOfBoundsIndex(index) || isEmptyList())
            return null;
        else if (index == 0)
            return deleteFirstNode();
        else if (index == this.size - 1)
            return deleteLastNode();

        Node prevHead = this.head;
        Node currHead = this.head.nextNode;

        for (int i = 1; i < index; i++) {
            prevHead = currHead;
            currHead = currHead.nextNode;
        }
        prevHead.nextNode = currHead.nextNode;

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
     *         The node will be of type {@code SinglyImplementation.Node}
     */
    public Node getFirstNode() {
        return this.head;
    }

    /**
     * <pre>
     * Returns the last node of the list, or null if the list is empty
     * 
     * Runtime: O(1) : because it just returns a pointer that's readily available
     * </pre>
     * 
     * @return The last {@code Node} in the list if it exits, else returns null.
     *         The node will be of type {@code SinglyImplementation.Node}
     */
    public Node getLastNode() {
        return this.tail;
    }

    /**
     * <pre>
     *  
     * Searches the linked list to see if it contains the given value
     * 
     * Runtime: O(N)
     * </pre>
     * 
     * @param value to search the linked list for
     * 
     * @return Whether or not the value is found in the linked list
     */
    public boolean search(int value) {
        Node currHead = this.head;

        while (currHead != null && currHead.data != value)
            currHead = currHead.nextNode;

        return (currHead != null && currHead.data == value);
    }

    /**
     * <pre>
     * Returns the head of the Linked List, or null if the list is empty
     * 
     * Runtime: O(1)
     * </pre>
     */
    public Node getHead() {
        return this.head;
    }

    /**
     * <pre>
     * Returns the tail of the Linked List, or null if the list is empty
     * 
     * Runtime: O(1)
     * </pre>
     */
    public Node getTail() {
        return this.tail;
    }

    // Utility Methods
    // =======================

    /**
     * <pre>
     * Returns the current size of the List
     * 
     * Runtime: O(1) : because it just returns the value of a private variable
     * </pre>
     * 
     * @
     *   @return the number of {@code Nodes} currently in the list
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
     *         else returns {@code false}
     */
    public boolean isEmptyList() {
        return this.head == null && this.tail == null && this.size == 0;
    }

    /**
     * <pre>
     * prints the entire list to the console
     * 
     * Runtime: O(N) : because it needs to iterate the list
     * </pre>
     */
    public void printLinkedList() {
        if (isEmptyList()) {
            System.out.println("EMPTY LIST");
            return;
        }

        Node currHead = this.head;

        while (currHead != null) {
            System.out.printf("%d -> ", currHead.data);
            currHead = currHead.nextNode;
        }
        System.out.print("NULL\n\n");
    }

    private boolean isOutOfBoundsIndex(int index) {
        return (index >= getSize() || index < 0);
    }

    // handles the initialization & configurations of adding the first node into the
    // list
    private boolean initFirtstNodeInList(int data) {
        this.head = this.tail = new Node(data);
        this.size = 1;
        return true;
    }

    class Node {
        int data;
        Node nextNode = null;

        public Node(int data) {
            this.data = data;
            this.nextNode = null;
        }
    }
}