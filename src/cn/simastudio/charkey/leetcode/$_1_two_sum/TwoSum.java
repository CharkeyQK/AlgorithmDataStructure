/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2013-2017 Charkey.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package cn.simastudio.charkey.leetcode.$_1_two_sum;

import java.util.Arrays;

/**
 * <p>Created by Charkey on 2/28/2017.</p>
 * <b>注意数组非有序、数组排序后新旧位置的映射、数组中出现相同数组的情况</b>
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

        nums = new int[]{3, 2, 4};
        target = 6;
        System.out.println(Arrays.toString(twoSum.twoSum(nums, target)));

        nums = new int[]{3, 3};
        target = 6;
        System.out.println(Arrays.toString(twoSum.twoSum(nums, target)));
    }
}
