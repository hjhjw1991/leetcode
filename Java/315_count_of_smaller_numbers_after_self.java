/**
 * 给定一个整数数组 nums，按要求返回一个新数组 counts。数组 counts 有该性质： counts[i] 的值是  nums[i] 右侧小于 nums[i] 的元素的数量。

示例:

输入: [5,2,6,1]
输出: [2,1,1,0] 
解释:
5 的右侧有 2 个更小的元素 (2 和 1).
2 的右侧仅有 1 个更小的元素 (1).
6 的右侧有 1 个更小的元素 (1).
1 的右侧有 0 个更小的元素.

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/count-of-smaller-numbers-after-self
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/
class Solution {
    public List<Integer> countSmaller(int[] nums) {
        // 暴力解的复杂度是O(n^2), 会超时
        // return bruteForce(nums);
        return fun1(nums);
    }
    
    public List<Integer> fun1(int[] nums) {
        // 从后到前以值建立二叉搜索树, 这个树代表当前位置时已经访问的数字的顺序, 根节点最小
        // 然后每个节点存储这个节点往后比它小的数字的个数
        // 在遍历时, 对于节点i, 它的答案就是对应值为i的节点存储的个数
        // 同时, 它会对每个在顺序上在它前面且比它大的节点(在树上则是它的后续节点)贡献+1的个数
        // 要省时间, 用数组模拟树更快, 要方便理解, 另外定义树结构更好
        // 以下代码是抄的, 需要自己理解
        if (nums.length == 0) {
            return new ArrayList<>();
        }
        // 找到数组最小值, 让数组的值化为正数
        int min = Integer.MAX_VALUE; // nums数组最小值
        for (int value : nums) {
            if (value < min) {
                min = value;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] - min + 1;
        }
        
        // 找到最大数, 作为树的最大规模
        int max = Integer.MIN_VALUE;
        for (int value : nums) {
            if (value > max) {
                max = value;
            }
        }
        
        // 构造二叉搜索树, 初始化根结点
        // 本质上是个等比递增范围的线段树
        int[] BITree = new int[max + 1];
        BITree[0] = 0;
        int[] countArr = new int[nums.length];
        // 从后向前搜索二叉树, 并更新二叉树
        for (int i = nums.length - 1; i >= 0; i--) {
            int count = getSum(nums[i] - 1, BITree);
            countArr[i] = count;
            update(nums[i], BITree);
        }
        List<Integer> result = toList(countArr);
        return result;
    }
    
    // BITree[i]的意思是从i//2到i之间的元素计数
    // 所以BITree本质上是个线段树
    public static int getSum(int value, int[] BITree) { // 获得BITree[i]从1...value的和
        int sum = 0;
        while (value > 0) {
            sum += BITree[value];
            value -= (value & -value);
        }
        return sum;
    }

    // 对每个值大于value的节点, value均贡献一个+1数量
    // 即对位于value及以后的所有含value的线段树节点, 均贡献+1个数量
    public static void update(int value, int[] BITree) {
        while (value <= BITree.length - 1) {
            BITree[value] += 1;
            value += (value & -value);
        }
    }
    
    public List<Integer> bruteForce(int[] nums) {
        int[] res = new int[nums.length];
        for(int i=nums.length-1;i>=0;i--) {
            for(int j=nums.length-1;j>i;j--) {
                if(nums[j] < nums[i]) {
                    res[i] ++;
                }
            }
        }
        return toList(res);
    }
    
    public List<Integer> toList(int[] nums) {
        List<Integer> list = new ArrayList<>(nums.length);
        for(int i: nums) {
            list.add(i);
        }
        return list;
    }
}