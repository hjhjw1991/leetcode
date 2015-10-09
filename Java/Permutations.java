import java.util.*;

public class Solution extends Test{
    // 对于任意26位以内的，以字母表示的无重复字母的字典序全排列
    // 本代码根据序号计算对应排列，或者根据排列计算对应序号
    
    // 根据序号算排列
    public static String findPermutationByIndex(int index, int len){
        char[] perms = new char[len];
        ArrayList<Character> valid = new ArrayList<Character>();
        int[] fact = new int[len+1];
        fact[0]=1;
        for(int i=0;i<len;i++){
            valid.add((char)('a'+i));
            fact[i+1]=fact[i]*(i+1);
        }
        index--;// 从0开始计数
        // 从最高位到最低位依次计算应该填哪个字母
        for(int i=len-1;i>=0;i--){
            int minus = index/fact[i];// 若序号大于当前位置右边所有位置的全排列，假设包含minus个
            index = index%fact[i];
            perms[len-i-1]=valid.remove(minus);// 则填写序号所包含的右边全排列的个数，即当前应该填剩余字母中第minus大的字母
        }
        return new String(perms);
    }
    
    // 根据排列算序号
    // index is less than 2147483648
    // 注意当位数很长时int型会溢出，需要提升数据类型
    public static int findIndexByPermutation(String perm){
        char[] perms = perm.toCharArray();
        int len = perms.length;
        LinkedList<Character> valid = new LinkedList<Character>();
        int[] fact = new int[len+1];
        fact[0]=1;
        for(int i=0;i<len;i++){
            valid.add((char)('a'+i));
            fact[i+1]=fact[i]*(i+1);
        }
        int minus;
        int index = 1;// 输出从1开始计数
        for(int i=0;i<len;i++){
            minus = valid.indexOf((Character)perms[i]);// 注意这里，是计算当前字母在剩余字母中第几大，设第minus大
            valid.remove((Character)perms[i]);// 移除当前字母
            index += minus*(fact[valid.size()]);// 序号加上minus个剩余字母全排列
        }
        return index;
    }
    
    protected void solve(Scanner sc){
        // mode 1 findPermutationByIndex
        // mode 2 findIndexByPermutation
        // 测试文件在Permutations.in，对照文件在Permutations.out
        int mode = sc.nextInt();
        switch(mode){
            case 1:
                int index = sc.nextInt();
                int len = sc.nextInt();
                System.out.println(index + " " + findPermutationByIndex(index, len));
                break;
            case 2:
                String perm = sc.next();
                System.out.println(perm + " " + findIndexByPermutation(perm));
                break;
        }
    }
    
    public void solve(){
        sc = new Scanner(System.in);
        // below is related to concrete problems
        int T = sc.nextInt();
        //sc.nextLine();//jump over the first line. 
        for(int i=1;i<=T;i++){
            System.out.printf("Case #%d:\n", i);
            solve(sc);
        }
    }
    
    public static void main(String[] args){
        Solution so = new Solution();
        so.debug();
        //so.noDebug("Permutations");
        so.solve();
    }
}