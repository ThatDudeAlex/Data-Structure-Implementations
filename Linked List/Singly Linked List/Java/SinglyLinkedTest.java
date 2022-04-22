public class SinglyLinkedTest {
    public static void main(String[] args) {
        testInsertFirst();
        testInsertLast();
        testGetInvalidNode();
        testGetValidNode();
        testDeleteValidNode();
        testDeleteInvalidNode();
        testSearch();
    }

    private static void testInsertFirst() {
        String funcName = "testInsertFirst";
        SinglyLinkedImplementation linkedList = new SinglyLinkedImplementation();
        
        linkedList.insertFirst(2);
        linkedList.insertFirst(9);

        if (linkedList.getSize() != 2) {
            failTest(funcName);
            return;
        } else if (linkedList.getHead().data != 9) {
            failTest(funcName);
            return;
        }

        passTest(funcName);
    }

    private static void testInsertLast() {
        String funcName = "testInsertLast";
        SinglyLinkedImplementation linkedList = new SinglyLinkedImplementation();
        
        linkedList.insertLast(2);

        if (linkedList.getTail().data != 2 ) {
            failTest(funcName);
            return;
        }

        linkedList.insertLast(9);

       if (linkedList.getHead().data != 2 || linkedList.getTail().data != 9 ) {
            failTest(funcName);
            return;
        }

        passTest(funcName);
    }

    private static void testGetInvalidNode() {
        String funcName = "testGetInvalidNode";
        SinglyLinkedImplementation linkedList = new SinglyLinkedImplementation();
        
        if (linkedList.getHead() != null) {
            failTest(funcName);
            return;
        } else if (linkedList.getNodeAtIndex(1) != null) {
            failTest(funcName);
            return;
        } 

        linkedList.insertFirst(2);
        linkedList.insertFirst(9);
        linkedList.insertFirst(3);

        if (linkedList.getNodeAtIndex(3) != null) {
            failTest(funcName);
            return;
        } else if (linkedList.getNodeAtIndex(-1) != null) {
            failTest(funcName);
            return;
        } 

        passTest(funcName);
    }


    private static void testGetValidNode() {
        String funcName = "testGetValidNode";
        SinglyLinkedImplementation linkedList = new SinglyLinkedImplementation();
        
        linkedList.insertFirst(2);
        linkedList.insertFirst(9);
        linkedList.insertFirst(3);

        if (linkedList.getHead().data != 3 ) {
            failTest(funcName);
            return;
        } else if (linkedList.getNodeAtIndex(1).data != 9) {
            failTest(funcName);
            return;
        } else if (linkedList.getNodeAtIndex(2).data != 2) {
            failTest(funcName);
            return;
        } 

        passTest(funcName);
    }

    private static void testDeleteValidNode() {
        String funcName = "testDeleteValidNode";
        SinglyLinkedImplementation linkedList = new SinglyLinkedImplementation();
        
        linkedList.insertFirst(2);
        linkedList.insertFirst(9);
        linkedList.insertFirst(3);

        linkedList.deleteNodeAtIndex(0);
        linkedList.deleteNodeAtIndex(1);

        linkedList.insertFirst(3);
        linkedList.insertFirst(10);
        linkedList.insertFirst(2);
        linkedList.insertFirst(7);
        linkedList.insertFirst(1);

        linkedList.deleteNodeAtIndex(3);
        linkedList.deleteNodeAtIndex(1);
        linkedList.deleteNodeAtIndex(3);
        
        if (linkedList.getSize() != 3) {
            failTest(funcName);
        } else if (linkedList.getHead().data != 1 || linkedList.getNodeAtIndex(1).data != 2 || linkedList.getTail().data != 3) {
            failTest(funcName);
        } else {
            passTest(funcName);
        }
    }

    private static void testDeleteInvalidNode() {
        String funcName = "testDeleteInvalidNode";
        SinglyLinkedImplementation linkedList = new SinglyLinkedImplementation();

        if (linkedList.deleteNodeAtIndex(0)) {
            failTest(funcName);
            return;
        }

        linkedList.insertFirst(10);
        
        if (linkedList.deleteNodeAtIndex(1) || linkedList.deleteNodeAtIndex(-1)) {
            failTest(funcName);
            return;
        }

        passTest(funcName);
    }

    private static void testSearch() {
        String funcName = "testSearch";
        SinglyLinkedImplementation linkedList = new SinglyLinkedImplementation();

        linkedList.insertFirst(10);
        linkedList.insertFirst(4);
        linkedList.insertFirst(40);
        linkedList.insertFirst(6);
        linkedList.insertFirst(33);

        if (linkedList.search(10) && linkedList.search(4) && linkedList.search(40)) {
            passTest(funcName);
        } else {
            failTest(funcName);
        }
    }

    private static void failTest(String funcName) {
        System.out.printf("\n* %s : FAIL\n", funcName);
    }

    private static void passTest(String funcName) {
        System.out.printf("\n* %s : PASS\n", funcName);
    }
}