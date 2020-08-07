package com.gong.demo;

import lombok.Data;

/**
 * @author gonhyuke
 * 二叉查找树
 * 二叉查找树要求，在树中的任意一个节点，其左子树中的每个节点的值，都要小于这个节点的值，而右子树节点的值都大于这个节点的值
 * 注意：二叉查找树中不存在两个值相同的节点
 * 1.查询
 * 2.新增
 * 3.删除
 */
@Data
public class BinaryTree {

    private Node tree;

    /**
     * 二叉树查找节点
     * @param data
     * @return
     */
    private Node find(int data){
        Node p = tree;
        while (p!=null){
            if (p.getData() == data){
                return p;
            }
            if (p.getData()<data){
                p=p.right;
            }
            if (p.getData()>data){
                p=p.left;
            }
        }
        return null;
    }

    /**
     * 插入节点
     * 插入的值在树中如果已经存在，树的结构不会发生变化
     * @param data
     */
    private void addNode(int data){
        if (tree==null){
            tree = new Node(data);
            return;
        }
        Node p = tree;
        while (p!=null){
            if (p.getData()>data){
                if (p.left == null){
                    p.left = new Node(data);
                    return;
                }
                p = p.left;
            }
            if (p.getData()<data){
                if (p.right == null){
                    p.right = new Node(data);
                    return;
                }
                p=p.right;
            }
            p = null;
        }
    }

    /**
     * 删除节点
     * @param data
     * @return
     */
    private boolean deleteNode(int data){
        //指向被删除节点，初始值为根节点
        Node p = tree;
        //指向被删除节点的父节点
        Node pp = null;
        //找出对应节点
        while (p!=null && p.data!=data){
            pp=p;
            if (p.data>data){
                p = p.left;
            }else {
                p=p.right;
            }
        }
        if (p==null){
            //没有查到该节点
            return false;
        }
        //被删除节点有两个子节点
        if (p.left!=null && p.right!=null){
            // 查找右子树中最小的节点
            Node minP = p.right;
            //指向minP的父节点
            Node minPP = p;
            while (minP.left!=null){
                minP = minP.left;
                minPP = minP;
            }
            p.data = minP.data;
            //下面变成了删除minP节点
            p=minP;
            pp=minPP;
        }
        //被删除节点是叶子节点或者只有一个子节点
        Node child;
        if (p.left!=null) child = p.left;
        else if (p.right!=null) child = p.right;
        else child = null;

        if (pp == null) tree = child;
        else if(pp.left == p) pp.left = child;
        else if (pp.right == p) pp.right = child;
        return true;

    }



    @Data
    public static class Node{
        private int data;
        private Node left;
        private Node right;
        public Node(int data){
            this.data=data;
        }
    }

}
