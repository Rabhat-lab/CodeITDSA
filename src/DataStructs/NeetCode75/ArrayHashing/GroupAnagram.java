package DataStructs.NeetCode75.ArrayHashing;

import java.util.*;

/**
 * Given an array of strings strs, group all anagrams together into sublists.
 * You may return the output in any order.
 * An anagram is a string that contains the exact same characters as another string,
 * but the order of the characters can be different.
 *
 * Example 1:
 * Input: strs = ["act","pots","tops","cat","stop","hat"]
 * Output: [["hat"],["act", "cat"],["stop", "pots", "tops"]]
 *
 * Example 2:
 * Input: strs = ["x"]
 * Output: [["x"]]
 *
 * Example 3:
 * Input: strs = [""]
 * Output: [[""]]
 *
 */
public class GroupAnagram {
    public static void main(String[] args){
        String[] strs = {"act","pots","tops","cat","stop","hat"};
        List<List<String>> groupAnagrams= getGroupAnagrams(strs);
        for(List<String> istring:groupAnagrams){
            System.out.println(istring);
        }
    }
    private static List<List<String>> getGroupAnagrams(String[] strs){
        //create a map to hold the word as key and the value will be the original list
        Map<String,List<String>> anagramMap = new HashMap<>();
        //iterate over each element in the array
        for(String s:strs){
            //convert the string into character array
            char[] sArr = s.toCharArray();
            //now sort the character array
            Arrays.sort(sArr);
            //create a string with the sorted array
            String sortString = String.valueOf(sArr);
            //check if the sortedSTring is present in the map.intialize the list
            //then add the original string to the list associated with the sorted string key
            //If the specified key is not already associated with a value (or is mapped to null),
            // attempts to compute its value using the given mapping function and enters it into this map unless null.
            anagramMap.computeIfAbsent(sortString,key->new ArrayList<>()).add(s);
        }
        // Return a new list containing all values from the map's lists,
        // effectively grouping all anagrams together.
        return new ArrayList<>(anagramMap.values());
    }

}
