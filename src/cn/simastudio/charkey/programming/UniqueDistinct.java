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

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Created by Charkey on 12/27/2016.</p>
 */
public class UniqueDistinct {

    public static void main(String[] args) {
        int[] a1 = {1, 3, 3, 5, 6, 6};
        int[] a2 = {2, 2, 5, 6, 7, 8, 9, 9};
        int l1 = a1.length;
        int l2 = a2.length;
        int p1 = 0;
        int p2 = 0;

        List<Integer> uniqueA = new ArrayList<>();
        List<Integer> uniqueB = new ArrayList<>();
        List<Integer> bothAB = new ArrayList<>();

        while (p1 < l1 && p2 < l2) {
            if (a1[p1] < a2[p2]) {
                if (!bothAB.contains(a1[p1])) {
                    uniqueA.add(a1[p1]);
                }
                p1++;
            } else if (a1[p1] == a2[p2]) {
                if (!bothAB.contains(a1[p1])) {
                    bothAB.add(a1[p1]);
                }
                p1++;
                p2++;
            } else {
                if (!bothAB.contains(a2[p2])) {
                    uniqueB.add(a2[p2]);
                }
                p2++;
            }
        }
        for (; p1 < l1; p1++) {
            if (!bothAB.contains(a1[p1])) {
                uniqueA.add(a1[p1]);
            }
        }
        for (; p2 < l2; p2++) {
            if (!bothAB.contains(a2[p2])) {
                uniqueB.add(a2[p2]);
            }
        }
        System.out.println("A:" + uniqueA.toString());
        System.out.println("B:" + uniqueB.toString());
        System.out.println("AB:" + bothAB.toString());
    }

}
