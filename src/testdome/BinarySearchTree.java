package testdome;

class Node {
    public int value;
    public Node left, right;

    public Node(int value, Node left, Node right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
}

public class BinarySearchTree {
    public static boolean contains(Node root, int value) {
        boolean containFlag = false;

        if(root == null){
            return false;
        }

        if(root.value == value){
            return true;
        }
        else if(root.value < value){

            if(contains(root.right, value)){
               containFlag = true;
            }
        }
        else if(root.value > value){

            if(contains(root.left, value)){
                containFlag = true;
            }
        }

        return containFlag;
    }
    
    public static void main(String[] args) {
        Node n1 = new Node(1, null, null);
        Node n3 = new Node(3, null, null);
        Node n2 = new Node(2, n1, n3);
        
        System.out.println(contains(n2, 3));
    }
}