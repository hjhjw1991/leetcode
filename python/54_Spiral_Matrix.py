# coding=utf-8
class Solution:
    # @param {integer[][]} matrix
    # @return {integer[]}
    def spiralOrder(self, matrix):
        if not matrix:
            return []
        row,col=len(matrix),len(matrix[0])
        left=top=0
        right=col-1
        down=row-1
        res=[]
        if top==down:
            return matrix[0]
        elif left==right:
            for i in range(top,down+1):
                res.append(matrix[i][right])
            return res
        while left<=right and top<=down:
            res.extend(matrix[top][left:right+1])
            top+=1
            if top>down:
                break
            for i in range(top,down+1):
                res.append(matrix[i][right])
            right-=1
            if right<left:
                break
            for i in range(right,left-1,-1):
                res.append(matrix[down][i])
            down-=1
            for i in range(down,top-1,-1):
                res.append(matrix[i][left])
            left+=1
        return res
        
so=Solution()
matrix=[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
#print so.spiralOrder(matrix)
matrix=[
[1,2,3,4],
[5,6,7,8],
[9,10,11,12],
[13,14,15,16]
]
print((so.spiralOrder(matrix)))