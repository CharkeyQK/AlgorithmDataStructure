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

package cn.simastudio.charkey.programming;

/**
 * Created by Charkey on 12/26/2016.
 */
public class QuickSort {

    public static int partition(int[] array, int low, int high) {
        int i = low, j = high + 1;
        while (true) {

            // 从左到右扫描，如果碰到比基准元素 array[low] 小，则该元素已经在正确的分区，i++，否则break，准备交换
            while (array[++i] < array[low]) {
                if (i == high) break;
            }

            // 从右向左扫描，如果碰到比基准元素 array[high] 大，则该元素已经在正确的分区，j--，否则break，准备交换
            while (array[--j] > array[high]) {
                if (j == low) break;
            }

            if (i >= j) break;

            swap(array, i, j);
        }
        // 经过相遇后，最后一次 array[i] array[j] 交换
        // array[j] < array[low]；array[i] > array[low]，所以基准元素和 array[j] 交换
        swap(array, low, j);
        return j;
    }

    public static void swap(int[] array, int start, int end) {
        System.out.println("SWAP...");
        int temp = array[start];
        array[start] = array[end];
        array[end] = temp;
    }

    public static void main(String[] args) {
        int[] array = {9,0,8,10,-5,2,13,7};
        System.out.println(partition(array, 0, array.length-1));
    }

}
