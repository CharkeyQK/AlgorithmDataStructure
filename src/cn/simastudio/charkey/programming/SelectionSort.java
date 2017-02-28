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

package cn.simastudio.charkey.programming;

import java.util.Arrays;

/**
 * <P>选择排序</P>
 * <ul>
 * <li>选择排序需要花费 (N – 1) + (N – 2) + ... + 1 + 0 = N(N- 1) / 2 ~ N2/2次比较 和 N-1次交换操作。</li>
 * <li>对初始数据不敏感，不管初始的数据有没有排好序，都需要经历N2/2次比较，这对于一些原本排好序，或者近似排好序的序列来说并不具有优势。在最好的情况下，即所有的排好序，需要0次交换，最差的情况，倒序，需要N-1次交换。</li>
 * <li>数据交换的次数较少，如果某个元素位于正确的最终位置上，则它不会被移动。在最差情况下也只需要进行N-1次数据交换，在所有的完全依靠交换去移动元素的排序方法中，选择排序属于比较好的一种。</li>
 * </ul>
 * <p>Created by Charkey on 12/26/2016.</p>
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
        int[] array = {1, 3, 1, 4, 2, 4, 2, 3, 2, 4, 7, 6, 6, 7, 5, 5, 7, 7};
        sort(array);
        System.out.println(Arrays.toString(array));
        ;
    }

}
