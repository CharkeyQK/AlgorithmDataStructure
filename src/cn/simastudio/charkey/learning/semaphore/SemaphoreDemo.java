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

package cn.simastudio.charkey.learning.semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Created by Qikai on 2016/8/1.
 */
public class SemaphoreDemo {

    public static void main(String[] args) {
        // 采用新特征来启动和管理线程--内部使用线程池
        ExecutorService exec = Executors.newCachedThreadPool();
        // 只允许5个线程同时访问
        final Semaphore semaphore = new Semaphore(5);
        // 模拟十个客户端访问
        for (int i = 0; i < 10; i++) {
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    try {
                        // 获得许可
                        semaphore.acquire();
                        System.out.println("线程" + Thread.currentThread().getName() + "获得许可");
                        // 模拟线程耗时操作
                        for (int j = 0; j < 999999; j++) ;
                        // 释放许可
                        semaphore.release();
                        System.out.println("线程" + Thread.currentThread().getName() + "释放许可");
                        System.out.println("当前许可可用数量：" + semaphore.availablePermits());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            exec.execute(runnable);
        }
        exec.shutdown();
    }

}
