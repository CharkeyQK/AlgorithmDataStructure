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

package cn.simastudio.charkey.leetcode.$_476_number_complement;

/**
 * <p>Integer.toBinaryString(num)</p>
 * <p>Math.pow(a, b)</p>
 * <p>Created by Charkey on 3/1/2017.</p>
 */
public class NumberComplement {

    public int findComplement(int num) {
        int bitsLength = Integer.toBinaryString(num).length();
        int negateNum = ~num;
        String nagateNumStr = Integer.toBinaryString(negateNum).substring(32 - bitsLength, 32);
        int result = 0;
        for (int i = 0; i < nagateNumStr.length(); i++) {
            if (nagateNumStr.charAt(i) == '1') {
                result += Math.pow(2, nagateNumStr.length() - 1 - i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        NumberComplement numberComplement = new NumberComplement();
        System.out.println(numberComplement.findComplement(5));
        System.out.println(numberComplement.findComplement(1));
        System.out.println(Integer.toBinaryString(0x55555555));
        System.out.println(Integer.toBinaryString(0x33333333));
        System.out.println(Integer.toBinaryString(0x3f));
    }
}
