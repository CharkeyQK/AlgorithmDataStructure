/*
 * Copyright (c) 2013-2016 Charkey. All rights reserved.
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

package cn.simastudio.charkey.learning.simulatestack;

/**
 * Recursion to Stack, 防止栈溢出
 * Created by Qikai on 2016/7/22.
 */
public class SimulateSysStack {

    private static int recursion1(int n) {
        if (n <= 1) {
            return 1;
        } else {
            return n * recursion1(n - 1);
        }
    }

    private static int recursion2(int n) {
        boolean back = false;
        int res = 1;
        int[] stack = new int[n];
        int front = -1;
        do {
            if (!back) {
                if (n <= 1) {
                    res = 1;
                    back = true;
                    continue;
                }
                stack[++front] = n--;
            } else {
                res *= stack[front--];
            }
        } while (front >= 0);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(recursion1(10));
        System.out.println(recursion2(10));
    }
}
