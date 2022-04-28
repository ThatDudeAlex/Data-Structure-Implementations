/**
 * An implementation of a Singly Linked List.
 * 
 * @author Alex Nunez
 */

public class Singly {
    private Node head;
    private Node tail;
    private int size;

    /**
     * Initializes an empty list
     */
    Singly() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    /**
     * Initializes a list that with 1 {@code Node} holding the value that was given
     * 
     * @param data the value the {@code Node} will hold
     */
    Singly(int data) {
        initFirtstNodeInList(data);
    }

    /**
     * Inserts a new {@code Node} at the beginning of the list
     * 
     * @param data The int value the node will have
     * 
     * @return {@code true} to show the {@code Node} was inserted
     * 
     * @Runtime {@code O(1)} - because its not affected by the size of the list
     */
    public boolean insertFirst(int data) {
        if (isEmpty())
            return initFirtstNodeInList(data);

        Node newNode = new Node(data);
        newNode.nextNode = this.head;
        this.head = newNode;

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

        this.tail = this.tail.nextNode = new Node(data);
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
     * Deletes the first {@code Node} in the linked list
     * 
     * @return The first {@code Node} in the list of type {@code Singly.Node}
     * 
     * @Runtime {@code O(1)} - because its not affected by the size of the list
     */
    public Node deleteFirstNode() {
        if (isEmpty())
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
     * Deletes the last {@code Node} in the linked list
     *
     * @return The last {@code Node} in the list of type {@code Singly.Node}
     * 
     * @Runtime {@code O(N)} - because it needs to iterate through the list
     */
    public Node deleteLastNode() {
        if (isEmpty())
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
     * Deletes the {@code Node} located at the given index if it exist
     * 
     * @param index the location of a {@code Node} in the linked list
     * 
     * @return The {@code Node} located at given index if it exitst else returns null. 
     * The node will be of type {@code Singly.Node}
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
     * Returns the head of the list, or null if the list is empty
     * 
     * @return The first {@code Node} in the list if it exits, else returns null. 
     * The node will be of type {@code Singly.Node}
     * 
     * @Runtime {@code O(1)} - because it just returns a pointer that's readily available
     */
    public Node getFirstNode() {
        return this.head;
    }

     /**
     * Returns the last node of the list, or null if the list is empty
     * 
     * @return The last {@code Node} in the list if it exits, else returns null. 
     * The node will be of type {@code Singly.Node}
     * 
     * @Runtime {@code O(1)} - because it just returns a pointer that's readily available
     */
    public Node getLastNode() {
        return this.tail;
    }

     /**
     * Returns the {@code Node} at the given index if it exist, else returns null
     *
     * @param index the location of a {@code Node} in the list
     * 
     * @return The {@code Node} located at the given index
     * 
     * @Runtime {@code O(N)} - because it needs to iterate the list
     */
    public Node getNodeAtIndex(int index) {
        Node currHead = this.head;

        if (isOutOfBoundsIndex(index) || isEmpty())
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
        Node currHead = this.head;

        while (currHead != null && currHead.data != value)
            currHead = currHead.nextNode;

        return (currHead != null && currHead.data == value);
    }

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
    public int size() {
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
    public boolean isEmpty() {
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
        if (isEmpty()) {
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
        return (index >= size() || index < 0);
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