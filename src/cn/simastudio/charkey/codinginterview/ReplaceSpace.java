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

package cn.simastudio.charkey.codinginterview;

/**
 * Created by Charkey on 2016/8/4.
 *
 * @see <a href="http://www.nowcoder.com/practice/4060ac7e3e404ad1a894ef3e17650423?tpId=13&tqId=11155&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking">ReplaceSpace</a>
 */
public class ReplaceSpace {

    public String replaceSpace(StringBuffer str) {
        while (str.indexOf(" ") != -1) {
            int index = str.indexOf(" ");
            str = str.replace(index, index + 1, "%20");
        }
        return str.toString();
    }

    public String replaceSpace2(StringBuffer str) {
        char[] strArray = str.toString().toCharArray();
        StringBuffer res = new StringBuffer();
        for (int i = 0; i < strArray.length; i++) {
            char curChar = strArray[i];
            if (curChar == ' ') {
                res.append("%20");
            } else {
                res.append(curChar);
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer();
        sb.append("we are happy");
        System.out.println(new ReplaceSpace().replaceSpace(sb));
        System.out.println(new ReplaceSpace().replaceSpace2(sb));
        // input: we are happy
        // result: we%20are%20happy
    }
}
