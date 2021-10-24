import java.util.*;
import java.lang.*;

public class AggeressiveCows {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int c = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        int ans = getmaxmin(arr, n, c);
        System.out.println(ans);
    }

    public static int getmaxmin(int[] arr, int n, int c) {

        int low = 0;
        int high = arr[n - 1];
        int best = 0;

        while (low <= high) {
            int mid = (high + low + 1) / 2;
            int gap = mid;

            int count = 1;

            int prev = 0;
            for (int i = 1; i < arr.length && count < c; i++) {
                if (arr[i] - arr[prev] >= gap) {
                    count++;
                    prev = i;
                }
            }

            if (count >= c) {

                best = gap;

                low = mid + 1;
            } else {
                high = mid - 1;
            }

        }

        return best;
    }
}
