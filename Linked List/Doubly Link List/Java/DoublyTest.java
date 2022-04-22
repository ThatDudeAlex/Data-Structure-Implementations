
public class DoublyTest {
    public static void main(String[] args) {
        testInsertFirst();
        testInsertLast();
        testGetValidNode();
        testGetInvalidNode();
        testDeleteValidNodeOnMultiNodeList();
        testDeleteValidNodeOnSingleNodeList();
        testDeleteInvalidNode();
        testSearchOnMultiNodeList();
        testSearchOnSingleNodeList();
        testSearchOnEmptyList();
    }

    private static void testInsertFirst() {
        String funcName = "testInsertFirst";
        DoublyImplementation doubly = new DoublyImplementation();
        
        doubly.insertFirst(2);
        doubly.insertFirst(9);

        DoublyImplementation.Node head = doubly.getHead();
        DoublyImplementation.Node tail = doubly.getTail();

        if (doubly.getSize() != 2 || head.data != 9)
            failTest(funcName);
        else if (head.prevNode != null || head.nextNode != tail || tail.prevNode != head)
            failTest(funcName);
        else
            passTest(funcName);
    }

    private static void testInsertLast() {
        String funcName = "testInsertLast";
        DoublyImplementation doubly = new DoublyImplementation();
        
        doubly.insertLast(2);

        if (doubly.getTail().data != 2 ) {
            failTest(funcName);
            return;
        }

        doubly.insertLast(9);

        DoublyImplementation.Node head = doubly.getHead();
        DoublyImplementation.Node tail = doubly.getTail();

        if (doubly.getHead().data != 2 || doubly.getTail().data != 9 ) 
            failTest(funcName);
        else if (head.prevNode != null || head.nextNode != tail || tail.prevNode != head) 
            failTest(funcName);
        else
            passTest(funcName);
    }
    
    private static void testGetValidNode() {
        String funcName = "testGetValidNode";
        DoublyImplementation doubly = new DoublyImplementation();
        
        doubly.insertFirst(2);
        doubly.insertFirst(9);
        doubly.insertFirst(7);
        doubly.insertFirst(8);
        doubly.insertFirst(3);

        if (doubly.getNodeAtIndex(0).data != 3 || doubly.getNodeAtIndex(4).data != 2)
            failTest(funcName);
        else if (doubly.getNodeAtIndex(1).data != 8 || doubly.getNodeAtIndex(2).data != 7 || doubly.getNodeAtIndex(3).data != 9)
            failTest(funcName);
        else
            passTest(funcName);
    }
    
    private static void testGetInvalidNode() {
        String funcName = "testGetInvalidNode";
        DoublyImplementation doubly = new DoublyImplementation();
        
        if (doubly.getHead() != null || doubly.getNodeAtIndex(1) != null) {
            failTest(funcName);
            return;
        } 

        doubly.insertFirst(2);
        doubly.insertFirst(9);
        doubly.insertFirst(3);

        if (doubly.getNodeAtIndex(3) != null || doubly.getNodeAtIndex(-1) != null)
            failTest(funcName);
        else
            passTest(funcName);
    }

    private static void testDeleteValidNodeOnMultiNodeList() {
        String funcName = "testDeleteValidNodeOnMultiNodeList";
        DoublyImplementation doubly = new DoublyImplementation();
        
        doubly.insertFirst(2);
        doubly.insertFirst(9);
        doubly.insertFirst(3);

        doubly.deleteNodeAtIndex(0);
        doubly.deleteNodeAtIndex(1);

        doubly.insertFirst(11);
        doubly.insertFirst(3);
        doubly.insertFirst(10);
        doubly.insertFirst(2);
        doubly.insertFirst(7);
        doubly.insertFirst(1);

        doubly.deleteNodeAtIndex(6);
        doubly.deleteNodeAtIndex(3);
        doubly.deleteNodeAtIndex(1);
        doubly.deleteNodeAtIndex(3);
        
        if (doubly.getSize() != 3)
            failTest(funcName);
        else if (doubly.getHead().data != 1 || doubly.getNodeAtIndex(1).data != 2 || doubly.getTail().data != 3)
            failTest(funcName);
        else 
            passTest(funcName);
    }

    private static void testDeleteValidNodeOnSingleNodeList() {
        String funcName = "testDeleteValidNodeOnSingleNodeList";
        DoublyImplementation doubly = new DoublyImplementation();
        
        doubly.insertFirst(2);
        doubly.deleteNodeAtIndex(0);
        
        if (doubly.getSize() != 0 || doubly.getHead() != null || doubly.getTail() != null) 
            failTest(funcName);
        else 
            passTest(funcName);
    }

    private static void testDeleteInvalidNode() {
        String funcName = "testDeleteInvalidNode";
        DoublyImplementation doubly = new DoublyImplementation();

        if (doubly.deleteNodeAtIndex(0)) {
            failTest(funcName);
            return;
        }

        doubly.insertFirst(10);
        
        if (doubly.deleteNodeAtIndex(1) || doubly.deleteNodeAtIndex(-1)) 
            failTest(funcName);
       else
            passTest(funcName);
    }

    private static void testSearchOnMultiNodeList() {
        String funcName = "testSearchOnMultiNodeList";
        DoublyImplementation doubly = new DoublyImplementation();

        doubly.insertFirst(10);
        doubly.insertFirst(4);
        doubly.insertFirst(40);
        doubly.insertFirst(6);
        doubly.insertFirst(33);

        if (doubly.search(10) && doubly.search(4) && doubly.search(40) && doubly.search(6) && doubly.search(33))
            passTest(funcName);
        else 
            failTest(funcName);
    }

    private static void testSearchOnSingleNodeList() {
        String funcName = "testSearchOnSingleNodeList";
        DoublyImplementation doubly = new DoublyImplementation();

        doubly.insertFirst(10);

        if (doubly.search(10))
            passTest(funcName);
        else 
            failTest(funcName);
    }

    private static void testSearchOnEmptyList() {
        String funcName = "testSearchOnEmptyList";
        DoublyImplementation doubly = new DoublyImplementation();

        doubly.insertFirst(10);
        doubly.deleteNodeAtIndex(0);

        if (doubly.search(10))
            failTest(funcName);
        else 
            passTest(funcName);
    }

    private static void failTest(String funcName) {
        System.out.printf("\n* %s : FAIL\n", funcName);
    }

    private static void passTest(String funcName) {
        System.out.printf("\n* %s : PASS\n", funcName);
    }
}
