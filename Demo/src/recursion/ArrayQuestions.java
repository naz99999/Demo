package recursion;

import java.util.ArrayList;
import java.util.List;

public class ArrayQuestions {
    public static void main(String[] args) {
        int[] arr = {5,6,7,8,9,1,2,3};
        //System.out.println(sortedOrNot(arr, 0));
        int key = 7;
        //System.out.println(linearSearch(arr, key, 0));
        List<Integer> ans = new ArrayList<>();
        //System.out.println(findIndices(arr, key, 0, ans));
        //System.out.println(findIndices2(arr, key, 0));
        System.out.println(rotatedBinarySearch(arr, key, 0, arr.length-1));
    }

    private static int rotatedBinarySearch(int[] arr, int key, int s, int e) {
        if (s>e) {
            return -1;
        }
        int mid = (e+s)/2;
        if (key == arr[mid])
            return mid;

        if (arr[s] <= arr[mid]) {
            if (arr[s] <= key && key <= arr[mid]) {
                return rotatedBinarySearch(arr, key, s, mid - 1);
            } else {
                return rotatedBinarySearch(arr, key, mid + 1, e);
            }
        }
        else {
            if (arr[mid] <= key && key <= arr[e]) {
                return rotatedBinarySearch(arr, key, mid + 1, e);
            } else {
                return rotatedBinarySearch(arr, key, s, mid - 1);
            }
        }
    }

    private static List<Integer> findIndices(int[] arr, int key, int index, List<Integer> ans) {
        if (index == arr.length) {
            return ans;
        }
        if (arr[index] == key) {
            ans.add(index);
        }
        return findIndices(arr, key, index+1, ans);
    }

    private static List<Integer> findIndices2(int[] arr, int key, int index) {
        List<Integer> ans = new ArrayList<>();
        if (index == arr.length) {
            return ans;
        }

        //this will contain answer for that function call only
        if (arr[index] == key) {
            ans.add(index);
        }
        List<Integer> ansFromBelowCalls = findIndices2(arr, key, index+1);
        ans.addAll(ansFromBelowCalls);

        return ans;
    }

    private static int linearSearch(int[] arr, int key, int index) {
        if (index == arr.length) {
            return -1;
        }
        if (arr[index] == key) {
            return index;
        }
        return linearSearch(arr, key, index+1);
    }

    private static boolean sortedOrNot(int[] arr, int index) {
        if (index==arr.length-1) {
            return true;
        }
        if (arr[index] > arr[index+1]) {
            return false;
        }
        return sortedOrNot(arr, index+1);
    }
}
