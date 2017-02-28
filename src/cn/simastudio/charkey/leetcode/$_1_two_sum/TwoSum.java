/*
 * Copyright (c) 2013-2015 Charkey. All rights reserved.
 *
 * This software is the confidential and proprietary information of Charkey.
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Charkey.
 *
 * Charkey MAKES NO REPRESENTATIONS OR WARRANTIES ABOUT THE SUITABILITY OF THE SOFTWARE,
 * EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE, OR NON-INFRINGEMENT.
 *
 * Charkey SHALL NOT BE LIABLE FOR ANY DAMAGES SUFFERED BY LICENSEE AS A RESULT OF USING,
 * MODIFYING OR DISTRIBUTING THIS SOFTWARE OR ITS DERIVATIVES.
 */

package cn.simastudio.charkey.leetcode.$_1_two_sum;

import java.util.Arrays;

/**
 * Created by Charkey on 2/28/2017.
 * 注意数组非有序、数组排序后新旧位置的映射、数组中出现相同数组的情况
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        // NOTE: leetcode 需要自己 import 需要的类
        int[] newNums = new int[nums.length];
        System.arraycopy(nums, 0, newNums, 0, newNums.length);
        Arrays.sort(newNums);
        int i = 0, j = newNums.length - 1;
        for (; i < j; ) {
            int sum = newNums[i] + newNums[j];
            // 两数和等于目标值
            if (sum == target) {
                int[] result = new int[2];
                int t = 0;
                for (int k = 0; k < nums.length; k++) {
                    if (nums[k] == newNums[i]) {
                        result[t++] = k;
                    } else if (nums[k] == newNums[j]) {
                        result[t++] = k;
                    }
                }
                return result;
            } else if (sum > target) {
                // 两数和大于目标值，因为数组已从小到大排序，所以 j--
                j--;
            } else if (sum < target) {
                // 两数和小于目标值，因为数组已从小到大排序，所以 i++
                i++;
            }
        }
        return new int[2];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;
        TwoSum twoSum = new TwoSum();
        System.out.println(Arrays.toString(twoSum.twoSum(nums, target)));

        nums = new int[]{3,2,4};
        target = 6;
        System.out.println(Arrays.toString(twoSum.twoSum(nums, target)));

        nums = new int[]{3,3};
        target = 6;
        System.out.println(Arrays.toString(twoSum.twoSum(nums, target)));
    }
}
