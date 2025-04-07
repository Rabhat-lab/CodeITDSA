package ArraysPrograms.Matrix;

public class SearchMatrix {
    public static void main(String[] args){
        int[][] a = {{0,6,8,9,11},{20,22,28,29,31},{36,38,50,61,63},{64,66,100,122,128}};
        int x = 20;
        System.out.println(isElemementPresent(a,x) ? "Found" : "Not Found");
    }
    private static boolean isElemementPresent(int[][] a,int x){
        int m = a.length; //row
        int n = a[0].length; //col
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(a[i][j]==x){
                    return true;
                }
            }
        }
        return false;
    }
}
