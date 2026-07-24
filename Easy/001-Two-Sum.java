/*
Problem: 1. Two Sum

Difficulty: Easy

Approach:
1. Use two nested loops.
2. Check every pair of elements.
3. If their sum equals the target,
   return their indices.

Time Complexity: O(n²)

Space Complexity: O(1)
*/

class Solution {

    public int[] twoSum(int[] nums, int target) {

        int[] ans = new int[2];

        int n = nums.length;

        for(int i = 0; i < n; i++) {

            for(int j = i + 1; j < n; j++) {

                if(nums[i] + nums[j] == target) {

                    ans[0] = i;
                    ans[1] = j;

                    return ans;
                }

            }

        }

        return ans;
    }
}