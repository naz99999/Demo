package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PermuationsString {
    static List<List<Integer>> ans = new ArrayList<>();
    public static void main(String[] args) {

        List<Integer> input = Arrays.asList(1,2,3);
        solve(input, 0, ans);
        //System.out.println(input);
    }

    private static void solve(List<Integer> arr, int index, List<List<Integer>> ans) {

        if (index >= arr.size()) {
            System.out.println(arr);
            ans.add(arr);
            return;
        }

        for(int j=index; j<arr.size(); j++) {
            //swap arr[j] and arr[index]
            int temp = arr.get(index);
            arr.set(index, arr.get(j));
            arr.set(j, temp);
            solve(arr, index+1, ans);

            //backtracking
            Collections.swap(arr, j, index);
        }
    }

}

