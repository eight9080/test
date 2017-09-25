package com.example.alg;

import java.util.Arrays;
import java.util.stream.Stream;

public class SelectionSortArray {

    private int[] array;
    private int lengthArray; // Default lengthArray is 0

    /**
     * Simple constructor
     */
    public SelectionSortArray(int arraySize) {
        array = new int[arraySize];
        lengthArray = 0;
    }

    /**
     * Insert an Array
     */
    public void insert(int crunchifyValue) {
        array[lengthArray++] = crunchifyValue;
    }

    /**
     * Simple way to swap array in Java
     */
    private void swap(int position1, int position2) {
        int tmp = array[position1];
        array[position1] = array[position2];
        array[position2] = tmp;
    }

    public int[] getArray() {
        return array;
    }

    /**
     * Acutal Selection Sort Logic goes here...
     */
    public void selectionSort() {
        int  minIndex;
        // Counter to print iteration
        int counter = 1;

        for (int outerIndex = 0; outerIndex < lengthArray-1; outerIndex++) {
              minIndex = outerIndex;
            for (int innerIndex = outerIndex; innerIndex < lengthArray; innerIndex++) {
                if(array[innerIndex]<array[minIndex]){
                    minIndex = innerIndex;
                }
            }
            swap(outerIndex, minIndex);
            // Let's print array after each iteration
            log("Iteration " + counter);
            counter++;
        }

    }

    private void log(String string) {
        System.out.println(" ========= " + string + " ========= ");
        log();
    }

    /**
     * Let's display Array
     */
    public void log() {
        Arrays.stream(array).forEach(elem -> System.out.print(elem + " "));
//        for (int i = 0; i < lengthArray; i++)
//            System.out.print(array[i] + " ");
        System.out.println("\n");
    }

}
