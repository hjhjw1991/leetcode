class Solution:
    # @param {character[][]} board
    # @return {boolean}
    def isValidSudoku(self, board):
        col=[[False, False, False, False, False, False, False, False, False] for i in range(9)]
        row=[[False, False, False, False, False, False, False, False, False] for i in range(9)]
        block=[[False, False, False, False, False, False, False, False, False] for i in range(9)]
        for i in range(9):
            for j in range(9):
                if board[i][j]=='.':
                    continue
                blockid=i/3*3+j/3
                digit=int(board[i][j])-1
                if col[j][digit]:
                    return False
                else:
                    col[j][digit]=True
                if row[i][digit]:
                    return False
                else:
                    row[i][digit]=True
                if block[blockid][digit]:
                    return False
                else:
                    block[blockid][digit]=True
        return True