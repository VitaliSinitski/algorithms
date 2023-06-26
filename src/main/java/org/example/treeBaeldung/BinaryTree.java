package org.example.treeBaeldung;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {

    Node root;

    public void add(int value) {
        root = addRecursive(root, value);
    }

    private Node addRecursive(Node current, int value) {

        if (current == null) {
            return new Node(value);
        }

        if (value < current.value) {
            current.left = addRecursive(current.left, value);
        } else if (value > current.value) {
            current.right = addRecursive(current.right, value);
        }

        return current;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public int getSize() {
        return getSizeRecursive(root);
    }

    private int getSizeRecursive(Node current) {
        return current == null ? 0 : getSizeRecursive(current.left) + 1 + getSizeRecursive(current.right);
    }

    public boolean containsNode(int value) {
        return containsNodeRecursive(root, value);
    }

    private boolean containsNodeRecursive(Node current, int value) {
        if (current == null) {
            return false;
        }

        if (value == current.value) {
            return true;
        }

        return value < current.value
                ? containsNodeRecursive(current.left, value)
                : containsNodeRecursive(current.right, value);
    }

    public void delete(int value) {
        root = deleteRecursive(root, value);
    }

    private Node deleteRecursive(Node current, int value) {
        if (current == null) {
            return null;
        }
        // Node to delete found
        if (value == current.value) {
            // Case 1: no children
            // у узла нет дочерних элементов (узел является конечным узлом) – это простейший случай;
            // нам просто нужно заменить этот узел на null в его родительском узле
            if (current.left == null && current.right == null) {
                return null;
            }

            // Case 2: only 1 child
            // у узла есть ровно один дочерний элемент:
            // в родительском узле мы заменяем этот узел его единственным дочерним элементом.
            if (current.right == null) {
                // мы возвращаем ненулевой дочерний элемент, чтобы его можно было назначить родительскому узлу
                return current.left;
            }

            if (current.left == null) {
                // мы возвращаем ненулевой дочерний элемент, чтобы его можно было назначить родительскому узлу
                return current.right;
            }

            // Case 3: 2 children
            // у узла есть два дочерних элемента – это самый сложный случай, поскольку он требует реорганизации дерева
            // сначала нам нужно найти узел, который заменит удаленный узел
            // затем мы присваиваем наименьшее значение удаляемому узлу, и после этого мы удалим его из правого поддерева
            int smallestValue = findSmallestValue(current.right);
            current.value = smallestValue;
            current.right = deleteRecursive(current.right, smallestValue);
            return current;
        }
        if (value < current.value) {
            current.left = deleteRecursive(current.left, value);
            return current;
        }

        current.right = deleteRecursive(current.right, value);
        return current;
    }

    // мы будем использовать наименьший узел правого поддерева узла, который вскоре будет удален
    private int findSmallestValue(Node root) {
        return root.left == null ? root.value : findSmallestValue(root.left);
    }

    public void traverseInOrder(Node node) {
        if (node != null) {
            traverseInOrder(node.left);
            visit(node.value);
            traverseInOrder(node.right);
        }
    }

    public void traversePreOrder(Node node) {
        if (node != null) {
            visit(node.value);
            traversePreOrder(node.left);
            traversePreOrder(node.right);
        }
    }

    public void traversePostOrder(Node node) {
        if (node != null) {
            traversePostOrder(node.left);
            traversePostOrder(node.right);
            visit(node.value);
        }
    }

    public void traverseLevelOrder() {
        if (root == null) {
            return;
        }

        Queue<Node> nodes = new LinkedList<>();
        nodes.add(root);

        while (!nodes.isEmpty()) {

            Node node = nodes.remove();

            System.out.print(" " + node.value);

            if (node.left != null) {
                nodes.add(node.left);
            }

            if (node.right != null) {
                nodes.add(node.right);
            }
        }
    }

    public void traverseInOrderWithoutRecursion() {
        Stack<Node> stack = new Stack<>();
        Node current = root;

        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            Node top = stack.pop();
            visit(top.value);
            current = top.right;
        }
    }

    public void traversePreOrderWithoutRecursion() {
        Stack<Node> stack = new Stack<>();
        Node current = root;
        stack.push(root);

        while (current != null && !stack.isEmpty()) {
            current = stack.pop();
            visit(current.value);

            if (current.right != null)
                stack.push(current.right);

            if (current.left != null)
                stack.push(current.left);
        }
    }

    public void traversePostOrderWithoutRecursion() {
        Stack<Node> stack = new Stack<>();
        Node prev = root;
        Node current = root;
        stack.push(root);

        while (current != null && !stack.isEmpty()) {
            current = stack.peek();
            boolean hasChild = (current.left != null || current.right != null);
            boolean isPrevLastChild = (prev == current.right || (prev == current.left && current.right == null));

            if (!hasChild || isPrevLastChild) {
                current = stack.pop();
                visit(current.value);
                prev = current;
            } else {
                if (current.right != null) {
                    stack.push(current.right);
                }
                if (current.left != null) {
                    stack.push(current.left);
                }
            }
        }
    }

    private void visit(int value) {
        System.out.print(" " + value);
    }

    class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
            right = null;
            left = null;
        }
    }
}
