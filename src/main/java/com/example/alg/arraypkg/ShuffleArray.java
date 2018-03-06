package com.example.alg.arraypkg;

public class ShuffleArray {
    /**
     * If [a1,a2,a3...,an,b1,b2...bn] is given input change this to [a1,b1,a2,b2.....an,bn] , solution should be in-place
     */
    static void shufleArray(int a[]){

        if(a==null || a.length==0){
            return;
        }

        shufleArray(a, 0, a.length-1);

    }

    static void shufleArray(int a[], int f, int l){

        if(l-f==1 || f<0 || l>=a.length){
            return;
        }

        //dividing point
        int middle = (f+l)/2;

        int temp = middle+1;

        int startingSubarrary = (f+middle)/2;

        for (int i = startingSubarrary+1; i <=middle; i++) {
            int aux = a[i];
            a[i]=a[temp];
            a[temp]=aux;
            temp++;
        }

        shufleArray(a, f, middle);
        shufleArray(a, middle+1, l);

    }
}
