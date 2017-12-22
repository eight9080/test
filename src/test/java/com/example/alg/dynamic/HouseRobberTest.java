package com.example.alg.dynamic;

import com.example.alg.treepck.TreeNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class HouseRobberTest {
    @Test
    public void rob3() throws Exception {
        final HouseRobber h = new HouseRobber();
        assertEquals(7, h.rob3(tree()));
    }

    private TreeNode tree(){
        TreeNode root = new TreeNode(3);
        TreeNode node11 = new TreeNode(2);
        TreeNode node12 = new TreeNode(3);
        root.left=node11;
        root.right=node12;
        TreeNode node21 = new TreeNode(3);
        node11.left=node21;

        TreeNode node31 = new TreeNode(1);
        node12.left=node31;

        return root;
    }

    @Test
    public void rob2() throws Exception {
        final HouseRobber h = new HouseRobber();
        assertEquals(3, h.rob2(new int[]{2,1,1,2}));

    }

    @Test
    public void robDP() throws Exception {
        final HouseRobber h = new HouseRobber();
        assertEquals(4, h.robDP(new int[]{2,1,1,2}));
        assertEquals(70, h.robDP(new int[]{10,20,4,50,30}));

    }

    @Test
    public void rob() throws Exception {

        final HouseRobber h = new HouseRobber();
        assertEquals(4, h.rob(new int[]{2,1,1,2}));
        assertEquals(70, h.rob(new int[]{10,20,4,50,30}));

    }

}