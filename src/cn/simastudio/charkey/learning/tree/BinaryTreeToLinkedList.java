/*
 * Copyright (c) 2013-2015 SimaStudio. All rights reserved.
 *
 * This software is the confidential and proprietary information of SimaStudio.
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with SimaStudio.
 *
 * SimaStudio MAKES NO REPRESENTATIONS OR WARRANTIES ABOUT THE SUITABILITY OF THE SOFTWARE,
 * EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE, OR NON-INFRINGEMENT.
 *
 * SimaStudio SHALL NOT BE LIABLE FOR ANY DAMAGES SUFFERED BY LICENSEE AS A RESULT OF USING,
 * MODIFYING OR DISTRIBUTING THIS SOFTWARE OR ITS DERIVATIVES.
 */

package cn.simastudio.charkey.learning.tree;

import cn.simastudio.charkey.structs.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Qikai on 2016/7/28.
 */
public class BinaryTreeToLinkedList {

    int[] binaryTree = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};

    List<TreeNode> leftList = new LinkedList<>();

    List<TreeNode> rightList = new LinkedList<>();

    TreeNode leftHead = null;

    TreeNode leftTail = null;

    TreeNode rightHead = null;

    TreeNode rightTail = null;

    public static void main(String[] args) {
        BinaryTreeToLinkedList binaryTree = new BinaryTreeToLinkedList();
        TreeNode leftHeader = new TreeNode(0);
        leftHeader.left = null;
        leftHeader.right = null;
        binaryTree.leftHead = leftHeader;
        binaryTree.leftTail = leftHeader;
        binaryTree.preOrderToLinkedList(1);

        while (binaryTree.leftHead != null) {
            System.out.print(binaryTree.leftHead.val + " ");
            binaryTree.leftHead = binaryTree.leftHead.right;
        }
    }

    public void preOrderToLinkedList(int rootIndex) {
        int leftIndex = 2 * rootIndex + 1;
        int rightIndex = 2 * rootIndex + 2;
        TreeNode curNode = new TreeNode(binaryTree[rootIndex]);
        leftTail.right = curNode;
        curNode.left = leftTail;
        leftTail = curNode;
        curNode.right = null;
        if (leftIndex <= binaryTree.length - 1) {
            preOrderToLinkedList(leftIndex);
        }
        if (rightIndex <= binaryTree.length - 1) {
            preOrderToLinkedList(rightIndex);
        }
    }

}
