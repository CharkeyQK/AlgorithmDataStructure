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

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by Qikai on 2016/8/4.
 * see @http://www.nowcoder.com/practice/d0267f7f55b3412ba93bd35cfa8e8035?tpId=13&tqId=11156&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 */
public class PrintListFromTailToHead {

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> listList = new ArrayList<>();
        Stack<Integer> listStack = new Stack<>();
        while (listNode != null) {
            listStack.push(listNode.val);
            listNode = listNode.next;
        }
        while (!listStack.isEmpty()) {
            listList.add(listStack.pop());
        }
        return listList;
    }

    public class ListNode {

        int val;

        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

}
