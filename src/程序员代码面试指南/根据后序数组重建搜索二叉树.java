package 程序员代码面试指南;

public class 根据后序数组重建搜索二叉树 {
    public boolean isPostArray(int[] arr){
        if(arr==null||arr.length==0){
            return false;
        }
        return isPost(arr,0,arr.length-1);
    }
    public boolean isPost(int[] arr,int start,int end){
        if(start==end)
            return true;
        int less =-1;
        int more = end;
        for(int i=start;i<end;i++) {
            if (arr[i] < arr[end])
                less = i;
            else
                more = more == end ? i : more;
        }
        if(less==-1||more==end)
            return isPost(arr,start,end-1);
        if(less!=more-1)
            return false;
        return isPost(arr,start,less)&&isPost(arr,more,end);

    }

}
