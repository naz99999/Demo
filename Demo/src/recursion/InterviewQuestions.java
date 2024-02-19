package recursion;

import java.util.ArrayList;
import java.util.List;

public class InterviewQuestions {
    public static void main(String[] args) {
        String[] mappings = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> ans = new ArrayList<>();
        //lettersOfCombinations("", "23", mappings, ans); QUES1
        //System.out.println(ans);
        //System.out.println(lettersOfCombinations2("", "23", mappings)); QUES2
        System.out.println(diceThrow("", 7)); //QUES3
    }

    private static int diceThrow(String p, int up) {
        if (up <= 0) {
            System.out.println(p.substring(0, p.length() - 2));
            return 1;
        }

        int count = 0;
        for (int i = 1; i <= 6 && i <= up; i++) {
                count += diceThrow(p + i + ", ", up - i);
        }
        return count;
    }

    private static void lettersOfCombinations(String p, String up, String[] mappings, List<String> ans) {
        if (up.isEmpty()) {
            ans.add(p);
            return;
        }

        int digit = up.charAt(0) - '0';
        String str = mappings[digit];

        for (int i=0; i<str.length(); i++) {
            char ch = str.charAt(i);
            lettersOfCombinations(p + ch, up.substring(1), mappings, ans);
        }
    }


//By adding arraylist from each call
    private static ArrayList<String> lettersOfCombinations2(String p, String up, String[] mappings) {
        if (up.isEmpty()) {
            ArrayList<String> ans = new ArrayList<>();
            ans.add(p);
            return ans;
        }

        int digit = up.charAt(0) - '0';
        String str = mappings[digit];
        ArrayList<String> list = new ArrayList<>();

        for (int i=0; i<str.length(); i++) {
            char ch = str.charAt(i);
            list.addAll(lettersOfCombinations2(p + ch, up.substring(1), mappings));
        }
        return list;
    }

}
