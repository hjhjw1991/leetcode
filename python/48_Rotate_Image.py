class Solution:
    # @param {integer[][]} matrix
    # @return {void} Do not return anything, modify matrix in-place instead.
    def rotate(self, matrix):
        if not matrix:
            return
        degree=len(matrix)
        for layer in xrange(degree/2):
            first=layer
            last=degree-1-layer
            for i in xrange(first,last):
                offset=i-first
                top=matrix[first][i]
                matrix[layer][i]=matrix[last-offset][first]
                matrix[last-offset][first]=matrix[last][last-offset]
                matrix[last][last-offset]=matrix[i][last]
                matrix[i][last]=top