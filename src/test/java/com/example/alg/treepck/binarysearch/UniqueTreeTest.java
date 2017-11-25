package com.example.alg.treepck.binarysearch;

import com.example.alg.treepck.TreeNode;
import com.example.alg.treepck.traversal.Preorder;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class UniqueTreeTest {

    final UniqueTree u = new UniqueTree();

    @Test
    public void generateTrees() throws Exception {
        final List<TreeNode> trees = u.generateTrees(3);

        final List<String> treesStr = trees.stream().map(t -> Preorder.print(t)).collect(Collectors.toList());

        final List<String> expect = Arrays.asList("[1, 2, 3]", "[1, 3, 2]",
                "[2, 1, 3]", "[3, 1, 2]", "[3, 2, 1]"  );

        assertEquals(expect, treesStr);

    }

    @Test
    public void numTrees() throws Exception {

        final int numTrees = u.numTrees(3);
        assertEquals(5, numTrees);

    }

}