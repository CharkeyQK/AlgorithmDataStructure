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

package cn.simastudio.charkey.codinginterview;

import java.util.Stack;

/**
 * <p>Created by Charkey on 2016/8/4.</p>
 *
 * @see <a href="http://www.nowcoder.com/practice/54275ddae22f475981afa2244dd448c6?tpId=13&tqId=11158&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking">TwoStackInQueue</a>
 */
public class TwoStackInQueue {

    Stack<Integer> stack1 = new Stack<Integer>();

    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        // stack1用来保存元素：当stack1为空时，将元素直接放进去；
        // 当stack1不为空时，将stack1的元素出栈，然后将元素入栈到stack2；新元素放入到stack1；然后将stack2的元素放回stack1
        if (stack1.isEmpty()) {
            stack1.push(node);
        } else {
            while (!stack1.isEmpty()) {
                int value = stack1.pop();
                stack2.push(value);
            }
            stack1.push(node);
            while (!stack2.isEmpty()) {
                int value = stack2.pop();
                stack1.push(value);
            }
        }
    }

    public int pop() {
        if (stack1.isEmpty()) {
            return Integer.MIN_VALUE;
        }
        return stack1.pop();
    }

    public static void main(String[] args) {
        TwoStackInQueue queue = new TwoStackInQueue();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.push(4);
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
    }
}
