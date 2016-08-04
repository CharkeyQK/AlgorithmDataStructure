/*
 * Copyright (c) 2013-2015 SimaStudio. All rights reserved.
 *
 * This software is the confidential and proprietary information of SimaStudio.
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with SimaStudio.
 *
 * SimaStudio MAKES NO REPRESENTATIONS OR WARRANTIES ABOUT THE SUITABILITY OF THE SOFTWARE,
 * EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE, OR NON-INFRINGEMENT.
 *
 * SimaStudio SHALL NOT BE LIABLE FOR ANY DAMAGES SUFFERED BY LICENSEE AS A RESULT OF USING,
 * MODIFYING OR DISTRIBUTING THIS SOFTWARE OR ITS DERIVATIVES.
 */

package cn.simastudio.charkey.codinginterview;

/**
 * Created by Qikai on 2016/8/4.
 * see @http://www.nowcoder.com/practice/4060ac7e3e404ad1a894ef3e17650423?tpId=13&tqId=11155&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
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
