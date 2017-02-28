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

package cn.simastudio.charkey.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <p>Created by Charkey on 2016/8/5.</p>
 */
public class RegexText {

    public static void main(String[] args) {
        String url = "http://blog.sina.com.cn/s/blog_58ae76e80100g8au.html\r\nNewLine";
        java.util.regex.Pattern p1 = java.util.regex.Pattern.compile("http://blog.sina.com.cn/s/blog_\\w*.html\r\n\\w*");
        Matcher m1 = p1.matcher(url);
        if (m1.find()) {
            System.out.println(url);
            System.out.println("FIND!");
            System.out.println(m1.group());
        }
        String string = "默地坐在第一排最后一个位置上。\n" +
                "\n" +
                "不过今天，事情似乎有了转变。";

        String newStr = "\\w";
        System.out.println(newStr);
        Pattern p2 = Pattern.compile("\\\\[a-z]");
        Matcher m2 = p2.matcher(newStr);
        if (m2.find()) {
            System.out.println(m2.group());
        }
    }

}
