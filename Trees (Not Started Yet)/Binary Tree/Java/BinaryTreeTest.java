
public class BinaryTreeTest {
    public static void main(String[] args) {
        testInsertion();
    }

    public static void testInsertion() {
        String funcName = "testInsertion";
        BinaryTreeImplementation binaryTree = new BinaryTreeImplementation(10);
        BinaryTreeImplementation.Node root = binaryTree.getRoot();

        binaryTree.insertValue(4);
        binaryTree.insertValue(7);
        binaryTree.insertValue(2);

        
        if (root.leftChild.data == 4 && root.rightChild.data == 7 && root.leftChild.leftChild.data == 2) {
            passTest(funcName);
        }
        failTest(funcName);
    }

    public static void testValidDeletion() {
        String funcName = "testValidDeletion";
        BinaryTreeImplementation binaryTree = new BinaryTreeImplementation(10);
        BinaryTreeImplementation.Node root = binaryTree.getRoot();

        binaryTree.insertValue(4);
        binaryTree.insertValue(7);
        binaryTree.insertValue(2);

        binaryTree.deleteValue(2);

        if (root.leftChild.leftChild == null) {
            passTest(funcName);
        }
        failTest(funcName);
    }

    public static void testRootDeletion() {
        
    }

    public static void testInvalidDeletion() {
        
    }

    public static void testSearch() {
        
    }

    private static void failTest(String funcName) {
        System.out.printf("\n* %s : FAIL\n", funcName);
    }

    private static void passTest(String funcName) {
        System.out.printf("\n* %s : PASS\n", funcName);
    }

}
