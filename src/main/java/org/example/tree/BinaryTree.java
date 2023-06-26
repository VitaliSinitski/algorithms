package org.example.tree;

public class BinaryTree {
    Node root;

    // ----------------------- add --------------------------
    // мы создадим общедоступный метод, который запускает рекурсию с корневого узла
    public void add(int value) {
        root = addRecursive(root, value);
    }

    // мы создадим рекурсивный метод для выполнения вставки
    private Node addRecursive(Node current, int value) {
        // если текущий узел равен null, то это означает, что дерево пустое, и новый узел будет становиться корневым узлом
        // или мы достигли конечного узла и можем вставить новый узел в эту позицию
        if (current == null) {
            return new Node(value);
        }

        // если значение нового узла меньше значения текущего узла, мы переходим к левому дочернему элементу и метод вызывается рекурсивно для левого поддерева
        if (value < current.value) {
            current.left = addRecursive(current.left, value);
            // если значение нового узла больше значения текущего узла, мы переходим к правому дочернему элементу и метод вызывается рекурсивно для правого поддерева
        } else if (value > current.value) {
            current.right = addRecursive(current.right, value);
            // или же значение уже существует и мы возвращаем его
        } else {
            return current;
        }
        return current;
    }

    // -------------------- contains --------------------------
    public boolean containsNode(int value) {
        return containsNodeRecursive(root, value);
    }

    // мы ищем значение, сравнивая его со значением в текущем узле; затем мы продолжим в левом или правом дочернем узле в зависимости от результата
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

    public void printTree() {
        printTreeRecursive(root);
    }

    // --------------------- delete ---------------------------
    private Node deleteRecursive (Node current, int value) {
        if (current == null) {
            return null;
        }

        if (value == current.value) {
            // Node to delete found
            // code to delete Node
        }

        if (value < current.value) {
            current.left = deleteRecursive(current.left, value);
                return current;
        }
        current.right = deleteRecursive(current.right, value);
        return current;
    }


    // использовать обход дерева симметричным (in-order) способом и выводить значения узлов на каждом шаге обхода.
    private void printTreeRecursive(Node root) {
        if (root != null) {
            printTreeRecursive(root.left);
            System.out.println(root.value + " ");
            printTreeRecursive(root.right);
        }
    }
}
