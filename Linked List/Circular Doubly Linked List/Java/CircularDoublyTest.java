import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class CircularDoublyTest {
    public static void main(String[] args) {
        int testNumber = 1;

        // Iterates through all the public methods in the class and invokes each one
        // except main().
        // This makes calling & adding additional testcases easier

        for (Method method : CircularDoublyTest.class.getDeclaredMethods()) {
            if (method.getName() != "main" && Modifier.isPublic(method.getModifiers())) {
                try {
                    method.invoke(method, new Object[] { method.getName(), testNumber++ });
                } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
                    testcaseError(e, testNumber++);
                }
            }
        }
    }
    
    /*
     * ======================
     * List Init test
     * ======================
     */

    public static void testInitListWithoutParams(String funcName, int testNumber) {
        CircularDoublyImplementation list = new CircularDoublyImplementation();

        if (list.getSize() != 0 || list.getFirstNode() != null)
            failTest(funcName, testNumber);
        else
            passTest(funcName, testNumber);
    }

    public static void testInitListWithParams(String funcName, int testNumber) {
        CircularDoublyImplementation list = new CircularDoublyImplementation(4);
        CircularDoublyImplementation.Node lastNode = list.getFirstNode();

        if (list.getSize() != 1 || lastNode == null || lastNode.data != 4)
            failTest(funcName, testNumber);
        else
            passTest(funcName, testNumber);
    }

    public static void testInitListWithParamsToVerifyListIsCircularWithSingleNode(String funcName, int testNumber) {
        CircularDoublyImplementation list = new CircularDoublyImplementation(2);
        CircularDoublyImplementation.Node lastNode = list.getLastNode();

        if (lastNode.nextNode != lastNode || lastNode.prevNode != lastNode)
            failTest(funcName, testNumber);
        else
            passTest(funcName, testNumber);
    }

    /*
     * ======================
     * insertFirst() test
     * ======================
     */

    public static void testInsertFirstWithEmptyList(String funcName, int testNumber) {
        CircularDoublyImplementation list = new CircularDoublyImplementation();

        list.insertFirst(2);
        
        CircularDoublyImplementation.Node firstNode = list.getFirstNode();

        if (list.getSize() != 1 || firstNode == null || firstNode.data != 2)
            failTest(funcName, testNumber);
        else
            passTest(funcName, testNumber);
    }

    public static void testInsertFirstOnListWithSingleNode(String funcName, int testNumber) {
        CircularDoublyImplementation list = new CircularDoublyImplementation(2);

        list.insertFirst(9);
        CircularDoublyImplementation.Node firstNode = list.getFirstNode();

        if (list.getSize() != 2 || firstNode.data != 9 || firstNode.nextNode.data != 2)
            failTest(funcName, testNumber);
        else
            passTest(funcName, testNumber);
    }

    public static void testInsertFirstOnListWithhMultipleNodes(String funcName, int testNumber) {
        CircularDoublyImplementation list = new CircularDoublyImplementation(2);

        list.insertFirst(9); list.insertFirst(7);

        CircularDoublyImplementation.Node firstNode = list.getFirstNode();

        if (list.getSize() != 3 || firstNode.data != 7 || firstNode.nextNode.data != 9 || firstNode.nextNode.nextNode.data != 2)
            failTest(funcName, testNumber);
        else
            passTest(funcName, testNumber);
    }

    public static void testInsertFirstToVerifyPrevAndNextPointersAreCorrect(String funcName, int testNumber) {
        CircularDoublyImplementation list = new CircularDoublyImplementation(2);

        list.insertFirst(9); list.insertFirst(7);

        CircularDoublyImplementation.Node firstNode = list.getFirstNode();
        CircularDoublyImplementation.Node lastNode = list.getLastNode();
        CircularDoublyImplementation.Node nodeAtIdx1 = list.getNodeAtIndex(1);

        if (firstNode.nextNode != nodeAtIdx1 || nodeAtIdx1.prevNode != firstNode)
            failTest(funcName, testNumber);
        else if (nodeAtIdx1.nextNode != lastNode || lastNode.prevNode != nodeAtIdx1)
            failTest(funcName, testNumber);
        else
            passTest(funcName, testNumber);
    }

    public static void testInsertFirstToVerifyListIsCircularWithSingleNode(String funcName, int testNumber) {
        CircularDoublyImplementation list = new CircularDoublyImplementation();
        
        list.insertFirst(2);
        CircularDoublyImplementation.Node firstNode = list.getLastNode();

        if (firstNode.nextNode != firstNode || firstNode.prevNode != firstNode)
            failTest(funcName, testNumber);
        else
            passTest(funcName, testNumber);
    }

    public static void testInsertFirstToVerifyListIsCircularWithTwoNodes(String funcName, int testNumber) {
        CircularDoublyImplementation list = new CircularDoublyImplementation(2);

        list.insertFirst(3);
        CircularDoublyImplementation.Node lastNode = list.getLastNode();
        CircularDoublyImplementation.Node firstNode = list.getFirstNode();

        if (lastNode.nextNode != firstNode || firstNode.prevNode != lastNode)
            failTest(funcName, testNumber);
        else
            passTest(funcName, testNumber);
    }

    public static void testInsertFirstToVerifyListIsCircularWithMultipleNodes(String funcName, int testNumber) {
        CircularDoublyImplementation list = new CircularDoublyImplementation(2);

        list.insertFirst(3); list.insertFirst(4);
        CircularDoublyImplementation.Node lastNode = list.getLastNode();
        CircularDoublyImplementation.Node firstNode = list.getFirstNode();

        if (lastNode.nextNode != firstNode || firstNode.prevNode != lastNode)
            failTest(funcName, testNumber);
        else
            passTest(funcName, testNumber);
    }

    /*
     * ======================
     * insertLast() test
     * ======================
     */

    public static void testInsertLasttWithEmptyList(String funcName, int testNumber) {
        CircularDoublyImplementation list = new CircularDoublyImplementation();

        list.insertLast(2);
        CircularDoublyImplementation.Node firstNode = list.getLastNode();

        if (list.getSize() != 1 || firstNode == null || firstNode.data != 2)
            failTest(funcName, testNumber);
        else
            passTest(funcName, testNumber);
    }

    public static void testInsertLastOnListWithSingleNode(String funcName, int testNumber) {
        CircularDoublyImplementation list = new CircularDoublyImplementation(2);

        list.insertLast(9);
        CircularDoublyImplementation.Node firstNode = list.getFirstNode();

        if (list.getSize() != 2 || firstNode.data != 2 || firstNode.nextNode.data != 9)
            failTest(funcName, testNumber);
        else
            passTest(funcName, testNumber);
    }

    public static void testInsertLastOnListWithhMultipleNodes(String funcName, int testNumber) {
        CircularDoublyImplementation list = new CircularDoublyImplementation(2);

        list.insertLast(9); list.insertLast(7);
        CircularDoublyImplementation.Node head = list.getFirstNode();

        if (list.getSize() != 3 || head.data != 2 || head.nextNode.data != 9 || head.nextNode.nextNode.data != 7)
            failTest(funcName, testNumber);
        else
            passTest(funcName, testNumber);
    }

    public static void testInsertLastToVerifyPrevAndNextPointersAreCorrect(String funcName, int testNumber) {
        CircularDoublyImplementation list = new CircularDoublyImplementation(2);

        list.insertLast(9); list.insertLast(7);

        CircularDoublyImplementation.Node firstNode = list.getFirstNode();
        CircularDoublyImplementation.Node lastNode = list.getLastNode();
        CircularDoublyImplementation.Node nodeAtIdx1 = list.getNodeAtIndex(1);

        if (firstNode.nextNode != nodeAtIdx1 || nodeAtIdx1.prevNode != firstNode)
            failTest(funcName, testNumber);
        else if (nodeAtIdx1.nextNode != lastNode || lastNode.prevNode != nodeAtIdx1)
            failTest(funcName, testNumber);
        else
            passTest(funcName, testNumber);
    }

    public static void testInsertLastToVerifyListIsCircularWithSingleNode(String funcName, int testNumber) {
        CircularDoublyImplementation list = new CircularDoublyImplementation();
        
        list.insertLast(2);
        CircularDoublyImplementation.Node lastNode = list.getLastNode();

        if (lastNode.nextNode != lastNode || lastNode.prevNode != lastNode)
            failTest(funcName, testNumber);
        else
            passTest(funcName, testNumber);
    }

    public static void testInsertLastToVerifyListIsCircularWithTwoNodes(String funcName, int testNumber) {
        CircularDoublyImplementation list = new CircularDoublyImplementation(2);

        list.insertLast(3);
        CircularDoublyImplementation.Node lastNode = list.getLastNode();
        CircularDoublyImplementation.Node firstNode = list.getFirstNode();

        if (lastNode.nextNode != firstNode || firstNode.prevNode != lastNode)
            failTest(funcName, testNumber);
        else
            passTest(funcName, testNumber);
    }

    public static void testInsertLastToVerifyListIsCircularWithMultipleNodes(String funcName, int testNumber) {
        CircularDoublyImplementation list = new CircularDoublyImplementation(2);

        list.insertFirst(3); list.insertFirst(4);
        CircularDoublyImplementation.Node lastNode = list.getLastNode();
        CircularDoublyImplementation.Node firstNode = list.getFirstNode();

        if (lastNode.nextNode != firstNode || firstNode.prevNode != lastNode)
            failTest(funcName, testNumber);
        else
            passTest(funcName, testNumber);
    }

    /*
     * ======================
     * insertAtIndex() test
     * ======================
     */

    public static void testInsertAtIndexWithEmptyListAtIndexZero(String funcName, int testNumber) {
        CircularDoublyImplementation list = new CircularDoublyImplementation();

        if (!list.insertAtIndex(0, 2) || list.getSize() != 1 || list.getFirstNode().data != 2)
            failTest(funcName, testNumber);
        else
            passTest(funcName, testNumber);
    }

    public static void testInsertAtIndexWithNonEmptyListAtIndexZero(String funcName, int testNumber) {
        CircularDoublyImplementation list = new CircularDoublyImplementation(2);

        list.insertLast(9); list.insertLast(7);

        if (!list.insertAtIndex(0, 5) || list.getSize() != 4 || list.getFirstNode().data != 5)
            failTest(funcName, testNumber);
        else
            passTest(funcName, testNumber);
    }

    public static void testInsertAtIndexWithInvalidIndexes(String funcName, int testNumber) {
        CircularDoublyImplementation list = new CircularDoublyImplementation();

        if (list.insertAtIndex(1, 2) || list.insertAtIndex(-1, 2))
            failTest(funcName, testNumber);
        else if (list.getSize() != 0 || list.getFirstNode() != null)
            failTest(funcName, testNumber);
        else
            passTest(funcName, testNumber);
    }

    public static void testInsertAtIndexWithNonEmptyList(String funcName, int testNumber) {
        CircularDoublyImplementation list = new CircularDoublyImplementation(2);

        list.insertLast(9); list.insertLast(7);

        if (!list.insertAtIndex(1, 5) || !list.insertAtIndex(3, 8) || list.getSize() != 5)
            failTest(funcName, testNumber);
        else if (list.getFirstNode().nextNode.data != 5)
            failTest(funcName, testNumber);
        else if (list.getFirstNode().nextNode.nextNode.nextNode.data != 8)
            failTest(funcName, testNumber);
        else
            passTest(funcName, testNumber);
    }

    public static void testInsertAtIndexToVerifyPrevAndNextPointersAreCorrect(String funcName, int testNumber) {
        CircularDoublyImplementation list = new CircularDoublyImplementation(2);

        list.insertAtIndex(0, 9); list.insertAtIndex(1, 7);

        CircularDoublyImplementation.Node firstNode = list.getFirstNode();
        CircularDoublyImplementation.Node lastNode = list.getLastNode();
        CircularDoublyImplementation.Node nodeAtIdx1 = list.getNodeAtIndex(1);

        if (firstNode.nextNode != nodeAtIdx1 || nodeAtIdx1.prevNode != firstNode)
            failTest(funcName, testNumber);
        else if (nodeAtIdx1.nextNode != lastNode || lastNode.prevNode != nodeAtIdx1)
            failTest(funcName, testNumber);
        else
            passTest(funcName, testNumber);
    }

    public static void testInsertAtIndexToVerifyListIsCircularWithSingleNode(String funcName, int testNumber) {
        CircularDoublyImplementation list = new CircularDoublyImplementation();
        
        list.insertAtIndex(0, 2);
        CircularDoublyImplementation.Node lastNode = list.getLastNode();

        if (lastNode.nextNode != lastNode || lastNode.prevNode != lastNode)
            failTest(funcName, testNumber);
        else
            passTest(funcName, testNumber);
    }

    public static void testInsertAtIndeToVerifyListIsCircularWithTwoNodes(String funcName, int testNumber) {
        CircularDoublyImplementation list = new CircularDoublyImplementation(2);

        list.insertAtIndex(0, 3);
        CircularDoublyImplementation.Node lastNode = list.getLastNode();
        CircularDoublyImplementation.Node firstNode = list.getFirstNode();

        if (lastNode.nextNode != firstNode || firstNode.prevNode != lastNode)
            failTest(funcName, testNumber);
        else
            passTest(funcName, testNumber);
    }

    public static void testInsertAtIndexToVerifyListIsCircularWithMultipleNodes(String funcName, int testNumber) {
        CircularDoublyImplementation list = new CircularDoublyImplementation(2);

        list.insertAtIndex(0, 3); list.insertAtIndex(1, 4);
        CircularDoublyImplementation.Node lastNode = list.getLastNode();
        CircularDoublyImplementation.Node firstNode = list.getFirstNode();

        if (lastNode.nextNode != firstNode || firstNode.prevNode != lastNode)
            failTest(funcName, testNumber);
        else
            passTest(funcName, testNumber);
    }

    /*
     * ======================
     * deleteFirstNode() test
     * ======================
     */

    public static void testDeleteFirstOnEmptyList(String funcName, int testNumber) {
        CircularDoublyImplementation list = new CircularDoublyImplementation();

        CircularDoublyImplementation.Node deletedNode = list.deleteFirstNode();

        if (list.getSize() != 0 || deletedNode != null)
            failTest(funcName, testNumber);
        else
            passTest(funcName, testNumber);
    }

    public static void testDeleteFirstOnListWithSingleNode(String funcName, int testNumber) {
        CircularDoublyImplementation list = new CircularDoublyImplementation(2);
        CircularDoublyImplementation.Node headToRemove = list.getFirstNode();
        CircularDoublyImplementation.Node deletedNode = list.deleteFirstNode();

        if (list.getSize() != 0 || list.getFirstNode() != null || deletedNode != headToRemove)
            failTest(funcName, testNumber);
        else
            passTest(funcName, testNumber);
    }

    public static void testDeleteFirstOnListWithMultipleNodes(String funcName, int testNumber) {
        CircularDoublyImplementation list = new CircularDoublyImplementation(2);

        list.insertFirst(3); list.insertFirst(4); list.insertFirst(5);

        CircularDoublyImplementation.Node nodeToRemove = list.getFirstNode();
        CircularDoublyImplementation.Node deletedNode = list.deleteFirstNode();
        CircularDoublyImplementation.Node firstNode = list.getFirstNode();
        CircularDoublyImplementation.Node lastNode = list.getLastNode();

        if (list.getSize() != 3 || deletedNode != nodeToRemove)
            failTest(funcName, testNumber);
        else if (firstNode.data != 4 || firstNode.nextNode.data != 3 || lastNode.data != 2)
            failTest(funcName, testNumber);
        else
            passTest(funcName, testNumber);
    }

    public static void testDeleteFirstToVerifyPrevAndNextPointersAreCorrect(String funcName, int testNumber) {
        CircularDoublyImplementation list = new CircularDoublyImplementation(2);

        list.insertFirst(3); list.insertFirst(4); list.insertFirst(5);

        list.deleteFirstNode();

        CircularDoublyImplementation.Node firstNode = list.getFirstNode();
        CircularDoublyImplementation.Node lastNode = list.getLastNode();
        CircularDoublyImplementation.Node nodeAtIdx1 = list.getNodeAtIndex(1);

        if (firstNode.nextNode != nodeAtIdx1 || nodeAtIdx1.prevNode != firstNode)
            failTest(funcName, testNumber);
        else if (nodeAtIdx1.nextNode != lastNode || lastNode.prevNode != nodeAtIdx1)
            failTest(funcName, testNumber);
        else
            passTest(funcName, testNumber);
    }

    public static void testDeleteFirstToVerifyListIsCircularWithTwoNodes(String funcName, int testNumber) {
        CircularDoublyImplementation list = new CircularDoublyImplementation(2);
        list.insertFirst(3);

        list.deleteFirstNode();

        CircularDoublyImplementation.Node firstNode = list.getFirstNode();
        CircularDoublyImplementation.Node lastNode = list.getLastNode();

        if (lastNode.nextNode != firstNode || firstNode.prevNode != lastNode)
            failTest(funcName, testNumber);
        else
            passTest(funcName, testNumber);
    }

    public static void testDeleteFirstToVerifyListIsCircularWithMultipleNodes(String funcName, int testNumber) {
        CircularDoublyImplementation list = new CircularDoublyImplementation(2);
        list.insertFirst(3); list.insertFirst(4); list.insertFirst(5);

        list.deleteFirstNode();

        CircularDoublyImplementation.Node firstNode = list.getFirstNode();
        CircularDoublyImplementation.Node lastNode = list.getLastNode();

        if (lastNode.nextNode != firstNode || firstNode.prevNode != lastNode)
            failTest(funcName, testNumber);
        else
            passTest(funcName, testNumber);
    }

    /*
     * ======================
     * deleteLastNode() test
     * ======================
     */

    public static void testDeleteLastOnEmptyList(String funcName, int testNumber) {
        CircularDoublyImplementation list = new CircularDoublyImplementation();

        CircularDoublyImplementation.Node deletedNode = list.deleteLastNode();

        if (list.getSize() != 0 || deletedNode != null)
            failTest(funcName, testNumber);
        else
            passTest(funcName, testNumber);
    }

    public static void testDeleteLastOnListWithSingleNode(String funcName, int testNumber) {
        CircularDoublyImplementation list = new CircularDoublyImplementation(2);
        CircularDoublyImplementation.Node nodeToRemove = list.getLastNode();
        CircularDoublyImplementation.Node deletedNode = list.deleteLastNode();

        if (list.getSize() != 0 || list.getLastNode() != null || deletedNode != nodeToRemove)
            failTest(funcName, testNumber);
        else
            passTest(funcName, testNumber);
    }

    public static void testDeleteLastOnListWithTwoNodes(String funcName, int testNumber) {
        CircularDoublyImplementation list = new CircularDoublyImplementation(2);
        list.insertLast(3);

        CircularDoublyImplementation.Node nodeToRemove = list.getLastNode();
        CircularDoublyImplementation.Node deletedNode = list.deleteLastNode();

        if (list.getSize() != 1 || list.getLastNode().data != 2 || deletedNode != nodeToRemove)
            failTest(funcName, testNumber);
        else
            passTest(funcName, testNumber);
    }

    public static void testDeleteLastOnListWithMultipleNodes(String funcName, int testNumber) {
        CircularDoublyImplementation list = new CircularDoublyImplementation(2);

        list.insertFirst(3); list.insertFirst(4); list.insertFirst(5);

        CircularDoublyImplementation.Node firstNode = list.getFirstNode();
        CircularDoublyImplementation.Node nodeToRemove = list.getLastNode();
        CircularDoublyImplementation.Node deletedNode = list.deleteLastNode();
        CircularDoublyImplementation.Node lastNode = list.getLastNode();

        if (list.getSize() != 3 || deletedNode.data != 2 || deletedNode != nodeToRemove)
            failTest(funcName, testNumber);
        else if (firstNode.data != 5 || firstNode.nextNode.data != 4 || lastNode.data != 3)
            failTest(funcName, testNumber);
        else
            passTest(funcName, testNumber);
    }

    public static void testDeleteLastToVerifyPrevAndNextPointersAreCorrect(String funcName, int testNumber) {
        CircularDoublyImplementation list = new CircularDoublyImplementation(2);

        list.insertFirst(3); list.insertFirst(4); list.insertFirst(5);

        list.deleteLastNode();

        CircularDoublyImplementation.Node firstNode = list.getFirstNode();
        CircularDoublyImplementation.Node lastNode = list.getLastNode();
        CircularDoublyImplementation.Node nodeAtIdx1 = list.getNodeAtIndex(1);

        if (firstNode.nextNode != nodeAtIdx1 || nodeAtIdx1.prevNode != firstNode)
            failTest(funcName, testNumber);
        else if (nodeAtIdx1.nextNode != lastNode || lastNode.prevNode != nodeAtIdx1)
            failTest(funcName, testNumber);
        else
            passTest(funcName, testNumber);
    }

    public static void testDeleteLastToVerifyListIsCircularWithTwoNodes(String funcName, int testNumber) {
        CircularDoublyImplementation list = new CircularDoublyImplementation(2);
        list.insertFirst(3);

        list.deleteLastNode();

        CircularDoublyImplementation.Node firstNode = list.getFirstNode();
        CircularDoublyImplementation.Node lastNode = list.getLastNode();

        if (lastNode.nextNode != firstNode || firstNode.prevNode != lastNode)
            failTest(funcName, testNumber);
        else
            passTest(funcName, testNumber);
    }

    public static void testDeleteLastToVerifyListIsCircularWithMultipleNodes(String funcName, int testNumber) {
        CircularDoublyImplementation list = new CircularDoublyImplementation(2);
        list.insertFirst(3); list.insertFirst(4); list.insertFirst(5);

        list.deleteLastNode();

        CircularDoublyImplementation.Node firstNode = list.getFirstNode();
        CircularDoublyImplementation.Node lastNode = list.getLastNode();

        if (lastNode.nextNode != firstNode || firstNode.prevNode != lastNode)
            failTest(funcName, testNumber);
        else
            passTest(funcName, testNumber);
    }

    /*
     * ======================
     * deleteNodeAtIndex() test
     * ======================
     */

    public static void testDeleteNodeAtIndexWithInvalidIndexes(String funcName, int testNumber) {
        CircularDoublyImplementation list = new CircularDoublyImplementation();
        CircularDoublyImplementation.Node nodeDeleted1 = list.deleteNodeAtIndex(0);

        list.insertFirst(2); list.insertFirst(3);

        CircularDoublyImplementation.Node nodeDeleted2 = list.deleteNodeAtIndex(3);
        CircularDoublyImplementation.Node nodeDeleted3 = list.deleteNodeAtIndex(-1);

        if (list.getSize() != 2 || nodeDeleted1 != null || nodeDeleted2 != null || nodeDeleted3 != null)
            failTest(funcName, testNumber);
        else
            passTest(funcName, testNumber);
    }

    public static void testDeleteNodeAtIndexWithIndexOfHead(String funcName, int testNumber) {
        CircularDoublyImplementation list = new CircularDoublyImplementation(2);
        CircularDoublyImplementation.Node head = list.getFirstNode();
        CircularDoublyImplementation.Node nodeDeleted = list.deleteNodeAtIndex(0);

        if (list.getSize() != 0 || nodeDeleted != head)
            failTest(funcName, testNumber);
        else
            passTest(funcName, testNumber);
    }

    public static void testDeleteNodeAtIndexWithIndexOfLastNode(String funcName, int testNumber) {
        CircularDoublyImplementation list = new CircularDoublyImplementation(2);

        list.insertLast(3); list.insertLast(4); list.insertLast(5);

        CircularDoublyImplementation.Node lastNode = list.getLastNode();
        CircularDoublyImplementation.Node nodeDeleted = list.deleteNodeAtIndex(3);

        if (list.getSize() != 3 || nodeDeleted != lastNode)
            failTest(funcName, testNumber);
        else
            passTest(funcName, testNumber);
    }

    public static void testDeleteNodeAtIndex(String funcName, int testNumber) {
        CircularDoublyImplementation list = new CircularDoublyImplementation(2);

        list.insertLast(3); list.insertLast(4); list.insertLast(5);

        CircularDoublyImplementation.Node nodeDeleted1 = list.deleteNodeAtIndex(1);
        CircularDoublyImplementation.Node nodeDeleted2 = list.deleteNodeAtIndex(1);

        if (list.getSize() != 2 || list.getFirstNode().data != 2 || list.getLastNode().data != 5)
            failTest(funcName, testNumber);
        else if (nodeDeleted1.data != 3 || nodeDeleted2.data != 4)
            failTest(funcName, testNumber);
        else
            passTest(funcName, testNumber);
    }

    public static void testDeleteNodeAtIndexToVerifyPrevAndNextPointersAreCorrect(String funcName, int testNumber) {
        CircularDoublyImplementation list = new CircularDoublyImplementation(2);

        list.insertFirst(3); list.insertFirst(4); list.insertFirst(5); list.insertFirst(6);

        list.deleteNodeAtIndex(1); list.deleteNodeAtIndex(2);

        CircularDoublyImplementation.Node firstNode = list.getFirstNode();
        CircularDoublyImplementation.Node lastNode = list.getLastNode();
        CircularDoublyImplementation.Node nodeAtIdx1 = list.getNodeAtIndex(1);

        if (firstNode.nextNode != nodeAtIdx1 || nodeAtIdx1.prevNode != firstNode)
            failTest(funcName, testNumber);
        else if (nodeAtIdx1.nextNode != lastNode || lastNode.prevNode != nodeAtIdx1)
            failTest(funcName, testNumber);
        else
            passTest(funcName, testNumber);
    }

    public static void testDeleteNodeAtIndexToVerifyListIsCircularWithTwoNodes(String funcName, int testNumber) {
        CircularDoublyImplementation list = new CircularDoublyImplementation(2);
        list.insertFirst(3);

        list.deleteNodeAtIndex(1);

        CircularDoublyImplementation.Node firstNode = list.getFirstNode();
        CircularDoublyImplementation.Node lastNode = list.getLastNode();

        if (lastNode.nextNode != firstNode || firstNode.prevNode != lastNode)
            failTest(funcName, testNumber);
        else
            passTest(funcName, testNumber);
    }

    public static void testDeleteNodeAtIndexToVerifyListIsCircularWithMultipleNodes(String funcName, int testNumber) {
        CircularDoublyImplementation list = new CircularDoublyImplementation(2);
        list.insertFirst(3); list.insertFirst(4); list.insertFirst(5); list.insertFirst(6);

        list.deleteNodeAtIndex(1); list.deleteNodeAtIndex(2);

        CircularDoublyImplementation.Node firstNode = list.getFirstNode();
        CircularDoublyImplementation.Node lastNode = list.getLastNode();

        if (lastNode.nextNode != firstNode || firstNode.prevNode != lastNode)
            failTest(funcName, testNumber);
        else
            passTest(funcName, testNumber);
    }

    /*
     * ======================
     * getFirstNode() test
     * ======================
     */

    public static void testGetFirstNodeOnEmptyList(String funcName, int testNumber) {
        CircularDoublyImplementation list = new CircularDoublyImplementation();
        CircularDoublyImplementation.Node nodeRetrieved = list.getFirstNode();

        if (list.getSize() != 0 || nodeRetrieved != null)
            failTest(funcName, testNumber);
        else
            passTest(funcName, testNumber);
    }

    public static void testGetFirstNodeOnListWithSingleNode(String funcName, int testNumber) {
        CircularDoublyImplementation list = new CircularDoublyImplementation(2);
        CircularDoublyImplementation.Node nodeRetrieved = list.getFirstNode();

        if (list.getSize() != 1 || nodeRetrieved.data != 2)
            failTest(funcName, testNumber);
        else
            passTest(funcName, testNumber);
    }

    public static void testGetFirstNodeOnListWithMultipleNodes(String funcName, int testNumber) {
        CircularDoublyImplementation list = new CircularDoublyImplementation(2);
        CircularDoublyImplementation.Node nodeRetrieved = list.getFirstNode();

        list.insertLast(3);
        list.insertLast(4);
        list.insertLast(5);

        if (list.getSize() != 4 || nodeRetrieved.data != 2)
            failTest(funcName, testNumber);
        else
            passTest(funcName, testNumber);
    }

    /*
     * ======================
     * getLastNode() test
     * ======================
     */

    public static void testGetLastNodeOnEmptyList(String funcName, int testNumber) {
        CircularDoublyImplementation list = new CircularDoublyImplementation();
        CircularDoublyImplementation.Node nodeRetrieved = list.getLastNode();

        if (list.getSize() != 0 || nodeRetrieved != null)
            failTest(funcName, testNumber);
        else
            passTest(funcName, testNumber);
    }

    public static void testGetLastNodeOnListWithSingleNode(String funcName, int testNumber) {
        CircularDoublyImplementation list = new CircularDoublyImplementation(2);
        CircularDoublyImplementation.Node nodeRetrieved = list.getLastNode();

        if (list.getSize() != 1 || nodeRetrieved.data != 2)
            failTest(funcName, testNumber);
        else
            passTest(funcName, testNumber);
    }

    public static void testGetLastNodeOnListWithMultipleNodes(String funcName, int testNumber) {
        CircularDoublyImplementation list = new CircularDoublyImplementation(2);

        list.insertLast(3);
        list.insertLast(4);
        list.insertLast(5);
        CircularDoublyImplementation.Node nodeRetrieved = list.getLastNode();

        if (list.getSize() != 4 || nodeRetrieved.data != 5)
            failTest(funcName, testNumber);
        else
            passTest(funcName, testNumber);
    }

    /*
     * ======================
     * getNodeAtIndex() test
     * ======================
     */

    public static void testGetNodeAtIndexWithInvalidIndexes(String funcName, int testNumber) {
        CircularDoublyImplementation list = new CircularDoublyImplementation();

        CircularDoublyImplementation.Node nodeRetrieved1 = list.getNodeAtIndex(0);

        list.insertFirst(2); list.insertFirst(3);

        CircularDoublyImplementation.Node nodeRetrieved2 = list.getNodeAtIndex(3);
        CircularDoublyImplementation.Node nodeRetrieved3 = list.getNodeAtIndex(-1);

        if (list.getSize() != 2 || nodeRetrieved1 != null || nodeRetrieved2 != null || nodeRetrieved3 != null)
            failTest(funcName, testNumber);
        else
            passTest(funcName, testNumber);
    }

    public static void testGetNodeAtIndexWithIndexOfHead(String funcName, int testNumber) {
        CircularDoublyImplementation list = new CircularDoublyImplementation(2);
        CircularDoublyImplementation.Node nodeRetrieved = list.getNodeAtIndex(0);
        CircularDoublyImplementation.Node head = list.getFirstNode();

        if (list.getSize() != 1 || nodeRetrieved != head)
            failTest(funcName, testNumber);
        else
            passTest(funcName, testNumber);
    }

    public static void testGetNodeAtIndexWithIndexOfLastNode(String funcName, int testNumber) {
        CircularDoublyImplementation list = new CircularDoublyImplementation(2);

        list.insertLast(3);
        list.insertLast(4);
        list.insertLast(5);

        CircularDoublyImplementation.Node nodeRetrieved = list.getNodeAtIndex(3);
        CircularDoublyImplementation.Node lastNode = list.getLastNode();

        if (list.getSize() != 4 || nodeRetrieved != lastNode)
            failTest(funcName, testNumber);
        else
            passTest(funcName, testNumber);
    }

    public static void testGetNodeAtIndex(String funcName, int testNumber) {
        CircularDoublyImplementation list = new CircularDoublyImplementation(2);

        list.insertLast(3);
        list.insertLast(4);
        list.insertLast(5);

        CircularDoublyImplementation.Node nodeRetrieved1 = list.getNodeAtIndex(1);
        CircularDoublyImplementation.Node nodeRetrieved2 = list.getNodeAtIndex(2);

        if (list.getSize() != 4 || nodeRetrieved1.data != 3 || nodeRetrieved2.data != 4)
            failTest(funcName, testNumber);
        else
            passTest(funcName, testNumber);
    }

    /*
     * ======================
     * isEmptyList() test
     * ======================
     */

    public static void testIsEmptyListWithEmptyList(String funcName, int testNumber) {
        CircularDoublyImplementation list = new CircularDoublyImplementation();

        if (list.isEmptyList())
            passTest(funcName, testNumber);
        else
            failTest(funcName, testNumber);
    }

    public static void testIsEmptyListOnSigleNodeList(String funcName, int testNumber) {
        CircularDoublyImplementation list = new CircularDoublyImplementation(2);

        if (list.isEmptyList())
            failTest(funcName, testNumber);
        else
            passTest(funcName, testNumber);
    }

    public static void testIsEmptyListOnMultiNodeList(String funcName, int testNumber) {
        CircularDoublyImplementation list = new CircularDoublyImplementation(2);

        list.insertFirst(4);
        list.insertFirst(40);
        list.insertFirst(6);
        list.insertFirst(33);

        if (list.isEmptyList())
            failTest(funcName, testNumber);
        else
            passTest(funcName, testNumber);
    }

    /*
     * ======================
     * search() test
     * ======================
     */

    public static void testSearch(String funcName, int testNumber) {
        CircularDoublyImplementation list = new CircularDoublyImplementation(10);

        list.insertFirst(4);
        list.insertFirst(40);
        list.insertFirst(6);
        list.insertFirst(33);

        if (list.search(10) && list.search(4) && list.search(40) && list.search(6) && list.search(33))
            passTest(funcName, testNumber);
        else
            failTest(funcName, testNumber);
    }

    /*
     * ======================
     * testGetSize() test
     * ======================
     */

    public static void testGetSize(String funcName, int testNumber) {
        CircularDoublyImplementation list = new CircularDoublyImplementation();

        if (list.getSize() != 0) {
            failTest(funcName, testNumber);
            return;
        }

        list.insertFirst(4);
        list.insertFirst(40);
        list.insertFirst(6);
        list.insertFirst(33);

        if (list.getSize() != 4) {
            failTest(funcName, testNumber);
            return;
        }

        list.deleteFirstNode();
        list.deleteLastNode();

        if (list.getSize() == 2)
            passTest(funcName, testNumber);
        else
            failTest(funcName, testNumber);
    }

    private static void failTest(String funcName, int testNumber) {
        String red = "\u001B[31m";
        System.out.printf("\n%s%d - %s : FAIL\n", red, testNumber++, funcName);
    }

    private static void passTest(String funcName, int testNumber) {
        String green = "\u001B[32m";
        System.out.printf("\n%s%d - %s : PASS\n", green, testNumber++, funcName);
    }

    private static void testcaseError(Exception e, int testNumber) {
        String yellow = "\u001b[33m";
        System.out.printf("\n%s%d - Testcase Error: %s\n", yellow, testNumber++, e.getMessage());
    }
}
