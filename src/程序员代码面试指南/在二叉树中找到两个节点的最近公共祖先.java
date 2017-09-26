package 程序员代码面试指南;

public class 在二叉树中找到两个节点的最近公共祖先 {
    public static class Node{
        public char value;
        public Node left;
        public Node right;
        public Node (char data){
            this.value = data;
        }
    }
    public Node lowestAncestor(Node head, Node o1,Node o2){
        if(head ==null||head==o1||head==o2)
            return head;
        Node left = lowestAncestor(head.left,o1,o2);
        Node right= lowestAncestor(head.right,o1,o2);
        if(left!=null&&right!=null)
            return head;
        return left!=null?left:right;
    }
}
