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

package cn.simastudio.charkey.leetcode.$_461_hamming_distance;

/**
 * <p>Created by Charkey on 2/28/2017.</p>
 * <p>Java 位运算</p>
 * <ul>
 * <li>与(&)：两边操作数都为 1 时结果为 1，否则为 0</li>
 * <li>或(|)：两边操作数其中一个为 1 时结果为 1，否则为 0</li>
 * <li>非(~)：0 变 1，1 变 0</li>
 * <li>异或(^)：两边操作数不同时为 1，相同时为 0</li>
 * </ul>
 * <p>位移运算</p>
 * <ul>
 * <li>算术左移(<<)：使用 0 填充右侧空位</li>
 * <li>!!!没有(<<<)!!!</li>
 * <li>算术右移(>>)：使用左边最高位填充左侧空位，每移动一位，都被除 2</li>
 * <li>逻辑右移(>>>)：使用 0 填充左侧空位，可能导致原数符号变动</li>
 * </ul>
 */
public class HammingDistance {

    public int hammingDistance(int x, int y) {
        int result = x ^ y;
        int initBit = 1;
        int cnt = 0;
        if ((1 & result) > 0) {
            cnt++;
        }
        for (int i = 1; i < 31; i++) {
            int com = initBit << i;
            if ((com & result) > 0) {
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        HammingDistance hammingDistance = new HammingDistance();
        System.out.println(hammingDistance.hammingDistance(1, 4));
        System.out.println(hammingDistance.hammingDistance(0x10101, 0x00110));
    }
}