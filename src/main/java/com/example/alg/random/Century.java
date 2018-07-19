package com.example.alg.random;

public class Century {


    public static int century(int number) {
        // your code goes here
        int century = number / 100;
        if(number%100==0){
            return century;
        }

        return century +1;
    }

}
