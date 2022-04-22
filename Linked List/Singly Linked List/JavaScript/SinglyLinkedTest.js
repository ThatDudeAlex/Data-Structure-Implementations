const SinglyLinkedList = require('./SinglyLinkedImplementation')

testInsertFirst = () => {
    const funcName = 'testInsertFirst'
    const singlyLinkedList = new SinglyLinkedList()
    
    singlyLinkedList.insertFirst(2)
    singlyLinkedList.insertFirst(9)

    if (singlyLinkedList.size != 2) 
        failTest(funcName)
    else if (singlyLinkedList.head.data != 9) 
        failTest(funcName)
    else 
        passTest(funcName)
}

testInsertLast = () => {
    const funcName = 'testInsertLast'
    const singlyLinkedList = new SinglyLinkedList()
    
    singlyLinkedList.insertLast(2)

    if (singlyLinkedList.tail.data !== 2) {
        failTest(funcName)
        return
    } 

    singlyLinkedList.insertLast(9)

    if (singlyLinkedList.head.data !== 2 || singlyLinkedList.tail.data !== 9) {
        failTest(funcName)
        return
    }

    passTest(funcName)
}

testGetValidNode = () => {
    const funcName = 'testGetValidNode'
    const singlyLinkedList = new SinglyLinkedList()

    singlyLinkedList.insertFirst(2)
    singlyLinkedList.insertFirst(9)
    singlyLinkedList.insertFirst(3)

    if (singlyLinkedList.head.data !== 3) 
        failTest(funcName)
    else if (singlyLinkedList.getNodeAtIndex(1).data !== 9) 
        failTest(funcName)
    else if (singlyLinkedList.getNodeAtIndex(2).data !== 2)
        failTest(funcName)
    else
        passTest(funcName)
}

testGetInvalidNode = () => {
    const funcName = 'testGetInvalidNode'
    const singlyLinkedList = new SinglyLinkedList()

    if (singlyLinkedList.head !== null || singlyLinkedList.getNodeAtIndex(1) !== null) {
        failTest(funcName)
        return
    }

    singlyLinkedList.insertFirst(2)
    singlyLinkedList.insertFirst(9)
    singlyLinkedList.insertFirst(3)

    if (singlyLinkedList.getNodeAtIndex(3) !== null || singlyLinkedList.getNodeAtIndex(-1) !== null) {
        failTest(funcName)
        return
    }

    passTest(funcName)
}

testDeleteValidNode = () => {
    const funcName = 'testDeleteValidNode'
    const singlyLinkedList = new SinglyLinkedList()

    singlyLinkedList.insertFirst(2)
    singlyLinkedList.insertFirst(9)
    singlyLinkedList.insertFirst(3)

    singlyLinkedList.deleteNodeAtIndex(0)
    singlyLinkedList.deleteNodeAtIndex(1)

    singlyLinkedList.insertFirst(3)
    singlyLinkedList.insertFirst(10)
    singlyLinkedList.insertFirst(2)
    singlyLinkedList.insertFirst(7)
    singlyLinkedList.insertFirst(1)

    singlyLinkedList.deleteNodeAtIndex(3)
    singlyLinkedList.deleteNodeAtIndex(1)
    singlyLinkedList.deleteNodeAtIndex(3)

    if (singlyLinkedList.size !== 3)
        failTest(funcName)
    else if (singlyLinkedList.head.data !== 1 || singlyLinkedList.getNodeAtIndex(1).data !== 2 || singlyLinkedList.tail.data !== 3)
        failTest(funcName)
    else 
        passTest(funcName)
}

testDeleteInvalidNode = () => {
    const funcName = 'testDeleteInvalidNode'
    const singlyLinkedList = new SinglyLinkedList()

    if (singlyLinkedList.deleteNodeAtIndex(0) !== false) {
        failTest(funcName)
        return
    }

    singlyLinkedList.insertFirst(10)

    if (singlyLinkedList.deleteNodeAtIndex(1) !== false || singlyLinkedList.deleteNodeAtIndex(-1) !== false)
        failTest(funcName)
    else 
        passTest(funcName)
}

testSearch = () => {
    const funcName = 'testSearch'
    const singlyLinkedList = new SinglyLinkedList()

    singlyLinkedList.insertFirst(10)
    singlyLinkedList.insertFirst(4)
    singlyLinkedList.insertFirst(40)
    singlyLinkedList.insertFirst(6)
    singlyLinkedList.insertFirst(33)

    if (singlyLinkedList.search(10) && singlyLinkedList.search(4) && singlyLinkedList.search(40))
        passTest(funcName)
    else 
        failTest(funcName)
}

failTest = (funcName) => {
    console.log(`* ${funcName} : FAIL\n`)
}

passTest = (funcName) => {
    console.log(`* ${funcName} : PASS\n`)
}

testInsertFirst()
testInsertLast()
testGetValidNode()
testGetInvalidNode()
testDeleteValidNode()
testDeleteInvalidNode()
testSearch()