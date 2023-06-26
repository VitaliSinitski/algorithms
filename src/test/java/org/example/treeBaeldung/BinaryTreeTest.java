package org.example.treeBaeldung;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeTest {

    @Test
    void containsNode() {
        // given
        BinaryTree binaryTree = new BinaryTree();

        // when
        binaryTree.add(6);
        binaryTree.add(8);
        binaryTree.add(10);

        // then
        assertTrue(binaryTree.containsNode(8));
        assertTrue(binaryTree.containsNode(10));
        assertFalse(binaryTree.containsNode(2));
    }

    @Test
    void delete() {
        // given
        BinaryTree binaryTree = new BinaryTree();

        // when
        binaryTree.add(6);
        binaryTree.add(8);
        binaryTree.add(10);

        assertTrue(binaryTree.containsNode(8));
        binaryTree.delete(8);
        assertFalse(binaryTree.containsNode(8));
    }
}