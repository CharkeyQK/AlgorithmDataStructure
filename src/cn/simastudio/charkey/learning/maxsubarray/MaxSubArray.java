/*
 * Copyright (c) 2013-2016 Charkey. All rights reserved.
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

package cn.simastudio.charkey.learning.maxsubarray;

/**
 * Created by Qikai on 2016/7/21.
 */
public class MaxSubArray {

    public static void main(String[] args) {
        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(method1(nums));

        int sum = 0;
        for (int i : nums) {
            sum += nums[i];
        }
        int start = 0;
        int end = nums.length - 1;
        for (; start < nums.length & start < end; ) {
            if (sum - nums[start] > sum - nums[end]) {

            }
        }
    }

    private static int method1(int[] nums) {
        int size = nums.length;
        int ans = -1000000000;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                int sum = 0;
                for (int k = i; k < j; k++) {
                    sum += nums[k];
                }
                if (sum > ans) {
                    ans = sum;
                }
            }
        }
        return ans;
    }

}
