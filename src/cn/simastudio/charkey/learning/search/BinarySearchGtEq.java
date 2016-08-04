/*
 * Copyright (c) 2013-2015 SimaStudio. All rights reserved.
 *
 * This software is the confidential and proprietary information of SimaStudio.
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with SimaStudio.
 *
 * SimaStudio MAKES NO REPRESENTATIONS OR WARRANTIES ABOUT THE SUITABILITY OF THE SOFTWARE,
 * EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE, OR NON-INFRINGEMENT.
 *
 * SimaStudio SHALL NOT BE LIABLE FOR ANY DAMAGES SUFFERED BY LICENSEE AS A RESULT OF USING,
 * MODIFYING OR DISTRIBUTING THIS SOFTWARE OR ITS DERIVATIVES.
 */

package cn.simastudio.charkey.learning.search;

import java.util.Arrays;

/**
 * Created by Qikai on 2016/8/4.
 */
public class BinarySearchGtEq {

    public int binarySearchGtEq(int[] array, int start, int end, int value) {
        int binaryIndex = 0;
        while (start <= end) {
            binaryIndex = (start + end) / 2;
            if (array[binaryIndex] < value) {
                start = binaryIndex + 1;
            } else if (array[binaryIndex] >= value) {
                end = binaryIndex;
            }
            if (start == end) {
                if (array[end] < value) {
                    return -1;
                } else {
                    return start;
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 4, 5, 6, 7, 9, 10, 11};
        int[] testArray = {-1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(testArray));
        System.out.println(">=-1 " + new BinarySearchGtEq().binarySearchGtEq(array, 0, array.length - 1, -1));
        System.out.println(">=0 " + new BinarySearchGtEq().binarySearchGtEq(array, 0, array.length - 1, 0));
        System.out.println(">=1 " + new BinarySearchGtEq().binarySearchGtEq(array, 0, array.length - 1, 1));
        System.out.println(">=2 " + new BinarySearchGtEq().binarySearchGtEq(array, 0, array.length - 1, 2));
        System.out.println(">=3 " + new BinarySearchGtEq().binarySearchGtEq(array, 0, array.length - 1, 3));
        System.out.println(">=4 " + new BinarySearchGtEq().binarySearchGtEq(array, 0, array.length - 1, 4));
        System.out.println(">=5 " + new BinarySearchGtEq().binarySearchGtEq(array, 0, array.length - 1, 5));
        System.out.println(">=6 " + new BinarySearchGtEq().binarySearchGtEq(array, 0, array.length - 1, 6));
        System.out.println(">=7 " + new BinarySearchGtEq().binarySearchGtEq(array, 0, array.length - 1, 7));
        System.out.println(">=8 " + new BinarySearchGtEq().binarySearchGtEq(array, 0, array.length - 1, 8));
        System.out.println(">=9 " + new BinarySearchGtEq().binarySearchGtEq(array, 0, array.length - 1, 9));
        System.out.println(">=10 " + new BinarySearchGtEq().binarySearchGtEq(array, 0, array.length - 1, 10));
        System.out.println(">=11 " + new BinarySearchGtEq().binarySearchGtEq(array, 0, array.length - 1, 11));
        System.out.println(">=12 " + new BinarySearchGtEq().binarySearchGtEq(array, 0, array.length - 1, 12));
        System.out.println(">=13 " + new BinarySearchGtEq().binarySearchGtEq(array, 0, array.length - 1, 13));
    }

}
