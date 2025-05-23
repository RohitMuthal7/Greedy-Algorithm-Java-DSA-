package GreedyAlgorithms;

import java.util.*;

/**
 * This program solves the Fractional Knapsack problem using a greedy approach.
 * 
 * Steps:
 * 1. Calculate the value-to-weight ratio for each item.
 * 2. Sort the items based on the ratio in ascending order.
 * 3. Start picking items from the highest ratio to maximize the total value:
 *    - If the whole item fits into the knapsack, add its full value.
 *    - Otherwise, add the fractional value proportional to the remaining capacity.
 * 4. Print the maximum total value that can be carried.
 * 
 * This ensures an optimal solution to the fractional knapsack problem.
 */

public class FractionalKnapsnack {

    public static void main(String[] args) {
        int val[] = {60, 100, 120};
        int weight[] = {10, 20, 30};
        int W = 50;

        // Array to store item index and its value-to-weight ratio
        double ratio[][] = new double[val.length][2];
        for (int i = 0; i < val.length; i++) {
            ratio[i][0] = i;  // Item index
            ratio[i][1] = val[i] / (double) weight[i];  // Value-to-weight ratio
        }

        // Sort items by their ratio in ascending order
        Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));

        int capacity = W;
        double finalVal = 0;

        // Start picking items from the highest ratio to maximize value
        for (int i = ratio.length - 1; i >= 0; i--) {
            int idx = (int) ratio[i][0];

            if (capacity >= weight[idx]) {
                // Take whole item
                finalVal += val[idx];
                capacity -= weight[idx];
            } else {
                // Take fraction of the item to fill remaining capacity
                finalVal += ratio[i][1] * capacity;
                capacity = 0;
                break;
            }
        }

        System.out.println("Maximum value in Knapsack = " + finalVal);
    }
}
