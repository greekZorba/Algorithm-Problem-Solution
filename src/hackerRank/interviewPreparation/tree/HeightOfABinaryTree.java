package hackerRank.interviewPreparation.tree;

public class HeightOfABinaryTree {

    public static void main(String[] args) {
        HeightOfABinaryTree tree = new HeightOfABinaryTree();
        Node node = tree.insert(null, 3);
        tree.insert(node, 2);
        tree.insert(node, 5);
        tree.insert(node, 7);
        tree.insert(node, 8);
        tree.insert(node, 10);

        System.out.println(tree.height(node));
    }




    // recursion으로 풀기?
    public int height(Node root) {
        int treeHeight = 0;

        if(root.left != null) {
            treeHeight = height(root.left);
            treeHeight++;
        }

        if(root.right != null) {
            treeHeight = height(root.right);
            treeHeight++;
        }

        return treeHeight;
    }

    public Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    private class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }
}
