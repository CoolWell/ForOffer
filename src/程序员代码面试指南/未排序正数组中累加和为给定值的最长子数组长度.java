package 程序员代码面试指南;

public class 未排序正数组中累加和为给定值的最长子数组长度 {
    public int getMaxLength(int[] arr,int k){
        if(arr==null||arr.length==0||k<=0)
            return 0;
        int left=0;
        int right=0;
        int sum=0;
        int len=0;
        while(right<arr.length){
            if(sum==k){
                len=Math.max(len,right-left+1);
                sum-=arr[left++];
            }
            else if(sum<k){
                //注意可能的数组越界情况
                if(++right==arr.length)
                    break;
                sum+=arr[right];
            }
            else {
                sum-=arr[left++];
            }
        }
        return len;
    }
}
