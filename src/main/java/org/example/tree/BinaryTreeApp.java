package org.example.tree;

public class BinaryTreeApp {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.add(20);
        binaryTree.add(10);
        binaryTree.add(5);
        binaryTree.add(4);
        binaryTree.add(45);
        binaryTree.add(40);
        binaryTree.add(2);
        boolean binaryResult = binaryTree.containsNode(2);
        System.out.println(binaryResult);
    }
}
