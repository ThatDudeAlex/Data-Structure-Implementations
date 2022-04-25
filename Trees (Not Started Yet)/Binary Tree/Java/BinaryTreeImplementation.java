import java.util.ArrayList;

public class BinaryTreeImplementation {
    
    Node root = null;

    BinaryTreeImplementation(int data) {
        this.root = new Node(data);
    }

    public boolean insertValue(int data) {
        if (isEmptyTree()) {
            this.root = new Node(data);
        }

        insertToAvailableSlot(data);
        return true;
    }

    private void insertToAvailableSlot(int data) {
        
    }

    public boolean deleteValue(int data) {

        return true;
    }

    public boolean containsValue(int data) {

        return true;
    }

    public Node getRoot() {
        return this.root;
    }

    public boolean isEmptyTree() {
        return this.root == null;
    }

    class Node {
        int data;
        Node leftChild = null;
        Node rightChild = null;

        Node(int data) {
            this.data = data;
        }
    }
}
