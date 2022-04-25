import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class DoublyTest {
    public static void main(String[] args) {
        int testNumber = 1;

        // Iterates through all the public methods in the class and invokes each one except main().
        // This makes calling & adding additional testcases easier
        
        for (Method method : DoublyTest.class.getDeclaredMethods()) {
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
        Doubly list = new Doubly();
        Doubly.Node head = list.getFirstNode();
        Doubly.Node tail = list.getLastNode();

        if (list.size() != 0 || head != null || tail != null)
            failTest(funcName, testNumber);
        else
            passTest(funcName, testNumber);
    }

    public static void testInitListWithParams(String funcName, int testNumber) {
        Doubly list = new Doubly(4);
        Doubly.Node head = list.getFirstNode();
        Doubly.Node tail = list.getLastNode();

        if (list.size() != 1 || head == null || tail == null)
            failTest(funcName, testNumber);
        else if (head.data != 4 || head.prevNode != null || head.nextNode != null || head != tail)
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
        Doubly list = new Doubly();

        list.insertFirst(4);
        Doubly.Node head = list.getFirstNode();
        Doubly.Node tail = list.getLastNode();

        if (list.size() != 1 || head.data != 4 || head == null || tail == null || head != tail)
            failTest(funcName, testNumber);
        else
            passTest(funcName, testNumber);
    }

    public static void testInsertFirstOnListWithSingleNode(String funcName, int testNumber) {
        Doubly list = new Doubly(2);

        list.insertFirst(9);
        Doubly.Node head = list.getFirstNode();
        Doubly.Node tail = list.getLastNode();

        if (list.size() != 2 || head.data != 9 || tail.data != 2)
            failTest(funcName, testNumber);
        else
            passTest(funcName, testNumber);
    }

    public static void testInsertFirstOnListWithhMultipleNodes(String funcName, int testNumber) {
        Doubly list = new Doubly(2);

        list.insertFirst(9);
        list.insertFirst(7);

        Doubly.Node head = list.getFirstNode();
        Doubly.Node tail = list.getLastNode();

        if (list.size() != 3 || head.data != 7 || head.nextNode.data != 9 || tail.data != 2)
            failTest(funcName, testNumber);
        else
            passTest(funcName, testNumber);
    }

    public static void testInsertFirstToVerifyPrevAndNextPointersAreCorrect(String funcName, int testNumber) {
        Doubly list = new Doubly(2);

        list.insertFirst(9);
        list.insertFirst(7);

        Doubly.Node head = list.getFirstNode();
        Doubly.Node tail = list.getLastNode();
        Doubly.Node nodeAtIdx1 = list.getNodeAtIndex(1);

        if (head.prevNode != null || tail.nextNode != null)
            failTest(funcName, testNumber);
        else if (head.nextNode != nodeAtIdx1 || nodeAtIdx1.prevNode != head || nodeAtIdx1.nextNode != tail
                || tail.prevNode != nodeAtIdx1)
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
        Doubly list = new Doubly();

        list.insertLast(2);
        Doubly.Node head = list.getFirstNode();
        Doubly.Node tail = list.getLastNode();

        if (list.size() != 1 || head == null || tail == null)
            failTest(funcName, testNumber);
        else if (head.data != 2 || head.prevNode != null || head.nextNode != null || head != tail)
            failTest(funcName, testNumber);
        else
            passTest(funcName, testNumber);
    }

    public static void testInsertLastOnListWithSingleNode(String funcName, int testNumber) {
        Doubly list = new Doubly(2);

        list.insertLast(9);
        Doubly.Node head = list.getFirstNode();
        Doubly.Node tail = list.getLastNode();

        if (list.size() != 2)
            failTest(funcName, testNumber);
        else if (head.data != 2 || tail.data != 9)
            failTest(funcName, testNumber);
        else if (head.nextNode != tail || head.prevNode != null || tail.nextNode != null)
            failTest(funcName, testNumber);
        else
            passTest(funcName, testNumber);
    }

    public static void testInsertLastOnListWithhMultipleNodes(String funcName, int testNumber) {
        Doubly list = new Doubly(2);

        list.insertLast(9);
        list.insertLast(7);
        Doubly.Node head = list.getFirstNode();
        Doubly.Node tail = list.getLastNode();

        if (list.size() != 3)
            failTest(funcName, testNumber);
        else if (head.data != 2 || head.nextNode.data != 9 || tail.data != 7)
            failTest(funcName, testNumber);
        else if (head.nextNode.nextNode != tail || head.prevNode != null || tail.nextNode != null)
            failTest(funcName, testNumber);
        else
            passTest(funcName, testNumber);
    }

    public static void testInsertLastToVerifyPrevAndNextPointersAreCorrect(String funcName, int testNumber) {
        Doubly list = new Doubly(2);

        list.insertLast(9);
        list.insertLast(7);

        Doubly.Node head = list.getFirstNode();
        Doubly.Node tail = list.getLastNode();
        Doubly.Node nodeAtIdx1 = list.getNodeAtIndex(1);

        if (head.prevNode != null || tail.nextNode != null)
            failTest(funcName, testNumber);
        else if (head.nextNode != nodeAtIdx1 || nodeAtIdx1.prevNode != head || nodeAtIdx1.nextNode != tail
                || tail.prevNode != nodeAtIdx1)
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
        Doubly list = new Doubly();

        if (!list.insertAtIndex(0, 2) || list.size() != 1 || list.getFirstNode().data != 2)
            failTest(funcName, testNumber);
        else if (list.getFirstNode() != list.getLastNode())
            failTest(funcName, testNumber);
        else
            passTest(funcName, testNumber);
    }

    public static void testInsertAtIndexWithNonEmptyListAtIndexZero(String funcName, int testNumber) {
        Doubly list = new Doubly(2);

        list.insertLast(9);
        list.insertLast(7);

        if (!list.insertAtIndex(0, 5) || list.size() != 4 || list.getFirstNode().data != 5)
            failTest(funcName, testNumber);
        else if (list.getFirstNode().nextNode.data != 2 || list.getFirstNode().nextNode.prevNode != list.getFirstNode())
            failTest(funcName, testNumber);
        else
            passTest(funcName, testNumber);
    }

    public static void testInsertAtIndexWithInvalidIndexes(String funcName, int testNumber) {
        Doubly list = new Doubly();

        if (list.insertAtIndex(1, 2) || list.insertAtIndex(-1, 2))
            failTest(funcName, testNumber);
        else if (list.size() != 0 || list.getFirstNode() != null)
            failTest(funcName, testNumber);
        else
            passTest(funcName, testNumber);
    }

    public static void testInsertAtIndexWithNonEmptyList(String funcName, int testNumber) {
        Doubly list = new Doubly(2);

        list.insertLast(9);
        list.insertLast(7);

        if (!list.insertAtIndex(1, 5) || !list.insertAtIndex(3, 8) || list.size() != 5)
            failTest(funcName, testNumber);
        else if (list.getFirstNode().nextNode.data != 5 || list.getFirstNode().nextNode.nextNode.nextNode.data != 8)
            failTest(funcName, testNumber);
        else
            passTest(funcName, testNumber);
    }

    public static void testInsertAtIndexToVerifyPrevAndNextPointersAreCorrect(String funcName, int testNumber) {
        Doubly list = new Doubly(2);

        list.insertLast(9);
        list.insertLast(7);
        list.insertAtIndex(1, 5);
        list.insertAtIndex(3, 8);

        Doubly.Node head = list.getFirstNode();
        Doubly.Node tail = list.getLastNode();
        Doubly.Node nodeAtIdx1 = list.getNodeAtIndex(1);
        Doubly.Node nodeAtIdx2 = list.getNodeAtIndex(2);
        Doubly.Node nodeAtIdx3 = list.getNodeAtIndex(3);

        if (head.prevNode != null || tail.nextNode != null)
            failTest(funcName, testNumber);
        else if (head.nextNode != nodeAtIdx1 || nodeAtIdx1.prevNode != head)
            failTest(funcName, testNumber);
        else if (nodeAtIdx1.nextNode != nodeAtIdx2 || nodeAtIdx2.prevNode != nodeAtIdx1)
            failTest(funcName, testNumber);
        else if (nodeAtIdx2.nextNode != nodeAtIdx3 || nodeAtIdx3.prevNode != nodeAtIdx2)
            failTest(funcName, testNumber);
        else if (nodeAtIdx3.nextNode != tail || tail.prevNode != nodeAtIdx3)
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
        Doubly list = new Doubly();

        Doubly.Node deletedNode = list.deleteFirstNode();

        if (list.size() != 0 || deletedNode != null)
            failTest(funcName, testNumber);
        else
            passTest(funcName, testNumber);
    }

    public static void testDeleteFirstOnListWithSingleNode(String funcName, int testNumber) {
        Doubly list = new Doubly(2);
        Doubly.Node nodeToRemove = list.getFirstNode();
        Doubly.Node deletedNode = list.deleteFirstNode();

        if (list.size() != 0 || list.getFirstNode() != null || list.getLastNode() != null
                || deletedNode != nodeToRemove)
            failTest(funcName, testNumber);
        else
            passTest(funcName, testNumber);
    }

    public static void testDeleteFirstOnListWithMultipleNodes(String funcName, int testNumber) {
        Doubly list = new Doubly(2);

        list.insertFirst(3);
        list.insertFirst(4);
        list.insertFirst(5);

        Doubly.Node headToRemove = list.getFirstNode();
        Doubly.Node deletedNode = list.deleteFirstNode();
        Doubly.Node newHead = list.getFirstNode();

        if (list.size() != 3 || deletedNode != headToRemove || newHead.data != 4)
            failTest(funcName, testNumber);
        else if (newHead.data != 4 || newHead.nextNode.data != 3 || newHead.nextNode.nextNode.data != 2)
            failTest(funcName, testNumber);
        else if (newHead.prevNode != null || newHead.nextNode.prevNode != newHead)
            failTest(funcName, testNumber);
        else
            passTest(funcName, testNumber);
    }

    public static void testDeleteFirstToVerifyPrevAndNextPointersAreCorrect(String funcName, int testNumber) {
        Doubly list = new Doubly(2);

        list.insertFirst(3);
        list.insertFirst(4);
        list.insertFirst(5);

        Doubly.Node deletedHead = list.deleteFirstNode();
        Doubly.Node newHead = list.getFirstNode();
        Doubly.Node tail = list.getLastNode();
        Doubly.Node nodeAtIdx1 = list.getNodeAtIndex(1);

        if (newHead.prevNode != null || tail.nextNode != null || deletedHead.prevNode != null
                || deletedHead.nextNode != null)
            failTest(funcName, testNumber);
        else if (newHead.nextNode != nodeAtIdx1 || nodeAtIdx1.prevNode != newHead)
            failTest(funcName, testNumber);
        else if (nodeAtIdx1.nextNode != tail || tail.prevNode != nodeAtIdx1)
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
        Doubly list = new Doubly();

        Doubly.Node deletedNode = list.deleteLastNode();

        if (list.size() != 0 || deletedNode != null)
            failTest(funcName, testNumber);
        else
            passTest(funcName, testNumber);
    }

    public static void testDeleteLastOnListWithSingleNode(String funcName, int testNumber) {
        Doubly list = new Doubly(2);
        Doubly.Node tailNodeToRemove = list.getLastNode();
        Doubly.Node deletedNode = list.deleteLastNode();

        if (list.size() != 0 || list.getFirstNode() != null || list.getLastNode() != null
                || deletedNode != tailNodeToRemove)
            failTest(funcName, testNumber);
        else
            passTest(funcName, testNumber);
    }

    public static void testDeleteLastOnListWithMultipleNodes(String funcName, int testNumber) {
        Doubly list = new Doubly(2);

        list.insertFirst(3);
        list.insertFirst(4);
        list.insertFirst(5);

        Doubly.Node head = list.getFirstNode();
        Doubly.Node lastNodeToRemove = list.getLastNode();
        Doubly.Node deletedNode = list.deleteLastNode();

        if (list.size() != 3 || deletedNode != lastNodeToRemove)
            failTest(funcName, testNumber);
        else if (head.data != 5 || head.nextNode.data != 4 || head.nextNode.nextNode.data != 3)
            failTest(funcName, testNumber);
        else if (head.nextNode.nextNode.nextNode != null || deletedNode.prevNode != null)
            failTest(funcName, testNumber);
        else
            passTest(funcName, testNumber);
    }

    public static void testDeleteLastToVerifyPrevAndNextPointersAreCorrect(String funcName, int testNumber) {
        Doubly list = new Doubly(2);

        list.insertFirst(3);
        list.insertFirst(4);
        list.insertFirst(5);

        Doubly.Node head = list.getFirstNode();
        Doubly.Node deletedTail = list.deleteLastNode();
        Doubly.Node newTail = list.getLastNode();
        Doubly.Node nodeAtIdx1 = list.getNodeAtIndex(1);

        if (head.prevNode != null || newTail.nextNode != null || deletedTail.prevNode != null
                || deletedTail.nextNode != null)
            failTest(funcName, testNumber);
        else if (head.nextNode != nodeAtIdx1 || nodeAtIdx1.prevNode != head)
            failTest(funcName, testNumber);
        else if (nodeAtIdx1.nextNode != newTail || newTail.prevNode != nodeAtIdx1)
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
        Doubly list = new Doubly();
        Doubly.Node nodeDeleted1 = list.deleteNodeAtIndex(0);

        list.insertFirst(2);
        list.insertFirst(3);

        Doubly.Node nodeDeleted2 = list.deleteNodeAtIndex(3);
        Doubly.Node nodeDeleted3 = list.deleteNodeAtIndex(-1);

        if (list.size() != 2 || nodeDeleted1 != null || nodeDeleted2 != null || nodeDeleted3 != null)
            failTest(funcName, testNumber);
        else
            passTest(funcName, testNumber);
    }

    public static void testDeleteNodeAtIndexWithIndexOfHead(String funcName, int testNumber) {
        Doubly list = new Doubly(2);
        Doubly.Node head = list.getFirstNode();
        Doubly.Node nodeDeleted = list.deleteNodeAtIndex(0);

        if (list.size() != 0 || nodeDeleted != head)
            failTest(funcName, testNumber);
        else
            passTest(funcName, testNumber);
    }

    public static void testDeleteNodeAtIndexWithIndexOfTail(String funcName, int testNumber) {
        Doubly list = new Doubly(2);

        list.insertLast(3);
        list.insertLast(4);
        list.insertLast(5);

        Doubly.Node tailNode = list.getLastNode();
        Doubly.Node nodeDeleted = list.deleteNodeAtIndex(3);

        if (list.size() != 3 || nodeDeleted != tailNode)
            failTest(funcName, testNumber);
        else
            passTest(funcName, testNumber);
    }

    public static void testDeleteNodeAtIndexWithNonEmptyList(String funcName, int testNumber) {
        Doubly list = new Doubly(2);

        list.insertLast(3);
        list.insertLast(4);
        list.insertLast(5);

        Doubly.Node nodeDeleted1 = list.deleteNodeAtIndex(1);
        Doubly.Node nodeDeleted2 = list.deleteNodeAtIndex(1);
        Doubly.Node head = list.getFirstNode();
        Doubly.Node tail = list.getLastNode();

        if (list.size() != 2 || head.data != 2 || tail.data != 5)
            failTest(funcName, testNumber);
        else if (nodeDeleted1.data != 3 || nodeDeleted2.data != 4)
            failTest(funcName, testNumber);
        else if (head.nextNode != tail || tail.prevNode != head || head.prevNode != null || tail.nextNode != null)
            failTest(funcName, testNumber);
        else
            passTest(funcName, testNumber);
    }

    public static void testDeleteNodeAtIndexToVerifyPrevAndNextPointersAreCorrect(String funcName, int testNumber) {
        Doubly list = new Doubly(2);

        list.insertLast(3);
        list.insertLast(4);
        list.insertLast(5);
        list.insertLast(6);

        Doubly.Node nodeDeleted1 = list.deleteNodeAtIndex(1);
        Doubly.Node nodeDeleted2 = list.deleteNodeAtIndex(2);

        Doubly.Node head = list.getFirstNode();
        Doubly.Node tail = list.getLastNode();
        Doubly.Node nodeAtIdx1 = list.getNodeAtIndex(1);

        if (head.prevNode != null || tail.nextNode != null)
            failTest(funcName, testNumber);
        else if (nodeDeleted1.prevNode != null || nodeDeleted1.nextNode != null)
            failTest(funcName, testNumber);
        else if (nodeDeleted2.prevNode != null || nodeDeleted2.nextNode != null)
            failTest(funcName, testNumber);
        else if (head.nextNode != nodeAtIdx1 || nodeAtIdx1.prevNode != head)
            failTest(funcName, testNumber);
        else if (nodeAtIdx1.nextNode != tail || tail.prevNode != nodeAtIdx1)
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
        Doubly list = new Doubly();
        Doubly.Node nodeRetrieved = list.getFirstNode();

        if (list.size() != 0 || nodeRetrieved != null)
            failTest(funcName, testNumber);
        else
            passTest(funcName, testNumber);
    }

    public static void testGetFirstNodeOnListWithSingleNode(String funcName, int testNumber) {
        Doubly list = new Doubly(2);
        Doubly.Node nodeRetrieved = list.getFirstNode();

        if (list.size() != 1 || nodeRetrieved.data != 2)
            failTest(funcName, testNumber);
        else
            passTest(funcName, testNumber);
    }

    public static void testGetFirstNodeOnListWithMultipleNodes(String funcName, int testNumber) {
        Doubly list = new Doubly(2);
        Doubly.Node nodeRetrieved = list.getFirstNode();

        list.insertLast(3);
        list.insertLast(4);
        list.insertLast(5);

        if (list.size() != 4 || nodeRetrieved.data != 2)
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
        Doubly list = new Doubly();
        Doubly.Node nodeRetrieved = list.getLastNode();

        if (list.size() != 0 || nodeRetrieved != null)
            failTest(funcName, testNumber);
        else
            passTest(funcName, testNumber);
    }

    public static void testGetLastNodeOnListWithSingleNode(String funcName, int testNumber) {
        Doubly list = new Doubly(2);
        Doubly.Node nodeRetrieved = list.getLastNode();

        if (list.size() != 1 || nodeRetrieved.data != 2)
            failTest(funcName, testNumber);
        else
            passTest(funcName, testNumber);
    }

    public static void testGetLastNodeOnListWithMultipleNodes(String funcName, int testNumber) {
        Doubly list = new Doubly(2);

        list.insertLast(3);
        list.insertLast(4);
        list.insertLast(5);
        Doubly.Node nodeRetrieved = list.getLastNode();

        if (list.size() != 4 || nodeRetrieved.data != 5)
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
        Doubly list = new Doubly();
        Doubly.Node nodeRetrieved1 = list.getNodeAtIndex(0);

        list.insertFirst(2);
        list.insertFirst(3);

        Doubly.Node nodeRetrieved2 = list.getNodeAtIndex(3);
        Doubly.Node nodeRetrieved3 = list.getNodeAtIndex(-1);

        if (list.size() != 2 || nodeRetrieved1 != null || nodeRetrieved2 != null || nodeRetrieved3 != null)
            failTest(funcName, testNumber);
        else
            passTest(funcName, testNumber);
    }

    public static void testGetNodeAtIndexWithIndexOfHead(String funcName, int testNumber) {
        Doubly list = new Doubly(2);
        Doubly.Node nodeRetrieved = list.getNodeAtIndex(0);
        Doubly.Node head = list.getFirstNode();

        if (list.size() != 1 || nodeRetrieved != head)
            failTest(funcName, testNumber);
        else
            passTest(funcName, testNumber);
    }

    public static void testGetNodeAtIndexWithIndexOfLastNode(String funcName, int testNumber) {
        Doubly list = new Doubly(2);

        list.insertLast(3);
        list.insertLast(4);
        list.insertLast(5);

        Doubly.Node nodeRetrieved = list.getNodeAtIndex(3);
        Doubly.Node lastNode = list.getLastNode();

        if (list.size() != 4 || nodeRetrieved != lastNode)
            failTest(funcName, testNumber);
        else
            passTest(funcName, testNumber);
    }

    public static void testGetNodeAtIndex(String funcName, int testNumber) {
        Doubly list = new Doubly(2);

        list.insertLast(3);
        list.insertLast(4);
        list.insertLast(5);

        Doubly.Node nodeRetrieved1 = list.getNodeAtIndex(1);
        Doubly.Node nodeRetrieved2 = list.getNodeAtIndex(2);

        if (list.size() != 4 || nodeRetrieved1.data != 3 || nodeRetrieved2.data != 4)
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
        Doubly list = new Doubly();

        if (list.isEmpty())
            passTest(funcName, testNumber);
        else
            failTest(funcName, testNumber);
    }

    public static void testIsEmptyListOnSigleNodeList(String funcName, int testNumber) {
        Doubly list = new Doubly(2);

        if (list.isEmpty())
            failTest(funcName, testNumber);
        else
            passTest(funcName, testNumber);
    }

    public static void testIsEmptyListOnMultiNodeList(String funcName, int testNumber) {
        Doubly list = new Doubly(2);

        list.insertFirst(4);
        list.insertFirst(40);
        list.insertFirst(6);
        list.insertFirst(33);

        if (list.isEmpty())
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
        Doubly list = new Doubly(10);

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
     * getSize() test
     * ======================
     */

    public static void testGetSize(String funcName, int testNumber) {

        Doubly list = new Doubly();

        if (list.size() != 0)
            failTest(funcName, testNumber);
        else if (list.insertFirst(4) && list.insertFirst(40) && list.insertFirst(6) && list.size() != 3)
            failTest(funcName, testNumber);
        else if (list.deleteFirstNode() != null && list.deleteLastNode() != null && list.size() == 1)
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
