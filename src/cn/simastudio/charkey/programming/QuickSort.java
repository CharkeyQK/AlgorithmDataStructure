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

/**
 * <p>Created by Charkey on 12/26/2016.</p>
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
        int[] array = {9, 0, 8, 10, -5, 2, 13, 7};
        System.out.println(partition(array, 0, array.length - 1));
    }

}
