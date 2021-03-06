class Solution:
    # @param {integer[][]} matrix
    # @param {integer} target
    # @return {boolean}
    def searchMatrix(self, matrix, target):
        if matrix:
            row,col,width=len(matrix)-1,0,len(matrix[0])
            while row>=0 and col<width:
                if matrix[row][col]==target:
                    return True
                elif matrix[row][col]>target:
                    row=row-1
                else:
                    col=col+1
            return False