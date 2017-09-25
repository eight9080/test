package com.dg;

import com.example.alg.InsertionSortArray;
import com.example.alg.SelectionSortArray;
import org.junit.Assert;
import org.junit.Test;

public class SelectionSortAlgorithmTest {

    @Test
    public void sort(){
        // Let's start with arraySize 11
        int arraySize = 11;

        SelectionSortArray selectionSortArray;
        selectionSortArray = new SelectionSortArray(arraySize);

        selectionSortArray.insert(10);
        selectionSortArray.insert(17);
        selectionSortArray.insert(9);
        selectionSortArray.insert(1);
        selectionSortArray.insert(8);
        selectionSortArray.insert(3);
        selectionSortArray.insert(7);
        selectionSortArray.insert(5);
        selectionSortArray.insert(15);
        selectionSortArray.insert(2);
        selectionSortArray.insert(4);

        System.out.print("Here is our initial array: ");
        selectionSortArray.log();

        selectionSortArray.selectionSort();

        System.out.print("Here is our final array after insertion sort: ");
        selectionSortArray.log();

        Assert.assertArrayEquals(new int[]{ 1, 2, 3, 4, 5, 7, 8, 9, 10, 15, 17}, selectionSortArray.getArray());

    }
}
