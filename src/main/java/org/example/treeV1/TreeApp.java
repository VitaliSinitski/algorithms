package org.example.treeV1;

public class TreeApp {
    public static void main(String[] args) {
        Tree root = new Tree(20,
                new Tree(7,
                        new Tree(4,
                                null,
                                new Tree(
                                        6)),
                        new Tree(9)),
                new Tree(35,
                        new Tree(31,
                                new Tree(28),
                                null),
                        new Tree(40,
                                new Tree(38),
                                new Tree(52))
                ));

//        int sum = Tree.sumRecursive(root);
//        int sum = Tree.sumDeep(root);
        int sum = Tree.sumWide(root);

        System.out.println("Tree sum is: " + sum);
    }
}
