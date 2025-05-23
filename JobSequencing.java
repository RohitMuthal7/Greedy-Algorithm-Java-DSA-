/**
 * Job Sequencing Problem (Greedy Algorithm)
 * -----------------------------------------
 * Goal: Maximize profit by scheduling jobs before their deadlines.
 *
 * Approach:
 * 1. Each job has a deadline and a profit.
 * 2. Sort jobs in descending order of profit.
 * 3. Try to schedule each job if it can be done before its deadline.
 * 4. Track the number of jobs scheduled to get max profit.
 */

package GreedyAlgorithms;

import java.util.ArrayList;
import java.util.Collections;

public class JobSequencing {

    // Class to represent a job with deadline, profit and ID
    static class Job {
        int deadLine; // Latest time by which job should be done
        int profit;   // Profit earned by completing this job
        int Id;       // Job ID or index

        // Constructor to initialize job details
        Job(int i, int d, int p) {
            Id = i;
            profit = p;
            deadLine = d;
        }
    }

    public static void main(String[] args) {
        // Each job is represented as {deadline, profit}
        int jobInfo[][] = {{4, 20}, {1, 10}, {1, 40}, {1, 30}};

        // Convert jobInfo array to list of Job objects
        ArrayList<Job> jobs = new ArrayList<>();
        for (int i = 0; i < jobInfo.length; i++) {
            jobs.add(new Job(i, jobInfo[i][0], jobInfo[i][1]));
        }

        // Sort jobs in descending order of profit (greedy choice)
        Collections.sort(jobs, (obj1, obj2) -> obj2.profit - obj1.profit);

        ArrayList<Integer> seq = new ArrayList<>(); // Stores IDs of selected jobs
        int time = 0; // Time slots filled so far

        // Try to schedule jobs greedily
        for (int i = 0; i < jobs.size(); i++) {
            Job curr = jobs.get(i);

            // If job can be scheduled before its deadline
            if (curr.deadLine > time) {
                seq.add(curr.Id); // Add job to the sequence
                time++;           // Occupy one more time slot
            }
        }

        // Output number of jobs scheduled
        System.out.println("Max number of jobs scheduled: " + seq.size());
    }
}
 