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

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * <p>Created by Charkey on 2016/8/9.</p>
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
                Thread.sleep((long) (Math.random() * 100));
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
        for (int i = 0; i < PLAYER_COUNT; i++) {
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
