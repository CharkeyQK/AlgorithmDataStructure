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

import java.io.Serializable;

/**
 * Created by Charkey on 2/27/2017.
 */
public class Student implements Serializable {

    private String name;
    private transient String password;
    private static int count = 0;

    public Student(String name, String password) {
        System.out.println("调用Student的带参的构造方法");
        this.name = name;
        this.password = password;
        count++;
    }

    public String toString() {
        return "人数: " + count + " 姓名: " + name + " 密码: " + password;
    }
}
