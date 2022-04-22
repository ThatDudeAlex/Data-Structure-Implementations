public class SinglyLinkedTest {
    public static void main(String[] args) {
        testInsertFirst();
        testInsertLast();
        testGetValidNode();
        testGetInvalidNode();
        testDeleteValidNodeOnMultiNodeList();
        testDeleteValidNodeOnSingleNodeList();
        testDeleteInvalidNode();
        testSearch();
    }

    private static void testInsertFirst() {
        String funcName = "testInsertFirst";
        SinglyLinkedImplementation singly = new SinglyLinkedImplementation();
        
        singly.insertFirst(2);
        singly.insertFirst(9);

        if (singly.getSize() != 2 || singly.getHead().data != 9)
            failTest(funcName);
        else
            passTest(funcName);
    }

    private static void testInsertLast() {
        String funcName = "testInsertLast";
        SinglyLinkedImplementation singly = new SinglyLinkedImplementation();
        
        singly.insertLast(2);

        if (singly.getTail().data != 2 ) {
            failTest(funcName);
            return;
        }

        singly.insertLast(9);

       if (singly.getHead().data != 2 || singly.getTail().data != 9 ) 
            failTest(funcName);
        else
            passTest(funcName);
    }
    
    private static void testGetValidNode() {
        String funcName = "testGetValidNode";
        SinglyLinkedImplementation singly = new SinglyLinkedImplementation();
        
        singly.insertFirst(2);
        singly.insertFirst(9);
        singly.insertFirst(3);

        if (singly.getHead().data != 3 || singly.getNodeAtIndex(1).data != 9 || singly.getNodeAtIndex(2).data != 2)
            failTest(funcName);
        else
            passTest(funcName);
    }
    
    private static void testGetInvalidNode() {
        String funcName = "testGetInvalidNode";
        SinglyLinkedImplementation singly = new SinglyLinkedImplementation();
        
        if (singly.getHead() != null || singly.getNodeAtIndex(1) != null) {
            failTest(funcName);
            return;
        } 

        singly.insertFirst(2);
        singly.insertFirst(9);
        singly.insertFirst(3);

        if (singly.getNodeAtIndex(3) != null || singly.getNodeAtIndex(-1) != null)
            failTest(funcName);
        else
            passTest(funcName);
    }



    private static void testDeleteValidNodeOnMultiNodeList() {
        String funcName = "testDeleteValidNodeOnMultiNodeList";
        SinglyLinkedImplementation singly = new SinglyLinkedImplementation();
        
        singly.insertFirst(2);
        singly.insertFirst(9);
        singly.insertFirst(3);

        singly.deleteNodeAtIndex(0);
        singly.deleteNodeAtIndex(1);

        singly.insertFirst(3);
        singly.insertFirst(10);
        singly.insertFirst(2);
        singly.insertFirst(7);
        singly.insertFirst(1);

        singly.deleteNodeAtIndex(3);
        singly.deleteNodeAtIndex(1);
        singly.deleteNodeAtIndex(3);
        
        if (singly.getSize() != 3)
            failTest(funcName);
        else if (singly.getHead().data != 1 || singly.getNodeAtIndex(1).data != 2 || singly.getTail().data != 3)
            failTest(funcName);
        else 
            passTest(funcName);
    }

    private static void testDeleteValidNodeOnSingleNodeList() {
        String funcName = "testDeleteValidNodeOnSingleNodeList";
        SinglyLinkedImplementation singly = new SinglyLinkedImplementation();
        
        singly.insertFirst(2);
        singly.deleteNodeAtIndex(0);
        
        if (singly.getSize() != 0 || singly.getHead() != null || singly.getTail() != null) 
            failTest(funcName);
        else 
            passTest(funcName);
    }

    private static void testDeleteInvalidNode() {
        String funcName = "testDeleteInvalidNode";
        SinglyLinkedImplementation singly = new SinglyLinkedImplementation();

        if (singly.deleteNodeAtIndex(0)) {
            failTest(funcName);
            return;
        }

        singly.insertFirst(10);
        
        if (singly.deleteNodeAtIndex(1) || singly.deleteNodeAtIndex(-1)) 
            failTest(funcName);
       else
            passTest(funcName);
    }

    private static void testSearch() {
        String funcName = "testSearch";
        SinglyLinkedImplementation singly = new SinglyLinkedImplementation();

        singly.insertFirst(10);
        singly.insertFirst(4);
        singly.insertFirst(40);
        singly.insertFirst(6);
        singly.insertFirst(33);

        if (singly.search(10) && singly.search(4) && singly.search(40))
            passTest(funcName);
        else 
            failTest(funcName);
    }

    private static void failTest(String funcName) {
        System.out.printf("\n* %s : FAIL\n", funcName);
    }

    private static void passTest(String funcName) {
        System.out.printf("\n* %s : PASS\n", funcName);
    }
}