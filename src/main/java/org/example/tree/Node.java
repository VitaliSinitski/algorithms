package org.example.tree;

public class Node {
    int value;
    Node left;
    Node right;

    Node(int value) {
        this.value = value;
        left = null;
        right = null;
    }

    @Override
    public String toString() {
        return "Node{" +
               " value=" + value +
               '}';
    }
}
