public class Solution {
    // 写在前面：这个题的leetcode oj有问题，题目既没有说保证有解也没有说在无解的时候应该返回什么，我这里是在无解时返回-1
    // 算法：
    // 对跳跃次数贪心。每次探索在当前的跳跃次数下能到达的最远位置，如果可以到达结尾则结束，
    // 否则从当前位置到最远位置之间进行下一次跳跃，跳跃次数加1
    // 直到找到一个解或发现无解时结束
    public int jump(int[] nums) {
        if(nums==null||nums.length<=1)return 0;
        int len=nums.length;
        int cur=0,next=cur+nums[cur],candi,cnt=1;//next记录当前跳跃次数下能到达的最远位置。最初跳跃1次，能到达的最远位置是next=cur+nums[cur]
        while(next>cur&&next<len-1){
            // 进行下一次跳跃
            int run=cur+1;// 下一次跳跃途经run点
            candi = next+nums[next];// 下一次跳跃的其中一个位置
            while(run<next){// 找到直到上一次跳跃的最远点为止，能够进行的下一次跳跃所能到达的最远点
                candi = Math.max(run+nums[run], candi);
                run++;
            }
            cur=next;// 记录上一次跳跃的最远点作为下一次跳跃的搜索起点
            next=candi;// 记录下一次跳跃的最远点
            cnt++;// 跳跃次数
        }
        return next>=len-1?cnt:-1;// 判断是否有解，若无解即无法到达数列最后，则当前跳跃最远只能到达当前位置，即next==cur
    }
}