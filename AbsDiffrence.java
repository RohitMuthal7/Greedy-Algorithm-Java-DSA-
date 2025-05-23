package GreedyAlgorithms;

import java.util.Arrays;

/**
 * This program calculates the minimum sum of absolute differences 
 * between corresponding elements of two integer arrays.
 * 
 * Steps:
 * 1. Sort both arrays to align elements in ascending order.
 * 2. Calculate the sum of absolute differences between each pair of elements.
 * 3. Print the minimum absolute difference sum.
 * 
 * This approach ensures the minimal total absolute difference using a greedy method.
 */

public class AbsDiffrence {
    public static void main(String[] args) {
        int A[] = {1, 2, 3};
        int B[] = {2, 3, 1};

        Arrays.sort(A);
        Arrays.sort(B);
        
        int Min_Diff = 0;

        for(int i = 0; i < A.length; i++){
            Min_Diff += Math.abs(A[i] - B[i]);
        }
        System.out.println("The Minimum Absolute Diffrence is : " + Min_Diff);
    }
}
