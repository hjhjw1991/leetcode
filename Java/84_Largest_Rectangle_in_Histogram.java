import java.util.*;

public class Solution {
    public int largestRectangleArea(int[] height) {
        if(height.length==0){
            return 0;
        }
        LinkedList<Integer> pre=new LinkedList<Integer>();
        int[] newheight=new int[height.length+1];
        int max=0,p,i=0;
        for(i=0;i<height.length;i++){
            newheight[i]=height[i];
        }
        newheight[i]=0;// add a dummy 0 to make sure while loop will break
        i=0;
        while(i<newheight.length){
            while(pre.size()>0&&newheight[i]<newheight[pre.peekLast()]){
                p=pre.pollLast();
                max=Math.max(max, newheight[p]*(pre.size()>0?i-pre.peekLast()-1:i));
            }
            pre.add(i++);
        }
        return max;
    }
    
    public static void main(String argv[]){
        Solution so=new Solution();
        int[] input={
            1,1,1,0};
        print(so.largestRectangleArea(input));
        print(input.length);
    }
    static void print(int[] num){
        for(int n:num){
            System.out.print(n);
            System.out.print("\t");
        }
        System.out.println();
    }
    
    static void print(int num){
        System.out.println(num);
    }
}