import java.util.*;

class MaxDiff {
    public static void main(String[] args) {
        int arr[] = {2, 4, 8, 7, 7, 9, 3};
        // ans=0, 3, 7, 3, 3, 3, 0
      // int res=
        findMaxDiff(arr, arr.length);
       // System.out.println(res);
    }

    private static void findMaxDiff(int[] arr, int length) {
       // int max = 0, flag = 0, flag1 = 0;

        Stack<Integer> s=new Stack<>();
        Stack<Integer> ss=new Stack<>();
        ArrayList<Integer>leftArrayList=new ArrayList<>();
        ArrayList<Integer>rightArrayList=new ArrayList<>();
        for(int i=0;i<arr.length;i++)
        {
          while(!s.isEmpty() && s.peek()>=arr[i])
          {
            s.pop();
          }
          if(s.isEmpty())
          {
            leftArrayList.add(0);
          }
          else{
            leftArrayList.add(s.peek());
          }
          
          s.push(arr[i]);
        }
        System.out.println(leftArrayList);
        for(int i=arr.length-1;i>=0;i--)
        {
          while(ss.isEmpty() && ss.peek()>=arr[i])
          {
            ss.pop()
          }
        }
       
    }
}