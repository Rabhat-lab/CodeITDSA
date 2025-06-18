package NeetCodePattern.ArraysString.PrefixSum;

public class ProductOfArrayExceptSelf {
    public static void main(String[] args){
        int[] ip = {-1,1,0,-3,3};
        int[] op = getproductArray(ip);
        for(int i:op){
            System.out.print(i+" ");
        }
    }
    private static int[] getproductArray(int[] ip) {
        int ipLen = ip.length;
        int[] answer = new int[ipLen];
        int leftProduct = 1;
        int rightproduct = 1;
        for(int i=0;i<ipLen;i++){
            answer[i]=leftProduct;
            leftProduct*=ip[i];
        }
        for(int i=ipLen-1;i>=0;i--){
            answer[i]*=rightproduct;
            rightproduct*=ip[i];
        }
        return answer;
    }
}
