package binarySearch;

public class RotationSortedArrayCount {
    public static void main(String[] args) {

        int[] arr = new int[]{2,2,2,9,2,2,2,2,2,2,2,2};
        int[] arr2 = new int[]{12,12,12,2,12};
        if (countOfRotatedSortedArray(arr) != -1) {
            System.out.println(countOfRotatedSortedArray(arr) + 1);
        }
    }

    private static int countOfRotatedSortedArray(int[] arr) {
        int pivot = findPivotWithDuplicates(arr, 0, arr.length-1);
        return pivot;
    }

    private static int findPivotWithDuplicates(int[] arr, int start, int end) {
        while (start < end) {
            int mid = (start + end)/2;
            if(mid < end && arr[mid] > arr[mid+1]) {
                return mid;
            }
            if(mid > start && arr[mid] < arr[mid-1]) {
                return mid - 1;
            }
            if(arr[start] == arr[end] && arr[start] == arr[mid]) {

                //Might be possible that the start is the pivot element
                if(arr[start] > arr[start+1]) {
                    return start;
                }

                //moving the start index because any element except pivot doesnt matter here if it is a duplicate
                start = start + 1;

                //Might be possible that the end is the pivot element
                if(arr[end] < arr[end-1]) {
                    return end - 1;
                }

                end = end - 1;
            }

            //left side is sorted then pivot must be in the right
            else if (arr[mid] > arr[start] || arr[mid] == arr[start] && arr[mid] > arr[end]) {
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }

        }
        return -1;
    }
}