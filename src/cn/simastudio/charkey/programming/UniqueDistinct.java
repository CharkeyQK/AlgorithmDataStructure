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

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Charkey on 12/27/2016.
 */
public class UniqueDistinct {

    public static void main(String[] args) {
        int[] a1 = {1,3,3,5,6,6};
        int[] a2 = {2,2,5,6,7,8,9,9};
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
        for (;p1 < l1; p1++) {
            if (!bothAB.contains(a1[p1])) {
                uniqueA.add(a1[p1]);
            }
        }
        for (;p2 < l2; p2++) {
            if (!bothAB.contains(a2[p2])) {
                uniqueB.add(a2[p2]);
            }
        }
        System.out.println("A:"+uniqueA.toString());
        System.out.println("B:"+uniqueB.toString());
        System.out.println("AB:"+bothAB.toString());
    }

}
