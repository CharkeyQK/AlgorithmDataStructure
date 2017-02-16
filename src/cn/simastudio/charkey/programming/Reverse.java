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
 * Created by Charkey on 12/26/2016.
 */
public class Reverse {

    public static void reverse(int[] array, int begin, int end) {
        while (begin < end) {
            int temp = array[begin];
            array[begin] = array[end];
            array[end] = temp;

            begin++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] array = {1,2,3,4,5};
        reverse(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));;
    }

}
