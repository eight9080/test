package com.example.alg.treepck.binarysearch;

import com.example.alg.treepck.TreeNode;
import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

public class ListDepthsTest {

    @Test
    public void createLevelList() {

        final TreeNode t1 = new TreeNode(1);
        final TreeNode t2 = new TreeNode(2);
        t1.right = t2;

        final TreeNode t4 = new TreeNode(4);
        final TreeNode t5 = new TreeNode(5);
        t4.right = t5;

        final TreeNode t3 = new TreeNode(3);
        t3.left = t1;
        t3.right = t4;

        final ListDepths l = new ListDepths();
        final List<List<TreeNode>> levelList = l.createLevelList(t3);

        assertThat(levelList)
                .containsExactlyInAnyOrder(
                        singletonList(t3),
                        asList(t1, t4),
                        asList(t2, t5)
                );


    }
}