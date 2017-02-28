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

package cn.simastudio.charkey.codinginterview;

import cn.simastudio.charkey.learning.search.BinarySearch;

/**
 * <p>Created by Charkey on 2016/8/5.</p>
 */
public class FindInMatrix {

    public boolean find(int[][] array, int target) {
        if (array == null || array[0].length == 0) {
            return false;
        }
        int h = array.length;
        int w = array[0].length;

        boolean isFind = false;
        for (int i = 0; i < h; i++) {
            int res = new BinarySearch().binarySearch2(array[i], 0, array[i].length - 1, target);
            if (res != -1) {
                isFind = true;
            }
        }
        return isFind;
    }

    public boolean find2(int[][] array, int target) {
        if (array == null || array[0].length == 0) {
            return false;
        }
        // array[y][x]
        int h = array.length;
        int w = array[0].length;
        int x = 0;
        int y = h - 1;
        while (x < w && y >= 0) {
            if (target > array[y][x]) {
                x++;
            } else if (target < array[y][x]) {
                y--;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] array = {{1, 2, 3, 4}, {2, 3, 4, 5}, {3, 4, 5, 6}};
        System.out.println(new FindInMatrix().find(array, 7));
        System.out.println(new FindInMatrix().find2(array, 7));
    }
}
