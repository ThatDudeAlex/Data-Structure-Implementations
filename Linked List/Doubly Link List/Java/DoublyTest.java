
public class DoublyTest {
    public static void main(String[] args) {
        testInitListWithoutParams();
        testInitListWithParams();
        testInsertFirstWithEmptyList();
        testInsertFirstOnListWithSingleNode();
        testInsertFirstOnListWithhMultipleNodes();
        testInsertLasttWithEmptyList();
        testInsertLastOnListWithSingleNode();
        testInsertLastOnListWithhMultipleNodes();
        testInsertAtIndexWithEmptyListAtIndexZero();
        testInsertAtIndexWithNonEmptyListAtIndexZero();
        testInsertAtIndexWithInvalidIndexes();
        testInsertAtIndexWithNonEmptyList();
        // testGetValidNode();
        // testGetInvalidNode();
        // testDeleteValidNodeOnSingleNodeList();
        // testDeleteValidNodeOnMultiNodeList();
        // testDeleteInvalidNode();
        // testSearchOnMultiNodeList();
        // testSearchOnSingleNodeList();
        // testSearchOnEmptyList();
    }

    public static void testInitListWithoutParams() {
        String funcName = "initListWithoutParams";
        DoublyImplementation  list = new DoublyImplementation();
        DoublyImplementation.Node head = list.getFirstNode();
        DoublyImplementation.Node tail = list.getLastNode();

        if (list.getSize() != 0 || head != null || tail != null) 
            failTest(funcName);
        else 
            passTest(funcName);
    }

     public static void testInitListWithParams() {
        String funcName = "initListWithParams";
        DoublyImplementation  list = new DoublyImplementation(4);
        DoublyImplementation.Node head = list.getFirstNode();
        DoublyImplementation.Node tail = list.getLastNode();

        if (list.getSize() != 1 || head == null || tail == null) 
            failTest(funcName);
        else if (head.data != 4 || head.prevNode != null || head.nextNode != null || head != tail)
            failTest(funcName);
        else 
            passTest(funcName);
    }

    public static void testInsertFirstWithEmptyList() {
        String funcName = "testInsertFirstWithEmptyList";
        DoublyImplementation  list = new DoublyImplementation();
        
        list.insertFirst(4);
        DoublyImplementation.Node head =  list.getFirstNode();
        DoublyImplementation.Node tail = list.getLastNode();

        if (list.getSize() != 1 || head == null || tail == null) 
            failTest(funcName);
        else if (head.data != 4 || head.prevNode != null || head.nextNode != null || head != tail)
            failTest(funcName);
        else 
            passTest(funcName);
    }

    
     public static void testInsertFirstOnListWithSingleNode() {
        String funcName = "testInsertFirstOnListWithSingleNode";
        DoublyImplementation  list = new DoublyImplementation(2);
        
        list.insertFirst(9);
        DoublyImplementation.Node head =  list.getFirstNode();
        DoublyImplementation.Node tail = list.getLastNode();

        if ( list.getSize() != 2 )
            failTest(funcName);
        else if (head.data != 9 || tail.data != 2) 
            failTest(funcName);
        else if (head.nextNode != tail || head.prevNode != null || tail.nextNode != null)
            failTest(funcName);
        else
            passTest(funcName);
    }

    
     public static void testInsertFirstOnListWithhMultipleNodes() {
        String funcName = "testInsertFirstOnListWithhMultipleNodes";
        DoublyImplementation  list = new DoublyImplementation(2);
        
        list.insertFirst(9);
        list.insertFirst(7);
        DoublyImplementation.Node head =  list.getFirstNode();
        DoublyImplementation.Node tail = list.getLastNode();

        if ( list.getSize() != 3 )
            failTest(funcName);
        else if (head.data != 7 || head.nextNode.data != 9 || tail.data != 2) 
            failTest(funcName);
        else if (head.nextNode.nextNode != tail || head.prevNode != null || tail.nextNode != null)
            failTest(funcName);
        else
            passTest(funcName);
    }

    public static void testInsertLasttWithEmptyList() {
        String funcName = "testInsertLasttWithEmptyList";
        DoublyImplementation  list = new DoublyImplementation();
        
         list.insertLast(2);
        DoublyImplementation.Node head =  list.getFirstNode();
        DoublyImplementation.Node tail = list.getLastNode();

        if (list.getSize() != 1 || head == null || tail == null) 
            failTest(funcName);
        else if (head.data != 2 || head.prevNode != null || head.nextNode != null || head != tail)
            failTest(funcName);
        else 
            passTest(funcName);
    }

    
     public static void testInsertLastOnListWithSingleNode() {
        String funcName = "testInsertLastOnListWithSingleNode";
        DoublyImplementation  list = new DoublyImplementation(2);
        
        list.insertLast(9);
        DoublyImplementation.Node head =  list.getFirstNode();
        DoublyImplementation.Node tail = list.getLastNode();

        if ( list.getSize() != 2 )
            failTest(funcName);
        else if (head.data != 2 || tail.data != 9) 
            failTest(funcName);
        else if (head.nextNode != tail || head.prevNode != null || tail.nextNode != null)
            failTest(funcName);
        else
            passTest(funcName);
    }

    
     public static void testInsertLastOnListWithhMultipleNodes() {
        String funcName = "testInsertFirstOnListWithhMultipleNodes";
        DoublyImplementation  list = new DoublyImplementation(2);
        
        list.insertLast(9); list.insertLast(7);
        DoublyImplementation.Node head =  list.getFirstNode();
        DoublyImplementation.Node tail = list.getLastNode();

        if ( list.getSize() != 3 )
            failTest(funcName);
        else if (head.data != 2 || head.nextNode.data != 9 || tail.data != 7) 
            failTest(funcName);
        else if (head.nextNode.nextNode != tail || head.prevNode != null || tail.nextNode != null)
            failTest(funcName);
        else
            passTest(funcName);
    }

