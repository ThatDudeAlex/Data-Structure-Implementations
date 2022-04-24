
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
        testDeleteFirstOnEmptyList();
        testDeleteFirstOnListWithSingleNode();
        testDeleteFirstOnListWithMultipleNodes();
        testDeleteLastOnEmptyList();
        testDeleteLastOnListWithSingleNode();
        testDeleteLastOnListWithMultipleNodes();
        testDeleteNodeAtIndexWithInvalidIndexes();
        testDeleteNodeAtIndexWithIndexOfHead();
        testDeleteNodeAtIndexWithIndexOfTail();
        testDeleteNodeAtIndex();
        testGetFirstNodeOnEmptyList();
        testGetFirstNodeOnListWithSingleNode();
        testGetFirstNodeOnListWithMultipleNodes();
        testGetLastNodeOnEmptyList();
        testGetLastNodeOnListWithSingleNode();
        testGetLastNodeOnListWithMultipleNodes();
        testGetNodeAtIndexWithInvalidIndexes();
        testGetNodeAtIndexWithIndexOfHead();
        testGetNodeAtIndexWithIndexOfLastNode();
        testGetNodeAtIndex();
        testSearch();
        testIsEmptyListWithEmptyList();
        testIsEmptyListOnSigleNodeList();
        testIsEmptyListOnMultiNodeList();
        testGetSize();
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
        else if (head.nextNode != tail || tail.prevNode != head || head.prevNode != null || tail.nextNode != null)
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
        else if (head.nextNode.nextNode != tail || tail.prevNode != head.nextNode || head.prevNode != null || tail.nextNode != null)
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
        else if (list.getFirstNode().nextNode.data != 5 || list.getFirstNode().nextNode.nextNode.nextNode.data != 8)
            failTest(funcName);
        else if (list.getFirstNode().nextNode.prevNode != list.getFirstNode())
            failTest(funcName);
        else if (list.getFirstNode().nextNode.nextNode.nextNode.prevNode != list.getFirstNode().nextNode.nextNode)
            failTest(funcName);
        else 
            passTest(funcName);
    }

    public static void testDeleteFirstOnEmptyList() {
        String funcName = "testDeleteFirstOnEmptyList";
        DoublyImplementation  list = new DoublyImplementation();
     
        DoublyImplementation.Node deletedNode = list.deleteFirstNode();
        
        if ( list.getSize() != 0 ||  deletedNode != null) 
            failTest(funcName);
        else 
            passTest(funcName);
    }

     public static void testDeleteFirstOnListWithSingleNode() {
        String funcName = "testDeleteFirstOnListWithSingleNode";
        DoublyImplementation  list = new DoublyImplementation(2);
        DoublyImplementation.Node nodeToRemove = list.getFirstNode();
        DoublyImplementation.Node deletedNode = list.deleteFirstNode();
        
        if ( list.getSize() != 0 || list.getFirstNode() != null || list.getLastNode() != null || deletedNode != nodeToRemove) 
            failTest(funcName);
        else 
            passTest(funcName);
    }

     public static void testDeleteFirstOnListWithMultipleNodes() {
        String funcName = "testDeleteFirstOnListWithMultipleNodes";
        DoublyImplementation  list = new DoublyImplementation(2);

        list.insertFirst(3); list.insertFirst(4); list.insertFirst(5);

        DoublyImplementation.Node headToRemove = list.getFirstNode();
        DoublyImplementation.Node deletedNode = list.deleteFirstNode();
        DoublyImplementation.Node newHead = list.getFirstNode();
        
        if ( list.getSize() != 3 || deletedNode != headToRemove) 
            failTest(funcName);
        else if (newHead.data != 4 || newHead.nextNode.data != 3 || newHead.nextNode.nextNode.data != 2)
            failTest(funcName);
        else if (newHead.prevNode != null || newHead.nextNode.prevNode != newHead)
            failTest(funcName);
        else 
            passTest(funcName);
    }

     public static void testDeleteLastOnEmptyList() {
        String funcName = "testDeleteLastOnEmptyList";
        DoublyImplementation  list = new DoublyImplementation();
     
        DoublyImplementation.Node deletedNode = list.deleteLastNode();
        
        if ( list.getSize() != 0 ||  deletedNode != null) 
            failTest(funcName);
        else 
            passTest(funcName);
    }

     public static void testDeleteLastOnListWithSingleNode() {
        String funcName = "testDeleteLastOnListWithSingleNode";
        DoublyImplementation  list = new DoublyImplementation(2);
        DoublyImplementation.Node tailNodeToRemove = list.getLastNode();
        DoublyImplementation.Node deletedNode = list.deleteLastNode();
        
        if ( list.getSize() != 0 || list.getFirstNode() != null || list.getLastNode() != null || deletedNode != tailNodeToRemove) 
            failTest(funcName);
        else 
            passTest(funcName);
    }

     public static void testDeleteLastOnListWithMultipleNodes() {
        String funcName = "testDeleteLastOnListWithMultipleNodes";
        DoublyImplementation  list = new DoublyImplementation(2);

        list.insertFirst(3); list.insertFirst(4); list.insertFirst(5);

        DoublyImplementation.Node head = list.getFirstNode();
        DoublyImplementation.Node lastNodeToRemove = list.getLastNode();
        DoublyImplementation.Node deletedNode = list.deleteLastNode();
        
        if ( list.getSize() != 3 || deletedNode != lastNodeToRemove) 
            failTest(funcName);
        else if (head.data != 5 || head.nextNode.data != 4 || head.nextNode.nextNode.data != 3)
            failTest(funcName);
        else if (head.nextNode.nextNode.nextNode != null || deletedNode.prevNode != null)
            failTest(funcName);
        else 
            passTest(funcName);
    }

     public static void testDeleteNodeAtIndexWithInvalidIndexes() {
        String funcName = "testGetNodeAtIndexWithInvalidIndexes";
        DoublyImplementation  list = new DoublyImplementation();
        DoublyImplementation.Node nodeDeleted1 =  list.deleteNodeAtIndex(0);

        list.insertFirst(2); list.insertFirst(3);

        DoublyImplementation.Node nodeDeleted2 =  list.deleteNodeAtIndex(3);
        DoublyImplementation.Node nodeDeleted3 =  list.deleteNodeAtIndex(-1);

        if (list.getSize() != 2 || nodeDeleted1 != null || nodeDeleted2 != null || nodeDeleted3 != null)
            failTest(funcName);
        else
            passTest(funcName);
    }

     public static void testDeleteNodeAtIndexWithIndexOfHead() {
        String funcName = "testDeleteNodeAtIndexWithIndexOfHead";
        DoublyImplementation  list = new DoublyImplementation(2);
        DoublyImplementation.Node head =  list.getFirstNode();
        DoublyImplementation.Node nodeDeleted =  list.deleteNodeAtIndex(0);

        if (list.getSize() != 0 || nodeDeleted != head)
            failTest(funcName);
        else
            passTest(funcName);
    }

     public static void testDeleteNodeAtIndexWithIndexOfTail() {
        String funcName = "testDeleteNodeAtIndexWithIndexOfTail";
        DoublyImplementation  list = new DoublyImplementation(2);

        list.insertLast(3); list.insertLast(4); list.insertLast(5);

        DoublyImplementation.Node tailNode =  list.getLastNode();
        DoublyImplementation.Node nodeDeleted =  list.deleteNodeAtIndex(3);

        if (list.getSize() != 3 || nodeDeleted != tailNode)
            failTest(funcName);
        else
            passTest(funcName);
    }

     public static void testDeleteNodeAtIndex() {
        String funcName = "testDeleteNodeAtIndex";
        DoublyImplementation  list = new DoublyImplementation(2);

        list.insertLast(3); list.insertLast(4); list.insertLast(5);

        DoublyImplementation.Node nodeDeleted1 =  list.deleteNodeAtIndex(1);
        DoublyImplementation.Node nodeDeleted2 =  list.deleteNodeAtIndex(1);
        DoublyImplementation.Node head =  list.getFirstNode();
        DoublyImplementation.Node tail =  list.getLastNode();

        if (list.getSize() != 2 || head.data != 2 || tail.data != 5)
            failTest(funcName);
        else if (nodeDeleted1.data != 3 || nodeDeleted2.data != 4)
            failTest(funcName);
        else if (head.nextNode != tail || tail.prevNode != head || head.prevNode != null || tail.nextNode != null)
            failTest(funcName);
        else
            passTest(funcName);
    }

     public static void testGetFirstNodeOnEmptyList() {
        String funcName = "testGetFirstNodeOnEmptyList";
        DoublyImplementation  list = new DoublyImplementation();
        DoublyImplementation.Node nodeRetrieved =  list.getFirstNode();
        
        if (list.getSize() != 0 || nodeRetrieved != null)
            failTest(funcName);
        else
            passTest(funcName);
    }

     public static void testGetFirstNodeOnListWithSingleNode() {
        String funcName = "testGetFirstNodeOnListWithSingleNode";
        DoublyImplementation  list = new DoublyImplementation(2);
        DoublyImplementation.Node nodeRetrieved =  list.getFirstNode();
        
        if (list.getSize() != 1 || nodeRetrieved.data != 2)
            failTest(funcName);
        else
            passTest(funcName);
    }

     public static void testGetFirstNodeOnListWithMultipleNodes() {
        String funcName = "testGetFirstNodeOnListWithMultipleNodes";
        DoublyImplementation  list = new DoublyImplementation(2);
        DoublyImplementation.Node nodeRetrieved =  list.getFirstNode();

        list.insertLast(3); list.insertLast(4); list.insertLast(5);

        if (list.getSize() != 4 || nodeRetrieved.data != 2)
            failTest(funcName);
        else
            passTest(funcName);
    }

     public static void testGetLastNodeOnEmptyList() {
        String funcName = "testGetLastNodeOnEmptyList";
        DoublyImplementation  list = new DoublyImplementation();
        DoublyImplementation.Node nodeRetrieved =  list.getLastNode();
        
        if (list.getSize() != 0 || nodeRetrieved != null)
            failTest(funcName);
        else
            passTest(funcName);
    }

     public static void testGetLastNodeOnListWithSingleNode() {
        String funcName = "testGetLastNodeOnListWithSingleNode";
        DoublyImplementation  list = new DoublyImplementation(2);
        DoublyImplementation.Node nodeRetrieved =  list.getLastNode();
        
        if (list.getSize() != 1 || nodeRetrieved.data != 2)
            failTest(funcName);
        else
            passTest(funcName);
    }

     public static void testGetLastNodeOnListWithMultipleNodes() {
        String funcName = "testGetLastNodeOnListWithMultipleNodes";
        DoublyImplementation  list = new DoublyImplementation(2);

        list.insertLast(3); list.insertLast(4); list.insertLast(5);
        DoublyImplementation.Node nodeRetrieved =  list.getLastNode();

        if (list.getSize() != 4 || nodeRetrieved.data != 5)
            failTest(funcName);
        else
            passTest(funcName);
    }
    
     public static void testGetNodeAtIndexWithInvalidIndexes() {
        String funcName = "testGetNodeAtIndexWithInvalidIndexes";
        DoublyImplementation  list = new DoublyImplementation();
        DoublyImplementation.Node nodeRetrieved1 =  list.getNodeAtIndex(0);

        list.insertFirst(2); list.insertFirst(3);

        DoublyImplementation.Node nodeRetrieved2 =  list.getNodeAtIndex(3);
        DoublyImplementation.Node nodeRetrieved3 =  list.getNodeAtIndex(-1);

        if (list.getSize() != 2 || nodeRetrieved1 != null || nodeRetrieved2 != null || nodeRetrieved3 != null)
            failTest(funcName);
        else
            passTest(funcName);
    }

     public static void testGetNodeAtIndexWithIndexOfHead() {
        String funcName = "testGetNodeAtIndexWithIndexOfHead";
        DoublyImplementation  list = new DoublyImplementation(2);
        DoublyImplementation.Node nodeRetrieved =  list.getNodeAtIndex(0);
        DoublyImplementation.Node head =  list.getFirstNode();

        if (list.getSize() != 1 || nodeRetrieved != head)
            failTest(funcName);
        else
            passTest(funcName);
    }

     public static void testGetNodeAtIndexWithIndexOfLastNode() {
        String funcName = "testGetNodeAtIndexWithIndexOfLastNode";
        DoublyImplementation  list = new DoublyImplementation(2);

        list.insertLast(3); list.insertLast(4); list.insertLast(5);

        DoublyImplementation.Node nodeRetrieved =  list.getNodeAtIndex(3);
        DoublyImplementation.Node lastNode =  list.getLastNode();

        if (list.getSize() != 4 || nodeRetrieved != lastNode)
            failTest(funcName);
        else
            passTest(funcName);
    }

     public static void testGetNodeAtIndex() {
        String funcName = "testGetNodeAtIndex";
        DoublyImplementation  list = new DoublyImplementation(2);

        list.insertLast(3); list.insertLast(4); list.insertLast(5);

        DoublyImplementation.Node nodeRetrieved1 =  list.getNodeAtIndex(1);
        DoublyImplementation.Node nodeRetrieved2 =  list.getNodeAtIndex(2);

        if (list.getSize() != 4 || nodeRetrieved1.data != 3 || nodeRetrieved2.data != 4)
            failTest(funcName);
        else
            passTest(funcName);
    }

     public static void testSearch() {
        String funcName = "testSearch";
        DoublyImplementation  list = new DoublyImplementation(10);

        list.insertFirst(4); list.insertFirst(40); list.insertFirst(6); list.insertFirst(33);

        if (list.search(10) &&  list.search(4) &&  list.search(40) && list.search(6) && list.search(33))
            passTest(funcName);
        else 
            failTest(funcName);
    }

     public static void testIsEmptyListWithEmptyList() {
        String funcName = "testIsEmptyListWithEmptyList";
        DoublyImplementation  list = new DoublyImplementation();

        if (list.isEmptyList())
            passTest(funcName);
        else
            failTest(funcName);
    }

     public static void testIsEmptyListOnSigleNodeList() {
        String funcName = "testIsEmptyListOnSigleNodeList";
        DoublyImplementation  list = new DoublyImplementation(2);

        if (list.isEmptyList())
            failTest(funcName);
        else
            passTest(funcName);
    }

     public static void testGetSize() {
        String funcName = "testGetSize";
        DoublyImplementation  list = new DoublyImplementation();

        if (list.getSize() != 0) {
            failTest(funcName);
            return;
        }

        list.insertFirst(4); list.insertFirst(40); list.insertFirst(6); list.insertFirst(33);

        if (list.getSize() != 4) {
            failTest(funcName);
            return;
        }

        list.deleteFirstNode();
        list.deleteLastNode();

        if (list.getSize() == 2)
            passTest(funcName);
        else 
            failTest(funcName);
    }

     public static void testIsEmptyListOnMultiNodeList() {
        String funcName = "testIsEmptyListOnMultiNodeList";
        DoublyImplementation  list = new DoublyImplementation(2);

        list.insertFirst(4); list.insertFirst(40); list.insertFirst(6); list.insertFirst(33);

        if (list.isEmptyList())
            failTest(funcName);
        else
            passTest(funcName);
    }
    
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
