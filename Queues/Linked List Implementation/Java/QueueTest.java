import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class QueueTest {
    public static void main(String[] args) {
        int testNumber = 1;

        // Iterates through all the public methods in the class and invokes each one except main().
        // This makes calling & adding additional testcases easier
        
        for (Method method : QueueTest.class.getDeclaredMethods()) {
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
     * Queue Init test
     * ======================
     */

    public static void testInitQueuetWithoutParams(String funcName, int testNumber) {
        Queue queue = new Queue();
        Integer front = queue.peek();

        if (queue.size() != 0 || front != null)
            failTest(funcName, testNumber);
        else
            passTest(funcName, testNumber);
    }

    public static void testInitQueueWithParams(String funcName, int testNumber) {
        Queue queue = new Queue(4);
        Integer front = queue.peek();

        if (queue.size() != 1 || front == null || front != 4)
            failTest(funcName, testNumber);
        else
            passTest(funcName, testNumber);
    }

    /*
     * ======================
     * enqueue() test
     * ======================
     */

    public static void testEnqueueOnEmptyQueue(String funcName, int testNumber) {
        Queue queue = new Queue();

        queue.enqueue(2);
        Integer front = queue.peek();

        if (queue.size() != 1 || front == null || front != 2)
            failTest(funcName, testNumber);
        else
            passTest(funcName, testNumber);
    }

    public static void testEnqueueOnNonEmptyQueue(String funcName, int testNumber) {
        Queue queue = new Queue(2);

        queue.enqueue(3);
        Integer front = queue.peek();

        if (queue.size() != 2 || front == null || front != 2)
            failTest(funcName, testNumber);
        else
            passTest(funcName, testNumber);
    }

    /*
     * ======================
     * dequeue() test
     * ======================
     */

    public static void testDequeueOnEmptyQueue(String funcName, int testNumber) {
        Queue queue = new Queue();
        Integer front = queue.dequeue();

        if (queue.size() != 0 || front != null)
            failTest(funcName, testNumber);
        else
            passTest(funcName, testNumber);
    }

    public static void testDequeueOnNonEmptyQueue(String funcName, int testNumber) {
        Queue queue = new Queue(2);
        queue.enqueue(3);

        Integer front1 = queue.dequeue();
        Integer front2 = queue.dequeue();

        if (queue.size() != 0 || front1 != 2 || front2 != 3)
            failTest(funcName, testNumber);
        else
            passTest(funcName, testNumber);
    }

    /*
     * ======================
     * isEmpty() test
     * ======================
     */

    public static void testIsEmptyOnEmptyQueue(String funcName, int testNumber) {
        Queue queue = new Queue();

        if (queue.isEmpty())
            passTest(funcName, testNumber);
        else
            failTest(funcName, testNumber);
    }

    public static void testIsEmptyOnNonEmptyQueue(String funcName, int testNumber) {
        Queue queue = new Queue(2);
        queue.enqueue(3);

        if (queue.isEmpty())
            failTest(funcName, testNumber);
        else
            passTest(funcName, testNumber);
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
