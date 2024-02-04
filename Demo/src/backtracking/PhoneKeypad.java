package backtracking;

import java.util.ArrayList;
import java.util.List;

public class PhoneKeypad {
    public static void main(String[] args) {

        String number = "267";
        String output = "";
        List<String> ans = new ArrayList<>();
        String[] mappings = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        phoneKeypad(number, output, 0, ans, mappings);

}

    private static void phoneKeypad(String digit, String output, int index, List<String> ans, String[] mappings) {

        if(index>=digit.length()) {
            ans.add(output);
            System.out.println(output);
            return;
        }

        int number = digit.charAt(index) - '0';
        String value = mappings[number];

        for (int i=0; i<value.length(); i++) {
            output = output +  value.charAt(i);
            phoneKeypad(digit, output, index+1, ans, mappings);

            //Backtrack
            output = output.substring(0, output.length()-1);
        }
    }

}
