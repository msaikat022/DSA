import java.util.LinkedList;
import java.util.Queue;

public class buildTreeFrmPrerder {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class BinaryTree {
        static int idx = -1;

        public static Node buildTree(int[] nodes) {
            idx++;
            if (nodes[idx] == -1) {
                return null;
            }
            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }

        public static void preorder(Node root) {
            if (root == null) {
                return;
            }
            System.out.print(root.data + " ");
            preorder(root.left);
            preorder(root.right);
        }

        public static void inorder(Node root) {
            if (root == null) {
                return;
            }
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }

        public static void postorder(Node root) {
            if (root == null) {
                return;
            }
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data + " ");
        }

        public static void levelOrder(Node root) {
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);
            while (!q.isEmpty()) {
                Node cNode = q.remove();
                if (cNode == null) {
                    System.out.println();
                    if (q.isEmpty()) {
                        break;
                    }
                    q.add(null);
                } else {
                    System.out.print(cNode.data + " ");
                    if (cNode.left != null) {
                        q.add(cNode.left);
                    }
                    if (cNode.right != null) {
                        q.add(cNode.right);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        BinaryTree b = new BinaryTree();
        Node root = b.buildTree(nodes);
        // b.preorder(root);
        // System.out.println();
        // b.inorder(root);
        // System.out.println();
        // b.postorder(root);
        System.out.println();
        b.levelOrder(root);
    }
}