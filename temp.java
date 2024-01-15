import java.util.*;
public class temp {
    public static void main(String[] args) {
        int nums[]={3,3};
        int target=6;
        
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<nums.length-1;i++)
        {
            for(int j=i+1;j<nums.length;j++)
            {
                if(nums[i]+nums[j]==target)
                {
                    System.out.println(i+" "+j);
                }
            }
        }
       
        // for (int i = 1; i < nums.length; i++) {
        //     for (int j = i; j < nums.length; j++) {
        //         if  (nums[j] + nums[j - i] == target) {
        //             return new int[]{j - i, j};
        //         }
        //     }
        // }
        // return null;
    }

        

    }
}



