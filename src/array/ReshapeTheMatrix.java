package array;

public class ReshapeTheMatrix {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        if(r*c!=nums.length*nums[0].length)
            return nums;
        int[][] ret=new int[r][c];
        int m=0,n=0;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                ret[i][j]=nums[m][n];
                if(n==nums[0].length-1){
                    n=0;
                    m++;
                }else{
                    n++;
                }
            }
        }
        return ret;
    }
}
