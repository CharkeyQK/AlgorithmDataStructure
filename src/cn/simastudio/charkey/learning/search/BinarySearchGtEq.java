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

import java.util.Arrays;

/**
 * <p>Created by Charkey on 2016/8/4.</p>
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
