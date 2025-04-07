package ArraysPrograms.Arrays.Geeks;

import java.util.Arrays;

/**
 * This sorts the array first and then finds the maximum frequency by
 * linearly traversing through the array
 */
public class FreqEleInArrayUsingSorting {
    public static void main(String[] args){
        int a[]={10,20,30,30,10,40,50,30};
        Arrays.sort(a);
        System.out.println("Sorted array is "+Arrays.toString(a));
        System.out.println("Frequent element is "+getFrequentelement(a));
    }
    private static int getFrequentelement(int[] a){
        int res = a[0];
        int maxcount = 0;
        for(int i=0;i<a.length;i++){
            int count =0;
            for(int j=0;j<a.length;j++) {
                if (a[i] == a[j]) {
                    count++;
                }
            }
            if(count>maxcount){
                maxcount = count;
                res = a[i];
            }
        }
        return res;
    }
}
