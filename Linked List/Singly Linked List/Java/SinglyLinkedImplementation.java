
public class SinglyLinkedImplementation {    
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
            this.head = newNode;

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
        if (isEmptyList()) 
            this.head = this.tail = new Node(data);
        else 
            this.tail = this.tail.nextNode = new Node(data);

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
        Node currHead = this.head;

        if (isOutOfBoundsIndex(index) || isEmptyList()) 
            return null;
        else if (index == 0) 
            return this.head;   // if is head index returns head
        else if (index == this.size - 1) 
            return this.tail;   // if is tail index returns tail

        for (int i = 1; i <= index; i++)
            currHead = currHead.nextNode;
        
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
        if (isOutOfBoundsIndex(index) || isEmptyList())
            return false;

        else if (index == 0 && this.size == 1) 
            this.tail = this.head = this.head.nextNode;
        
        else if (index == 0) 
            this.head = this.head.nextNode;
        
        else {
            Node prevHead = this.head;
            Node currHead = this.head.nextNode;

            for (int i = 1; i < index; i++) {
                prevHead = currHead;
                currHead = currHead.nextNode;
            }
            prevHead.nextNode = currHead.nextNode;

            if (index == this.size - 1) 
                this.tail = prevHead;
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
        Node currHead = this.head;

        while (currHead != null && currHead.data != value)
            currHead = currHead.nextNode;

        return (currHead != null && currHead.data == value);
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

    private boolean isEmptyList() {
        return this.head == null && this.tail == null;
    }

    private boolean isOutOfBoundsIndex(int index) {
        return (index >= getSize() || index < 0);
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