    public static void testInsertAtIndexWithEmptyListAtIndexZero() {
        String funcName = "testInsertAtIndexWithEmptyListAtIndexZero";
        DoublyImplementation  list = new DoublyImplementation();

        if (!list.insertAtIndex(0, 2) || list.getSize() != 1 || list.getFirstNode().data != 2)
            failTest(funcName);
        else if (list.getFirstNode() != list.getLastNode())
            failTest(funcName);
        else 
            passTest(funcName);
    }

    public static void testInsertAtIndexWithNonEmptyListAtIndexZero() {
        String funcName = "testInsertAtIndexWithNonEmptyListAtIndexZero";
        DoublyImplementation  list = new DoublyImplementation(2);

        list.insertLast(9); list.insertLast(7);

        if (!list.insertAtIndex(0, 5) || list.getSize() != 4|| list.getFirstNode().data != 5)
            failTest(funcName);
        else if (list.getFirstNode().nextNode.data != 2 || list.getFirstNode().nextNode.prevNode != list.getFirstNode())
            failTest(funcName);
        else 
            passTest(funcName);
    }

    public static void testInsertAtIndexWithInvalidIndexes() {
        String funcName = "testInsertAtIndexWithInvalidIndexes";
        DoublyImplementation  list = new DoublyImplementation();

        if (list.insertAtIndex(1, 2) || list.insertAtIndex(-1, 2))
            failTest(funcName);
        else if (list.getSize() != 0 || list.getFirstNode() != null)
            failTest(funcName);
        else 
            passTest(funcName);
    }

    public static void testInsertAtIndexWithNonEmptyList() {
        String funcName = "testInsertAtIndexWithNonEmptyList";
        DoublyImplementation  list = new DoublyImplementation(2);

        list.insertLast(9); list.insertLast(7);

        if (!list.insertAtIndex(1, 5) || !list.insertAtIndex(3, 8) || list.getSize() != 5)
            failTest(funcName);
        else if (list.getFirstNode().nextNode.data != 5)
            failTest(funcName);
        else if (list.getFirstNode().nextNode.nextNode.nextNode.data != 8)
            failTest(funcName);
        else 
            passTest(funcName);
    }

    //====
    
    public static void testGetValidNode() {
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
    
    public static void testGetInvalidNode() {
        String funcName = "testGetInvalidNode";
        DoublyImplementation doubly = new DoublyImplementation();
        
        if (doubly.getFirstNode() != null || doubly.getNodeAtIndex(1) != null) {
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

    public static void testDeleteValidNodeOnMultiNodeList() {
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
        else if (doubly.getFirstNode().data != 1 || doubly.getNodeAtIndex(1).data != 2 || doubly.getLastNode().data != 3)
            failTest(funcName);
        else 
            passTest(funcName);
    }

    public static void testDeleteValidNodeOnSingleNodeList() {
        String funcName = "testDeleteValidNodeOnSingleNodeList";
        DoublyImplementation doubly = new DoublyImplementation();
        
        doubly.insertFirst(2);

        DoublyImplementation.Node headToBeDeleted = doubly.getFirstNode();
        DoublyImplementation.Node deletedNode = doubly.deleteNodeAtIndex(0);
        
        if (doubly.getSize() != 0 || doubly.getFirstNode() != null || doubly.getLastNode() != null) 
            failTest(funcName);
        else if (headToBeDeleted != deletedNode)
            failTest(funcName);
        else 
            passTest(funcName);
    }

    public static void testDeleteInvalidNode() {
        String funcName = "testDeleteInvalidNode";
        DoublyImplementation doubly = new DoublyImplementation();

        if (doubly.deleteNodeAtIndex(0) != null) {
            failTest(funcName);
            return;
        }

        doubly.insertFirst(10);
        
        if (doubly.deleteNodeAtIndex(1) != null || doubly.deleteNodeAtIndex(-1) != null) 
            failTest(funcName);
       else
            passTest(funcName);
    }

    public static void testSearchOnMultiNodeList() {
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

    public static void testSearchOnSingleNodeList() {
        String funcName = "testSearchOnSingleNodeList";
        DoublyImplementation doubly = new DoublyImplementation();

        doubly.insertFirst(10);

        if (doubly.search(10))
            passTest(funcName);
        else 
            failTest(funcName);
    }

    public static void testSearchOnEmptyList() {
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
        String red = "\u001B[31m";
        System.out.printf("\n%s* %s : FAIL\n", red, funcName);
    }

    private static void passTest(String funcName) {
        String green = "\u001B[32m";
        System.out.printf("\n%s* %s : PASS\n", green, funcName);
    }
}
