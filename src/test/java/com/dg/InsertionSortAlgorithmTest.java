package com.dg;

import com.example.alg.InsertionSortArray;
import org.junit.Assert;
import org.junit.Test;

public class InsertionSortAlgorithmTest {

    @Test
    public void sort(){
        // Let's start with arraySize 11
        int arraySize = 11;

        InsertionSortArray insertionSort;
        insertionSort = new InsertionSortArray(arraySize);

        insertionSort.insert(10);
        insertionSort.insert(17);
        insertionSort.insert(-9);
        insertionSort.insert(1);
        insertionSort.insert(8);
        insertionSort.insert(33);
        insertionSort.insert(7);
        insertionSort.insert(35);
        insertionSort.insert(15);
        insertionSort.insert(21);
        insertionSort.insert(4);

        System.out.print("Here is our initial array: ");
        insertionSort.log();

        insertionSort.insertionSort();

        System.out.print("Here is our final array after insertion sort: ");
        insertionSort.log();

        Assert.assertArrayEquals(new int[]{ -9, 1, 4, 7, 8, 10, 15, 17, 21, 33, 35}, insertionSort.getArray());

    }
}
