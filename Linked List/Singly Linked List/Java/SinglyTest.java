import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class SinglyTest {
    public static void main(String[] args) {
        int testNumber = 1;

        // Iterates through all the public methods in the class and invokes each one
        // except main().
        // This makes calling & adding additional testcases easier

        for (Method method : SinglyTest.class.getDeclaredMethods()) {
            if (method.getName() != "main" && Modifier.isPublic(method.getModifiers())) {
                try {
                    method.invoke(method, new Object[] { method.getName(), testNumber++ });
                } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
                    testcaseError(e, testNumber++);
                }
            }
        }
    }

    public static void testInsertFirst(String funcName, int testNumber) {
        SinglyImplementation singly = new SinglyImplementation();

        singly.insertFirst(2);
        singly.insertFirst(9);

        if (singly.getSize() != 2 || singly.getHead().data != 9)
            failTest(funcName, testNumber);
        else
            passTest(funcName, testNumber);
    }

    public static void testInsertLast(String funcName, int testNumber) {
        SinglyImplementation singly = new SinglyImplementation();

        singly.insertLast(2);

        if (singly.getTail().data != 2) {
            failTest(funcName, testNumber);
            return;
        }

        singly.insertLast(9);

        if (singly.getHead().data != 2 || singly.getTail().data != 9)
            failTest(funcName, testNumber);
        else
            passTest(funcName, testNumber);
    }

    public static void testGetValidNode(String funcName, int testNumber) {
        SinglyImplementation singly = new SinglyImplementation();

        singly.insertFirst(2);
        singly.insertFirst(9);
        singly.insertFirst(3);

        if (singly.getHead().data != 3 || singly.getNodeAtIndex(1).data != 9 || singly.getNodeAtIndex(2).data != 2)
            failTest(funcName, testNumber);
        else
            passTest(funcName, testNumber);
    }

    public static void testGetInvalidNode(String funcName, int testNumber) {
        SinglyImplementation singly = new SinglyImplementation();

        if (singly.getHead() != null || singly.getNodeAtIndex(1) != null) {
            failTest(funcName, testNumber);
            return;
        }

        singly.insertFirst(2);
        singly.insertFirst(9);
        singly.insertFirst(3);

        if (singly.getNodeAtIndex(3) != null || singly.getNodeAtIndex(-1) != null)
            failTest(funcName, testNumber);
        else
            passTest(funcName, testNumber);
    }

    public static void testDeleteValidNodeOnMultiNodeList(String funcName, int testNumber) {
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
            failTest(funcName, testNumber);
        else if (singly.getHead().data != 1 || singly.getNodeAtIndex(1).data != 2 || singly.getTail().data != 3)
            failTest(funcName, testNumber);
        else
            passTest(funcName, testNumber);
    }

    public static void testDeleteValidNodeOnSingleNodeList(String funcName, int testNumber) {
        SinglyImplementation singly = new SinglyImplementation();

        singly.insertFirst(2);
        singly.deleteNodeAtIndex(0);

        if (singly.getSize() != 0 || singly.getHead() != null || singly.getTail() != null)
            failTest(funcName, testNumber);
        else
            passTest(funcName, testNumber);
    }

    public static void testDeleteInvalidNode(String funcName, int testNumber) {
        SinglyImplementation singly = new SinglyImplementation();

        if (singly.deleteNodeAtIndex(0)) {
            failTest(funcName, testNumber);
            return;
        }

        singly.insertFirst(10);

        if (singly.deleteNodeAtIndex(1) || singly.deleteNodeAtIndex(-1))
            failTest(funcName, testNumber);
        else
            passTest(funcName, testNumber);
    }

    public static void testSearch(String funcName, int testNumber) {
        SinglyImplementation singly = new SinglyImplementation();

        singly.insertFirst(10);
        singly.insertFirst(4);
        singly.insertFirst(40);
        singly.insertFirst(6);
        singly.insertFirst(33);

        if (singly.search(10) && singly.search(4) && singly.search(40))
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