public class SinglyTest {
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

    public static void testInsertFirst() {
        String funcName = "testInsertFirst";
        SinglyImplementation singly = new SinglyImplementation();
        
        singly.insertFirst(2);
        singly.insertFirst(9);

        if (singly.getSize() != 2 || singly.getHead().data != 9)
            failTest(funcName);
        else
            passTest(funcName);
    }

    public static void testInsertLast() {
        String funcName = "testInsertLast";
        SinglyImplementation singly = new SinglyImplementation();
        
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
    
    public static void testGetValidNode() {
        String funcName = "testGetValidNode";
        SinglyImplementation singly = new SinglyImplementation();
        
        singly.insertFirst(2);
        singly.insertFirst(9);
        singly.insertFirst(3);

        if (singly.getHead().data != 3 || singly.getNodeAtIndex(1).data != 9 || singly.getNodeAtIndex(2).data != 2)
            failTest(funcName);
        else
            passTest(funcName);
    }
    
    public static void testGetInvalidNode() {
        String funcName = "testGetInvalidNode";
        SinglyImplementation singly = new SinglyImplementation();
        
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



    public static void testDeleteValidNodeOnMultiNodeList() {
        String funcName = "testDeleteValidNodeOnMultiNodeList";
        SinglyImplementation singly = new SinglyImplementation();
        
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

    public static void testDeleteValidNodeOnSingleNodeList() {
        String funcName = "testDeleteValidNodeOnSingleNodeList";
        SinglyImplementation singly = new SinglyImplementation();
        
        singly.insertFirst(2);
        singly.deleteNodeAtIndex(0);
        
        if (singly.getSize() != 0 || singly.getHead() != null || singly.getTail() != null) 
            failTest(funcName);
        else 
            passTest(funcName);
    }

    public static void testDeleteInvalidNode() {
        String funcName = "testDeleteInvalidNode";
        SinglyImplementation singly = new SinglyImplementation();

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

    public static void testSearch() {
        String funcName = "testSearch";
        SinglyImplementation singly = new SinglyImplementation();

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
        String red = "\u001B[31m";
        System.out.printf("\n%s* %s : FAIL\n", red, funcName);
    }

    private static void passTest(String funcName) {
        String green = "\u001B[32m";
        System.out.printf("\n%s* %s : PASS\n", green, funcName);
    }
}