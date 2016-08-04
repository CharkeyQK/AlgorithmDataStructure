/*
 * Copyright (c) 2013-2016 Charkey. All rights reserved.
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

/**
 * Created by Qikai on 2016/7/25.
 */
public class TestClass {

    public static void permutation(String str, String result, int len) {
        /* 全排列 递归实现
      递归树：
          str:          a            b                c
                      ab ac         ba   bc         ca   cb
        result:        abc acb        bac    bca      cab   cba
         */

        //结果 开始传入""   空字符进入   len   是这个数的长度
        if (result.length() == len) {            //表示遍历完了一个全排列结果
            System.out.println(result);
        } else {
            for (int i = 0; i < str.length(); i++) {
                //System.out.println(i+" " +str.charAt(i)+ " " + result);
                if (result.indexOf(str.charAt(i)) < 0) {    //返回指定字符在此字符串中第一次出现处的索引。
                    permutation(str, result + str.charAt(i), len);
                }
            }
        }
    }

    public static void main(String args[]) throws Exception {
        String str = "123";
        String result = "";
        permutation(str, result, str.length());
    }

}
