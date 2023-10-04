
/**
* A class which represents an implementation of a Binary
* Search Tree
* Please fill out the following marking information below:
* Family name : Chordia
* Given names : Shivraj Singh

* Course : ITEC 2620
*
**/
import java.util.ArrayDeque;
import java.util.Queue;

public class BST implements Tree

{

   

    // variables

   

    // Tree Root

    private BSTNode root;

    
    // Constructors

   

    // Create an empty Binary search Tree with a Root set to null

    public BST()

    {

        root = null;

    }

    

    // Methods

   

    // Print the Binary search Tree

    public void display()

    {

        System.out.print("( ");

        traverse(root);

        System.out.println(" )");

    }

    // A recursive function that traverses and prints out

    // the binary search tree with an inorder traversal.

    private void traverse(BSTNode node)

    {

        if (node == null)

            return;

        traverse(node.left);

        System.out.print(node.val + " ");

        traverse(node.right);

    }

    // ================

    // Implement These

    // ================

    // This method takes an integer parameter n and inserts it

    // as a node in a binary search tree.

    public void insert(int n)

    {

        root = insertRec(root, n);

    }

    private BSTNode insertRec(BSTNode root, int n) {
        if (root == null) {
            root = new BSTNode(n);
            return root;
        }
        if (n < root.val)
            root.left = insertRec(root.left, n);
        else if (n > root.val)
            root.right = insertRec(root.right, n);
        return root;

    }

    // This method searches the binary tree for an integer n

    // and if it exists deletes this node from the tree.

    public void delete(int n)

    {

        root = deleteRec(root, n);

        return;

    }

    private BSTNode deleteRec(BSTNode root, int n) {
        if (root == null)
            return root;
        if (n < root.val)
            root.left = deleteRec(root.left, n);
        else if (n > root.val)
            root.right = deleteRec(root.right, n);

        else {
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            root.val = minValue(root.right);
            root.right = deleteRec(root.right, root.val);
        }

        return root;
    }

    private int minValue(BSTNode root) {
        int minv = root.val;
        while (root.left != null) {
            minv = root.left.val;
            root = root.left;
        }
        return minv;
    }

    // This function returns true if the binary tree is a

    // complete binary tree, otherwise it returns false.

    public boolean isComplete()

    {

        if (root == null) {
            return false;
        }

        Queue<BSTNode> queue = new ArrayDeque<>();
        queue.add(root);

        BSTNode frontNode;
        boolean iscomplete = false;
        while (!queue.isEmpty()) {
            frontNode = queue.poll();
            if (iscomplete && (frontNode.left != null || frontNode.right != null))
                return false;
            if (frontNode.left == null && frontNode.right != null)
                return false;
            if (frontNode.left != null)
                queue.add(frontNode.left);
            else
                iscomplete = true;
            if (frontNode.right != null)
                queue.add(frontNode.right);
            else
                iscomplete = true;
        }

        return true;
    }

}