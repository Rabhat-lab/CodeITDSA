package ArraysPrograms.Arrays.Geeks;

public class FixedPointArray {
    public static void main(String[] args){
        int a[] = {-10, -5, 0, 3, 7};
        System.out.println("Fixed point in array using naive approach "+getFixedPointNaive(a));
        System.out.println("Fixed point in array using Binary search "+getFixedPointBinary(a));
    }
    private static int getFixedPointNaive(int[] a){
        for(int i=0;i<a.length;i++){
            if(Math.abs(a[i])==i){
                return i;
            }
        }
        return -1;
    }

    private static int getFixedPointBinary(int []a){
        int l=0;
        int h=a.length-1;
        while(l<=h){
            int mid= (int) (Math.floor(l+h)/2);
            if(a[mid]==mid){
                return mid;
            } else if(a[mid]<mid){
                l=mid+1;
            } else if(a[mid]>mid){
                h=mid-1;
            }
        }
        return -1;
    }
}
