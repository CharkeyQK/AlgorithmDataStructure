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

package cn.simastudio.charkey.codinginterview;

import cn.simastudio.charkey.learning.search.BinarySearch;

/**
 * Created by Qikai on 2016/8/5.
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
        while (x<w && y >=0) {
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
        int[][] array = {{1,2,3,4},{2,3,4,5},{3,4,5,6}};
        System.out.println(new FindInMatrix().find(array, 7));
        System.out.println(new FindInMatrix().find2(array, 7));
    }
}
