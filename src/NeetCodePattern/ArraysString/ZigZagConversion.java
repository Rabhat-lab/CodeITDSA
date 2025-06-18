package NeetCodePattern.ArraysString;

import java.util.ArrayList;
import java.util.List;

/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
 * (you may want to display this pattern in a fixed font for better legibility)
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 *
 * And then read line by line: "PAHNAPLSIIGYIR"
 * Write the code that will take a string and make this conversion given a number of rows:
 * string convert(string s, int numRows);
 *
 * Example 1:
 * Input: s = "PAYPALISHIRING", numRows = 3
 * Output: "PAHNAPLSIIGYIR"
 *
 * Example 2:
 * Input: s = "PAYPALISHIRING", numRows = 4
 * Output: "PINALSIGYAHRPI"
 * Explanation:
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 *
 * Example 3:
 * Input: s = "A", numRows = 1
 * Output: "A"
 */
public class ZigZagConversion {
    public static void main(String[] args){
        String s = "PAYPALISHIRING";
        int numRows = 3;
        String zigzagStr = getZigZagString(s,numRows);
        String zigzagStr1 = getZigZagStringOptimal(s,numRows);
        System.out.println(zigzagStr);
        System.out.println(zigzagStr1);
    }

    //runtime = 5ms ,
    private static String getZigZagString(String s, int numRows) {
        if(numRows==1){ //when the number of rows is given as 1 then return the string in itself
            return s;
        }
        //now initialize a rows list to fill in the characters in zigzag manner
        List<StringBuilder> rows = new ArrayList<>();
        //for each iteration create a new String builder
        for(int i=0;i<numRows;i++){
            rows.add(new StringBuilder());
        }
        //take a variable i=0 and a boolean function goDOwn which is initially false
        int i=0;
        boolean goDown=false;
        for(char c:s.toCharArray()){
            //append the character to each index of row
            rows.get(i).append(c);
            //check if i=0 or i= end of the rows , if yes then negate the goDown
            if(i==0||i==numRows-1){
                goDown=!goDown;
            }
            //find the i by checking the goDOwn flag
            i+=goDown?1:-1;
        }
        //build the final string reading the each row
        StringBuilder result = new StringBuilder();
        for(StringBuilder row:rows){
            result.append(row);
        }
        return result.toString();
    }

    private static String getZigZagStringOptimal(String s, int numRows) {
        int len = s.length();
        if(numRows==1 || numRows>=len) return s;

        StringBuilder result = new StringBuilder();
        int cycleLen = 2*numRows-2;
        for(int i=0;i<numRows;i++){
            for(int j=i;j<len;j+=cycleLen){
                result.append(s.charAt(j));
                int second = j+cycleLen-2*i;
                if(i!=0 && i!=numRows-1 && second<len){
                    result.append(s.charAt(second));
                }
            }
        }
        return result.toString();
    }
}
