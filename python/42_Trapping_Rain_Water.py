class Solution:
    # @param {integer[]} height
    # @return {integer}
  def trap(self, height):
    if len(height) <3:
        return 0
    left = 0
    right = len(height)-1
    sum = 0
    while left<len(height)-2 and height[left]<height[left+1]:
        left += 1
    while right>1 and height[right]<height[right-1]:
        right -= 1
    if left<right:
        while left < right:
            if height[left]<height[right]:
                l = left + 1
                while height[left]>height[l]:
                    sum += height[left] - height[l]
                    l += 1
                left = l
            else:
                r = right - 1
                while height[right]>height[r]:
                    sum += height[right] - height[r]
                    r -= 1
                right = r
    return sum