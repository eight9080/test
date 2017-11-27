package com.example.alg.treepck.binary;

import com.example.alg.treepck.TreeNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class CodecTest {
    @Test
    public void serialize() throws Exception {

        final Codec c = new Codec();
        final String serialize = c.serialize(tree());
        assertEquals("1,2,3,null,null,4,5,null,null,null,null", serialize);
        final TreeNode treeNode = c.deserialize(serialize);
        assertEquals(tree(), treeNode);

    }

    private TreeNode tree(){
        TreeNode root = new TreeNode(1);
        TreeNode node11 = new TreeNode(2);
        TreeNode node12 = new TreeNode(3);
        root.left=node11;
        root.right=node12;
        TreeNode node21 = new TreeNode(4);
        TreeNode node22 = new TreeNode(5);
        node12.left=node21;
        node12.right=node22;

        return root;
    }

}