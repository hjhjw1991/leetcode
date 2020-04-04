/*
给定一个无序的数组 nums，将它重新排列成 nums[0] < nums[1] > nums[2] < nums[3]... 的顺序。

示例 1:

输入: nums = [1, 5, 1, 1, 6, 4]
输出: 一个可能的答案是 [1, 4, 1, 5, 1, 6]
示例 2:

输入: nums = [1, 3, 2, 2, 3, 1]
输出: 一个可能的答案是 [2, 3, 1, 3, 1, 2]
说明:
你可以假设所有输入都会得到有效的结果。

进阶:
你能用 O(n) 时间复杂度和 / 或原地 O(1) 额外空间来实现吗？

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/wiggle-sort-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/
class Solution {
    public void wiggleSort(int[] nums) {
        if(nums == null || nums.length <= 1) {
            return;
        }
        sortAndFill(nums);
        // three_way_partition(nums);
    }
    
    public void sortAndFill(int[] nums) {
        // 排序, 然后找到中位数, 以中位数为分割将数组分成小的和大的两部分
        // 分别填到原数组的奇数和偶数位置
        Arrays.sort(nums);
        int mid = (nums.length-1)/2;
        int[] tmp = new int[nums.length];
        int j=mid, k=0;
        for(int i=nums.length-1;i>mid && j>=0;i--, j--) {
            tmp[k++] = nums[j];
            tmp[k++] = nums[i];
        }
        if (j==0) {
            // 奇数个, 需要单独处理
            tmp[k] = nums[j];
        }
        for(int i=0;i<nums.length;i++) {
            nums[i] = tmp[i];
        }
    }
    
    public void three_way_partition(int[] nums) {
        // 将下标重新映射为[奇数, 偶数]两部分后进行3路划分
        // 基本思想跟排序划分相同, 但无需排序, 可以借鉴快排的过程来理解
        // 快排是将值交换到标兵的两侧, 3路划分则是将值交换到中位数的两侧
        // 对于偶数和奇数数量的数组需要区分
        // 相较而言还是排序好理解
        int mid = quickSelect(nums, 0, nums.length-1, (nums.length+1)/2);
        int i=0, j=0, k, length = nums.length, tmp;
        k = length-1;
        // Java里做重映射比较麻烦
        // 这里还是复制数组
        int[] tmparray = Arrays.copyOf(nums, length);

        // 对复制的数组进行三路划分, [small, equal, big]
        while(j <= k) {
            if(tmparray[j] < mid) {
                {
                    tmp = tmparray[j];
                    tmparray[j] = tmparray[i];
                    tmparray[i] = tmp;
                }
                i++;
                j++;
            } else if (tmparray[j] > mid) {
                {
                    tmp = tmparray[j];
                    tmparray[j] = tmparray[k];
                    tmparray[k] = tmp;
                }
                k--;
            } else {
                j++;
            }
        }
        
        // 将三路划分后的数组填回原数组
        for(k=length-1, j=(length-1)/2, i=0; k>(length-1) / 2 && j>=0; k--, j--) {
            nums[i++] = tmparray[j];
            nums[i++] = tmparray[k];
        }
        if (j == 0) {
            nums[i] = tmparray[j];
        }
    }
    
    public int quickSelect(int[] nums, int start, int end, int k) {
        // 快速选择, 原理与快速排序相似, 可以用于查找未排序数组内第K大的数
        // 选择一个标兵, 按快速排序方式运行一轮, 如果标兵左边数量大于K则结果在左边, 假设左边大, 否则查找右边第K-i大的数
        if (start == end && k == 1) {
            return nums[start];
        }
        int pivot = nums[start];
        int oldStart = start, oldEnd = end;
        while(start < end) {
            while(start < end && nums[end] <= pivot) {
                end--;
            }
            if(start < end) {
                nums[start] = nums[end];
                start++;
            }
            while(start < end && nums[start] > pivot) {
                start++;
            }
            if(start < end) {
                nums[end] = nums[start];
                end--;
            }
        }
        nums[start] = pivot;
        
        if (start-oldStart==k-1) {
            return pivot;
        } else if (start-oldStart > k-1) {
            return quickSelect(nums, oldStart, start, k);
        } else {
            return quickSelect(nums, start+1, oldEnd, k-(start-oldStart+1));
        }
    }
}