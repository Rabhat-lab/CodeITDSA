package ArraysPrograms.Arrays.Geeks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The best approach to do this is by using 3 pointer algorithm
 * Given three sorted arrays in non-decreasing order, print all common elements in these arrays.
 * In case of duplicate common elements, print only once.
 * take simply three pointers, one at each sorted array, and check if the current elements are same or not.
 * When a common integer has been found, we want to move forward in each array. Otherwise,
 * only the pointer to the smallest integer among the three must move forward.
 *
 */
public class FindCommonAmongstArrays {
    public static void main(String args[]){
        int[] a = { 1, 5, 10, 20, 30 };
        int[] b = { 5, 13, 15, 20 };
        int[] c = { 5, 20 };

        //List<Integer> commonEle = getCommonElements(a,b,c);
        List<Integer> commonEleOptimized = getCommonELementsOptimized(a,b,c);
        /*System.out.println("Common Elements are :");
        for(int x:commonEle){
            System.out.print(" "+x);
        }*/
        for(int x:commonEleOptimized){
            System.out.print(" "+x);
        }
    }

    private static List<Integer> getCommonELementsOptimized(int[] a, int[] b, int[] c) {
        int i=0,j=0,k=0;
        int l=0;
        List<Integer> newList = new ArrayList<>();
        List<Integer> commonEle = new ArrayList<>();
        if(a.length<b.length && a.length<c.length){
            l=a.length;
            for(int x=0;x<l;x++){
                newList.add(a[x]);
            }
        } else if(b.length<c.length && b.length<a.length){
            l=b.length;
            for(int x=0;x<l;x++){
                newList.add(b[x]);
            }
        } else {
            l=c.length;
            for(int x=0;x<l;x++){
                newList.add(c[x]);
            }
        }
        int m=0;

            return commonEle;

    }

    private static List<Integer> getCommonElements(int[] a,int[] b,int[] c) {
        List<Integer> list = new ArrayList<>();
        int i = 0, j = 0, k = 0;
        while (i < a.length && j < b.length && k < c.length) {
            if (a[i] == b[j] && b[j] == c[k]) {
                list.add(a[i]);
                i++;
                j++;
                k++;

                //skipping duplicates
                while (a[i] == a[i - 1]) {
                    i++;
                }
                while (b[j] == b[j - 1]) {
                    j++;
                }
                while (c[k] == c[k - 1]) {
                    k++;
                }
            } else if (a[i] < b[j]) { //if a is less than b then they are not common
                i++;
            } else if (b[j] < c[k]) { //if b is less than c then they are not common
                j++;
            } else { //is c is least then they are not common
                k++;
            }
        }
        return list;
    }

}
