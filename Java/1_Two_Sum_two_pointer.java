/**
Given an array of integers, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

You may assume that each input would have exactly one solution.

Input: numbers={2, 7, 11, 15}, target=9
Output: index1=1, index2=2
*/
//~356ms
public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        HashMap<Integer, ArrayList<Integer>> map=new HashMap<Integer, ArrayList<Integer>>();
        ArrayList<Integer> list;
        for(int i=0;i<numbers.length;i++){
            if(map.containsKey(numbers[i])){
                list=map.get(numbers[i]);
                list.add(i);
                map.put(numbers[i], list);
            }else{
                list=new ArrayList<Integer>();
                list.add(i);
                map.put(numbers[i],list);
            }
        }
        int[] result=new int[]{-1,-1};
        Arrays.sort(numbers);
    	int left=0,right=numbers.length-1;
    	while(left<right){
    	    if(numbers[left]+numbers[right]<target){
    	        left++;
    	    }else if(numbers[left]+numbers[right]>target){
    	        right--;
    	    }else{
    	        break;
    	    }
    	}
    	result[0]=map.get(numbers[left]).get(0)+1;
    	if(numbers[left]==numbers[right]){
    	    result[1]=map.get(numbers[right]).get(1)+1;
    	}else{
    	    result[1]=map.get(numbers[right]).get(0)+1;
    	}
    	if(result[0]>result[1]){
    	    left=result[0];
    	    result[0]=result[1];
    	    result[1]=left;
    	}
    	return result;
    }
}