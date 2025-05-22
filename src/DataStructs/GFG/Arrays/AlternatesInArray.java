package DataStructs.GFG.Arrays;

import java.util.Scanner;

public class AlternatesInArray {
    //Given an array arr[], the task is to print every alternate element of the array starting from the first element.
    /**Input: arr[] = [10, 20, 30, 40, 50]
     Output: 10 30 50
     Explanation: Print the first element (10), skip the second element (20), print the third element (30), skip the fourth element(40) and print the fifth element(50).


     Input: arr[] = [-5, 1, 4, 2, 12]
     Output: -5 4 12
     **/
    public static void main(String args[] ){
        System.out.println("Enter the array size ");
        Scanner sc = new Scanner(System.in);
        int s= 0;
        if(sc.hasNext()){
            s=sc.nextInt();
        }
        int a[] = new int[s];
        System.out.println("Enter array elements :");

        for(int i=0;i<s;i++){
            if(sc.hasNext()){
                a[i] = sc.nextInt();
            }
        }

        System.out.println("alternative elements are: ");
        for(int i=0;i<=a.length;i+=2){
            System.out.print(a[i]+" ");
        }
        sc.close();
    }
}
