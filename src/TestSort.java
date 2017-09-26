public class TestSort {
    public static void selectSort(int[] a){
        int i,j;
        int temp=0;
        int flag=0;
        int n=a.length;
        for(i=0;i<n;i++){
            temp=a[i];
            flag=i;
            for(j=i+1;j<n;j++){
                if(a[j]<temp){
                    temp=a[j];
                    flag=j;
                }
            }
            if(flag!=i){
                a[flag]=a[i];
                a[i]=temp;
            }

        }
    }
    public static void insertSort(int[] a){
        if(a!=null){
            for(int i=1;i<a.length;i++){
                int temp=a[i],j=i;
                if(a[j-1]>temp){
                    while(j>=1&&a[j-1]>temp){
                        a[j]=a[j-1];
                        j--;
                    }
                }
                a[j]=temp;
            }
        }
    }
    public static void bubbleSort(int[] a){
        for(int i=0;i<a.length;i++){
            for(int j=a.length-1;j>i;--j){
                if(a[j]<a[j-1]){
                    int temp = a[j-1];
                    a[j-1]=a[j];
                    a[j]=temp;
                }
            }
        }
    }
    public static void merge(int[] a,int p,int q,int r){
        int i,j,k,n1,n2;
        n1=q-p+1;
        n2=r-q;
        int[] L=new int[n1];
        int[] R=new int[n2];
        for(i=0,k=p;i<n1;i++,k++) {
            L[i]=a[k];
        }
        for(i=0,k=q+1;i<n2;i++,k++)
            R[i]=a[k];
        for(k=p,i=0,j=0;i<n1&&j<n2;k++){
            if(L[i]>R[j]) {
                a[k] = L[i];
                i++;
            }
            else{
                a[k]=R[j];
                j++;
            }
        }
        if(i<n1){
            for(j=i;j<n1;j++,k++)
                a[k]=L[j];
        }
        if(j<n2){
            for(i=j;i<n2;i++,k++)
                a[k]=R[i];
        }


    }
    public static void mergeSort(int[] a,int p,int r){
        if(p<r){
            int q = (p + r)/2;
            mergeSort(a,p,q);
            mergeSort(a, q + 1, r);
            merge(a, p, q, r);

        }
    }
    public static int partition(int[] data,int length,int start,int end){
//        if(data==null||length<=0||start<0||end>=length)
//            throw new exception("input error");
        int index = (int)Math.random()*(end-start)+start;
        swap(data,index,end);
        int small = start-1;
        for(index=start;index<end;++index){
            if(data[index]<data[end]){
                small++;
                if(small!=index)
                    swap(data,index,small);
            }
        }
        small++;
        swap(data,small,end);
        return small;


    }
    public static void quickSort(int[] data,int length,int start,int end){
        if(start==end)
            return;
        int index = partition(data,length,start,end);
        if(index>start)
            quickSort(data,length,start,index-1);
        if(index<end)
            quickSort(data,length,index+1,end);

    }

    private static void swap(int[] data, int index, int end) {
        int temp=data[index];
        data[index]=data[end];
        data[end]=temp;
    }
    public static int getMiddle(int[] data,int low,int high){
        int temp=data[low];
        while(low<high){
            while (low<high&&data[high]>temp)
                high--;
            data[low]=data[high];
            while(low<high&&data[low]<temp)
                low++;
            data[high]=data[low];

        }
        data[low]=temp;
        return low;
    }
    public static void _quickSort(int[] data,int low,int high){
        if(low<high){
            int middle=getMiddle(data,low,high);
            _quickSort(data,low,middle-1);
            _quickSort(data,middle+1,high);
        }
    }
    public static void __quickSort(int[] data,int low,int high){
        int i,j;
        int index;
        if(low>=high)
            return;
        i=low;
        j=high;
        index=data[i];
        while(i<j){
            while(i<j&&data[j]>index)
                j--;
            if(i<j)
                data[i++]=data[j];
            while(i<j&&data[i]<index)
                i++;
            if(i<j)
                data[j--]=data[i];
        }
        data[i]=index;
        __quickSort(data,low,i-1);
        __quickSort(data,i+1,high);
    }
    public static void shellSort(int[] a){
        int length=a.length;
        int i,j;
        int h;
        int temp;
        for(h=length/2;h>0;h/=2){
            for(i=h;i<length;i++){
                temp=a[i];
                for(j=i-h;j>=0;j-=h){
                    if(temp<a[j])
                        a[j+h]=a[j];
                    else
                        break;
                }
                a[j+h]=temp;
            }
        }
    }
    public static void adjustMinHeap(int[] a,int pos,int len){
        int temp;
        int child;
        for(temp=a[pos];2*pos+1<=len;pos=child){
            child=2*pos+1;
            if(child<len&&a[child]>a[child+1])
                child++;
            if(a[child]<temp)
                a[pos]=a[child];
            else
                break;
        }
        a[pos]=temp;
    }
    public static void minHeapSort(int[] a){
        int i;
        int len=a.length;
        for(i=len/2-1;i>=0;i--)
            adjustMinHeap(a,i,len-1);
        for(i=len-1;i>=0;i--){
            int temp = a[0];
            a[0]=a[i];
            a[i]=temp;
            adjustMinHeap(a,0,i-1);
        }
    }

    public static void main(String[] args){
        int i=0;
        int a[]={5,4,3,4,5,87,7,1,2};
//        quickSort(a,a.length,0,a.length-1);
//        selectSort(a);
        minHeapSort(a);
        for(i=0;i<a.length;i++)
            System.out.print(a[i]+" ");
        System.out.print("\n");

    }
}
