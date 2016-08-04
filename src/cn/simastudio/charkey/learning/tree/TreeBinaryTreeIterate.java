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

package cn.simastudio.charkey.learning.tree;

import cn.simastudio.charkey.structs.TreeNode;

import java.util.ArrayList;

/**
 * Created by Qikai on 2016/8/4.
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
