public class Solution{
    public boolean isSelfCrossing(int[] x) {
        int len=x.length;
        if(len<=3) return false;
        if(len==4) return x[3]>=x[1]&&x[2]<=x[0];
        // 如果自交，可能是跟i-3或i-5之一相交，也有可能跟i-4或i-6重合，不可能越过这四条而到达更外面或更里面的边
        // 因此只要判断当前线是不是与i-3或i-5相交
        for(int i=3;i<len;i++){
            if(x[i-1]<=x[i-3]&&x[i]>=x[i-2])return true;// cross i-3
            if(i>=4 && x[i-1]<=x[i-3] && x[i-1]+(i>=5?x[i-5]:0)>=x[i-3] && x[i]>=x[i-2]-x[i-4] && x[i-2]>=x[i-4])return true;// cross i-5 only when ascending
            // start from the 5th line && check if the line is between i-2 and i-4 && check if the line can reach to i-5 && check if it's ascending
        }
        return false;
    }
    
    public static void main(String[] argv){
        Java java = new Java();
        int[] x = new int[]{3,3,3,2,1,1};
        System.out.println(java.isSelfCrossing(x));
        x = new int[]{1,1,1,1};
        System.out.println(java.isSelfCrossing(x));
    }
}