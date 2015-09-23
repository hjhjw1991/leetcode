import java.util.Scanner;
//an example of using Test
public class Solution extends Test{
    protected void solve(Scanner sc){
        System.out.println(longestPalindrome(sc.next()));
    }
    
    public String longestPalindrome(String s) {
        char[] cstr = Join(s, '#');
        StringBuffer sb = new StringBuffer();
        if(cstr!=null){
            int len = cstr.length;
            int longcent = 0, longleng=1, index = 0;
            int curcent = 1;
            int[] point = new int[len];
            point[0]=1;
            while(curcent<len){
                if(point[index]+index>curcent){
                    point[curcent] = Math.min(point[index - (curcent - index)], point[index] - (curcent - index));
                }else{
                    point[curcent] = 1;
                }
                while(curcent>=point[curcent]&&curcent + point[curcent]<len && cstr[curcent+point[curcent]]==cstr[curcent-point[curcent]])point[curcent]++;
                if(point[index]+index<point[curcent]+curcent){
                    index = curcent;
                }
                if(longleng<point[curcent]){
                    longleng = point[curcent];
                    longcent = curcent;
                }
                curcent++;
            }
            return s.substring(longcent/2-(longleng-1)/2, longcent/2+longleng/2);
        }else{
            return s;
        }
    }
    
    public char[] Join(String s, char deli){
        if(s==null||s.length()==0)return null;
        StringBuffer sb = new StringBuffer();
        char[] cs = s.toCharArray();
        sb.append(deli);
        for(char c:cs){
            sb.append(c);
            sb.append(deli);
        }
        return sb.toString().toCharArray();
    }
    
    public void solve(){
        sc = new Scanner(System.in);
        // below is related to concrete problems
        int T = sc.nextInt();
        sc.nextLine();//jump over the first line. 
        for(int i=1;i<=T;i++){
            solve(sc);
        }
    }
    
    public static void main(String[] args){
        Solution so = new Solution();
        so.debug();
        //so.noDebug("2");
        so.solve();
    }
}