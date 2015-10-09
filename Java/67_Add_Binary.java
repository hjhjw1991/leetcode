public class Solution {
    public String addBinary(String a, String b) {
        char[] sa = a.toCharArray();
        char[] sb = b.toCharArray();
        if(sa.length==0||sb.length==0)return sa.length==0?b:a;
        int lena = sa.length, lenb = sb.length;
        int c = 0,i=0;
        char[] sc = new char[lena>lenb? lena+1:lenb+1];
        int lenc = sc.length;
        int[] digits = new int[lenc];
        while(i<lena&&i<lenb){
            digits[lenc-1-i]=sa[lena-1-i]-'0'+sb[lenb-1-i]-'0'+c;
            c=digits[lenc-1-i]/2;
            digits[lenc-1-i]=digits[lenc-1-i]%2;
            i++;
        }
        while(i<lena){
            digits[lenc-1-i]=sa[lena-1-i]-'0'+c;
            c=digits[lenc-1-i]/2;
            digits[lenc-1-i]=digits[lenc-1-i]%2;
            i++;
        }
        while(i<lenb){
            digits[lenc-1-i]=sb[lenb-1-i]-'0'+c;
            c=digits[lenc-1-i]/2;
            digits[lenc-1-i]=digits[lenc-1-i]%2;
            i++;
        }
        digits[0]=c;// 注意是从右到左倒着填结果
        for(i=0;i<lenc;i++){
            sc[i]=(char)('0'+digits[i]);
        }
        String res = new String(sc);
        return c>0?res:res.substring(1);
    }
}