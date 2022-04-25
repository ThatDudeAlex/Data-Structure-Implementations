/**
 * An implementation of a Doubly Linked List.
 * 
 * @author Alex Nunez 
 */
public class Doubly {    
    private Node head;
    private Node tail;
    private int size;

    /**
     * Initializes an empty list
     */
    Doubly() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    /**
     * Initializes a list that with 1 {@code Node} holding the value that was given
     * 
     * @param data the value the {@code Node} will hold
     */
    Doubly(int data) {
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

        Node newNode =  new Node(data);
        newNode.nextNode = this.head;
        this.head = head.prevNode = newNode;

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

        Node newNode =  new Node(data);
        newNode.prevNode = tail;
        this.tail = this.tail.nextNode = newNode;

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
        
        Node currNodeAtIndex = getNodeAtIndex(index);
        Node prevNode = currNodeAtIndex.prevNode;
        Node newNode = new Node(data);

        prevNode.nextNode = currNodeAtIndex.prevNode = newNode;
        newNode.nextNode = currNodeAtIndex;
        newNode.prevNode = prevNode;
        
        this.size++;
        return true;
    }

    /**
     * Deletes the first {@code Node} in the linked list
     * 
     * @return The first {@code Node} in the list of type {@code Doubly.Node}
     * 
     * @Runtime {@code O(1)} - because its not affected by the size of the list
     */
    public Node deleteFirstNode() {
        if (isEmpty())
            return null;

        Node deletedHead = this.head;

        if (this.size == 1) {
            this.head = this.tail = null;
        } else {
            this.head = this.head.nextNode;
            this.head.prevNode = deletedHead.nextNode = deletedHead.prevNode = null;
        }
        this.size--;
        return deletedHead;
    }

    /**
     * Deletes the last {@code Node} in the linked list
     *
     * @return The last {@code Node} in the list of type {@code Doubly.Node}
     * 
     * @Runtime {@code O(N)} - because it needs to iterate through the list
     */
    public Node deleteLastNode() {
        if (isEmpty())
            return null;

        Node deletedTailNode = this.tail;

        if (this.size == 1) {
            this.tail = this.head = null;
        } else {
            this.tail.prevNode.nextNode = this.tail.nextNode;
            this.tail = this.tail.prevNode;
            deletedTailNode.prevNode = deletedTailNode.nextNode = null;
        }
        this.size--;
        return deletedTailNode;
    }

   /**
     * Deletes the {@code Node} located at the given index if it exist
     * 
     * @param index the location of a {@code Node} in the linked list
     * 
     * @return The {@code Node} located at given index if it exitst else returns null. 
     * The node will be of type {@code Doubly.Node}
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
        
        Node deletedNode = getNodeAtIndex(index);
        deletedNode.prevNode.nextNode = deletedNode.nextNode;
        deletedNode.nextNode.prevNode = deletedNode.prevNode;
        deletedNode.prevNode = deletedNode.nextNode = null;
        
        this.size--;
        return deletedNode;
    }

    /**
     * Returns the head of the list, or null if the list is empty
     * 
     * @return The first {@code Node} in the list if it exits, else returns null. 
     * The node will be of type {@code Doubly.Node}
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
     * The node will be of type {@code Doubly.Node}
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
        Node currHead = (index <= (this.size / 2)) ? this.head : this.tail;

        if (isOutOfBoundsIndex(index) || isEmpty()) 
            return null;
        else if (index == 0) 
            return this.head;   // if is head index returns head
        else if (index == this.size - 1) 
            return this.tail;   // if is tail index returns tail
        
        // If the input index is is at the lower half of the list, searches the list by starting at the head and 
        // moves forward. If the Input index is at the upper half of the list, searches the list by starting at
        // the tail and moving backwards. This helps speed up the search by giving a Runtime of 1/2 O(N) = O(N)

        if (currHead == this.head) 
            for (int i = 1; i <= index; i++)
                currHead = currHead.nextNode;
        else 
            for (int i = this.size - 2; i >= index; i--)
                currHead = currHead.prevNode;

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

        Node currHead = this.head;
        Node currTail = this.tail;

        // Searches the list from both sides simultaneously, helps speed up the search by giving a Runtime of 1/2 O(N) = O(N)
        for (int i = 0; i <= this.size / 2; i++) {
            if (currHead.data == value || currTail.data == value)
                return true;

            currHead = currHead.nextNode;
            currTail = currTail.prevNode;
        }
        return false;
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
        return this.head == null && this.tail == null;
    }

    /**
     * prints the entire list to the console
     * 
     * @Runtime {@code O(N)} - because it needs to iterate the list
     */
    public void printLinkedList() {
        if (isEmpty()) {
            System.out.println("EMPTY LIST");
            return;
        }

        StringBuilder sb = new StringBuilder().append("\n\nNULL <- ");
        Node currHead = this.head;

        while (currHead != null) {
            sb.append(printListHelper(currHead));
            currHead = currHead.nextNode;
        }
        System.out.println(sb.toString());
    }

    private String printListHelper(Node currHead) {
        if (currHead.nextNode == null)
            return String.format("%d -> NULL\n\n", currHead.data);

        return String.format("%d <-> ", currHead.data);
    }

    private boolean isOutOfBoundsIndex(int index) {
        return (index >= size() || index < 0);
    }

    // handles the initialization & configurations of adding the first node into the list
    private boolean initFirtstNodeInList(int data) {
        this.head = this.tail = new Node(data);
        this.size = 1;
        return true;
    }

    /**
     * A standard {@code Doubly Linked List Node}, that holds an integer value and points to 
     * next & previous {@code Nodes} in the list
     */
    class Node {
        int data;
        Node nextNode = null;
        Node prevNode = null;
    
        public Node(int data) {
            this.data = data;
            this.nextNode = null;
            this.prevNode = null;
        }
    }
}