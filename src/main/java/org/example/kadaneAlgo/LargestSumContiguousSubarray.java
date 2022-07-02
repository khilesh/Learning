package org.example.kadaneAlgo;

public class LargestSumContiguousSubarray {


    public static void main (String [] args){

        System.out.println ("Hello world");

        int inputArray[] = {-5, 4, 6, -3, 4, -1 };

        int outputSum = 0 ;

        //finding largest Sum of contiguous array

        for (int i = 0; i< inputArray.length; i++){

            outputSum = inputArray[i] + outputSum ;
            System.out.println ("Hello world" + outputSum);
        }
       // System.out.println ("Hello world" + outputSum);
    }
}
