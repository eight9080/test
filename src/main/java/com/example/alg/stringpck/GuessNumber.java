package com.example.alg.stringpck;

/**
 * We are playing the Guess Game. The game is as follows:
 * <p>
 * I pick a number from 1 to n. You have to guess which number I picked.
 * <p>
 * Every time you guess wrong, I'll tell you whether the number is higher or lower.
 * <p>
 * You call a pre-defined API guess(int num) which returns 3 possible results (-1, 1, or 0):
 * <p>
 * -1 : My number is lower
 * 1 : My number is higher
 * 0 : Congrats! You got it!
 * Example:
 * n = 10, I pick 6.
 * <p>
 * Return 6.
 */
public class GuessNumber {

    private int numberPicked;

    public GuessNumber(int numberPicked) {
        this.numberPicked = numberPicked;
    }

    public int guessNumber(int n) {
        int low = 1;
        int high = n;

        while (low<=high){
            int mid = low +(high-low)/2;
            int result = guess(mid);
            if(result==0){
                return mid;
            }
            if(result==-1){
                high = mid-1;
            }else {
                low=mid+1;
            }
        }
        return -1;
    }


    private int guess(int tryNumber) {
        if (tryNumber == numberPicked) {
            return 0;
        }
        return tryNumber > numberPicked ? -1 : 1;
    }

}
