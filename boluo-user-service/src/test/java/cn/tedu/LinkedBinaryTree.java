package cn.tedu;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class LinkedBinaryTree {

    private Node root;      //根节点

    public LinkedBinaryTree(){
        super();
    }

    public LinkedBinaryTree(Node root){
        super();
        this.root = root;
    }

    //判断二叉树是否为空
    public boolean isEmpty(){
        return root == null;
    }

    //二叉树节点的个数
    public int size(){
        System.out.println("二叉树节点的个数为:");
        return size(root);
    }

    public int size(Node root){
        if(root == null){
            return 0;
        }else {
            //获取左子树节点的个数
            int nl = size(root.leftChild);
            //获取右子树节点的个数
            int nr = size(root.rightChild);
            //返回两个数值的总和+根节点
            return nl+nr+1;
        }
    }

    //二叉树的高度
    public int getHeight(){
        System.out.println("二叉树的高度为:");
        return getHeight(root);
    }

    public int getHeight(Node root){
        if(root == null){
            return 0;
        }else {
            //获取左子树的高度
            int nl = getHeight(root.leftChild);
            //获取右子树的高度
            int nr = getHeight(root.rightChild);
            //返回两个子树中高度较大的一个
            return nl > nr ? nl+1 : nr +1;
        }
    }

    //在二叉树中查找某个值
    public Node findKey(int value){
        return this.findKey(value,root);
    }

    public Node findKey(Object value,Node root){
        if(root == null){       //递归结束条件1
            return null;
        }else if(root != null && root.value == value){      //递归结束条件2
            return root;
        }else {                 //递归体
            Node node1 = this.findKey(value,root.leftChild);
            Node node2 = this.findKey(value,root.rightChild);
            if(node1 != null && value == node1.value){
                return node1;
            }else if(node2 != null && value == node2.value){
                return node2;
            }else {
                return null;
            }
        }
    }

    //先序遍历二叉树(递归)
    public void preOrderTraverse(){
        if(root != null){

            //输出根节点的值
            System.out.print(root.value+" ");

            //对左子树进行先序遍历
            //构建一个二叉树   根是左子树的根
            LinkedBinaryTree leftTree = new LinkedBinaryTree(root.leftChild);
            leftTree.preOrderTraverse();    //对左子树进行先序遍历

            //对右子树进行先序遍历
            //构建一个二叉树,根是右子树的根
            LinkedBinaryTree rightTree =  new LinkedBinaryTree(root.rightChild);
            rightTree.preOrderTraverse();   //对右子树进行先序遍历

        }
    }

    //中序遍历二叉树(递归)
    public void inOrderTraverse(){
        System.out.println("中序遍历二叉树(递归)");
        inOrderTraverse(root);
        System.out.println();
    }

    public void inOrderTraverse(Node root){
        if(root != null){
            //遍历左子树
            this.inOrderTraverse(root.leftChild);
            //输出根的值
            System.out.print(root.value+" ");
            //遍历右子树
            this.inOrderTraverse(root.rightChild);

        }
    }

    //后序遍历二叉树(递归)
    public void postOrderTraverse(){
        System.out.println("后序遍历二叉树(递归)");
        postOrderTraverse(root);
        System.out.println();
    }

    public void postOrderTraverse(Node root){
        if(root != null){
            //遍历左子树
            this.postOrderTraverse(root.leftChild);
            //遍历右子树
            this.postOrderTraverse(root.rightChild);
            //输出根节点
            System.out.print(root.value+" ");
        }
    }

    //按照层次遍历(借助队列)
    public void levelOrderByStack(){
        if(root == null){
            return ;
        }

        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);    //加入根节点

        while(queue.size() != 0){

            for(int i=0;i<queue.size();i++){
                Node temp = queue.poll();
                System.out.print(temp.value+" ");
                if(temp.leftChild != null){
                    queue.add(temp.leftChild);
                }
                if(temp.rightChild != null){
                    queue.add(temp.rightChild);
                }
            }
        }
        System.out.println();
    }

    //中序遍历非递归(借助栈)
    public void inOrderByStack(){
        //创建栈(Deque是双端队列,一般做栈使用)
        Deque<Node> stack = new LinkedList<Node>();
        Node current = root;

        while(current != null || stack.isEmpty()){

            while (current != null){
                stack.push(current);
                current = current.leftChild;
            }

            if(!stack.isEmpty()){
                current = stack.pop();
                System.out.print(current.value+" ");
                current = current.rightChild;
            }
        }
    }

}























