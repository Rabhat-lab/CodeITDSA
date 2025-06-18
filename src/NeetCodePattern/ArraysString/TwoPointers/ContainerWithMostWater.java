package NeetCodePattern.ArraysString.TwoPointers;

/**
 * You are given an integer array heights where heights[i] represents the height of the
 * ith bar.
 * You may choose any two bars to form a container.
 * Return the maximum amount of water a container can store.
 *
 * Example:
 * Input: height = [1,7,2,5,4,7,3,6]
 * Output: 36
 *      |               |
 *      |               |       |
 *      |       |       |       |
 *      |       |   |   |       |
 *      |       |   |   |   |   |
 *      |   |   |   |   |   |   |
 *   |  |   |   |   |   |   |   |
 *
 * Example 2:
 * Input: height = [2,2,2]
 * Output: 4
 *
 */
public class ContainerWithMostWater {
    public static void main(String[] args){
        int[] a = {1,7,2,5,4,7,3,6};
        int maxWater = getContainerWithMaxWater(a);
        System.out.println(maxWater);
    }
    private static int getContainerWithMaxWater(int[] a){
        int maxWaterArea = 0,i=0,j=a.length-1;
        while(i<j){
            int area = Math.min(a[i],a[j])*Math.abs(i-j);
            maxWaterArea = Math.max(maxWaterArea,area);

            if(a[i]<a[j]){
                i++;
            } else {
                j--;
            }
        }
        return maxWaterArea;
    }
}
