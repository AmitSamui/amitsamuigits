import java.util.*;

public class EKOSPOJ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(ekosol(arr ,  n , m));
    }

    static int ekosol(int[] arr , int n , int m){
        int max = findmax(arr , n);

        

        int start = 1;
        int end = max;
        int mid;

        while( start <= end){
            mid = start +(end- start)/2;
           

            int sum = 0;
            for (int i = 0; i < arr.length; i++) {
                if(arr[i] > mid){
                    sum += arr[i]-mid;
                }
            }

           

            if(sum > m){
                start = mid+1;
            }else if(sum < m){
                end = mid-1;
            }else{
                return mid;
            }



        }

        return end;
    }

    static int findmax(int[] arr , int n){
        int max = -1;

        for (int i = 0; i < arr.length; i++) {
            if(arr[i] > max){
                max = arr[i];
            }
        }

        return max;
    }
}
