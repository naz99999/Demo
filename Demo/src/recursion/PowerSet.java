package recursion;

import java.util.ArrayList;
import java.util.List;

public class PowerSet {
    public static void printSubset(int arr[], int index, ArrayList<Integer> currentSubset) {

        // print only in last iteration
        if (index >= arr.length) {
            System.out.println(currentSubset);
            return;
        }

        // don't take
        // Cloning 'result' is important
        //ArrayList<Integer> currentSubsetE = new ArrayList<Integer>(currentSubset);
        printSubset(arr, index + 1, new ArrayList<>(currentSubset));

        // take
        currentSubset.add(arr[index]);
        printSubset(arr, index + 1, new ArrayList<>(currentSubset));
    }

    public static void main(String[] args) {
        printSubset(new int[]{1, 2, 3}, 0, new ArrayList<>());
    }

}
