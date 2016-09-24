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

import java.util.concurrent.*;

/**
 * Created by Qikai on 2016/8/12.
 */
public class ThreadJoinTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        FutureTask futureTask1 = new FutureTask(new Callable() {
            @Override
            public Object call() throws Exception {
                Thread.sleep(1000);
                return 10;
            }
        });
        FutureTask futureTask2 = new FutureTask(new Callable() {
            @Override
            public Object call() throws Exception {
                Thread.sleep(1000);
                return 20;
            }
        });
        FutureTask countTask = new FutureTask(new Callable() {
            @Override
            public Object call() throws Exception {
                return (int)futureTask1.get() + (int)futureTask2.get();
            }
        });
        executorService.execute(countTask);

        executorService.execute(futureTask1);
        executorService.execute(futureTask2);

        while (!countTask.isDone()) {
            System.out.println(countTask.get());
        }
        executorService.shutdown();
    }

}
