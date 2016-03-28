public class NumMatrix {

    private int[][] sums;
    public NumMatrix(int[][] matrix) {
        if(matrix==null||matrix.length==0||matrix[0].length==0)return;
        int row = matrix.length;
        int col = matrix[0].length;
        sums = new int[row+1][col+1];
        for(int i=0;i<=col;i++){
            sums[0][i]=0;
        }
        for(int i=0;i<=row;i++){
            sums[i][0]=0;
        }
        for(int i=1;i<=row;i++){
            int sum=0;
            for(int j=1;j<=col;j++){
                sum+=matrix[i-1][j-1];
                sums[i][j]=sums[i-1][j]+sum;
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if(row1>row2&&col1>col2){
            // handle this
            return -1;
        }else{
            if(col2>=sums[0].length-1){
                col2=sums[0].length-2;
            }
            if(row2>=sums.length-1){
                row2=sums.length-2;
            }
            return sums[row2+1][col2+1]+sums[row1][col1]-sums[row1][col2+1]-sums[row2+1][col1];
        }
    }
}


// Your NumMatrix object will be instantiated and called as such:
// NumMatrix numMatrix = new NumMatrix(matrix);
// numMatrix.sumRegion(0, 1, 2, 3);
// numMatrix.sumRegion(1, 2, 3, 4);