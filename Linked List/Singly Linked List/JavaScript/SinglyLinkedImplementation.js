class Node {
    constructor(data) {
        this.data = data
        this.nextNode = null
    }
}

class SinglyLinkedList {
    constructor(head = null, tail = null, size = 0) {
        this.head = head
        this.tail = tail
        this.size = size
    }

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

module.exports = SinglyLinkedList