package com.example.alg.dfs;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.*;

public class SequencesTest {

    @Test
    public void findSubsequences() {

        final Sequences s = new Sequences();
        final List<List<Integer>> subsequences = s.findSubsequences(new int[]{4, 6, 7, 7});

        Assertions.assertThat(subsequences)
                .hasSize(8)
                .contains(asList(4, 6),
                        asList(4, 7),
                        asList(4, 6, 7),
                        asList(4, 6, 7, 7),
                        asList(6, 7),
                        asList(6, 7, 7),
                        asList(7, 7),
                        asList(4, 7, 7));

    }
}