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
        int val = 25;
        int min = 20;
        int max = 50;

        List<Integer> r = bst.searchRange(root, min, max);
        
        checks(bst, root, val, r, min, max);
        root = bst.delete(root, val);

        r = bst.searchRange(root, min, max);
        checks(bst, root, val, r, min, max);

        
        

    }

    public static void checks(BinarySearchTree bst, TreeNode root, int val, List<Integer> r, int min, int max) {
        System.out.print(ANSI_GREEN + "\nCHECKS:\n" + "----------------------------------" + ANSI_RESET + "\n"); // title

        System.out.print("InOrder\t\t: ");
        bst.inOrder(root);
        System.out.print("\nEnthält " + val + "?\t: " + bst.contains(root, val) + "\n");
        System.out.print("Größe\t\t: " + bst.size(root) + "\n");
        System.out.println("Range " + min + " - " + max + "\t: " + r + "\n");
        System.out.println("Min\t\t: " + bst.Max_Min(root, false) + "\nMax\t\t: " + bst.Max_Min(root, true));
        
    }
}
