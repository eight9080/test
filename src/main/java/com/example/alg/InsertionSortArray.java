package com.example.alg;

public class InsertionSortArray {
    private  int[] array;
    private  int index; // Default index is 0

    /**
     * Simple constructor
     */
    public InsertionSortArray(int arraySize) {
        array = new int[arraySize];
        index = 0;
    }

    public void insert(int value){
        array[index++]=value;
    }

    public int[] getArray() {
        return array;
    }

    public  void insertionSort(){
        int tmpObj, index1, index2;

        // Counter to print iteration
        int counter = 1;

        for(index2 = 1; index2< array.length; index2++){
            index1 = index2-1;
            tmpObj = array[index2];
            while (index1>=0 && tmpObj<array[index1]){
                array[index1+1]=array[index1];
                index1--;
                log("Iteration " + counter);
            }
            array[index1 + 1] = tmpObj;
            // Let's print array after each iteration
            log("Iteration " + counter);
            counter++;
        }
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
        for (int i = 0; i < index; i++)
            System.out.print(array[i] + " ");
        System.out.println("\n");
    }

}
