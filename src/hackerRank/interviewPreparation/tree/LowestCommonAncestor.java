package hackerRank.interviewPreparation.tree;

import java.util.ArrayList;
import java.util.List;

public class LowestCommonAncestor {

    public static void main(String[] args) {
        LowestCommonAncestor tree = new LowestCommonAncestor();
//        Node node = tree.insert(null, 4);
//        tree.insert(node, 2);
//        tree.insert(node, 3);
//        tree.insert(node, 1);
//        tree.insert(node, 7);
//        tree.insert(node, 6);
        Node node = tree.insert(null, 1);
        tree.insert(node, 2);

        System.out.println(tree.lca(node, 1,2).data);
    }

    public Node lca(Node root, int v1, int v2) {

        List<Integer> tracePathV1 = binarySearch(root, v1);
        List<Integer> tracePathV2 = binarySearch(root, v2);

        for(int i=0; i<tracePathV1.size(); i++) {
            if(tracePathV2.contains(tracePathV1.get(i))) {
                return findNode(root, tracePathV1.get(i));
            }
        }

        return null;
    }

    public Node findNode(Node root, int value) {

        if(root.data < value ) {
            root = findNode(root.right, value);
        } else if(root.data > value) {
            root = findNode(root.left, value);
        }

        return root;
    }

    public List<Integer> binarySearch(Node root, int value) {
        List<Integer> tracePath = new ArrayList<>();

        if(root.data < value ) {
            tracePath = binarySearch(root.right, value);
            tracePath.add(root.data);
        } else if(root.data > value) {
            tracePath = binarySearch(root.left, value);
            tracePath.add(root.data);
        } else {
            tracePath.add(root.data);
        }

        return tracePath;
    }

    // 해커랭크 discussion 참조 - 훨씬 쉽게 풀어져있음
    public Node hackerrandSolution(Node root, int v1, int v2) {

        //Decide if you have to call rekursively
        //Samller than both
        if(root.data < v1 && root.data < v2){
            return lca(root.right,v1,v2);
        }
        //Bigger than both
        if(root.data > v1 && root.data > v2){
            return lca(root.left,v1,v2);
        }

        //Else solution already found
        return root;
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
