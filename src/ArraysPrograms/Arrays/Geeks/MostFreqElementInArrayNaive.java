package ArraysPrograms.Arrays.Geeks;

import java.util.Scanner;

/**
 * Given an array, find the most frequent element in it.
 * If there are multiple elements that appear a maximum number of times, print any one of them
 * Input : arr[] = {1, 3, 2, 1, 4, 1}
 * Output : 1
 * Explanation: 1 appears three times in array which is maximum frequency.
 *
 * Input : arr[] = {10, 20, 10, 20, 30, 20, 20}
 * Output : 20 appears four  times in array which is maximum frequency
 *
 */
public class MostFreqElementInArrayNaive {
    public static void main(String[] args){
        int[] a = new int[5];
        Scanner sc = new Scanner(System.in);
        for(int i=0;i<a.length;i++){
            if(sc.hasNext()){
                a[i]=sc.nextInt();
            }
        }
        getMaxAppearedElement(a);
    }
    private static void getMaxAppearedElement(int[] a){
        int maxCount =0;
        int res = a[0];
        for(int i=0;i<a.length;i++){
            int count=0;
            for(int j=0;j<a.length;j++){
                if(a[i]==a[j]){
                    count++;
                }
            }
            if(count>maxCount){
                maxCount=count;
                res = a[i];
            }
        }
        System.out.println(res+" has appeared "+maxCount+" of times");
    }
}
