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

import cn.simastudio.charkey.learning.tree.TreeBinaryTreeIterate;
import cn.simastudio.charkey.structs.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * <p>Created by Charkey on 2016/8/4.</p>
 *
 * @see <a href="http://www.nowcoder.com/practice/8a19cbe657394eeaac2f6ea9b0f6fcf6?tpId=13&tqId=11157&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking">ReconstructBinaryTree</a>
 */
public class ReconstructBinaryTree {

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre.length == 0 || in.length == 0) {
            return null;
        }
        // 辅助Map，用于在中序遍历结果数组中定位根节点的索引
        HashMap<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < in.length; i++) {
            inMap.put(in[i], i);
        }
        return construct(pre, 0, pre.length - 1, in, 0, in.length - 1, inMap);
    }

    /**
     * @param pre      前序遍历结果数组
     * @param preStart 前序遍历结果数组的起始索引
     * @param preEnd   前序遍历结果数组的结束索引
     * @param in       中序遍历结果数组
     * @param inStart  中序遍历结果数组的起始索引
     * @param inEnd    中序遍历结果数组的结束索引
     * @param inMap    辅助map
     * @return 重建所得二叉树的头结点
     */
    public TreeNode construct(int[] pre, int preStart, int preEnd, int[] in, int inStart, int inEnd, HashMap<Integer, Integer> inMap) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        // 前序遍历数组结果数组中第一个节点就是子树的根节点
        TreeNode rootNode = new TreeNode(pre[preStart]);

        int rootIndex = inMap.get(pre[preStart]);
        int preStartLeft = preStart + 1;
        int preEndLeft = rootIndex - inStart + preStart;
        int inStartLeft = inStart;
        int inEndLeft = rootIndex - 1;

        int preStartRight = preStart + rootIndex - inStart + 1;
        int preEndRight = preEnd;
        int inStartRight = rootIndex + 1;
        int inEndRight = inEnd;

        rootNode.left = construct(pre, preStartLeft, preEndLeft, in, inStartLeft, inEndLeft, inMap);
        rootNode.right = construct(pre, preStartRight, preEndRight, in, inStartRight, inEndRight, inMap);

        return rootNode;
    }

    public static void main(String[] args) {
        int[] preStr = {1, 2, 4, 8, 9, 5, 10, 11, 3, 6, 12, 7};
        int[] inStr = {8, 4, 9, 2, 10, 5, 11, 1, 12, 6, 3, 7};
        TreeNode root = new ReconstructBinaryTree().reConstructBinaryTree(preStr, inStr);
        System.out.println(root.val);
        ArrayList<Integer> res = new ArrayList<>();
        System.out.println(new TreeBinaryTreeIterate().preOrder(root, res));
        res.clear();
        System.out.println(new TreeBinaryTreeIterate().inOrder(root, res));
    }

}
