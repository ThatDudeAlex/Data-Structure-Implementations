import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class CircularSinglyTest {
    public static void main(String[] args) {
        int testNumber = 1;

        // Iterates through all the public methods in the class and invokes each one except main().
        // This makes calling & adding additional testcases easier

        for (Method method : CircularSinglyTest.class.getDeclaredMethods()) {
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
        CircularSingly list = new CircularSingly();

        if (list.size() != 0 || list.getFirstNode() != null)
            failTest(funcName, testNumber);
        else
            passTest(funcName, testNumber);
    }

    public static void testInitListWithParams(String funcName, int testNumber) {
        CircularSingly list = new CircularSingly(4);
        CircularSingly.Node head = list.getFirstNode();

        if (list.size() != 1 || head == null || head.nextNode != head)
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
        CircularSingly list = new CircularSingly();

        list.insertFirst(2);
        
        CircularSingly.Node head = list.getFirstNode();

        if (list.size() != 1 || head == null)
            failTest(funcName, testNumber);
        else if (head.data != 2 || head.nextNode != head)
            failTest(funcName, testNumber);
        else
            passTest(funcName, testNumber);
    }

    public static void testInsertFirstOnListWithSingleNode(String funcName, int testNumber) {
        CircularSingly list = new CircularSingly(2);

        list.insertFirst(9);
        CircularSingly.Node head = list.getFirstNode();

        if (list.size() != 2)
            failTest(funcName, testNumber);
        else if (head.data != 9 || head.nextNode.data != 2 || head.nextNode.nextNode != head)
            failTest(funcName, testNumber);
        else
            passTest(funcName, testNumber);
    }

    public static void testInsertFirstOnListWithhMultipleNodes(String funcName, int testNumber) {
        CircularSingly list = new CircularSingly(2);

        list.insertFirst(9); list.insertFirst(7);

        CircularSingly.Node head = list.getFirstNode();

        if (list.size() != 3)
            failTest(funcName, testNumber);
        else if (head.data != 7 || head.nextNode.data != 9 || head.nextNode.nextNode.data != 2)
            failTest(funcName, testNumber);
        else if (head.nextNode.nextNode.nextNode != head)
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
        CircularSingly list = new CircularSingly();

        list.insertLast(2);
        CircularSingly.Node head = list.getFirstNode();

        if (list.size() != 1 || head == null)
            failTest(funcName, testNumber);
        else if (head.data != 2 || head.nextNode != head)
            failTest(funcName, testNumber);
        else
            passTest(funcName, testNumber);
    }

    public static void testInsertLastOnListWithSingleNode(String funcName, int testNumber) {
        CircularSingly list = new CircularSingly(2);

        list.insertLast(9);
        CircularSingly.Node head = list.getFirstNode();

        if (list.size() != 2)
            failTest(funcName, testNumber);
        else if (head.data != 2 || head.nextNode.data != 9 || head.nextNode.nextNode != head)
            failTest(funcName, testNumber);
        else
            passTest(funcName, testNumber);
    }

    public static void testInsertLastOnListWithhMultipleNodes(String funcName, int testNumber) {
        CircularSingly list = new CircularSingly(2);

        list.insertLast(9);
        list.insertLast(7);
        CircularSingly.Node head = list.getFirstNode();

        if (list.size() != 3)
            failTest(funcName, testNumber);
        else if (head.data != 2 || head.nextNode.data != 9 || head.nextNode.nextNode.data != 7)
            failTest(funcName, testNumber);
        else if (head.nextNode.nextNode.nextNode != head)
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
        CircularSingly list = new CircularSingly();

        if (!list.insertAtIndex(0, 2) || list.size() != 1 || list.getFirstNode().data != 2)
            failTest(funcName, testNumber);
        else
            passTest(funcName, testNumber);
    }

    public static void testInsertAtIndexWithNonEmptyListAtIndexZero(String funcName, int testNumber) {
        CircularSingly list = new CircularSingly(2);

        list.insertLast(9);
        list.insertLast(7);

        if (!list.insertAtIndex(0, 5) || list.size() != 4 || list.getFirstNode().data != 5)
            failTest(funcName, testNumber);
        else if (list.getLastNode().nextNode.data != 5)
            failTest(funcName, testNumber);
        else
            passTest(funcName, testNumber);
    }

    public static void testInsertAtIndexWithInvalidIndexes(String funcName, int testNumber) {
        CircularSingly list = new CircularSingly();

        if (list.insertAtIndex(1, 2) || list.insertAtIndex(-1, 2))
            failTest(funcName, testNumber);
        else if (list.size() != 0 || list.getFirstNode() != null)
            failTest(funcName, testNumber);
        else
            passTest(funcName, testNumber);
    }

    public static void testInsertAtIndexWithNonEmptyList(String funcName, int testNumber) {
        CircularSingly list = new CircularSingly(2);

        list.insertLast(9);
        list.insertLast(7);

        if (!list.insertAtIndex(1, 5) || !list.insertAtIndex(3, 8) || list.size() != 5)
            failTest(funcName, testNumber);
        else if (list.getFirstNode().nextNode.data != 5)
            failTest(funcName, testNumber);
        else if (list.getFirstNode().nextNode.nextNode.nextNode.data != 8)
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
        CircularSingly list = new CircularSingly();

        CircularSingly.Node deletedNode = list.deleteFirstNode();

        if (list.size() != 0 || deletedNode != null)
            failTest(funcName, testNumber);
        else
            passTest(funcName, testNumber);
    }

    public static void testDeleteFirstOnListWithSingleNode(String funcName, int testNumber) {
        CircularSingly list = new CircularSingly(2);
        CircularSingly.Node headToRemove = list.getFirstNode();
        CircularSingly.Node deletedNode = list.deleteFirstNode();

        if (list.size() != 0 || list.getFirstNode() != null || deletedNode != headToRemove)
            failTest(funcName, testNumber);
        else
            passTest(funcName, testNumber);
    }

    public static void testDeleteFirstOnListWithMultipleNodes(String funcName, int testNumber) {
        CircularSingly list = new CircularSingly(2);

        list.insertFirst(3);
        list.insertFirst(4);
        list.insertFirst(5);

        CircularSingly.Node headToRemove = list.getFirstNode();
        CircularSingly.Node deletedNode = list.deleteFirstNode();
        CircularSingly.Node newHead = list.getFirstNode();

        if (list.size() != 3 || deletedNode != headToRemove)
            failTest(funcName, testNumber);
        else if (newHead.data != 4 || newHead.nextNode.data != 3 || newHead.nextNode.nextNode.data != 2)
            failTest(funcName, testNumber);
        else if (newHead.nextNode.nextNode.nextNode != newHead)
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
        CircularSingly list = new CircularSingly();

        CircularSingly.Node deletedNode = list.deleteLastNode();

        if (list.size() != 0 || deletedNode != null)
            failTest(funcName, testNumber);
        else
            passTest(funcName, testNumber);
    }

    public static void testDeleteLastOnListWithSingleNode(String funcName, int testNumber) {
        CircularSingly list = new CircularSingly(2);
        CircularSingly.Node lastNodeToRemove = list.getLastNode();
        CircularSingly.Node deletedNode = list.deleteLastNode();

        if (list.size() != 0 || list.getFirstNode() != null || deletedNode != lastNodeToRemove)
            failTest(funcName, testNumber);
        else
            passTest(funcName, testNumber);
    }

    public static void testDeleteLastOnListWithMultipleNodes(String funcName, int testNumber) {
        CircularSingly list = new CircularSingly(2);

        list.insertFirst(3);
        list.insertFirst(4);
        list.insertFirst(5);

        CircularSingly.Node head = list.getFirstNode();
        CircularSingly.Node lastNodeToRemove = list.getLastNode();
        CircularSingly.Node deletedNode = list.deleteLastNode();

        if (list.size() != 3 || deletedNode.data != 2 || deletedNode != lastNodeToRemove)
            failTest(funcName, testNumber);
        else if (head.data != 5 || head.nextNode.data != 4 || head.nextNode.nextNode.data != 3)
            failTest(funcName, testNumber);
        else if (head.nextNode.nextNode.nextNode != head)
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
        CircularSingly list = new CircularSingly();
        CircularSingly.Node nodeDeleted1 = list.deleteNodeAtIndex(0);

        list.insertFirst(2);
        list.insertFirst(3);

        CircularSingly.Node nodeDeleted2 = list.deleteNodeAtIndex(3);
        CircularSingly.Node nodeDeleted3 = list.deleteNodeAtIndex(-1);

        if (list.size() != 2 || nodeDeleted1 != null || nodeDeleted2 != null || nodeDeleted3 != null)
            failTest(funcName, testNumber);
        else
            passTest(funcName, testNumber);
    }

    public static void testDeleteNodeAtIndexWithIndexOfHead(String funcName, int testNumber) {
        CircularSingly list = new CircularSingly(2);
        CircularSingly.Node head = list.getFirstNode();
        CircularSingly.Node nodeDeleted = list.deleteNodeAtIndex(0);

        if (list.size() != 0 || nodeDeleted != head)
            failTest(funcName, testNumber);
        else
            passTest(funcName, testNumber);
    }

    public static void testDeleteNodeAtIndexWithIndexOfLastNode(String funcName, int testNumber) {
        CircularSingly list = new CircularSingly(2);

        list.insertLast(3);
        list.insertLast(4);
        list.insertLast(5);

        CircularSingly.Node lastNode = list.getLastNode();
        CircularSingly.Node nodeDeleted = list.deleteNodeAtIndex(3);

        if (list.size() != 3 || nodeDeleted != lastNode)
            failTest(funcName, testNumber);
        else
            passTest(funcName, testNumber);
    }

    public static void testDeleteNodeAtIndex(String funcName, int testNumber) {
        CircularSingly list = new CircularSingly(2);

        list.insertLast(3);
        list.insertLast(4);
        list.insertLast(5);

        CircularSingly.Node nodeDeleted1 = list.deleteNodeAtIndex(1);
        CircularSingly.Node nodeDeleted2 = list.deleteNodeAtIndex(1);

        if (list.size() != 2 || list.getFirstNode().data != 2 || list.getLastNode().data != 5)
            failTest(funcName, testNumber);
        else if (nodeDeleted1.data != 3 || nodeDeleted2.data != 4)
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
        CircularSingly list = new CircularSingly();
        CircularSingly.Node nodeRetrieved = list.getFirstNode();

        if (list.size() != 0 || nodeRetrieved != null)
            failTest(funcName, testNumber);
        else
            passTest(funcName, testNumber);
    }

    public static void testGetFirstNodeOnListWithSingleNode(String funcName, int testNumber) {
        CircularSingly list = new CircularSingly(2);
        CircularSingly.Node nodeRetrieved = list.getFirstNode();

        if (list.size() != 1 || nodeRetrieved.data != 2)
            failTest(funcName, testNumber);
        else
            passTest(funcName, testNumber);
    }

    public static void testGetFirstNodeOnListWithMultipleNodes(String funcName, int testNumber) {
        CircularSingly list = new CircularSingly(2);
        CircularSingly.Node nodeRetrieved = list.getFirstNode();

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
        CircularSingly list = new CircularSingly();
        CircularSingly.Node nodeRetrieved = list.getLastNode();

        if (list.size() != 0 || nodeRetrieved != null)
            failTest(funcName, testNumber);
        else
            passTest(funcName, testNumber);
    }

    public static void testGetLastNodeOnListWithSingleNode(String funcName, int testNumber) {
        CircularSingly list = new CircularSingly(2);
        CircularSingly.Node nodeRetrieved = list.getLastNode();

        if (list.size() != 1 || nodeRetrieved.data != 2)
            failTest(funcName, testNumber);
        else
            passTest(funcName, testNumber);
    }

    public static void testGetLastNodeOnListWithMultipleNodes(String funcName, int testNumber) {
        CircularSingly list = new CircularSingly(2);

        list.insertLast(3);
        list.insertLast(4);
        list.insertLast(5);
        CircularSingly.Node nodeRetrieved = list.getLastNode();

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
        CircularSingly list = new CircularSingly();
        CircularSingly.Node nodeRetrieved1 = list.getNodeAtIndex(0);

        list.insertFirst(2);
        list.insertFirst(3);

        CircularSingly.Node nodeRetrieved2 = list.getNodeAtIndex(3);
        CircularSingly.Node nodeRetrieved3 = list.getNodeAtIndex(-1);

        if (list.size() != 2 || nodeRetrieved1 != null || nodeRetrieved2 != null || nodeRetrieved3 != null)
            failTest(funcName, testNumber);
        else
            passTest(funcName, testNumber);
    }

    public static void testGetNodeAtIndexWithIndexOfHead(String funcName, int testNumber) {
        CircularSingly list = new CircularSingly(2);
        CircularSingly.Node nodeRetrieved = list.getNodeAtIndex(0);
        CircularSingly.Node head = list.getFirstNode();

        if (list.size() != 1 || nodeRetrieved != head)
            failTest(funcName, testNumber);
        else
            passTest(funcName, testNumber);
    }

    public static void testGetNodeAtIndexWithIndexOfLastNode(String funcName, int testNumber) {
        CircularSingly list = new CircularSingly(2);

        list.insertLast(3);
        list.insertLast(4);
        list.insertLast(5);

        CircularSingly.Node nodeRetrieved = list.getNodeAtIndex(3);
        CircularSingly.Node lastNode = list.getLastNode();

        if (list.size() != 4 || nodeRetrieved != lastNode)
            failTest(funcName, testNumber);
        else
            passTest(funcName, testNumber);
    }

    public static void testGetNodeAtIndex(String funcName, int testNumber) {
        CircularSingly list = new CircularSingly(2);

        list.insertLast(3);
        list.insertLast(4);
        list.insertLast(5);

        CircularSingly.Node nodeRetrieved1 = list.getNodeAtIndex(1);
        CircularSingly.Node nodeRetrieved2 = list.getNodeAtIndex(2);

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
        CircularSingly list = new CircularSingly();

        if (list.isEmpty())
            passTest(funcName, testNumber);
        else
            failTest(funcName, testNumber);
    }

    public static void testIsEmptyListOnSigleNodeList(String funcName, int testNumber) {
        CircularSingly list = new CircularSingly(2);

        if (list.isEmpty())
            failTest(funcName, testNumber);
        else
            passTest(funcName, testNumber);
    }

    public static void testIsEmptyListOnMultiNodeList(String funcName, int testNumber) {
        CircularSingly list = new CircularSingly(2);

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
        CircularSingly list = new CircularSingly(10);

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
     * testsize() test
     * ======================
     */

    public static void testsize(String funcName, int testNumber) {
        CircularSingly list = new CircularSingly();

        if (list.size() != 0) {
            failTest(funcName, testNumber);
            return;
        }

        list.insertFirst(4);
        list.insertFirst(40);
        list.insertFirst(6);
        list.insertFirst(33);

        if (list.size() != 4) {
            failTest(funcName, testNumber);
            return;
        }

        list.deleteFirstNode();
        list.deleteLastNode();

        if (list.size() == 2)
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
