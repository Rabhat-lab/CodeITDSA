package NeetCodePattern.ArraysString;

/**
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a
 * different day in the future to sell that stock.
 * Return the maximum profit you can achieve from this transaction.
 * If you cannot achieve any profit, return 0.
 *
 * ip - prices = [7 1 5 3 6 4]
 * output - 5
 * explanation : Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 * Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
 *
 * ip = prices = [7,6,4,3,1]
 * op = 0
 * explanation = In this case, no transactions are done and the max profit = 0.
 *
 * */
public class BestTimeBuySellStock1 {
    public static void main(String[] args){
        int[] a = {7 ,1 ,5 ,3 ,6 ,4};
        int maxProfit = getMaxProfit(a);
        System.out.println(maxProfit);
    }
    private static int getMaxProfit(int[] a){
        int maxProfit=0, minPrice=a[0];
        for(int i:a){
            maxProfit = Math.max(maxProfit,i-minPrice);
            minPrice = Math.min(minPrice,i);
        }
        return maxProfit;

    }
}
