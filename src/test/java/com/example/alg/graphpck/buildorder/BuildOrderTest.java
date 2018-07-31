package com.example.alg.graphpck.buildorder;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class BuildOrderTest {

    @Test
    public void findBuildOrder() {
        final BuildOrder b = new BuildOrder();
        final Project[] buildOrder = b.findBuildOrder(new String[]{"a", "b", "c", "d", "e", "f"},
                new String[][]{
                        {"a", "d"},
                        {"f", "b"},
                        {"b", "d"},
                        {"f", "a"},
                        {"d", "c"}
                }
        );

        final String resultOrder = Arrays.stream(buildOrder)
                .map(Project::getName)
                .collect(Collectors.joining());

        final List<String> posibleResults = Arrays.asList("feabdc", "efabdc", "efbadc");

        assertTrue(posibleResults.stream().anyMatch(s -> s.equals(resultOrder)));

   }
}