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

package cn.simastudio.charkey.learning.search;

/**
 * <p>Created by Charkey on 2016/8/4.</p>
 */
public class BinarySearch {

    /**
     * return the index of value
     * If not exists, return -1;
     *
     * @param array array
     * @param start start index
     * @param end   end index
     * @param value expected value to be search
     * @return index of the value
     */
    public int binarySearch(int[] array, int start, int end, int value) {
        int binaryIndex = (start + end) / 2;
        //int binaryIndex2 = start + (end - start) / 2;
        // 这个即使待查找的数不在数组最小值和最大值范围内，也需要进行几次二分查找
        if (start > array.length || end > array.length || start > end) {
            return -1;
        }
        if (array[binaryIndex] < value) {
            return binarySearch(array, binaryIndex + 1, end, value);
        } else if (array[binaryIndex] > value) {
            return binarySearch(array, start, binaryIndex - 1, value);
        } else {
            return binaryIndex;
        }
    }

    /**
     * return the index of value
     * If not exists, return -1;
     *
     * @param array array
     * @param start start index
     * @param end   end index
     * @param value expected value to be search
     * @return index of the value
     */
    public int binarySearch2(int[] array, int start, int end, int value) {
        int binaryIndex = (start + end) / 2;
        //int binaryIndex2 = start + (end - start) / 2;
        // 更为高效，先判断待查找的数是否不在数组最小值和最大值范围内
        if (value < array[start] || value > array[end] || end < start) {
            return -1;
        }
        if (array[binaryIndex] < value) {
            return binarySearch2(array, binaryIndex + 1, end, value);
        } else if (array[binaryIndex] > value) {
            return binarySearch2(array, start, binaryIndex - 1, value);
        } else {
            return binaryIndex;
        }
    }

    public int binarySearch3(int[] array, int start, int end, int value) {
        int binaryIndex = 0;
        while (start <= end) {
            binaryIndex = (start + end) / 2;
            if (array[binaryIndex] < value) {
                start = binaryIndex + 1;
            } else if (array[binaryIndex] > value) {
                end = binaryIndex - 1;
            } else {
                return binaryIndex;
            }
        }
        if (end < start) {
            return -1;
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 4, 5, 6, 7, 9, 10, 11};
        System.out.print(new BinarySearch().binarySearch(array, 0, array.length - 1, 0) + " ");
        System.out.print(new BinarySearch().binarySearch(array, 0, array.length - 1, 1) + " ");
        System.out.print(new BinarySearch().binarySearch(array, 0, array.length - 1, 2) + " ");
        System.out.print(new BinarySearch().binarySearch(array, 0, array.length - 1, 3) + " ");
        System.out.print(new BinarySearch().binarySearch(array, 0, array.length - 1, 4) + " ");
        System.out.print(new BinarySearch().binarySearch(array, 0, array.length - 1, 5) + " ");
        System.out.print(new BinarySearch().binarySearch(array, 0, array.length - 1, 6) + " ");
        System.out.print(new BinarySearch().binarySearch(array, 0, array.length - 1, 7) + " ");
        System.out.print(new BinarySearch().binarySearch(array, 0, array.length - 1, 8) + " ");
        System.out.print(new BinarySearch().binarySearch(array, 0, array.length - 1, 9) + " ");
        System.out.print(new BinarySearch().binarySearch(array, 0, array.length - 1, 10) + " ");
        System.out.print(new BinarySearch().binarySearch(array, 0, array.length - 1, 11) + " ");
        System.out.print(new BinarySearch().binarySearch(array, 0, array.length - 1, 12) + " ");
        System.out.println(new BinarySearch().binarySearch(array, 0, array.length - 1, 13));

        System.out.print(new BinarySearch().binarySearch2(array, 0, array.length - 1, 0) + " ");
        System.out.print(new BinarySearch().binarySearch2(array, 0, array.length - 1, 1) + " ");
        System.out.print(new BinarySearch().binarySearch2(array, 0, array.length - 1, 2) + " ");
        System.out.print(new BinarySearch().binarySearch2(array, 0, array.length - 1, 3) + " ");
        System.out.print(new BinarySearch().binarySearch2(array, 0, array.length - 1, 4) + " ");
        System.out.print(new BinarySearch().binarySearch2(array, 0, array.length - 1, 5) + " ");
        System.out.print(new BinarySearch().binarySearch2(array, 0, array.length - 1, 6) + " ");
        System.out.print(new BinarySearch().binarySearch2(array, 0, array.length - 1, 7) + " ");
        System.out.print(new BinarySearch().binarySearch2(array, 0, array.length - 1, 8) + " ");
        System.out.print(new BinarySearch().binarySearch2(array, 0, array.length - 1, 9) + " ");
        System.out.print(new BinarySearch().binarySearch2(array, 0, array.length - 1, 10) + " ");
        System.out.print(new BinarySearch().binarySearch2(array, 0, array.length - 1, 11) + " ");
        System.out.print(new BinarySearch().binarySearch2(array, 0, array.length - 1, 12) + " ");
        System.out.println(new BinarySearch().binarySearch2(array, 0, array.length - 1, 13));

        System.out.print(new BinarySearch().binarySearch3(array, 0, array.length - 1, 0) + " ");
        System.out.print(new BinarySearch().binarySearch3(array, 0, array.length - 1, 1) + " ");
        System.out.print(new BinarySearch().binarySearch3(array, 0, array.length - 1, 2) + " ");
        System.out.print(new BinarySearch().binarySearch3(array, 0, array.length - 1, 3) + " ");
        System.out.print(new BinarySearch().binarySearch3(array, 0, array.length - 1, 4) + " ");
        System.out.print(new BinarySearch().binarySearch3(array, 0, array.length - 1, 5) + " ");
        System.out.print(new BinarySearch().binarySearch3(array, 0, array.length - 1, 6) + " ");
        System.out.print(new BinarySearch().binarySearch3(array, 0, array.length - 1, 7) + " ");
        System.out.print(new BinarySearch().binarySearch3(array, 0, array.length - 1, 8) + " ");
        System.out.print(new BinarySearch().binarySearch3(array, 0, array.length - 1, 9) + " ");
        System.out.print(new BinarySearch().binarySearch3(array, 0, array.length - 1, 10) + " ");
        System.out.print(new BinarySearch().binarySearch3(array, 0, array.length - 1, 11) + " ");
        System.out.print(new BinarySearch().binarySearch3(array, 0, array.length - 1, 12) + " ");
        System.out.println(new BinarySearch().binarySearch3(array, 0, array.length - 1, 13));
    }
}
