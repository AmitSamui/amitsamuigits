import java.util.*;
import java.lang.*;

public class insertElement {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int target = sc.nextInt(); 

        System.out.println(search(arr, target));



    }

    public static int search(int[] arr ,int target){
        int n = arr.length;
        int start = 0;
        int end = n-1;
        
        while(start < end){
            int mid = start + ((end-start)/2);
            
            if(arr[mid] > target){
                end = mid-1;
            }else  if(arr[mid] < target){
                start = mid + 1;
            }else{
                return mid;
            }
        }

        if(arr[start] < target){
            return start+1;
        }
        return start;


        
        
    }
}
