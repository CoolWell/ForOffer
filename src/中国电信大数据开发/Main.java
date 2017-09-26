package 中国电信大数据开发;

import java.util.*;


public class Main {

    public static class Node{
        public char value;
        public Node left;
        public Node right;
        public Node (char data){
            this.value = data;
        }

    }
    public static Node reconPreOrder(Queue<Character> queue){
        char value = queue.poll();
        if(value=='#'){
            return null;
        }
        Node head = new Node(value);
        head.left = reconPreOrder(queue);
        head.right = reconPreOrder(queue);
        return head;

    }
    public static Node recon(String preStr){
        char[] s = preStr.toCharArray();
        Queue<Character> queue = new LinkedList<Character>();
        for(int i = 0;i<s.length;i++){
            queue.offer(s[i]);
        }
        return reconPreOrder(queue);
    }
    public static void inOrder(Node head){
        if(head == null) return;
        inOrder(head.left);
        System.out.print(head.value+" ");
        inOrder(head.right);
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String preStr = sc.nextLine();
        Node head = recon(preStr);
        inOrder(head);
    }
}
