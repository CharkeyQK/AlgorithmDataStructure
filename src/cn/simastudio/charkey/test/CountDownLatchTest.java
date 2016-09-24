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

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Qikai on 2016/8/9.
 */
public class CountDownLatchTest {

    static class Player implements Runnable {
        // Player id
        int id;
        // wait for begin signal
        CountDownLatch beginLatch;
        // reach end, count down
        CountDownLatch endLatch;

        public Player(int id, CountDownLatch beginLatch, CountDownLatch endLatch) {
            this.id = id;
            this.beginLatch = beginLatch;
            this.endLatch = endLatch;
        }

        public void run() {
            try {
                // wait for begin signal
                beginLatch.await();
                // racing
                Thread.sleep((long)(Math.random()*100));
                System.out.println("Player " + id + " arrived!");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                // end
                endLatch.countDown();
            }
        }

    }

    public static void main(String[] args) {

        int PLAYER_COUNT = 5;

        CountDownLatch beginLatch = new CountDownLatch(1);

        CountDownLatch endLatch = new CountDownLatch(PLAYER_COUNT);
        ExecutorService executorService = Executors.newFixedThreadPool(PLAYER_COUNT);
        for (int i = 0; i< PLAYER_COUNT; i++) {
            Player playerI = new Player(i, beginLatch, endLatch);
            executorService.execute(playerI);
        }

        System.out.println("Begin");
        beginLatch.countDown();

        try {
            // wait for all plays come to end
            endLatch.await();
            System.out.println("End");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }
    }

}
