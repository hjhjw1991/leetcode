# Definition for a point.
# class Point:
#     def __init__(self, a=0, b=0):
#         self.x = a
#         self.y = b

class Solution:
    # @param {Point[]} points
    # @return {integer}
    def maxPoints(self, points):
        answer = 0
        for p in points:
            pctr = 0
            ctr = collections.Counter()
            for q in points:
                x, y = q.x - p.x, q.y - p.y
                pctr += x == y == 0
                ctr[float(y)/x if x else 'inf'] += 1
            ctr['inf'] -= pctr
            answer = max(answer, pctr + max(ctr.values()))
        return answer
        