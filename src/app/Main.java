package app;

import java.util.List;

import datastructures.bstree.BinarySearchTree;
import datastructures.bstree.TreeNode;

public class Main {
    //? ignore
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static void main(String[] args) {
        // make bst
        BinarySearchTree<Integer> bst = new BinarySearchTree<>(Integer::compareTo);
        TreeNode<Integer> root = null;

        int[] initial = {40, 25, 60, 20, 30, 50, 70};
        for (int v : initial) {
            root = bst.insert(root, v);
        }
        
        TreeNode<Integer> root2 = null;
        int[] initial2 = {32, 56, 7, 2, 4, 567, 1};
        for (int v : initial2) {
            root2 = bst.insert(root2, v);
        }

        int val = 25;
        int min = 20;
        int max = 50;
        TreeNode<Integer> merged = null;

        List<Integer> r = bst.searchRange(root, min, max);
        
        r = bst.searchRange(root, min, max);
        checks(bst, root, root2, val, r, min, max, merged);

        root = bst.delete(root, val);
        checks(bst, root, root2, val, r, min, max, merged);


        merged = bst.combineBSTs(root, root2);
        checks(bst, root, root2, val, r, min, max, merged);

    }

    public static void checks(BinarySearchTree bst, TreeNode root, TreeNode<Integer> root2, int val, List<Integer> r, int min, int max, TreeNode<Integer> merged) {
        System.out.print(ANSI_GREEN + "\nCHECKS:\n" + "----------------------------------" + ANSI_RESET + "\n"); // title

        System.out.print("InOrder merged\t: ");
        bst.inOrder(root);
        System.out.println("\nEnthält " + val + "?\t: " + bst.contains(root, val) );
        System.out.println("Größe\t\t: " + bst.size(root));
        System.out.println("Range " + min + " - " + max + "\t: " + r);
        System.out.println("Min\t\t: " + bst.Max_Min(root, true) + "\nMax\t\t: " + bst.Max_Min(root, false));
    }
}
