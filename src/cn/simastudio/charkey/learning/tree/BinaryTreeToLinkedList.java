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

package cn.simastudio.charkey.learning.tree;

import cn.simastudio.charkey.structs.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * <p>Created by Charkey on 2016/7/28.</p>
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
