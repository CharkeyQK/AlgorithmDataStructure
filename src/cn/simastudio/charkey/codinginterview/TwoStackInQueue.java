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

package cn.simastudio.charkey.codinginterview;

import java.util.Stack;

/**
 * Created by Qikai on 2016/8/4.
 * see @http://www.nowcoder.com/practice/54275ddae22f475981afa2244dd448c6?tpId=13&tqId=11158&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
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
