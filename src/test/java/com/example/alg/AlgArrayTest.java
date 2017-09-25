package com.example.alg;

import org.hamcrest.Matchers;
import org.junit.Test;

import java.util.HashSet;
import java.util.Map;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class AlgArrayTest {
    @Test
    public void findDuplicates() throws Exception {
        String[] names = { "Java", "JavaScript", "Python", "C", "Ruby", "Java" };

        final HashSet<String> duplicates = new AlgArray(names).findDuplicates();
        assertThat(duplicates, notNullValue());
        assertThat(duplicates, contains("Java"));
    }

    @Test
    public void findNoOfOccuranceOfDuplicates() throws Exception {
        String[] names = { "Java", "JavaScript", "Python", "C", "Ruby", "Java" };

        final Map<String, Integer> noOfOccuranceOfDuplicates = new AlgArray(names).findNoOfOccuranceOfDuplicates();
        assertThat(noOfOccuranceOfDuplicates, notNullValue());
        assertThat(noOfOccuranceOfDuplicates.size(), is(1));
        assertThat(noOfOccuranceOfDuplicates, hasKey("Java"));
        assertThat(noOfOccuranceOfDuplicates, hasValue(2));

    }
}