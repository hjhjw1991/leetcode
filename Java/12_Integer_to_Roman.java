public class Solution {
    public String intToRoman(int num) {
        if(num==0)
            return "";
        HashMap<Integer, String> itor = new HashMap<Integer, String>(){
            {
                put(1, "I");
                put(5, "V");
                put(10, "X");
                put(50, "L");
                put(100, "C");
                put(500, "D");
                put(1000, "M");
            }
        };// map. Do not forget the semicolon
        int dig=-1;
        StringBuffer res = new StringBuffer();
        int rem;
        while(num!=0){
            rem = num % 10;
            num /= 10;
            dig += 1;
            if(rem < 4){
                String s = itor.get((int)Math.pow(10, dig));// Math.pow() returns a double result, must be cast to int.
                for(int i=0;i<rem;i++){
                    res.append(s);
                }
            }else if(rem == 4){
                res.append(itor.get(5*(int)Math.pow(10, dig)));
                res.append(itor.get((int)Math.pow(10, dig)));
            }else if(rem < 9){
                String s = itor.get((int)Math.pow(10, dig));
                rem-=5;
                for(int i=0;i<rem;i++){
                    res.append(s);
                }
                res.append(itor.get(5*(int)Math.pow(10, dig)));
            }else{
                res.append(itor.get((int)Math.pow(10, dig+1)));
                res.append(itor.get((int)Math.pow(10, dig)));
            }
        }
        return res.reverse().toString();
    }
}