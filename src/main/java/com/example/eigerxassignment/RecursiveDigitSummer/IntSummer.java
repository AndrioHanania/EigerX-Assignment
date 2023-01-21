package com.example.eigerxassignment.RecursiveDigitSummer;

public class IntSummer {
    /**
     * input: positive integer number.
     * return: sum of all the digits in the number.
     * no use with String and loops.
     * */
    public int sumDigits(int num){
        if(num < 0)
            throw new IllegalArgumentException("only positive numbers");
        return sumDigitsHelper(num);
    }

    public int sumDigitsHelper(Integer num){
        if(num <= 9)
            return num;
        else
            return (num % 10) + sumDigitsHelper(num / 10);
    }
}