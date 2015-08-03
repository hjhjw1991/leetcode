public class Solution {
    public int findMin(int[] num) {
         int begin = 0;  
            int end = num.length - 1;  
            int mid = begin;  
            while(begin <= end && num[begin] >= num[end]) {  
                if(begin == end)  
                  return num[begin];  
                mid = (begin + end) >> 1;  
                if(num[mid] > num[begin])  
                  begin = mid + 1;  
                else if(num[mid] < num[begin]) {  
                    begin++;  
                    end = mid;  
                } else {  
                    if(num[mid] > num[end])   
                      begin = mid + 1;  
                    else {  
                        int minVal = num[begin];  
                        for(int i = begin + 1; i <= end; i++) {  
                            if(minVal > num[i])  
                              minVal = num[i];  
                        }  
                        return minVal;  
                    }  
                }  
                if(num[begin] < num[end])  
                  return num[begin];  
            }  
            return num[mid];  
        }
}