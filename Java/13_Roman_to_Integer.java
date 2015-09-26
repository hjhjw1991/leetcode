public class Solution {
    public int romanToInt(String s) {
        if(s==null || s.length()==0){
            return 0;
        }
        char[] digits = s.toCharArray();
        int res=0, i=digits.length-1;
        char last='.';
        while(i>=0){
            switch(digits[i]){
                case 'I':
                    if(last!='.'&&(last=='V'||last=='X')){// there are two cases in total that we should substract the current digit.
                        res -= 1;
                    }else{
                        res += 1;
                    }
                    break;
                case 'V':
                    res += 5;
                    break;
                case 'X':
                    if(last!='.'&&last=='L'||last=='C'){// there are two cases in total that we should substract the current digit.
                        res -= 10;
                    }else{
                        res += 10;
                    }
                    break;
                case 'L':
                    res += 50;
                    break;
                case 'C':
                    if(last!='.'&&last=='D'||last=='M'){// there are two cases in total that we should substract the current digit.
                        res -= 100;
                    }else{
                        res += 100;
                    }
                    break;
                case 'D':
                    res += 500;
                    break;
                case 'M':
                    res += 1000;
                    break;
            }
            last = digits[i--];
        }
        return res;
    }
}