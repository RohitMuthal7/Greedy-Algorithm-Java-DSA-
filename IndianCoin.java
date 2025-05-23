package GreedyAlgorithms;
import java.util.*;
public class IndianCoin {
    public static void main(String[] args) {
        Integer coin[] = {1, 2, 5, 10, 20, 50, 100, 500, 2000};
         
        Arrays.sort(coin,Comparator.reverseOrder());
        int amount = 590;
        int CountOfCoins = 0;

        ArrayList<Integer> ans = new ArrayList<>();

        for(int i = 0 ;i< coin.length;i++){
            if(coin[i] <= amount){
                while (coin[i] <= amount) {
                    CountOfCoins++;
                    ans.add(coin[i]);
                    amount -= coin[i];
                }
            }
        }
        System.out.println("The Count of COin is : "+ CountOfCoins);

        System.out.println("Coins Used : "+ans);
    }
}
