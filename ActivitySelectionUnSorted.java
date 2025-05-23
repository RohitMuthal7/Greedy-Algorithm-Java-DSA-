// ======================================================================
//  ACTIVITY SELECTION PROBLEM - Unsorted End Times (Greedy Algorithm)
// ======================================================================
//  Problem: Select the maximum number of non-overlapping activities
//  Input: start[] and end[] arrays (NOT sorted by end time)
//  Goal: Sort activities by end time and select maximum non-overlapping
//  Strategy: Use a greedy approach after sorting by end time
// ======================================================================

package GreedyAlgorithms;

import java.util.*;

public class ActivitySelectionUnSorted {

    public static void main(String[] args) {
        int start[] = {1, 3, 0, 5, 8, 5};
        int end[]   = {4, 5, 6, 9, 9, 7};

        // STEP 1: Create a 2D array to store {index, start, end} for each activity
        int activities[][] = new int[start.length][3];
        for (int i = 0; i < start.length; i++) {
            activities[i][0] = i;       // activity index
            activities[i][1] = start[i]; // start time
            activities[i][2] = end[i];   // end time
        }

        // STEP 2: Sort activities by end time using lambda expression
        Arrays.sort(activities, Comparator.comparingInt(o -> o[2]));

        // STEP 3: Greedy Selection of Non-Overlapping Activities
        ArrayList<Integer> ans = new ArrayList<>();
        int maxAct = 1;

        // Select the first activity by default
        ans.add(activities[0][0]);
        int lastEnd = activities[0][2];

        // Traverse remaining activities
        for (int i = 1; i < activities.length; i++) {
            // If the start time is after or equal to the last selected activity's end time
            if (activities[i][1] >= lastEnd) {
                maxAct++;
                ans.add(activities[i][0]);
                lastEnd = activities[i][2];
            }
        }

        // STEP 4: Output the result
        System.out.println("Maximum Activities: " + maxAct);
        System.out.print("Selected Activities: ");
        for (int i = 0; i < ans.size(); i++) {
            System.out.print("A" + ans.get(i) + " ");
        }
    }
}
