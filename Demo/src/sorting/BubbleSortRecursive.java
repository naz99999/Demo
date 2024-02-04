package sorting;

import java.util.Arrays;

public class BubbleSortRecursive {
    public static void main(String[] args) {
        int[] arr = {5,4,3,2,1};
        int n = arr.length;
        int r = 0;
        int c = 0;
        bubbleSortRecursive(arr, r, c, n);
        System.out.println(Arrays.toString(arr));
    }

    private static void bubbleSortRecursive(int[] arr, int r, int c, int n) {

        //base case could also be(r==0) if we start r with arr.length - 1
        if (r==n)
            return;

        //then cond would be c<r
        if (c < n-r-1) {
            if (arr[c] > arr[c+1]) {
                //swap
                int temp = arr[c];
                arr[c] = arr[c+1];
                arr[c+1] = temp;

                bubbleSortRecursive(arr, r, c+1, n);
            }
        }  else {
            //and here in the call we would pass r-1 instead of r+1
            bubbleSortRecursive(arr, r+1, 0, n);
        }
    }
}
