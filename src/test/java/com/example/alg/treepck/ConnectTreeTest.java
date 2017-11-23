package com.example.alg.treepck;

import org.junit.Test;

import static org.junit.Assert.*;

public class ConnectTreeTest {
    @Test
    public void connect() throws Exception {
        final ConnectTree c = new ConnectTree();
        final TreeLinkNode tree = tree();
        c.connect(tree);

        assertEquals(expectTree(), tree);

    }

    private TreeLinkNode tree(){
        TreeLinkNode root = new TreeLinkNode(1);
        TreeLinkNode node11 = new TreeLinkNode(2);
        TreeLinkNode node12 = new TreeLinkNode(3);
        root.left=node11;
        root.right=node12;
        TreeLinkNode node21 = new TreeLinkNode(4);
        TreeLinkNode node22 = new TreeLinkNode(5);
        node11.left=node21;
        node11.right=node22;

        TreeLinkNode node31 = new TreeLinkNode(6);
        TreeLinkNode node32 = new TreeLinkNode(7);
        node12.left=node31;
        node12.right=node32;

        return root;
    }

    private TreeLinkNode expectTree(){
        TreeLinkNode root = new TreeLinkNode(1);
        TreeLinkNode node11 = new TreeLinkNode(2);
        TreeLinkNode node12 = new TreeLinkNode(3);
        root.left=node11;
        root.right=node12;
        node11.next=node12;
        TreeLinkNode node21 = new TreeLinkNode(4);
        TreeLinkNode node22 = new TreeLinkNode(5);
        node11.left=node21;
        node11.right=node22;
        node21.next=node22;

        TreeLinkNode node31 = new TreeLinkNode(6);
        TreeLinkNode node32 = new TreeLinkNode(7);
        node12.left=node31;
        node12.right=node32;
        node22.next=node31;
        node31.next=node32;

        return root;
    }

}