/*
附近的家居城促销，你买回了一直心仪的可调节书架，打算把自己的书都整理到新的书架上。

你把要摆放的书 books 都整理好，叠成一摞：从上往下，第 i 本书的厚度为 books[i][0]，高度为 books[i][1]。

按顺序 将这些书摆放到总宽度为 shelf_width 的书架上。

先选几本书放在书架上（它们的厚度之和小于等于书架的宽度 shelf_width），然后再建一层书架。重复这个过程，直到把所有的书都放在书架上。

需要注意的是，在上述过程的每个步骤中，摆放书的顺序与你整理好的顺序相同。 例如，如果这里有 5 本书，那么可能的一种摆放情况是：第一和第二本书放在第一层书架上，第三本书放在第二层书架上，第四和第五本书放在最后一层书架上。

每一层所摆放的书的最大高度就是这一层书架的层高，书架整体的高度为各层高之和。

以这种方式布置书架，返回书架整体可能的最小高度。

 

示例：
![img](https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2019/06/28/shelves.png)


输入：books = [[1,1],[2,3],[2,3],[1,1],[1,1],[1,1],[1,2]], shelf_width = 4
输出：6
解释：
3 层书架的高度和为 1 + 3 + 2 = 6 。
第 2 本书不必放在第一层书架上。
 

提示：

1 <= books.length <= 1000
1 <= books[i][0] <= shelf_width <= 1000
1 <= books[i][1] <= 1000

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/filling-bookcase-shelves
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/
class Solution {
    public int minHeightShelves(int[][] books, int shelf_width) {
        // minHeight[i] 表示前i本书能够构成的最小书架高度
        // 算法: 每新增加一本书, 查看它前面的书跟它一起形成的行, 所能形成的最小总高度, 直到所取的书超过每一行宽度为止
        // minHeight[i] = min{sigma(minHeight[j-1]+max{books[j][1]}) | for j let sigma(books[j][0])|j...i < shelf_width} 

        int num = books.length;
        int[] dp = new int[num+1];
        Arrays.fill(dp, Integer.MAX_VALUE); // 初始化为最大值
        dp[0] = 0;
        int width = shelf_width;
        for(int i=1;i<=num;i++) {
            // 对于第i本书, 计算最小高度
            int tmpwidth = 0;
            int tmpheight = 0;
            for(int j=i-1;j>=0;j--) {
                // 从第j本开始尝试构成一行. 这里的j是books数组里的下标, 第j本实际上就是第i本
                tmpwidth += books[j][0];
                if (tmpwidth > width) {
                    // 超过一行的宽度了, 不用再继续
                    break;
                }
                tmpheight = Math.max(tmpheight, books[j][1]);
                dp[i] = Math.min(dp[i], dp[j]+tmpheight); // 在状态数组里的下标j表示的是前j本, 不含第i本, 正好无需调整
            }
        }
        return dp[num];
    }
}