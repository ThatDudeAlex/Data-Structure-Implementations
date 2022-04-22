
public class DoublyImplementation {    
    private Node head = null;
    private Node tail = null;
    private int size = 0;

    /**
     * <pre>
     * Inserts a new node at the beginning of the list
     * 
     * Runtime: O(1)
     * </pre>
     * 
     * @param data The value that the new node will hold
     */
    public void insertFirst(int data) {
        Node newNode =  new Node(data);
        newNode.nextNode = this.head;
        
        if (isEmptyList())
            this.tail = this.head = newNode;
        else 
            this.head = this.head.prevNode = newNode;
        
        this.size++;
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
    public void insertLast(int data) {
        Node newNode =  new Node(data);
        newNode.prevNode = tail;

        if (isEmptyList()) 
            this.head = this.tail = newNode;
        else 
            this.tail = this.tail.nextNode = newNode;

        this.size++;
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
        Node currHead = (index <= (this.size / 2)) ? this.head : this.tail;

        if (isOutOfBoundsIndex(index) || isEmptyList()) 
            return null;
        else if (index == 0) 
            return this.head;   // if is head index returns head
        else if (index == this.size - 1) 
            return this.tail;   // if is tail index returns tail
        
        // If the input index is is at the lower half of the list, searches the list by starting at the head and 
        // moves forward. If the Input index is at the upper half of the list, searches the list by starting at
        // the tail and moving backwards. This helps speed up the search given a Runtime of 1/2 O(N) = O(N)

        if (currHead == this.head) 
            for (int i = 1; i <= index; i++)
                currHead = currHead.nextNode;
        else 
            for (int i = this.size - 2; i >= index; i--)
                currHead = currHead.prevNode;

        return currHead;
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
    public boolean deleteNodeAtIndex(int index) {
        if (isOutOfBoundsIndex(index) || isEmptyList()){
            return false;
        }
        else if (index == 0 && this.size == 1) {
            this.tail = this.head = this.head.nextNode;
        }
        else if (index == 0) {
            this.head = this.head.nextNode;
        }
        else if (index == this.size - 1) {
            this.tail = this.tail.prevNode;
            this.tail.nextNode = null;
        }
        else {
            Node deletedNode = getNodeAtIndex(index);
            deletedNode.prevNode.nextNode = deletedNode.nextNode;
            deletedNode.nextNode.prevNode = deletedNode.prevNode;
        }

        this.size--;
        return true;
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
        Node currTail = this.tail;

        // Searches the list from both sides simultaneously, to speed up the search
        for (int i = 0; i <= this.size / 2; i++) {
            if (currHead.data == value || currTail.data == value)
                return true;

            currHead = currHead.nextNode;
            currTail = currTail.prevNode;
        }
        return false;
    }

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

    public void printLinkedList() {
        if (isEmptyList()) {
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

    private boolean isEmptyList() {
        return this.head == null && this.tail == null;
    }

    private boolean isOutOfBoundsIndex(int index) {
        return (index >= getSize() || index < 0);
    }

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