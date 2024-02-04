package recursion;

import java.util.ArrayList;
import java.util.List;

public class Subsequences {
    public static void main(String[] args) {

        String input = "abc";
        String output = "";
        List<String> ans = new ArrayList<>();
        subsequences(input, output, 0, ans);
//        for(int i=0; i< ans.size(); i++) {
//            System.out.println(" ["+ans.get(i)+"] ");
//        }
    }

    private static void subsequences(String input, String output, int index, List<String> ans) {
        if(index >= input.length()) {
            ans.add(output);
            System.out.println(" ["+output+"] ");
            return;
        }

        //exclude
        subsequences(input, output, index+1, new ArrayList(ans));

        //include
        Character curr = input.charAt(index);
        output = output + curr;
        subsequences(input, output, index+1, new ArrayList(ans));

    }
}
