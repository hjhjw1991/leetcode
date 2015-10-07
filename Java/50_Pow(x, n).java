public class Solution {
    // 本题考量点是三个地方：
    // 1 涉及到整数计算，考了溢出
    // 2 涉及到双精度数的计算，考了精度问题
    // 3 涉及到幂指数计算规则，考了corner case的处理
    
    final double eps=0.000000000000000000000001;// 精度限制, 24位。若精度限制为6位则无法pass所有测例
    public double myPow(double x, int n) {
        if(Math.abs(x)<eps)return 0;// 底数为0不必计算
        else if(n==0||Math.abs(x-1)<eps) return 1;// 底数为1或指数为0不必计算
        else if(Math.abs(x+1)<eps)return ((n&1)==1)?-1:1;// 底数为-1不必计算
        else if(n<0){// 指数为负时
            long l = (long)n;// 处理负指数直接取相反会溢出的问题
            l = -l;
            if((l & 1)==1){
                return 1/(myPow(x*x, (int)(l>>1))*x);
            }else{
                return 1/myPow(x*x, (int)(l>>1));
            }
        }
        // double odd = (n&1)==1?x:1;
        // return myPow(x*x, n>>1)*odd;
        if((n & 1)==1){// 指数为正时
            return myPow(x*x, n>>1)*x;
        }else{
            return myPow(x*x, n>>1);
        }
    }
}