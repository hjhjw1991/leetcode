# coding=utf-8

class Solution:
    # @return
    def calculateMinimumHP(self, dungeon):
        step = self.calculateMinimum(dungeon)
        if step < 0:
            step = 0
        return step + 1
    def calculateMinimum(self, dungeon):
        row = len(dungeon)
        col = len(dungeon[0])
        #存储所有格子需要的最低血量
        HPs = []
        for rowi in range(row-1, -1, -1):
            HP = []
            for coli in range(col-1, -1, -1):
                if coli == col - 1 and rowi == row - 1:
                    HP.append(max(-dungeon[rowi][coli], 0))
                elif coli == col - 1:
                    HP.append(max(HPs[-1][0]-dungeon[rowi][coli], 0))
                elif rowi == row - 1:
                    HP.append(max(HP[-1]-dungeon[rowi][coli], 0))
                else:
                    HP.append(max(min(HPs[-1][col-1-coli]-dungeon[rowi][coli], HP[-1]-dungeon[rowi][coli]), 0))
            HPs.append(HP)
        #for HPline in HPs:
        #    print "\t".join(map(str, HPline)) 
        return HPs[-1][-1]