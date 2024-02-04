package binarySearch;

public class RotatedSortedArray {
    public static void main(String[] args) {

        int[] arr = new int[]{5,7,8,9,10,12,2,4};
        //int[] arr = new int[]{2,9,2,2,2};
        int target = 8;
        System.out.println(searchInRotatedSortedArray(arr, target));
    }

    private static int searchInRotatedSortedArray(int[] arr, int target) {
        int pivot = findPivot(arr, 0, arr.length-1);

        //if pivot is not found, means array is not rotated
        if(pivot!= -1) {
            return binarySearch(arr, target, 0, arr.length-1);
        }

        if(arr[pivot] == target) {
            return pivot;
        }

        //if target is greater than first element then it must lie in the first half
        if(target >= arr[0]) {
            return binarySearch(arr, target, 0, pivot-1);
        }

        return binarySearch(arr, target, pivot+1, arr.length-1);
    }

    private static int findPivot(int[] arr, int start, int end) {
        while (start < end) {
            int mid = (start + end)/2;
            if(mid < end && arr[mid] > arr[mid+1]) {
                return mid;
            }
            if(mid > start && arr[mid] < arr[mid-1]) {
                return mid - 1;
            }
            if(arr[mid] <= arr[start]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    private static int binarySearch(int[] arr, int target, int start, int end) {
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] == target)
                return mid;
            else if (arr[mid] < target)
                start = mid + 1;
            else if (arr[mid] > target)
                end = mid - 1;
        }
        return -1;
    }
}
