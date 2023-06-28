package org.example.treeBaeldung;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ThreadLocalRandom;

public class BinaryTree {

    Node root;

    // --------------------- fill tree -----------------------
    public void fillRandomTree(BinaryTree tree) {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        for (int i = 0; i < 10; i++) {
            tree.add(random.nextInt(10));
        }
    }

    public void fillInOrderTreeToTen(BinaryTree tree) {
        for (int i = 1; i <= 10; i++) {
            tree.add(i);
        }
    }

    // --------------------- add ----------------------
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

    // ---------------------- isEmpty ------------------------
    public boolean isEmpty() {
        return root == null;
    }

    // ----------------------- getSize ------------------------
    public int getSize() {
        return getSizeRecursive(root);
    }

    private int getSizeRecursive(Node current) {
        return current == null ? 0 : getSizeRecursive(current.left) + 1 + getSizeRecursive(current.right);
    }

    // ------------------------ minimum --------------------------
    // Возвращает узел с минимальным ключом
    public Node minimum() {
        Node current;
        Node last = null;
        current = root;     // Обход начинается с корневого узла
        while (current != null) {   // и продолжается до низа
            last = current;     // Сохранение узла
            current = current.left;     // Переход к левому потомку
        }
        return last;
        // минимальное значение пригодится при удалении узла
    }

    // ------------------------ maximum --------------------------
    // Возвращает узел с максимальным ключом
    public Node maximum() {
        Node current;
        Node last = null;
        current = root;     // Обход начинается с корневого узла
        while (current != null) {   // и продолжается до низа
            last = current;     // Сохранение узла
            current = current.right;     // Переход к правому потомку
        }
        return last;
    }

    // ------------------------ contains -------------------------
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

    // -------------------- delete -----------------------
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

    // ------------------- traverse with recursion ----------------------
    // Поиск в глубину (DFS)
    // Поиск в глубину представляет собой способ обхода бинарного дерева, который спускается вглубь каждой ветви, прежде чем переходить к следующей


    // ------------------- Симметричный обход ---------------------------
    // Симметричный обход (инфиксный обход) (In-order traversal) - или обход по порядку (слева направо)
    // сначала посещается левое поддерево, затем текущий узел, а затем правое поддерево
    // В результате элементы дерева выводятся в отсортированном порядке (для бинарного дерева поиска).

    // Также это подход называется инфиксной обход, который обычно используемой в алгебре.
    // При обходе дерева в симметричном порядке генерируется правильная инфиксная запись

    // При вызове рекурсивного метода для обхода всего дерева в аргументе передается узел.
    // В исходном состоянии этим узлом является корень дерева.
    public void traverseInOrder(Node node) { // вывод в консоль: 3 4 5 6 7 8 9
        if (node != null) {
            // вызов самого себя для обхода левого поддерева узла
            traverseInOrder(node.left);
            //  посещение узла (подразумевает выполнение некоторой операции: вывод данных, запись в файл и т. д.)
            visit(node.value);
            // вызов самого себя для обхода правого поддерева узла
            traverseInOrder(node.right);
            // Далее метод действует самостоятельно, рекурсивно вызывая самого себя до тех пор, пока не останется узлов для обхода.
        }
    }

    // -------------------- Прямой обход ---------------------------
    // Прямой обход (Префиксный обход) (Pre-order traversal) - сверху вниз
    // сначала посещается текущий узел, затем левое поддерево, а затем правое поддерево
    public void traversePreOrder(Node node) { // вывод в консоль: 6 4 3 5 8 7 9
        if (node != null) {
            //  посещение узла (подразумевает выполнение некоторой операции: вывод данных, запись в файл и т. д.)
            visit(node.value);
            // вызов самого себя для обхода левого поддерева узла
            traversePreOrder(node.left);
            // вызов самого себя для обхода правого поддерева узла
            traversePreOrder(node.right);
        }
    }

    // Обратный обход (Постфиксный обход) (Post-order traversal) - снизу вверх
    // сначала посещается левое поддерево, затем правое поддерево, а затем текущий узел
    public void traversePostOrder(Node node) { // вывод в консоль: 3 5 4 7 9 8 6
        if (node != null) {
            // вызов самого себя для обхода левого поддерева узла
            traversePostOrder(node.left);
            // вызов самого себя для обхода правого поддерева узла
            traversePostOrder(node.right);
            //  посещение узла (подразумевает выполнение некоторой операции: вывод данных, запись в файл и т. д.)
            visit(node.value);
        }
    }


    // ------------------ traverse without recursion ------------------------

    // Поперечный обход (симметричный) (In-order traversal) - или обход по порядку (слева направо)
    // сначала посещается левое поддерево, затем текущий узел, а затем правое поддерево
    // В результате элементы дерева выводятся в отсортированном порядке (для бинарного дерева поиска).
    public void traverseInOrderWithoutRecursion() {  // вывод в консоль: 3 4 5 6 7 8 9
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

    // Прямой обход (Pre-order traversal) - сверху вниз
    // сначала посещается текущий узел, затем левое поддерево, а затем правое поддерево
    public void traversePreOrderWithoutRecursion() { // вывод в консоль: 6 4 3 5 8 7 9
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

    // Обратный обход (Post-order traversal) - снизу вверх
    // сначала посещается левое поддерево, затем правое поддерево, а затем текущий узел
    public void traversePostOrderWithoutRecursion() { // вывод в консоль: 3 5 4 7 9 8 6
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

    // ------------------- breadth-first search ----------------------
    // поиск в ширину (BFS - Breadth-First Search)
    public void breadthFirstTraversal(Node root) {
        if (root == null)
            return;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);      // Добавляем корневой узел в очередь

        while (!queue.isEmpty()) {
            Node current = queue.poll();    // Извлекаем узел из очереди
            System.out.print(current.value + " ");      // Посещение текущего узла

            // Добавляем потомков текущего узла в очередь
            if (current.left != null)
                queue.offer(current.left);
            if (current.right != null)
                queue.offer(current.right);
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

    // --------------------- to console ------------------------
    private void visit(int value) {
        System.out.print(" " + value);
    }

    // --------------------- class Node -------------------------
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
