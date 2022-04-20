public class SinglyLinkedTest {
    public static void main(String[] args) {
        testInsertion();
        testGetInvalidNode();
        testGetValidNode();
        testDeleteValidNode();
        testDeleteInvalidNode();
        testSearch();
    }

    private static void testInsertion() {
        String funcName = "testInsertion";
        SinglyLinkedImplementation linkedList = new SinglyLinkedImplementation();
        
        linkedList.insert(2);
        linkedList.insert(9);

        if (linkedList.getSize() != 2) {
            failTest(funcName);
            return;
        } else if (linkedList.getHead().data != 9) {
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

        linkedList.insert(2);
        linkedList.insert(9);
        linkedList.insert(3);

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
        
        linkedList.insert(2);
        linkedList.insert(9);
        linkedList.insert(3);

        if (linkedList.getHead().data != 3 ) {
            failTest(funcName);
            return;
        } else if (linkedList.getNodeAtIndex(0).data != 3) {
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
        
        linkedList.insert(2);
        linkedList.insert(9);
        linkedList.insert(3);

        linkedList.deleteNodeAtIndex(0);
        linkedList.deleteNodeAtIndex(1);

        linkedList.insert(3);
        linkedList.insert(10);
        linkedList.insert(2);
        linkedList.insert(7);
        linkedList.insert(1);

        linkedList.deleteNodeAtIndex(3);
        linkedList.deleteNodeAtIndex(1);
        linkedList.deleteNodeAtIndex(3);
        
        if (linkedList.getSize() != 3) {
            failTest(funcName);
        } else if (linkedList.getNodeAtIndex(0).data != 1 || linkedList.getNodeAtIndex(1).data != 2 || linkedList.getNodeAtIndex(2).data != 3) {
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

        linkedList.insert(10);
        
        if (linkedList.deleteNodeAtIndex(1) || linkedList.deleteNodeAtIndex(-1)) {
            failTest(funcName);
            return;
        }

        passTest(funcName);
    }

    private static void testSearch() {
        String funcName = "testSearch";
        SinglyLinkedImplementation linkedList = new SinglyLinkedImplementation();

        linkedList.insert(10);
        linkedList.insert(4);
        linkedList.insert(40);
        linkedList.insert(6);
        linkedList.insert(33);

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