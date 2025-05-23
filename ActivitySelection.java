// ===============================================================
//  ACTIVITY SELECTION PROBLEM (Greedy Algorithm)
// ==============================================================
// Goal: Select the maximum number of activities that can be 
//    performed by a single person (no overlapping)
// Constraint: A person can do only one activity at a time
//  Greedy Strategy: Always choose the activity that finishes earliest
//  Note: The 'end' array is already sorted in ascending order
// ===============================================================

package GreedyAlgorithms;

import java.util.ArrayList;

public class ActivitySelection {

    public static void main(String[] args) {
        // Start and End times of activities (Already Sorted by end time)
        int start[] = {1, 3, 0, 5, 8, 5};
        int end[]   = {2, 4, 6, 7, 9, 9};

        // To store selected activity indices
        ArrayList<Integer> ans = new ArrayList<>();

        // We select the first activity by default (A0)
        int maxAct = 1;
        ans.add(0);

        // Store the end time of the last selected activity
        int lastEnd = end[0];

        // Loop through the remaining activities
        for (int i = 1; i < end.length; i++) {
            // If the current activity starts after or at the end of the last selected one
            if (start[i] >= lastEnd) {
                maxAct++;              // Increment activity count
                ans.add(i);            // Store the index
                lastEnd = end[i];      // Update last end time
            }
        }

        // Output the results
        System.out.println("Maximum Activities: " + maxAct);
        System.out.print("Selected Activities: ");
        for (int i = 0; i < ans.size(); i++) {
            System.out.print("A" + ans.get(i) + " ");
        }
    }
}
