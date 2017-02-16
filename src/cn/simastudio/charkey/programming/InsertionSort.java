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

import java.util.Arrays;

/**
 * 1. 插入排序平均需要N2/4次比较和N2/4 次交换。在最坏的情况下需要N2/2 次比较和交换；在最好的情况下只需要N-1次比较和0次交换。
 * 2. 插入排序中，元素交换的次数等于序列中逆序元素的对数。元素比较的次数最少为元素逆序元素的对数，最多为元素逆序的对数 加上数组的个数减1。
 3.总体来说，插入排序对于部分有序序列以及元素个数比较小的序列是一种比较有效的方式。
 对于部分有序数组，插入排序是比较有效的。当数组中逆元素的对数越低，插入排序要比其他排序方法要高效的多。
 * Created by Charkey on 12/26/2016.
 */
public class InsertionSort {

    public static void swap(int[] array, int start, int end) {
        System.out.println("SWAP...");
        int temp = array[start];
        array[start] = array[end];
        array[end] = temp;
    }

    public static void sort(int[] array) {
        int cnt = array.length;
        // 从第2个元素开始
        for (int i = 1; i < cnt; i++) {
            // 未排序的，从后往前扫
            for (int j = i; j > 0; j--) {
                // 如果后面的元素小于前一个，交换
                if (array[j] < array[j - 1]) {
                    swap(array, j, j-1);
                } else {
                    // 如果后面的元素已经大于前面已经排好序的最后一个，就不用再继续往前比较了
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] array = { 1, 3, 1, 4, 2, 4, 2, 3, 2, 4, 7, 6, 6, 7, 5, 5, 7, 7 };
        sort(array);
        System.out.println(Arrays.toString(array));;
    }

}
