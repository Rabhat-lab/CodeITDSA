package DataStructs.GFG.Arrays;

import java.util.Arrays;

public class LeastFrequentElementInArray {
    public static void main(String[] args){
        int a[] = {20,30,40,20,20,30,40,40};
        Arrays.sort(a);
        System.out.println("Least Frequent Element is: "+getLeastFrequentElement(a));
    }
    private static int getLeastFrequentElement(int[] a){
        int res=a[0];
        int minCount = a.length+1;
        int count =1;
        for(int i=1;i<a.length;i++){
            if(a[i]==a[i-1]){
                count++;
            }
            if(count<=minCount){
                minCount=count;
                res=a[i-1];
            }
            count=1;
        }
        return res;
    }
}
