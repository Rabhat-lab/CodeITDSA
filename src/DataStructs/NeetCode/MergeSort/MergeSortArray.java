package DataStructs.NeetCode.MergeSort;

public class MergeSortArray {
    public static void main(String[] args){
        int[] a = {3,2,4,1,6};
        int[] sortedArr = getSortedArray(a);
        for(int i:sortedArr){
            System.out.print(i+" ");
        }
    }
    private static int[] getSortedArray(int[] a){
        int l = 0;
        int r = a.length-1;
        if(a.length==1){
            return a;
        }
        return mergeSort(a,l,r);
    }

    private static int[] mergeSort(int[] a,int l,int r){
        if(l<r){
            int mid = (l+r)/2;
            mergeSort(a,l,mid);
            mergeSort(a,mid+1,r);
            mergeArr(a,l,mid,r);
        }
        return a;
    }

    private static void mergeArr(int[] a, int l, int mid, int r) {
        int l1 = mid-l+1;
        int l2 = r-mid;

        //create two temporary arrays
        int[] left = new int[l1];
        int[] right = new int[l2];

        //copy all elements from left and right halves to temporary arrays
        for(int i=0;i<l1;i++){
            left[i]=a[l+i];
        }
        for(int j=0;j<l2;j++){
            right[j]=a[mid+1+j];
        }

        //take initial indexes of the left and right subarrays
        int m=0;
        int n=0;
        int k=l; //initial index of merged array

        //merge two sorted arrays
        while(m<l1 && n<l2){
            if(left[m] <= right[n]){
                a[k]=left[m];
                m++;
            } else {
                a[k] = right[n];
                n++;
            }
            k++;
        }

        //put remaining elements into the array - left
        while(m<l1){
            a[k]=left[m];
            m++;
            k++;
        }

        //put remaining elements into the array - right
        while(n<l2){
            a[k]= right[n];
            n++;
            k++;
        }
    }
}
