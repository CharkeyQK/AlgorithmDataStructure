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

/**
 * Created by Qikai on 2016/7/28.
 */
public class ArrayBinaryTreeIterate {

    int[] binaryTree = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};

    public static void main(String[] args) {
        ArrayBinaryTreeIterate binaryTree = new ArrayBinaryTreeIterate();
        binaryTree.preOrder(0);
        System.out.println();
        binaryTree.inOrder(0);
        System.out.println();
        binaryTree.aftOrder(0);
    }

    /**
     * 前序遍历：先输出根节点，再遍历左子树，再遍历右子树；
     * 当左子树或右子树存在子树时，重复以上流程；
     *
     * @param rootIndex 每次遍历时的根节点数组下标
     */
    public void preOrder(int rootIndex) {
        int leftIndex = 2 * rootIndex + 1;
        int rightIndex = 2 * rootIndex + 2;
        System.out.print(binaryTree[rootIndex] + " ");
        if (leftIndex <= binaryTree.length - 1) {
            preOrder(leftIndex);
        }
        if (rightIndex <= binaryTree.length - 1) {
            preOrder(rightIndex);
        }
    }

    /**
     * 中序遍历：先遍历左子树，后输出根节点，再遍历右子树；
     * 当左子树或右子树存在子树时，重复以上流程；
     *
     * @param rootIndex 每次遍历时的根节点数组下标
     */
    public void inOrder(int rootIndex) {
        int leftIndex = 2 * rootIndex + 1;
        int rightIndex = 2 * rootIndex + 2;
        if (leftIndex <= binaryTree.length - 1) {
            inOrder(leftIndex);
        }
        System.out.print(binaryTree[rootIndex] + " ");
        if (rightIndex <= binaryTree.length - 1) {
            inOrder(rightIndex);
        }
    }

    /**
     * 后序遍历：先遍历左子树，再遍历右子树，最后输出根节点；
     * 当左子树或右子树存在子树时，重复以上流程；
     *
     * @param rootIndex 每次遍历时的根节点数组下标
     */
    public void aftOrder(int rootIndex) {
        int leftIndex = 2 * rootIndex + 1;
        int rightIndex = 2 * rootIndex + 2;
        if (leftIndex <= binaryTree.length - 1) {
            aftOrder(leftIndex);
        }
        if (rightIndex <= binaryTree.length - 1) {
            aftOrder(rightIndex);
        }
        System.out.print(binaryTree[rootIndex] + " ");
    }

}
