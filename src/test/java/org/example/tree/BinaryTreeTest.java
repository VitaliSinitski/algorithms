package org.example.tree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeTest {

    @Test
    void containsNode() {
        // given
        BinaryTree binaryTree = new BinaryTree();

        // when
        binaryTree.add(4);
        binaryTree.add(6);

        // then
        assertTrue(binaryTree.containsNode(4));
        assertTrue(binaryTree.containsNode(6));
        assertFalse(binaryTree.containsNode(2));
    }

    @Test
    void deleteNode() {
        // given
    }
}