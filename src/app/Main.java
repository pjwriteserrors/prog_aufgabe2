package app;

import datastructures.avltree.AVLTree;
import datastructures.bstree.TreeNode;

import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        AVLTree<Integer> tree = new AVLTree<Integer>(Comparator.naturalOrder());
        TreeNode<Integer> root = null;

        // Test: Insertion
        int[] values = {10, 20, 30, 5, 15, 25, 35};
        for (int val : values) {
            root = tree.insert(root, val);
        }
        System.out.println("Inserted values: " + Arrays.toString(values));
        System.out.println("Is AVL Tree? " + tree.isAVLtree(root));

        // Test: Deletion
        root = tree.delete(root, 20);
        System.out.println("Deleted 20");
        System.out.println("Is AVL Tree? " + tree.isAVLtree(root));

        // Test: Median
        Double median = tree.findMedian(root);
        System.out.println("Median: " + median);

        // Test: Average
        Double average = tree.findAVG(root);
        System.out.println("Average: " + average);

        // Test: Merge
        AVLTree<Integer> tree2 = new AVLTree<Integer>(Comparator.naturalOrder());
        TreeNode<Integer> root2 = null;
        for (int val : new int[]{40, 45, 50}) {
            root2 = tree2.insert(root2, val);
        }
        TreeNode<Integer> merged = tree.merge(root, root2);
        System.out.println("Merged trees");
        System.out.println("Is AVL Tree after merge? " + tree.isAVLtree(merged));

        // Test: Split
        TreeNode<Integer>[] split = tree.split(merged, 30);
        System.out.println("Split tree by 30");
        System.out.println("Left tree (values < 30) is AVL? " + tree.isAVLtree(split[0]));
        System.out.println("Right tree (values > 30) is AVL? " + tree.isAVLtree(split[1]));

        System.out.println("Left tree median: " + tree.findMedian(split[0]));
        System.out.println("Right tree median: " + tree.findMedian(split[1]));
    }
}
