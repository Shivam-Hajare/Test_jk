import java.util.Arrays;

class MinimizeHeights {
    public static void main(String[] args) {
        int K = 5, N = 10;
        int Arr[] = { 2, 6, 3, 4, 7, 2, 10, 3, 2, 1 };
        int min = getMinDiff(Arr, N, K);
        System.out.println("min : " + min);
    }

    public static int getMinDiff(int[] arr, int n, int k) {
        // code here
        Arrays.sort(arr);

        int max = Integer.MAX_VALUE, temp = 0;

        temp = ((arr[n - 1] + k) - (arr[0] + k));
        System.out.println("1 " + temp);

        if (temp >= 0)
            if (temp < max)
                max = temp;

        temp = ((arr[n - 1] + k) - (arr[0] - k));
        System.out.println("2 " + temp);

        if (temp >= 0)
            if (temp < max)
                max = temp;

        temp = ((arr[n - 1] - k) - (arr[0] + k));
        System.out.println("3 " + temp);

        if (temp >= 0)
            if (temp < max)
                max = temp;

        temp = ((arr[n - 1] - k) - (arr[0] - k));
        System.out.println("4 " + temp);

        if (temp >= 0)
            if (temp < max)
                max = temp;

        return max;
    }
}