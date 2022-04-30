import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class SimpleStackTest {
    public static void main(String[] args) {
        int testNumber = 1;

        // Iterates through all the public methods in the class and invokes each one except main().
        // This makes calling & adding additional testcases easier
        
        for (Method method : SimpleStackTest.class.getDeclaredMethods()) {
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
     * stack Init test
     * ======================
     */

    public static void testInitStacktWithoutParams(String funcName, int testNumber) {
        SimpleStack stack = new SimpleStack();
        Integer top = stack.peek();

        if (stack.size() != 0 || top != null)
            failTest(funcName, testNumber);
        else
            passTest(funcName, testNumber);
    }

    public static void testInitStackWithParams(String funcName, int testNumber) {
        SimpleStack stack = new SimpleStack(4);
        Integer top = stack.peek();

        if (stack.size() != 1 || top == null || top != 4)
            failTest(funcName, testNumber);
        else
            passTest(funcName, testNumber);
    }

    /*
     * ======================
     * push() test
     * ======================
     */

    public static void testPushOnEmptyStack(String funcName, int testNumber) {
        SimpleStack stack = new SimpleStack();

        stack.push(2);
        Integer top = stack.peek();

        if (stack.size() != 1 || top == null || top != 2)
            failTest(funcName, testNumber);
        else
            passTest(funcName, testNumber);
    }

    public static void testPushOnNonEmptyStack(String funcName, int testNumber) {
        SimpleStack stack = new SimpleStack(2);

        stack.push(3);
        Integer top = stack.peek();

        if (stack.size() != 2 || top == null || top != 3)
            failTest(funcName, testNumber);
        else
            passTest(funcName, testNumber);
    }

    /*
     * ======================
     * pop() test
     * ======================
     */

    public static void testPopOnEmptyStack(String funcName, int testNumber) {
        SimpleStack stack = new SimpleStack();
        Integer top = stack.pop();

        if (stack.size() != 0 || top != null)
            failTest(funcName, testNumber);
        else
            passTest(funcName, testNumber);
    }

    public static void testPopOnNonEmptyStack(String funcName, int testNumber) {
        SimpleStack stack = new SimpleStack(2);
        stack.push(3);

        Integer top1 = stack.pop();
        Integer top2 = stack.pop();

        if (stack.size() != 0 || top1 != 3 || top2 != 2)
            failTest(funcName, testNumber);
        else
            passTest(funcName, testNumber);
    }

    /*
     * ======================
     * isEmpty() test
     * ======================
     */

    public static void testIsEmptyOnEmptyStack(String funcName, int testNumber) {
        SimpleStack stack = new SimpleStack();

        if (stack.isEmpty())
            passTest(funcName, testNumber);
        else
            failTest(funcName, testNumber);
    }

    public static void testIsEmptyOnNonEmptyStack(String funcName, int testNumber) {
        SimpleStack stack = new SimpleStack(2);
        stack.push(3);

        if (stack.isEmpty())
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
