package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RatInAMaze {
    private static List<String> ans = new ArrayList<>();
    public static void main(String[] args) {
        List<List<Integer>> input = new ArrayList<>();
        input.add(Arrays.asList(1,0,0,0));
        input.add(Arrays.asList(1,1,0,0));
        input.add(Arrays.asList(1,1,0,0));
        input.add(Arrays.asList(0,1,1,1));

        List<List<Integer>> visited = new ArrayList<>();
        visited.add(Arrays.asList(0,0,0,0));
        visited.add(Arrays.asList(0,0,0,0));
        visited.add(Arrays.asList(0,0,0,0));
        visited.add(Arrays.asList(0,0,0,0));

        solve(0, 0, input.size(), input, "", visited, ans);
        System.out.println(ans);
    }

    private static void solve(int x, int y, int n, List<List<Integer>> input, String path, List<List<Integer>> visited, List<String> ans) {

        if(x==n-1 && y==n-1) {
            ans.add(path);
            return;
        }

        visited.get(x).set(y, 1);

        //down
        int newX = x+1;
        int newY = y;
        if(isSafe(newX, newY, input, visited, n)) {
            path = path+"D";
            solve(newX, newY, n, input, path, visited, ans);
            //backtrack
            path = path.substring(0, path.length() - 1);
        }

        //right
        newX = x;
        newY = y+1;
        if(isSafe(newX, newY, input, visited, n)) {
            path = path+"R";
            solve(newX, newY, n, input, path, visited, ans);
            //backtrack
            path = path.substring(0, path.length() - 1);
        }

        //left
        newX = x;
        newY = y-1;
        if(isSafe(newX, newY, input, visited, n)) {
            path = path+"L";
            solve(newX, newY, n, input, path, visited, ans);
            //backtrack
            path = path.substring(0, path.length() - 1);
        }

        //up
        newX = x-1;
        newY = y;
        if(isSafe(newX, newY, input, visited, n)) {
            path = path+"R";
            solve(newX, newY, n, input, path, visited, ans);
            //backtrack
            path = path.substring(0, path.length() - 1);
        }

        //backtrack
        visited.get(x).set(y, 0);
    }

    private static boolean isSafe(int x, int y, List<List<Integer>> input, List<List<Integer>> visited, int n) {
        if((x>=0 && x<n) && y>=0 && input.get(x).get(y)==1 && visited.get(x).get(y)==0) {
            return true;
        }
        else {
            return false;
        }
    }
}
