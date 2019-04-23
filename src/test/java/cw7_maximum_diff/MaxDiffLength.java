package cw7_maximum_diff;

import java.util.Arrays;

public class MaxDiffLength {
    /**
     You are given two arrays a1 and a2 of strings. Each string is composed with letters from a to z. Let x be any string in the first array and y be any string in the second array.
     Find max(abs(length(x) − length(y)))
     If a1 and/or a2 are empty return -1 in each language except in Haskell (F#) where you will return Nothing (None).
     #Example:
     a1 = ["hoqq", "bbllkw", "oox", "ejjuyyy", "plmiis", "xxxzgpsssa", "xxwwkktt", "znnnnfqknaz", "qqquuhii", "dvvvwz"]
     a2 = ["cccooommaaqqoxii", "gggqaffhhh", "tttoowwwmmww"]
     mxdiflg(a1, a2) --> 13
     */

    private static int findMaxMin(String[]arr, boolean ifMax){
        if (arr.length ==0) return -1;
        int result = arr[0].length();
        for (int i = 1; i < arr.length; i ++){
            if ((ifMax && (arr[i].length() > result))
                    || (!ifMax && (arr[i].length() < result)))
                result = arr[i].length();
        }
        return result;
    }

    public static int mxdiflg(String[]arrOne, String[]arrTwo){
        //alghorithm - find smallest and the biggest, -1 if one of them are empty
        if ((arrOne.length == 0)||(arrTwo.length == 0)) return -1;
        int optionOne = findMaxMin(arrOne, true) - findMaxMin(arrTwo, false);
        int optionTwo = findMaxMin(arrTwo, true) - findMaxMin(arrOne, false);
        return optionOne > optionTwo ? optionOne : optionTwo;
    }

    public static void main(String[] args) {
        String[]a1 = {"hoqq", "bbllkw", "oox", "ejjuyyy", "plmiis", "xxxzgpsssa", "xxwwkktt", "znnnnfqknaz", "qqquuhii", "dvvvwz"};
        String[]a2 = {"cccooommaaqqoxii", "gggqaffhhh", "tttoowwwmmww"};
    }
}
