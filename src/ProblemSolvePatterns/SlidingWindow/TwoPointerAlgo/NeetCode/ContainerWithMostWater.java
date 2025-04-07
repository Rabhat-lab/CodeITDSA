package ProblemSolvePatterns.SlidingWindow.TwoPointerAlgo.NeetCode;

import static java.util.Collections.min;

/**
 * You are given an integer array heights where heights[i] represents the height of the ith bar.
 * You may choose any two bars to form a container. Return the maximum amount of water a container can store.
 *
 * Input: height = [1,7,2,5,4,7,3,6]
 * Output: 36
 *
 * Input: height = [2,2,2]
 * Output: 4
 *
 */
public class ContainerWithMostWater {
    public static void main(String[] args){
        int[] a = {2,2,2};
        int area = getMaxArea(a);
        System.out.println(area);
    }
    private static int getMaxArea(int[] a){
        int area =0;
        int i=0;
        int j=a.length-1;
        while(i<j){
            int maxArea = Math.abs(i-j)*Math.min(a[i],a[j]);
            area = Math.max(area,maxArea);
            if (a[i] < a[j]) {
                i++;
            } else {
                j--;
            }
        }
        return area;
    }

}
