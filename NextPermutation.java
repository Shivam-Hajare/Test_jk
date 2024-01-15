import java.util.Arrays;

class NextPermutation {
    public static void main(String[] args) {
        int[] nums = {3,2,1};
        // nextPermutation(nums);
        nextPermutation1(nums);
    }

    public static void nextPermutation(int[] a) {
        int index = 0, i = 0, currentEle = 0, index1 = 0;

        while (a[i] > a[i + 1] && i < a.length - 1) {
            index = i + 1;
            i++;
        }
        System.out.println("index=" + index);
        for (int j = index; j < a.length; j++) {
            if (a[j] > a[index - 1]) {
                currentEle = a[j];
                index1 = i;
            }
            System.out.println(currentEle);
            if (currentEle < a[j]) {
                currentEle = a[j];
                index1 = i;
            }

        }
        System.out.println("current ele: " + currentEle);

        int temp = 0;
        temp = a[index - 1];
        a[index - 1] = currentEle;
        a[index1] = temp;

        // sorting
        int n = a.length;
        for (int j = index; j < a.length; j++) {
            for (int k = 1; k < (n - j); k++) {
                if (a[k - 1] > a[k]) {
                    // swap elements
                    temp = a[k - 1];
                    a[k - 1] = a[k];
                    a[k] = temp;
                }
            }
        }

        for (int e : a)
            System.out.println(e);

    }

    public static void nextPermutation1(int[] a) {
        int k = -1;
        int n = a.length;
        for (int i = n - 2; i >= 0; i--) {
            if (a[i] < a[i + 1]) {
                k = i;
                break;
            }
        }
        System.out.println("k= " +k);

        if (k == -1) {
            for (int i = 0; i < a.length / 2; i++) {
                int temp = a[i];
                a[i] = a[a.length - 1 - i];
                a[a.length - 1 - i] = temp;
            }
            
            // String arrStr = Arrays.toString(a);
            // System.out.println(arrStr);
            System.out.print("[");
                int r=0;
            for(int each:a)
            {
                if(r==0)
                {
                    System.out.print(each);
                    r++;
                }
                else
                System.out.print(","+each);
            }
            System.out.print("]");
            System.exit(0);
        }
        int l = 0;
        for (int i = n - 1; i >= k + 1; i--) {
            if (a[k] < a[i]) {
                l = i;
                break;
            }
        }

        System.out.println("l= " + l);
        // Swaping k and L element and reverse

        int temp = a[k];
        a[k] = a[l];
        a[l] = temp;
        int j = n - 1;
        for (int i = k + 1; i < n; i++) {
            if (i >= j) {
                break;
            }
            int temp1 = a[i];
            a[i] = a[j];
            a[j] = temp1;
            j--;
        }
        System.out.print(Arrays.toString(a));

    }
}
