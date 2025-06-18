package NeetCodePattern.ArraysString.KadanesAlgo;

/**
 * LeetCode - 1014
 * You are given an integer array values where values[i] represents the value of the ith sightseeing spot.
 * Two sightseeing spots i and j have a distance j - i between them.
 * The score of a pair (i < j) of sightseeing spots is values[i] + values[j] + i - j:
 * the sum of the values of the sightseeing spots, minus the distance between them.
 * Return the maximum score of a pair of sightseeing spots.
 *
 * Example 1:
 * Input: values = [8,1,5,2,6]
 * Output: 11
 * Explanation: i = 0, j = 2, values[i] + values[j] + i - j = 8 + 5 + 0 - 2 = 11
 *
 * Example 2:
 * Input: values = [1,2]
 * Output: 2
 *
 * Traditional brute force approach to this would be having two iterations and checking pair for each of the number
 * other approach :
 * the question if thought about has two parts : to have the max value of numbers for max sum and min distance between
 * the sightseeing sites
 * for this seeing the first element and then moving toward the next we would not know if there is smaller element than
 * the first element or there is a bigger element than the first element which is impossible to predict
 * Rather than keeping the first element as pivot its better to find out if previous elements as we can possibly know the
 * previous elements and find max pair ending at that element
 * thr formula rephrases to : values[i]+i+values[j]-j
 * the solution proceeds by keeping the max score at ith position : values[i]+i and as we proceed in the iteration (for
 * each j) we get values[j]-j which is current score between the spots. then we update the maxScore by taking the max
 * between maxScore and the currentScore
 *
 */
public class BestSightSeeingPair {
    public static void main(String[] args){
        int[] a = {8,1,5,2,6};
        int maxSumPair = getMaxSumSightSeeingPair(a);
        System.out.println(maxSumPair);
    }
    private static int getMaxSumSightSeeingPair(int[] a){
        //intialize maxScore to 0
        int maxScore = 0;
        //intialize currentScore so far as the first element of the array
        int currentScore = a[0];
        //start the iteration from 1 as we have already covered the 0th index
        for(int j=1;j<a.length;j++){
            //update the maxScore taking the max between the maxScroe so far and the currentScore combined with previous
            //score . This score is computed as the value of current element plus its 'value' score (values[j]) subtracted
            //by its distance from the start(j) plus the currentScore
            maxScore = Math.max(maxScore,a[j]-j+currentScore);
            //update the current score by taking max between the so far currentScore and the value score of current index
            //added to the index . this account for the fact that as we move right our index increases which decreases our score
            //so we need to keep track of the element which will contribute the most to the score including our index
            currentScore = Math.max(currentScore,a[j]+j);
        }
        return maxScore;
    }
}
