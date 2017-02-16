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
 * 选择排序
 *
 1. 选择排序需要花费 (N – 1) + (N – 2) + ... + 1 + 0 = N(N- 1) / 2 ~ N2/2次比较 和 N-1次交换操作。
 2. 对初始数据不敏感，不管初始的数据有没有排好序，都需要经历N2/2次比较，这对于一些原本排好序，或者近似排好序的序列来说并不具有优势。在最好的情况下，即所有的排好序，需要0次交换，最差的情况，倒序，需要N-1次交换。
 3. 数据交换的次数较少，如果某个元素位于正确的最终位置上，则它不会被移动。在最差情况下也只需要进行N-1次数据交换，在所有的完全依靠交换去移动元素的排序方法中，选择排序属于比较好的一种。
 * Created by Charkey on 12/26/2016.
 */
public class SelectionSort {

    public static void swap(int[] array, int start, int end) {
        System.out.println("SWAP...");
        int temp = array[start];
        array[start] = array[end];
        array[end] = temp;
    }

    public static void sort(int[] array) {
        int cnt = array.length;
        for (int i = 0; i < cnt; i++) {
            // 假设当前 i 位置的元素就是最小
            int min = i;
            // 从第 i+1 个元素开始查找
            for (int j = i + 1; j < cnt; j++) {
                // 第 i+1 个元素 小于 当前最小元素，更新 最小元素索引 min
                if (array[j] < array[min]) {
                    min = j;
                }
            }
            // 交换
            if (i != min) {
                swap(array, i, min);
            }
        }
    }

    public static void main(String[] args) {
        int[] array = { 1, 3, 1, 4, 2, 4, 2, 3, 2, 4, 7, 6, 6, 7, 5, 5, 7, 7 };
        sort(array);
        System.out.println(Arrays.toString(array));;
    }

}
