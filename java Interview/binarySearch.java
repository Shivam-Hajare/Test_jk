public class binarySearch {
    public static void main(String[] args) {
        int arr [] = new int[]{1,2,3,4,5,6,7,8,9};

       System.out.println("Element present at index: "+binarySh(arr,9)); 
    }

    private static int binarySh(int[] arr,int element) {
        int left=0,right=arr.length-1;
        int mid=-1;

        while(left<=right)
        {
            mid=(left+right)/2;
            System.out.println(mid);

            if(arr[mid]>element)
            {
                right=mid - 1 ;
            }
            else if(arr[mid]<element)
            {
                left=mid+1;
            }
            else if(arr[mid]==element)
                return mid;
        }
        return -1;
    }
}
