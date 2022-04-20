
public class SinglyLinkedImplementation {    
    private Node head = null;
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
    public void insert(int data) {
        if (isEmptyList()) {
            this.head = new Node(data);
        } else {
            Node newHead = new Node(data, head);
            this.head = newHead;
        }
        size++;
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
        if (!isValidIndex(index) || isEmptyList()) {
            return null;
        }

        Node currHead = this.head;

        for (int idx = 0; idx < index; idx++) {
            currHead = currHead.nextNode;
        }
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
        if (!isValidIndex(index) || isEmptyList()) {
            return false;
        } 
        
        if (index == 0) {
            this.head = this.head.nextNode;
        } else {
            Node prevHead = null;
            Node currHead = this.head;

            for (int idx = 0; idx < index; idx++) {
                prevHead = currHead;
                currHead = currHead.nextNode;
            }
            prevHead.nextNode = currHead.nextNode;
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

        while (currHead != null) {
            if (currHead.data == value) {
                return true;
            }
            currHead = currHead.nextNode;
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
        return getSize() == 0 && getHead() == null ;
    }

    private boolean isValidIndex(int index) {
        if (index >= getSize() || index < 0) { 
            return false;
        }
        return true;
    }
}