/**
Given an array of integers, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

You may assume that each input would have exactly one solution.

Input: numbers={2, 7, 11, 15}, target=9
Output: index1=1, index2=2
*/

public class Solution {
    public int[] twoSum(int[] numbers, int target) {
    	int[] result={0,0};
    	int i=0,j=0,k;
    	for(i=1;i<numbers.length;i++){
    		k=target-numbers[i];
    		for(j=0;j<i;j++){
    			if(numbers[j]==k)break;
    		}
    		if(j<i)break;
    	}
    	result[0]=j+1;
    	result[1]=i+1;
    	return result;
    }
}