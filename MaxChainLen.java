package GreedyAlgorithms;

import java.util.Arrays;
import java.util.Comparator;

/**
 * This program finds the maximum length of a chain that can be formed from pairs.
 * 
 * Each pair has a start and end value. A chain can be formed if the start of the next pair 
 * is greater than the end of the current pair.
 * 
 * Steps:
 * 1. Sort the pairs based on their end values in ascending order.
 * 2. Initialize chain length and track the end of the first pair.
 * 3. Iterate over the sorted pairs:
 *    - If the start of the current pair is greater than the end of the last included pair,
 *      increase the chain length and update the chain end.
 * 4. Print the maximum chain length.
 * 
 * This greedy approach ensures the longest chain by always picking the pair which ends earliest.
 */

public class MaxChainLen {
    public static void main(String[] args) {
        int pair[][] = {{5, 24}, {39, 60}, {5, 28}, {27, 40}, {50, 90}};
        
        // Sort pairs by their second element (end value)
        Arrays.sort(pair, Comparator.comparingDouble(o -> o[1]));

        int chainLen = 1;              // Start with first pair in the chain
        int chainEnd = pair[0][1];    // End value of the first pair

        for (int i = 1; i < pair.length; i++) {
            if (pair[i][0] > chainEnd) {  // If start of current pair > end of last chain pair
                chainLen++;               // Increase chain length
                chainEnd = pair[i][1];   // Update chain end to current pair's end
            }
        }

        System.out.println("Maximum length of chain: " + chainLen);
    }
}
