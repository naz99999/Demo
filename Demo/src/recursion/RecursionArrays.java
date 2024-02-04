package recursion;

public class RecursionArrays {
    public static void main(String[] args) {

        int arr[] = {1,2,6,4,5,6,7};
        int size = 7;

        boolean ans = isArraySorted(arr, size);

        if(ans)
            System.out.println("Sorted");
        else
            System.out.println("Unsorted");

        int sum = sumOfDigits(arr, size);
        System.out.println(sum);

        System.out.println(3/2);
    }

    private static int sumOfDigits(int[] arr, int size) {

        if (size==0) {
            return 0;
        }
        if(size==1) {
            return arr[0];
        }

        int sum = arr[size-1] + sumOfDigits(arr, size-1);
        return sum;
    }

    private static boolean isArraySorted(int arr[], int size) {
        if(size==0 || size==1) {
            return true;
        }

        if(arr[size-1]<arr[size-2]) {
            return false;
        }
        return isArraySorted(arr, size-1);
    }
}
