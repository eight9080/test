package com.example.alg.mathpck;

public class AddDigits {
    /**
     * Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.

     For example:

     Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.
     */
    public int addDigits(int num) {

        if(num<10)
            return num;

        int sum = getSum(num);

        while (sum>9){
            sum = getSum(sum);
        }

        return sum;
    }

    private int getSum(int num) {
        int sum = 0;
        int n = num;
        while (n>0){
            final int digit = n % 10;
            sum+=digit;
            n=n/10;
        }
        return sum;
    }
}
