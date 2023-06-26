package org.example.treeV1;

import lombok.AllArgsConstructor;
import org.example.queue.SimpleQueue;
import org.example.stack.SimpleStack;

@AllArgsConstructor
public class Tree {
    private int value;
    Tree left;
    Tree right;

    public Tree(int value) {
        this.value = value;
    }

    public static int sumRecursive(Tree root) {
        int result = root.value;
        if (root.left != null) {
            result += sumRecursive(root.left);
        }
        if (root.right != null) {
            result += sumRecursive(root.right);
        }
        return result;
    }

    // using Stack
    public static int sumDeep(Tree root) {
        SimpleStack<Tree> stack = new SimpleStack<>();
        stack.push(root);

        int result = 0;

        while (!stack.isEmpty()) {
            Tree node = stack.pop();

            System.out.println(node.value);

            result += node.value;

            if (node.right != null) {
                stack.push(node.right);
            }

            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return result;
    }

    // using Queue
    public static int sumWide(Tree root) {
        SimpleQueue<Tree> queue = new SimpleQueue<>();
        queue.add(root);

        int result = 0;

        while (!queue.isEmpty()) {
            Tree node = queue.remove();

            System.out.println(node.value);

            result += node.value;

            if (node.right != null) {
                queue.add(node.right);
            }

            if (node.left != null) {
                queue.add(node.left);
            }
        }
        return result;
    }
}
