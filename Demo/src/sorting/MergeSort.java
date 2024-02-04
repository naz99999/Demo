package sorting;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {

        int[] arr = {3,2,1};
        int[] ans = mergeSort(arr);
        mergeSortInPlace(arr, 0, arr.length);
        System.out.println(Arrays.toString(arr));
    }

    private static void mergeSortInPlace(int[] arr, int s, int e) {
        if(e-s==1)
            return;

        int mid = (e+s)/2;

        mergeSortInPlace(arr, s, mid);
        mergeSortInPlace(arr, mid, e);

        mergeInPlace(arr, s, mid, e);
    }

    private static void mergeInPlace(int[] arr, int s, int mid, int e) {
        int i=s;
        int j=mid;
        int k=0;
        int[] mix = new int[e-s];

        while (i<mid && j<e) {
            if (arr[i] < arr[j]) {
                mix[k] = arr[i];
                i++;
            } else {
                mix[k] = arr[j];
                j++;
            }
            k++;
        }

        while (i<mid) {
            mix[k] = arr[i];
            i++;
            k++;
        }

        while (j<e) {
            mix[k] = arr[j];
            j++;
            k++;
        }

        for (int l=0; l<mix.length; l++) {
            arr[s+l] = mix[l];
        }
    }

    private static int[] mergeSort(int[] arr) {
        if(arr.length==1) {
            return arr;
        }
        int mid = arr.length/2;

        int[] left = mergeSort(Arrays.copyOfRange(arr, 0, mid));
        int[] right = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));

        return merge(left, right);
    }

    private static int[] merge(int[] left, int[] right) {
        int i=0;
        int j=0;
        int k=0;
        int[] mix = new int[left.length + right.length];

        while (i<left.length && j<right.length) {
            if (left[i] < right[j]) {
                mix[k] = left[i];
                i++;
            } else {
                mix[k] = right[j];
                j++;
            }
            k++;
        }

        while (i<left.length) {
            mix[k] = left[i];
            i++;
            k++;
        }

        while (j<right.length) {
            mix[k] = right[j];
            j++;
            k++;
        }
        return mix;
    }

}
