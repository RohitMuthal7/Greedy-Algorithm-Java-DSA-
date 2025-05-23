// 📌 Problem: Given the cost of horizontal and vertical cuts of a chocolate bar,
// find the minimum total cost to cut the entire chocolate into 1x1 pieces
// using a greedy strategy (always pick the highest cost cut first).

package GreedyAlgorithms;
import java.util.*;

public class ChocolaProblem {
    public static void main(String[] args) {
        // Dimensions of the chocolate
        // int n = 4; // Number of rows (=> n - 1 vertical cuts needed)
        // int m = 6; // Number of columns (=> m - 1 horizontal cuts needed)

        // Cost of horizontal cuts (size m-1)
        Integer[] costHor = {2, 1, 3, 1, 4};

        // Cost of vertical cuts (size n-1)
        Integer[] costVer = {4, 1, 2};

        // Sort both arrays in descending order to use greedy approach
        Arrays.sort(costHor, Collections.reverseOrder());
        Arrays.sort(costVer, Collections.reverseOrder());

        // Pointers for horizontal and vertical cuts
        int h = 0, v = 0;

        // Initial number of parts in each direction
        int hp = 1; // Horizontal parts
        int vp = 1; // Vertical parts

        // Total cost
        int cost = 0;

        // Traverse through both arrays
        while (h < costHor.length && v < costVer.length) {
            // Choose the higher cost cut first (greedy)
            if (costVer[v] <= costHor[h]) {
                // Horizontal cut is more expensive, so cut it
                cost += costHor[h] * vp; // Cost = cut cost × number of vertical pieces
                hp++; // Horizontal parts increase
                h++;  // Move to next horizontal cut
            } else {
                // Vertical cut is more expensive, so cut it
                cost += costVer[v] * hp; // Cost = cut cost × number of horizontal pieces
                vp++; // Vertical parts increase
                v++;  // Move to next vertical cut
            }
        }

        // Add remaining horizontal cuts, if any
        while (h < costHor.length) {
            cost += costHor[h] * vp;
            hp++;
            h++;
        }

        // Add remaining vertical cuts, if any
        while (v < costVer.length) {
            cost += costVer[v] * hp;
            vp++;
            v++;
        }

        // Output the final minimum cost
        System.out.println("Minimum cost of cutting the chocolate is: " + cost);
    }
}
