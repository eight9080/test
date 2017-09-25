package com.example.alg;

import java.util.Arrays;
import java.util.function.BiPredicate;

public class BubbleSortArray {
    private  int[] array;

    /**
     * Simple constructor
     */
    public BubbleSortArray(int[] array) {
        this.array = array;
    }

    public int[] getArray() {
        return array;
    }

    public  void bubbleSortAsc(){
        bubbleSort((arrayToSort, position) -> arrayToSort[position-1]>arrayToSort[position]);
    }

    public  void bubbleSortDesc(){
        bubbleSort((arrayToSort, position) -> arrayToSort[position-1]<arrayToSort[position]);
    }

    private  void bubbleSort(BiPredicate<int[], Integer> condition){
        for (int i = 0; i < array.length; i++) {
            for (int j = 1; j < array.length; j++) {
                if(condition.test(array, j)){
                    swap(j);
                }
            }
            log("Iteration " + (i + 1) + ": " + Arrays.toString(array));
        }
    }

    private void swap(int j) {
        int temp = array[j-1];
        array[j-1] = array[j];
        array[j] = temp;
    }

    public void log(String string) {
        System.out.println(" ========= " + string + " ========= ");
        log();
    }

    /**
     * Let's display Array
     */
    public void log() {
        System.out.println("\n");
        for (int i = 0; i < array.length; i++)
            System.out.print(array[i] + " ");
        System.out.println("\n");
    }

}
