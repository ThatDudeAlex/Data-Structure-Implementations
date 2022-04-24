
public class CircularSinglyImplementation {
    private Node head;
    private int size;

    CircularSinglyImplementation() {
        this.head = null;
        this.size = 0;
    }

    CircularSinglyImplementation(int data) {
        initFirtstNodeInList(data);
        this.size = 1;
    }

    /**
     * <pre>
     * Inserts a new node at the beginning of the list
     * 
     * Runtime: O(N) : The enitire list has to be traversed to make sure the last node points back to the beginning
     * 
     * </pre>
     * 
     * @param data The value that the new node will hold
     */
    public boolean insertFirst(int data) {
        if (isEmptyList()) {
            initFirtstNodeInList(data);
        } else {
            Node newHead =  new Node(data);
            Node lastNode = getLastNode();

            newHead.nextNode = this.head;
            lastNode.nextNode = newHead;
            this.head = newHead;
        }
        this.size++;
        return true;
    }

    /**
     * <pre>
     * Inserts a new node at the end of the linked list
     * 
     * Runtime: O(N) : The enitire list has to be traversed to make add the new node 
     * </pre>
     * 
     * @param data The value that the new node will hold
     */
    public boolean insertLast(int data) {
        if (isEmptyList()) {
            initFirtstNodeInList(data);
        } else {
            Node newNode =  new Node(data);
            Node lastNode = getLastNode();

            lastNode.nextNode = newNode;
            newNode.nextNode = this.head;
        }
        this.size++;
        return true;
    }

    /**
     * <pre>
     * Deletes the first node in the linked list
     * 
     * Runtime: O(N) : The enitire list has to be traversed to make sure the last node points back to the new head
     * </pre>
     * 
     * @param data The value that the new node will hold
     */
    public Node deleteFirstNode() {
        if (isEmptyList())
            return null;

        Node deletedHead = this.head;

        if (this.size == 1) {
            deletedHead.nextNode = null;
            this.head = null;
        } else {
            Node lastNode = getLastNode();
            this.head = lastNode.nextNode = deletedHead.nextNode;
            deletedHead.nextNode = null;
        }
        this.size--;
        return deletedHead;
    }

    public Node deleteLastNode() {
        if (isEmptyList())
            return null;

        Node deletedLastNode = null;

        if (this.size == 1) {
            deletedLastNode = this.head;
            deletedLastNode.nextNode = null;
            this.head = null;
        } else {
            Node newLastNode = getNodeAtIndex(this.size - 2);
            deletedLastNode = newLastNode.nextNode;
            newLastNode.nextNode = deletedLastNode.nextNode;
            deletedLastNode.nextNode = null;
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
        currHead.nextNode = null;

        this.size--;
        return currHead;
    }

    /**
     * <pre>
     * Returns the head of the Linked List, or null if the list is empty
     * 
     * Runtime: O(1)
     * </pre>
     */
    public Node getFirstNode() {
        return this.head;
    }

    public Node getLastNode() {
        return getNodeAtIndex(this.size - 1);
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
        if (isOutOfBoundsIndex(index) || isEmptyList()) 
            return null;
        else if (index == 0)
            return getFirstNode();

        Node currHead = this.head;

        for (int i = 0; i < index; i++)
            currHead = currHead.nextNode;

        return currHead;
    }

    /**
     * <pre> 
     * Searches the linked list to see if it contains the given value
     * 
     * Runtime: O(N)
     * </pre>
     * @param value to search the linked list for
     * 
     * @return Whether or not the value is found in the linked list
     */
    public boolean search(int value) {
        if (isEmptyList())
            return false;

        Node currHead = this.head;

        while (currHead.nextNode != this.head && currHead.data != value)
            currHead = currHead.nextNode;

        return currHead.data == value;
    }

    // Utility Methods
    // =======================

     /**
     * <pre>
     * Returns the current size of the Linked List
     * 
     * Runtime: O(1)
     * </pre>
     */
    public int getSize() {
        return this.size;
    }

    public boolean isEmptyList() {
        return this.head == null && this.size == 0;
    }

    private boolean isOutOfBoundsIndex(int index) {
        return (index >= this.size || index < 0);
    }

    public void printLinkedList() {
        if (this.head == null) {
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

    private void initFirtstNodeInList(int data) {
        this.head = new Node(data);
        this.head.nextNode = this.head;
    }

    class Node {
        int data;
        Node nextNode;
    
        public Node(int data) {
            this.data = data;
            this.nextNode = null;
        }
    }
}