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

/**
 * Created by Qikai on 2016/8/4.
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
