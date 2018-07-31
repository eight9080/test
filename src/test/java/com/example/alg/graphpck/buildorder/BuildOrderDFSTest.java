package com.example.alg.graphpck.buildorder;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class BuildOrderDFSTest {

    @Test
    public void findBuildOrder() {

        final BuildOrderDFS b = new BuildOrderDFS();
        final List<Project> buildOrder = b.findBuildOrder(new String[]{"a", "b", "c", "d", "e", "f"},
                new String[][]{
                        {"a", "d"},
                        {"f", "b"},
                        {"b", "d"},
                        {"f", "a"},
                        {"d", "c"}
                }
        );

        final String resultOrder = buildOrder.stream()
                .map(Project::getName)
                .collect(Collectors.joining());

        final List<String> posibleResults = Arrays.asList("feabdc", "efabdc",
                "efbadc", "febadc");
        assertTrue(posibleResults.stream().anyMatch(s -> s.equals(resultOrder)));

    }
}