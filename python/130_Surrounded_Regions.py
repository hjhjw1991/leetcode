class Solution:
    # @param {character[][]} board
    # @return {void} Do not return anything, modify board in-place instead.
    def solve(self, board):
        if not board:
            return
        def sink(r,c):
            if 0<=r<len(board) and 0<=c<len(board[0]) and board[r][c]=='O':
                queue=[(r,c)]
                while queue:
                    (r,c)=queue.pop()
                    board[r][c]='+'
                    if r>0 and board[r-1][c]=='O':
                        queue.append((r-1,c))
                    if c>0 and board[r][c-1]=='O':
                        queue.append((r,c-1))
                    if r<len(board)-1 and board[r+1][c]=='O':
                        queue.append((r+1,c))
                    if c<len(board[0])-1 and board[r][c+1]=='O':
                        queue.append((r,c+1))
        rows,cols=len(board),len(board[0])
        for i in range(cols):
            sink(0,i)
            sink(rows-1,i)
        for i in range(1,rows-1):
            sink(i,0)
            sink(i,cols-1)
        for i in range(rows):
            for j in range(cols):
                if board[i][j]=='+':
                    board[i][j]='O'
                else:
                    board[i][j]='X'