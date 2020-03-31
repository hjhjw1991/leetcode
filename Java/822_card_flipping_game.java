/*
在桌子上有 N 张卡片，每张卡片的正面和背面都写着一个正数（正面与背面上的数有可能不一样）。

我们可以先翻转任意张卡片，然后选择其中一张卡片。

如果选中的那张卡片背面的数字 X 与任意一张卡片的正面的数字都不同，那么这个数字是我们想要的数字。

哪个数是这些想要的数字中最小的数（找到这些数中的最小值）呢？如果没有一个数字符合要求的，输出 0。

其中, fronts[i] 和 backs[i] 分别代表第 i 张卡片的正面和背面的数字。

如果我们通过翻转卡片来交换正面与背面上的数，那么当初在正面的数就变成背面的数，背面的数就变成正面的数。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/card-flipping-game
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

选中的卡片可以是任意一张卡片 --hjhjw1991
*/
public class Solution {
    public int flipgame(int[] fronts, int[] backs) {
        // 正反一样数字的一定不是答案
        Set<Integer> exclude = new HashSet<>();
        for(int i=0;i<fronts.length;i++) {
            if (fronts[i] == backs[i]) {
                exclude.add(fronts[i]);
            }
        }
        // 寻找剩下数字中最小的, 它就是答案
        int res = Integer.MAX_VALUE;
        for(int f:fronts) {
            if (!exclude.contains(f)) {
                res = Math.min(res, f);
            }
        }

        for(int b:backs) {
            if (!exclude.contains(b)) {
                res = Math.min(res, b);
            }
        }

        // 有可能没有答案
        return res == Integer.MAX_VALUE? 0: res;
    }
}