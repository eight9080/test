package com.example.alg.arraypkg;

import com.sun.tools.javac.util.ArrayUtils;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.regex.Pattern;

import static org.junit.Assert.*;

public class KLargestElementTest {

    @Test
    public void findKthLargest() throws Exception {
        final int kthLargest = KLargestElement.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2);
        assertEquals(5, kthLargest);
    }

    @Test
    public void findKthLargestLong() throws Exception {

        Path path = Paths.get(Objects.requireNonNull(getClass().getClassLoader()
                .getResource("longArrayFindKthLargestArray.txt")).toURI());
        StringBuilder data = new StringBuilder();
        Files.lines(path).forEach(data::append);

        final String[] parts = Pattern.compile(",").split(data);
        final int[] integers = Arrays.stream(parts)
                .map(Integer::valueOf)
                .mapToInt(i-> i)
                .toArray();
        final int kthLargest = KLargestElement.findKthLargest(integers, 918);
        assertEquals(8221, kthLargest);
    }

    public static <T> T[] concat(T[] first, T[] second) {
        T[] result = Arrays.copyOf(first, first.length + second.length);
        System.arraycopy(second, 0, result, first.length, second.length);
        return result;
    }

    @Test
    public void findKthLargestQuickSort() throws Exception {
        final int kthLargest = KLargestElement.findKthLargestQuickSort(new int[]{3, 2, 1, 5, 6, 4}, 2);
        assertEquals(5, kthLargest);
    }

}