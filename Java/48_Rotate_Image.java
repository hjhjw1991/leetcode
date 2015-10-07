public class Solution {
    // 旋转图形矩阵由于要访问所有的元素，所以问题的时间复杂度为O(n^2)，没法降低
    // 本方法就是最直接的模拟法，从最外围到内一层层旋转
    // 本题唯一要注意的地方是下标的变换关系
    public void rotate(int[][] matrix) {
        if(matrix==null||matrix.length<=1||matrix[0].length<=1)return;
        int top=0, left=0, right=matrix.length-1, bottom=matrix.length-1;
        int n=matrix.length;
        int i, keep;
        while(left<right){
            for(i=left;i<right;i++){
                keep=matrix[top][i];
                matrix[top][i]=matrix[n-i-1][left];
                matrix[n-i-1][left]=matrix[bottom][n-i-1];
                matrix[bottom][n-i-1]=matrix[i][right];
                matrix[i][right]=keep;
            }
            top++;
            bottom--;
            left++;
            right--;
        }
    }
}