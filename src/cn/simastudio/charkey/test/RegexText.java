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

package cn.simastudio.charkey.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Qikai on 2016/8/5.
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
