public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if(gas==null||gas.length<1)return -1;
        int len=gas.length;
        int start=len-1,end=0, curgas=0;// 从第len-1个站点开始，start指向第len-1个站点，end指向下一个要到达的站点
        // 如果存在一个环可以走完所有站点，那么在这个环内，从任意一点开始，累积到起点的所得gas，一定可以覆盖该点以后的所有站点，因此可以在开始时任意选择一个点，当gas不足时往前寻找gas补充。这种方法能保证在有解的情况下找到一个解。
        while(start>=end){// 每一步不是起点前移就是终点后移，由于起终点的初始值选择，这里一旦两者相遇则说明已经访问了一圈
        //对于每一步，只需判断是向前走还是向后退。
            if(curgas+gas[end]-cost[end]>=0){// 若当前存留的汽油加上当前站点的汽油足以到达下一个站点
                curgas+=gas[end]-cost[end];// 则到达下一个站点
                end++;
            }else{// 否则向起点前一个站点索求汽油
                curgas+=gas[start]-cost[start];
                start--;
            }
        }
        return curgas>=0?(start+1)%len:-1;
    }
}