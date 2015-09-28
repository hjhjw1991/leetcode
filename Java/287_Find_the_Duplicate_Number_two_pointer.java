public class Solution {
    public int findDuplicate(int[] nums) {
        // regard nums as a linked list
        // the index is pointing to the next node
        // if there are duplicates
        // that means more than 1 nodes are pointing to the same node
        // which is a loop in the linked list
        // so just find the loop.
        // and the start point of this loop is that duplicated number.
        int slow=0,faster=0;
        while(true){
            slow=nums[slow];
            faster=nums[nums[faster]];
            if(slow==faster){
                break;
            }
        }
        int find=0;
        while(true){
            slow=nums[slow];
            find=nums[find];
            if(slow==find){
                return find;
            }
        }
    }
}