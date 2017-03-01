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

package cn.simastudio.charkey.leetcode.$_496_next_greater_element_i;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * <p>Created by Charkey on 3/1/2017.</p>
 */
public class NextGreaterElementI_1 {

    public int[] nextGreaterElement(int[] findNums, int[] nums) {
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> mapping = new HashMap<>();
        for (int cur : nums) {
            while (!stack.isEmpty() && stack.peek() < cur) {
                mapping.put(stack.pop(), cur);
            }
            stack.push(cur);
        }
        for (int r = 0; r < findNums.length; r++) {
            findNums[r] = mapping.getOrDefault(findNums[r], -1);
        }
        return findNums;
    }

    public static void main(String[] args) {
        NextGreaterElementI nextGreaterElementI = new NextGreaterElementI();
        System.out.println(Arrays.toString(nextGreaterElementI.nextGreaterElement(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2})));
        System.out.println(Arrays.toString(nextGreaterElementI.nextGreaterElement(new int[]{2, 4}, new int[]{1, 2, 3, 4})));
    }
}
