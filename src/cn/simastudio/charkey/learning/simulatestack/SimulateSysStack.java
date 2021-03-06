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

package cn.simastudio.charkey.learning.simulatestack;

/**
 * <p>Recursion to Stack, 防止栈溢出</p>
 * <p>Created by Charkey on 2016/7/22.</p>
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
