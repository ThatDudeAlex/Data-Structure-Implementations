
public class CircularSinglyTest {
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
        testInsertAtIndexWithInvalidIndexes();
        testInsertAtIndexWithNonEmptyListAtIndexZero();
        testInsertAtIndexWithNonEmptyList();
        testDeleteFirstOnEmptyList();
        testDeleteFirstOnListWithSingleNode();
        testDeleteFirstOnListWithMultipleNodes();
        testDeleteLastOnEmptyList();
        testDeleteLastOnListWithSingleNode();
        testDeleteLastOnListWithMultipleNodes();
        testDeleteNodeAtIndexWithInvalidIndexes();
        testDeleteNodeAtIndexWithIndexOfHead();
        testDeleteNodeAtIndexWithIndexOfLastNode();
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
        CircularSinglyImplementation  list = new CircularSinglyImplementation();

        if (list.getSize() != 0 || list.getFirstNode() != null) 
            failTest(funcName);
        else 
            passTest(funcName);
    }

     public static void testInitListWithParams() {
        String funcName = "initListWithParams";
        CircularSinglyImplementation  list = new CircularSinglyImplementation(4);
        CircularSinglyImplementation.Node head =  list.getFirstNode();

        if (list.getSize() != 1 || head == null || head.nextNode != head) 
            failTest(funcName);
        else 
            passTest(funcName);
    }

     public static void testInsertFirstWithEmptyList() {
        String funcName = "testInsertFirstWithEmptyList";
        CircularSinglyImplementation  list = new CircularSinglyImplementation();
        
         list.insertFirst(2);
        CircularSinglyImplementation.Node head =  list.getFirstNode();

        if ( list.getSize() != 1 || head == null)
            failTest(funcName);
        else if (head.data != 2 || head.nextNode != head) 
            failTest(funcName);
        else
            passTest(funcName);
    }

    
     public static void testInsertFirstOnListWithSingleNode() {
        String funcName = "testInsertFirstOnListWithSingleNode";
        CircularSinglyImplementation  list = new CircularSinglyImplementation(2);
        
        list.insertFirst(9);
        CircularSinglyImplementation.Node head =  list.getFirstNode();

        if ( list.getSize() != 2 )
            failTest(funcName);
        else if (head.data != 9 || head.nextNode.data != 2 || head.nextNode.nextNode != head) 
            failTest(funcName);
        else
            passTest(funcName);
    }

    
     public static void testInsertFirstOnListWithhMultipleNodes() {
        String funcName = "testInsertFirstOnListWithhMultipleNodes";
        CircularSinglyImplementation  list = new CircularSinglyImplementation(2);
        
        list.insertFirst(9);
        list.insertFirst(7);
        CircularSinglyImplementation.Node head =  list.getFirstNode();

        if ( list.getSize() != 3 )
            failTest(funcName);
        else if (head.data != 7 || head.nextNode.data != 9 || head.nextNode.nextNode.data != 2) 
            failTest(funcName);
        else if (head.nextNode.nextNode.nextNode != head) 
            failTest(funcName);
        else
            passTest(funcName);
    }

     public static void testInsertLasttWithEmptyList() {
        String funcName = "testInsertLasttWithEmptyList";
        CircularSinglyImplementation  list = new CircularSinglyImplementation();
        
         list.insertLast(2);
        CircularSinglyImplementation.Node head =  list.getFirstNode();

        if ( list.getSize() != 1 || head == null)
            failTest(funcName);
        else if (head.data != 2 || head.nextNode != head) 
            failTest(funcName);
        else
            passTest(funcName);
    }

    
     public static void testInsertLastOnListWithSingleNode() {
        String funcName = "testInsertLastOnListWithSingleNode";
        CircularSinglyImplementation  list = new CircularSinglyImplementation(2);
        
        list.insertLast(9);
        CircularSinglyImplementation.Node head =  list.getFirstNode();

        if ( list.getSize() != 2 )
            failTest(funcName);
        else if (head.data != 2 || head.nextNode.data != 9 || head.nextNode.nextNode != head) 
            failTest(funcName);
        else
            passTest(funcName);
    }

    
     public static void testInsertLastOnListWithhMultipleNodes() {
        String funcName = "testInsertFirstOnListWithhMultipleNodes";
        CircularSinglyImplementation  list = new CircularSinglyImplementation(2);
        
        list.insertLast(9); list.insertLast(7);
        CircularSinglyImplementation.Node head =  list.getFirstNode();

        if ( list.getSize() != 3 )
            failTest(funcName);
        else if (head.data != 2 || head.nextNode.data != 9 || head.nextNode.nextNode.data != 7) 
            failTest(funcName);
        else if (head.nextNode.nextNode.nextNode != head) 
            failTest(funcName);
        else
            passTest(funcName);
    }

    public static void testInsertAtIndexWithEmptyListAtIndexZero() {
        String funcName = "testInsertAtIndexWithEmptyListAtIndexZero";
        CircularSinglyImplementation  list = new CircularSinglyImplementation();

        if (!list.insertAtIndex(0, 2) || list.getSize() != 1 || list.getFirstNode().data != 2)
            failTest(funcName);
        else 
            passTest(funcName);
    }

    public static void testInsertAtIndexWithNonEmptyListAtIndexZero() {
        String funcName = "testInsertAtIndexWithNonEmptyListAtIndexZero";
        CircularSinglyImplementation  list = new CircularSinglyImplementation(2);

        list.insertLast(9); list.insertLast(7);

        if (!list.insertAtIndex(0, 5) || list.getSize() != 4|| list.getFirstNode().data != 5)
            failTest(funcName);
        else if (list.getLastNode().nextNode.data != 5)
            failTest(funcName);
        else 
            passTest(funcName);
    }

    public static void testInsertAtIndexWithInvalidIndexes() {
        String funcName = "testInsertAtIndexWithInvalidIndexes";
        CircularSinglyImplementation  list = new CircularSinglyImplementation();

        if (list.insertAtIndex(1, 2) || list.insertAtIndex(-1, 2))
            failTest(funcName);
        else if (list.getSize() != 0 || list.getFirstNode() != null)
            failTest(funcName);
        else 
            passTest(funcName);
    }

    public static void testInsertAtIndexWithNonEmptyList() {
        String funcName = "testInsertAtIndexWithNonEmptyList";
        CircularSinglyImplementation  list = new CircularSinglyImplementation(2);

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

     public static void testDeleteFirstOnEmptyList() {
        String funcName = "testDeleteFirstOnEmptyList";
        CircularSinglyImplementation  list = new CircularSinglyImplementation();
     
        CircularSinglyImplementation.Node deletedNode = list.deleteFirstNode();
        
        if ( list.getSize() != 0 ||  deletedNode != null) 
            failTest(funcName);
        else 
            passTest(funcName);
    }

     public static void testDeleteFirstOnListWithSingleNode() {
        String funcName = "testDeleteFirstOnListWithSingleNode";
        CircularSinglyImplementation  list = new CircularSinglyImplementation(2);
        CircularSinglyImplementation.Node headToRemove = list.getFirstNode();
        CircularSinglyImplementation.Node deletedNode = list.deleteFirstNode();
        
        if ( list.getSize() != 0 || list.getFirstNode() != null || deletedNode != headToRemove) 
            failTest(funcName);
        else 
            passTest(funcName);
    }

     public static void testDeleteFirstOnListWithMultipleNodes() {
        String funcName = "testDeleteFirstOnListWithMultipleNodes";
        CircularSinglyImplementation  list = new CircularSinglyImplementation(2);

        list.insertFirst(3); list.insertFirst(4); list.insertFirst(5);

        CircularSinglyImplementation.Node headToRemove = list.getFirstNode();
        CircularSinglyImplementation.Node deletedNode = list.deleteFirstNode();
        CircularSinglyImplementation.Node newHead = list.getFirstNode();
        
        if ( list.getSize() != 3 || deletedNode != headToRemove) 
            failTest(funcName);
        else if (newHead.data != 4 || newHead.nextNode.data != 3 || newHead.nextNode.nextNode.data != 2)
            failTest(funcName);
        else if (newHead.nextNode.nextNode.nextNode != newHead)
            failTest(funcName);
        else 
            passTest(funcName);
    }

     public static void testDeleteLastOnEmptyList() {
        String funcName = "testDeleteLastOnEmptyList";
        CircularSinglyImplementation  list = new CircularSinglyImplementation();
     
        CircularSinglyImplementation.Node deletedNode = list.deleteLastNode();
        
        if ( list.getSize() != 0 ||  deletedNode != null) 
            failTest(funcName);
        else 
            passTest(funcName);
    }

     public static void testDeleteLastOnListWithSingleNode() {
        String funcName = "testDeleteLastOnListWithSingleNode";
        CircularSinglyImplementation  list = new CircularSinglyImplementation(2);
        CircularSinglyImplementation.Node lastNodeToRemove = list.getLastNode();
        CircularSinglyImplementation.Node deletedNode = list.deleteLastNode();
        
        if ( list.getSize() != 0 || list.getFirstNode() != null || deletedNode != lastNodeToRemove) 
            failTest(funcName);
        else 
            passTest(funcName);
    }

     public static void testDeleteLastOnListWithMultipleNodes() {
        String funcName = "testDeleteLastOnListWithMultipleNodes";
        CircularSinglyImplementation  list = new CircularSinglyImplementation(2);

        list.insertFirst(3); list.insertFirst(4); list.insertFirst(5);

        CircularSinglyImplementation.Node head = list.getFirstNode();
        CircularSinglyImplementation.Node lastNodeToRemove = list.getLastNode();
        CircularSinglyImplementation.Node deletedNode = list.deleteLastNode();
        
        if ( list.getSize() != 3 || deletedNode.data != 2 || deletedNode != lastNodeToRemove) 
            failTest(funcName);
        else if (head.data != 5 || head.nextNode.data != 4 || head.nextNode.nextNode.data != 3)
            failTest(funcName);
        else if (head.nextNode.nextNode.nextNode != head)
            failTest(funcName);
        else 
            passTest(funcName);
    }

     public static void testDeleteNodeAtIndexWithInvalidIndexes() {
        String funcName = "testGetNodeAtIndexWithInvalidIndexes";
        CircularSinglyImplementation  list = new CircularSinglyImplementation();
        CircularSinglyImplementation.Node nodeDeleted1 =  list.deleteNodeAtIndex(0);

        list.insertFirst(2); list.insertFirst(3);

        CircularSinglyImplementation.Node nodeDeleted2 =  list.deleteNodeAtIndex(3);
        CircularSinglyImplementation.Node nodeDeleted3 =  list.deleteNodeAtIndex(-1);

        if (list.getSize() != 2 || nodeDeleted1 != null || nodeDeleted2 != null || nodeDeleted3 != null)
            failTest(funcName);
        else
            passTest(funcName);
    }

     public static void testDeleteNodeAtIndexWithIndexOfHead() {
        String funcName = "testDeleteNodeAtIndexWithIndexOfHead";
        CircularSinglyImplementation  list = new CircularSinglyImplementation(2);
        CircularSinglyImplementation.Node head =  list.getFirstNode();
        CircularSinglyImplementation.Node nodeDeleted =  list.deleteNodeAtIndex(0);

        if (list.getSize() != 0 || nodeDeleted != head)
            failTest(funcName);
        else
            passTest(funcName);
    }

     public static void testDeleteNodeAtIndexWithIndexOfLastNode() {
        String funcName = "testGetNodeAtIndexWithIndexOfLastNode";
        CircularSinglyImplementation  list = new CircularSinglyImplementation(2);

        list.insertLast(3); list.insertLast(4); list.insertLast(5);

        CircularSinglyImplementation.Node lastNode =  list.getLastNode();
        CircularSinglyImplementation.Node nodeDeleted =  list.deleteNodeAtIndex(3);

        if (list.getSize() != 3 || nodeDeleted != lastNode)
            failTest(funcName);
        else
            passTest(funcName);
    }

     public static void testDeleteNodeAtIndex() {
        String funcName = "testDeleteNodeAtIndex";
        CircularSinglyImplementation  list = new CircularSinglyImplementation(2);

        list.insertLast(3); list.insertLast(4); list.insertLast(5);

        CircularSinglyImplementation.Node nodeDeleted1 =  list.deleteNodeAtIndex(1);
        CircularSinglyImplementation.Node nodeDeleted2 =  list.deleteNodeAtIndex(1);

        if (list.getSize() != 2 || list.getFirstNode().data != 2 || list.getLastNode().data != 5)
            failTest(funcName);
        else if (nodeDeleted1.data != 3 || nodeDeleted2.data != 4)
            failTest(funcName);
        else
            passTest(funcName);
    }

     public static void testGetFirstNodeOnEmptyList() {
        String funcName = "testGetFirstNodeOnEmptyList";
        CircularSinglyImplementation  list = new CircularSinglyImplementation();
        CircularSinglyImplementation.Node nodeRetrieved =  list.getFirstNode();
        
        if (list.getSize() != 0 || nodeRetrieved != null)
            failTest(funcName);
        else
            passTest(funcName);
    }

     public static void testGetFirstNodeOnListWithSingleNode() {
        String funcName = "testGetFirstNodeOnListWithSingleNode";
        CircularSinglyImplementation  list = new CircularSinglyImplementation(2);
        CircularSinglyImplementation.Node nodeRetrieved =  list.getFirstNode();
        
        if (list.getSize() != 1 || nodeRetrieved.data != 2)
            failTest(funcName);
        else
            passTest(funcName);
    }

     public static void testGetFirstNodeOnListWithMultipleNodes() {
        String funcName = "testGetFirstNodeOnListWithMultipleNodes";
        CircularSinglyImplementation  list = new CircularSinglyImplementation(2);
        CircularSinglyImplementation.Node nodeRetrieved =  list.getFirstNode();

        list.insertLast(3); list.insertLast(4); list.insertLast(5);

        if (list.getSize() != 4 || nodeRetrieved.data != 2)
            failTest(funcName);
        else
            passTest(funcName);
    }

     public static void testGetLastNodeOnEmptyList() {
        String funcName = "testGetLastNodeOnEmptyList";
        CircularSinglyImplementation  list = new CircularSinglyImplementation();
        CircularSinglyImplementation.Node nodeRetrieved =  list.getLastNode();
        
        if (list.getSize() != 0 || nodeRetrieved != null)
            failTest(funcName);
        else
            passTest(funcName);
    }

     public static void testGetLastNodeOnListWithSingleNode() {
        String funcName = "testGetLastNodeOnListWithSingleNode";
        CircularSinglyImplementation  list = new CircularSinglyImplementation(2);
        CircularSinglyImplementation.Node nodeRetrieved =  list.getLastNode();
        
        if (list.getSize() != 1 || nodeRetrieved.data != 2)
            failTest(funcName);
        else
            passTest(funcName);
    }

     public static void testGetLastNodeOnListWithMultipleNodes() {
        String funcName = "testGetLastNodeOnListWithMultipleNodes";
        CircularSinglyImplementation  list = new CircularSinglyImplementation(2);

        list.insertLast(3); list.insertLast(4); list.insertLast(5);
        CircularSinglyImplementation.Node nodeRetrieved =  list.getLastNode();

        if (list.getSize() != 4 || nodeRetrieved.data != 5)
            failTest(funcName);
        else
            passTest(funcName);
    }
    
     public static void testGetNodeAtIndexWithInvalidIndexes() {
        String funcName = "testGetNodeAtIndexWithInvalidIndexes";
        CircularSinglyImplementation  list = new CircularSinglyImplementation();
        CircularSinglyImplementation.Node nodeRetrieved1 =  list.getNodeAtIndex(0);

        list.insertFirst(2); list.insertFirst(3);

        CircularSinglyImplementation.Node nodeRetrieved2 =  list.getNodeAtIndex(3);
        CircularSinglyImplementation.Node nodeRetrieved3 =  list.getNodeAtIndex(-1);

        if (list.getSize() != 2 || nodeRetrieved1 != null || nodeRetrieved2 != null || nodeRetrieved3 != null)
            failTest(funcName);
        else
            passTest(funcName);
    }

     public static void testGetNodeAtIndexWithIndexOfHead() {
        String funcName = "testGetNodeAtIndexWithIndexOfHead";
        CircularSinglyImplementation  list = new CircularSinglyImplementation(2);
        CircularSinglyImplementation.Node nodeRetrieved =  list.getNodeAtIndex(0);
        CircularSinglyImplementation.Node head =  list.getFirstNode();

        if (list.getSize() != 1 || nodeRetrieved != head)
            failTest(funcName);
        else
            passTest(funcName);
    }

     public static void testGetNodeAtIndexWithIndexOfLastNode() {
        String funcName = "testGetNodeAtIndexWithIndexOfLastNode";
        CircularSinglyImplementation  list = new CircularSinglyImplementation(2);

        list.insertLast(3); list.insertLast(4); list.insertLast(5);

        CircularSinglyImplementation.Node nodeRetrieved =  list.getNodeAtIndex(3);
        CircularSinglyImplementation.Node lastNode =  list.getLastNode();

        if (list.getSize() != 4 || nodeRetrieved != lastNode)
            failTest(funcName);
        else
            passTest(funcName);
    }

     public static void testGetNodeAtIndex() {
        String funcName = "testGetNodeAtIndex";
        CircularSinglyImplementation  list = new CircularSinglyImplementation(2);

        list.insertLast(3); list.insertLast(4); list.insertLast(5);

        CircularSinglyImplementation.Node nodeRetrieved1 =  list.getNodeAtIndex(1);
        CircularSinglyImplementation.Node nodeRetrieved2 =  list.getNodeAtIndex(2);

        if (list.getSize() != 4 || nodeRetrieved1.data != 3 || nodeRetrieved2.data != 4)
            failTest(funcName);
        else
            passTest(funcName);
    }

     public static void testSearch() {
        String funcName = "testSearch";
        CircularSinglyImplementation  list = new CircularSinglyImplementation(10);

        list.insertFirst(4); list.insertFirst(40); list.insertFirst(6); list.insertFirst(33);

        if (list.search(10) &&  list.search(4) &&  list.search(40) && list.search(6) && list.search(33))
            passTest(funcName);
        else 
            failTest(funcName);
    }

     public static void testIsEmptyListWithEmptyList() {
        String funcName = "testIsEmptyListWithEmptyList";
        CircularSinglyImplementation  list = new CircularSinglyImplementation();

        if (list.isEmptyList())
            passTest(funcName);
        else
            failTest(funcName);
    }

     public static void testIsEmptyListOnSigleNodeList() {
        String funcName = "testIsEmptyListOnSigleNodeList";
        CircularSinglyImplementation  list = new CircularSinglyImplementation(2);

        if (list.isEmptyList())
            failTest(funcName);
        else
            passTest(funcName);
    }

     public static void testIsEmptyListOnMultiNodeList() {
        String funcName = "testIsEmptyListOnMultiNodeList";
        CircularSinglyImplementation  list = new CircularSinglyImplementation(2);

        list.insertFirst(4); list.insertFirst(40); list.insertFirst(6); list.insertFirst(33);

        if (list.isEmptyList())
            failTest(funcName);
        else
            passTest(funcName);
    }

    public static void testGetSize() {
        String funcName = "testGetSize";
        CircularSinglyImplementation  list = new CircularSinglyImplementation();

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

     private static void failTest(String funcName) {
        String red = "\u001B[31m";
        System.out.printf("\n%s* %s : FAIL\n", red, funcName);
    }

     private static void passTest(String funcName) {
        String green = "\u001B[32m";
        System.out.printf("\n%s* %s : PASS\n", green, funcName);
    }
}
