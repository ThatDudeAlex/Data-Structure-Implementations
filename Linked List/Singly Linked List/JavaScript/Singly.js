class Node {
    constructor(data) {
        this.data = data
        this.nextNode = null
    }
}

class Singly {
    constructor(head = null, tail = null, size = 0) {
        this.head = head
        this.tail = tail
        this.size = size
    }

    /**
     * Inserts a new node at the beginning of the list
     * 
     * Runtime: O(1)
     * 
     * @param data The value that the new node will hold
     */
    insertFirst(data) {
        if (!isNumber(data)) {
            console.log("This Linked List only accepts numberic value")
            return
        }

        if (this.isEmptyList()) {
            this.head = new Node(data)
            this.tail = this.head
        } else {
            let newHead = new Node(data);
            newHead.nextNode = this.head;
            this.head = newHead;
        }
        this.size++;
    }

    /**
     * Inserts a new node at the end of the list
     * 
     * Runtime: O(1)
     * 
     * @param data The value that the new node will hold
     */
    insertLast(data) {
        if (!isNumber(data)) {
            console.log("This Linked List only accepts numberic value")
            return
        }

        if (this.isEmptyList()) {
            this.head = new Node(data)
            this.tail = this.head
        } else {
            this.tail.nextNode = new Node(data)
            this.tail = this.tail.nextNode
        }
        this.size++;
    }

    /**
     * Returns the node at the given index if it exist, else returns null
     * 
     * Runtime: O(N)
     * 
     * @param index the location of a node in the linked list
     * 
     * @return The node located at the given index
     */
    getNodeAtIndex(index) {
        if (this.isEmptyList() || !isValidIndex(index, this.size)) 
            return null
        else if (index === 0)
            return this.head
        else if (index === this.size - 1)
            return this.tail

        let currHead = this.head

        for (let i = 0; i < index; i++)
            currHead = currHead.nextNode
        
        return currHead
    }

    /**
     * Deletes the node located at the given index if it exist
     * 
     * Runtime: O(N)
     * 
     * @param index the location of a node in the linked list
     * 
     * @return A boolean stating whether or not a node was deleted
     */
    deleteNodeAtIndex(index) {
        if (this.isEmptyList() || !isValidIndex(index, this.size))
            return false
        
        if (index === 0) {
            this.head = this.head.nextNode
        } else {
            let prevHead = null
            let currHead = this.head

            for (let i = 0; i < index; i++) {
                prevHead = currHead
                currHead = currHead.nextNode
            }
            prevHead.nextNode = currHead.nextNode

            if (index === this.size - 1) 
                this.tail = prevHead
        }

        this.size = this.size - 1
        return true
    }

    /**
     * Searches the linked list to see if it contains the given value
     * 
     * Runtime: O(N)
     * 
     * @param value to search the linked list for
     * 
     * @return Whether or not the value is found in the linked list
     */
    search(value) {
        let currHead = this.head

        while (currHead !== null) {
            if (currHead.data === value)
                return true 

            currHead = currHead.nextNode
        }
        return false
    }

    isEmptyList() {
        return (this.size === 0 && this.head === null) 
    }
}

isNumber = (data) => Number.isFinite(data)

isValidIndex = (index, listSize) => {
    if (index >= listSize || index < 0)
        return false

    return true
}

module.exports = Singly