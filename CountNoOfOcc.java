public class CountNoOfOcc {

    public static void main(String[] args) {
        int target=2;
        int a[] = {1, 1, 2, 2, 2, 2, 3};

       System.out.println(count(a,a.length,target));
    }
      static int count(int[] a, int n, int target) {
        int left=0;
        int right=a.length-1;
        int mid=0;
        int k=0;
        int count=0;
        //array length=1
        if(a.length==1)
        {
            if(a[0]==target)
            {
                return 1;
            }
            return 0;
        }

        while(left<=right)
        {
            mid=(left+right)/2;
            
            if(a[mid]==target)
            {
                k=mid;
                while(target==a[k] && k>0)
                {
                    count++;
                    k--;
                }
                k=mid;
                while(target==a[k+1] && k<a.length-1)
                {
                    count++;
                    k++;
                }
            }
            else if(target>a[mid])
            {
                left=mid+1;
            }
            else if(target<a[mid])
            {
                right=mid-1;
            }
        }
        return count;
    }
}
