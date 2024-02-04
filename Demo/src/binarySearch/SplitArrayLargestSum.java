package binarySearch;

public class SplitArrayLargestSum {
    public static void main(String[] args) {

        int[] arr = new int[]{7,2,5,8,10};
        int m = 2;//no. Of pieces the array can be split
        System.out.println(splitArrayLargestSum(arr, m));
        }

    private static int splitArrayLargestSum(int[] arr, int m) {
        int start = 0;
        int end = 0;

        for (int i : arr) {
            start = Math.max(start, i); //in the end it will contain the max element
            end += i; //will contain the sum of all elements
        }

        //binary search on the possible range of sum
        int mid = 0;
        while (start < end) {
            mid = start + (end - start) / 2;

            int sum = 0;
            int pieces = 1;
            for (int num : arr) {
                if (sum + num > mid) { //you cannot add another element in this subarray
                    sum = num; //the sum will become the next number and the addition will go on
                    pieces++;
                } else {
                    sum += num;
                }
            }

            if(pieces > m) {//if there are more pieces it means we have assumed a less sum, it needs to be more
                start = mid + 1;
            } else { // pieces<=m ; meaning that a piece must be having a large sum so we can reduce it to accomodate more pieces
                end = mid;
            }
        }
        return end; //here start==end at the end, only 1 element would be left
    }
}
