package org.example.treeBaeldung;

import org.w3c.dom.ls.LSOutput;

public class App {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.fillRandomTree(tree);
//        tree.fillInOrderTreeToTen(tree);
        System.out.println("Is empty: " + tree.isEmpty());
        System.out.println("Size is:" + tree.getSize());
        System.out.println("Root: " + tree.root.value);
//        tree.traverseInOrderWithoutRecursion();
        System.out.print("Traverse in order: ");
        tree.traverseInOrder(tree.root);

        System.out.println();

        System.out.print("Travers pre order: ");
        tree.traversePreOrder(tree.root);

        System.out.println();

        System.out.print("Travers post order: ");
        tree.traversePostOrder(tree.root);

        System.out.println();

        System.out.print("Breadth first search: ");
        tree.breadthFirstTraversal(tree.root);

        System.out.println();

        System.out.println("Minimum value is: " + tree.minimum().value);
        System.out.println("Maximum value is: " + tree.maximum().value);
    }
}
