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

package cn.simastudio.charkey.leetcode.$_500_keyboard_row;

import java.util.*;

/**
 * <p>Created by Charkey on 3/1/2017.</p>
 */
public class KeyboardRow {

    public String[] findWords(String[] words) {
        Set<String> rowOne = new HashSet<>();
        rowOne.add("Q");
        rowOne.add("W");
        rowOne.add("E");
        rowOne.add("R");
        rowOne.add("T");
        rowOne.add("Y");
        rowOne.add("U");
        rowOne.add("I");
        rowOne.add("O");
        rowOne.add("P");
        Set<String> rowTwo = new HashSet<>();
        rowTwo.add("A");
        rowTwo.add("S");
        rowTwo.add("D");
        rowTwo.add("F");
        rowTwo.add("G");
        rowTwo.add("H");
        rowTwo.add("J");
        rowTwo.add("K");
        rowTwo.add("L");
        Set<String> rowThree = new HashSet<>();
        rowThree.add("Z");
        rowThree.add("X");
        rowThree.add("C");
        rowThree.add("V");
        rowThree.add("B");
        rowThree.add("N");
        rowThree.add("M");

        List<String> result = new ArrayList<>();
        for (String s : words) {
            char[] charArray = s.toUpperCase().toCharArray();
            int len = charArray.length;
            int cnt = 0;
            if (rowOne.contains(String.valueOf(charArray[0]))) {
                for (char c : charArray) {
                    if (rowOne.contains(String.valueOf(c))) {
                        cnt++;
                    }
                }
            }
            if (rowTwo.contains(String.valueOf(charArray[0]))) {
                for (char c : charArray) {
                    if (rowTwo.contains(String.valueOf(c))) {
                        cnt++;
                    }
                }
            }
            if (rowThree.contains(String.valueOf(charArray[0]))) {
                for (char c : charArray) {
                    if (rowThree.contains(String.valueOf(c))) {
                        cnt++;
                    }
                }
            }
            if (cnt == len) {
                result.add(s);
            }
        }

        return result.toArray(new String[result.size()]);
    }

    public static void main(String[] args) {
        String[] inputs = new String[]{"Hello", "Alaska", "Dad", "Peace"};
        KeyboardRow keyboardRow = new KeyboardRow();
        System.out.println(Arrays.toString(keyboardRow.findWords(inputs)));
    }

}
