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

package cn.simastudio.charkey.learning.O1QueueGetMax;

import java.util.Arrays;

/**
 * <p>Created by Charkey on 2016/7/23.</p>
 */
public class O1QueueGetMax {

    int length = 10;

    int[] queue = new int[length];

    int[] maxQueue = new int[length];

    int front = -1;

    int tail = -1;

    int mFront = -1;

    int mTail = -1;

    // 通过一个单调队列来维护最大值\最小值
    public static void main(String[] args) {
        O1QueueGetMax queueGetMax = new O1QueueGetMax();
        queueGetMax.enqueue(2);
        queueGetMax.enqueue(7);
        queueGetMax.enqueue(4);
        queueGetMax.enqueue(1);
        queueGetMax.enqueue(3);
        queueGetMax.enqueue(6);
        queueGetMax.enqueue(5);
        queueGetMax.enqueue(8);
        queueGetMax.enqueue(10);
        queueGetMax.enqueue(12);
        queueGetMax.enqueue(9);
        queueGetMax.enqueue(11);
        System.out.println(Arrays.toString(queueGetMax.queue));

        System.out.println(queueGetMax.dequeue());
        System.out.println(queueGetMax.dequeue());
        System.out.println(queueGetMax.dequeue());
        System.out.println(queueGetMax.dequeue());
        System.out.println(queueGetMax.dequeue());
        System.out.println(queueGetMax.dequeue());
        System.out.println(queueGetMax.dequeue());
        System.out.println(queueGetMax.dequeue());
        queueGetMax.enqueue(13);
        queueGetMax.enqueue(14);
        queueGetMax.enqueue(15);
        queueGetMax.enqueue(21);
        System.out.println(queueGetMax.dequeue());
        System.out.println(queueGetMax.dequeue());
        System.out.println(queueGetMax.dequeue());
        System.out.println(queueGetMax.dequeue());
        System.out.println(queueGetMax.dequeue());
        System.out.println(queueGetMax.dequeue());
        queueGetMax.enqueue(22);
        queueGetMax.enqueue(23);
        queueGetMax.enqueue(24);
        System.out.println(queueGetMax.dequeue());
        System.out.println(queueGetMax.dequeue());
        System.out.println(queueGetMax.dequeue());
        System.out.println(queueGetMax.dequeue());
        System.out.println(queueGetMax.dequeue());

        System.out.println("Front: " + queueGetMax.front + " Tail: " + queueGetMax.tail);
        System.out.println(Arrays.toString(queueGetMax.queue));
        System.out.println(queueGetMax.dequeue());
        System.out.println("Front: " + queueGetMax.front + " Tail: " + queueGetMax.tail);
        System.out.println(Arrays.toString(queueGetMax.queue));
        queueGetMax.enqueue(25);
        queueGetMax.enqueue(20);
        queueGetMax.enqueue(19);
        queueGetMax.enqueue(18);
        queueGetMax.enqueue(17);
        queueGetMax.enqueue(16);
        System.out.println(queueGetMax.dequeue());
        System.out.println("Front: " + queueGetMax.front + " Tail: " + queueGetMax.tail);
        System.out.println(Arrays.toString(queueGetMax.queue));

    }

    private void enqueue(int value) {
        if (tail - front == length - 1 || ((tail == front - 1) && tail != -1)) {
            return;
        }
        if (tail < 0) {
            queue[++tail] = value;
            enqueueMax(value);
            front++;
        } else if (front <= tail) {
            if (tail == length - 1 && tail - front != length - 1) {
                tail = -1;
            }
            queue[++tail] = value;
            enqueueMax(value);
        } else if (tail < front - 1) {
            queue[++tail] = value;
            enqueueMax(value);
        }

    }

    private int dequeue() {
        if (front < 0) {
            return Integer.MIN_VALUE;
        }
        if (front == tail) {
            int temp = front;
            front = -1;
            tail = -1;
            return queue[temp];
        } else if (front < tail) {
            return queue[front++];
        } else if (front > tail) {
            if (front < length - 1) {
                return queue[front++];
            } else {
                front = 0;
                return queue[length - 1];
            }
        }
        return Integer.MIN_VALUE;
    }

    private void enqueueMax(int value) {
        if (mTail < 0) {
            maxQueue[++mTail] = value;
        } else {
            if (maxQueue[mTail] >= value) {
                maxQueue[++mTail] = value;
            } else {
                while (maxQueue[mTail] < value && mTail >= 0) {
                    if (mTail == 0) {
                        maxQueue[mTail] = value;
                    } else {
                        mTail--;
                    }
                }
            }
        }
        System.out.println("Max Queue: " + Arrays.toString(maxQueue) + " - " + mTail);
    }

    private int getMax() {
        if (mTail >= 0) {
            return maxQueue[0];
        }
        return Integer.MIN_VALUE;
    }
}
