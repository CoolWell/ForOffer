package 程序员代码面试指南;


public class 判断二叉树是否为平衡二叉树 {
    public static class Node{
        public char value;
        public Node left;
        public Node right;
        public Node (char data){
            this.value = data;
        }
    }
    public boolean isBalance(Node head){
        boolean[] res = new boolean[1];
        res[0] = true;
        getHeight(head,1,res);
        return res[0];
    }
    public int getHeight(Node head,int level,boolean[] res){
        if(head==null){
            return level;
        }
        int lH = getHeight(head.left,level+1,res);
        if(!res[0])
            return level;
        int rH = getHeight(head.right,level+1,res);
        if(!res[0])
            return level;
        if(Math.abs(lH-rH)>1)
            res[0] = false;
        return Math.max(lH,rH);
    }

}
