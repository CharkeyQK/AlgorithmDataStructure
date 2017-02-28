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

/**
 * <p>Created by Charkey on 2016/7/28.</p>
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
