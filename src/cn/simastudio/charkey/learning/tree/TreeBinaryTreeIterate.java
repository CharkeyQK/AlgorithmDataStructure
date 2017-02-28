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

import java.util.ArrayList;

/**
 * <p>Created by Charkey on 2016/8/4.</p>
 */
public class TreeBinaryTreeIterate {

    public ArrayList<Integer> preOrder(TreeNode treeNode, ArrayList<Integer> res) {
        if (treeNode == null) {
            return null;
        }
        res.add(treeNode.val);
        if (treeNode.left != null) {
            preOrder(treeNode.left, res);
        }
        if (treeNode.right != null) {
            preOrder(treeNode.right, res);
        }
        return res;
    }

    public ArrayList<Integer> inOrder(TreeNode treeNode, ArrayList<Integer> res) {
        if (treeNode == null) {
            return null;
        }
        if (treeNode.left != null) {
            inOrder(treeNode.left, res);
        }
        res.add(treeNode.val);
        if (treeNode.right != null) {
            inOrder(treeNode.right, res);
        }
        return res;
    }

    public ArrayList<Integer> aftOrder(TreeNode treeNode, ArrayList<Integer> res) {
        if (treeNode == null) {
            return null;
        }
        if (treeNode.left != null) {
            aftOrder(treeNode.left, res);
        }
        if (treeNode.right != null) {
            aftOrder(treeNode.right, res);
        }
        res.add(treeNode.val);
        return res;
    }

}
