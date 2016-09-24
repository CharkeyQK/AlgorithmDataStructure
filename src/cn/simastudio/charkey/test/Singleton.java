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

/**
 * Created by Qikai on 2016/8/8.
 */
public class Singleton {

    // 私有构造方法，防止被实例化
    private Singleton() {

    }

    // 使用内部类维护单例，JVM可以保证一个类被加载时，加载过程是线程互斥的
    private static class SingletonFactory {
        private static Singleton instance = new Singleton();
    }

    // 获取实例
    public Singleton getInstance() {
        return SingletonFactory.instance;
    }

    public Object readResolve() {
        return getInstance();
    }

}

