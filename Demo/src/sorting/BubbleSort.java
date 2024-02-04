package sorting;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {

        int[] arr = new int[]{5,4,7,2,0,11,16,13};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void bubbleSort(int[] arr) {
        for (int i=0; i<arr.length; i++) {
            boolean swapped = false;
            for (int j=1; j<arr.length-i; j++) {

                if(arr[j]<arr[j-1]) {
                    int temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                    swapped = true;
                }
            }
            if(!swapped) {
                break;
            }
        }
    }
}
