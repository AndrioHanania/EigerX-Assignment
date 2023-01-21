package com.example.eigerxassignment.RecursiveNumericSequencer;

import java.util.Scanner;

public class MaxCountSeq
{
    private Scanner scanner;

    public void printMaxCountSeq()
    {
        //initialize here because the test
        scanner = new Scanner(System.in);
        int max, countMax = 1;
        max = scanner.nextInt();
        if(max == 0)
            System.out.println("(0;0)");
        else
            printMaxCountSeqHelper(max, countMax);
    }

    private void printMaxCountSeqHelper(int max, int countMax)
    {
        int num = scanner.nextInt();
        if(num == 0)
            System.out.print(String.format("(%s;%s)", max, countMax));
        else if (num > max)
            printMaxCountSeqHelper(num, 1);
        else if (num == max)
            printMaxCountSeqHelper(max, countMax + 1);
        else
            printMaxCountSeqHelper(max, countMax);
    }
}
