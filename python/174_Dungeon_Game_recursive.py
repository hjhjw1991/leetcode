# coding=utf-8

class Solution:
    # @return
    def calculateMinimumHP(self, dungeon):
        step = self.calculateMinimum(dungeon)
        if step < 0:
            step = 0
        return step + 1
    def calculateMinimum(self, dungeon):
        if len(dungeon) == 1:
            return self.minHP(dungeon[0])
        if len(dungeon[0]) == 1:
            return self.minHP([row[0] for row in dungeon])
        rightDungeon = []
        for list in dungeon:
            rightDungeon.append(list[1:])
        downDungeon = dungeon[1:]
        curHP = dungeon[0][0]
        stepRight = self.calculateMinimum(downDungeon)
        stepDown = self.calculateMinimum(rightDungeon)
        stepRight = stepRight - curHP
        stepDown = stepDown - curHP
        return min(stepRight, stepDown)
        
    def minHP(self, list):
        sum = 0
        HP = 0
        for cell in list:
            sum += cell
            if sum < 0:
                HP += sum
                sum = 0
        return -HP