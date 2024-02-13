package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringQuestions {
    public static void main(String[] args) {
        String str = "bappnanappleapporangeappleappemappleapp";
        //System.out.println(skipACharacter(str, 0, "")); //QUES1

        //System.out.println(skipACharacter2(str, "")); //QUES2

        String toSkip = "app";
        //System.out.println(skipAString(str, toSkip, "")); //QUES3
        String notSkip = "apple";
        //System.out.println(skipAStringButNotSkip(str, toSkip, notSkip, "")); //QUES3

        //subSequences("abc", ""); //QUES4

        //List<String> ans = subSequences2("abc", ""); //QUES5
        //System.out.println(ans);

        //subSets(new int[]{1, 2, 3}, ""); //QUES6

//        int[] arr = {1,2,3};
//        System.out.println(Arrays.toString(Arrays.copyOfRange(arr, 1, arr.length))); //ROUGH

        //System.out.println(subSetsIterative(new int[]{1, 2, 3})); //QUES7
        //System.out.println(subSetsIterativeDuplicates(new int[]{1, 2, 2, 2})); //QUES8

//        String strp = "abc";
//        List<String> ans = new ArrayList<>();
//        List<String> sol = permutationsOfAString(strp, "", ans); //QUES 9
//        System.out.println(ans); //whether we pass the permutations to 'sol' or make the function void and not create 'sol', 'ans' arraylist would still contain the permutations
//        System.out.println(sol);

//        String strp = "abc";
//        List<String> ans = permutationsOfAString2(strp, ""); //QUES 9
//        System.out.println(ans);

        String strp = "abc";
        System.out.println(countPermutations(strp, "")); //QUES10
    }

    private static int countPermutations(String up, String p) {
        if (up.isEmpty()) {
            return 1;
        }

        char ch = up.charAt(0);
        int count = 0;
        for (int i = 0; i <= p.length(); i++) {
            String first = p.substring(0, i);
            String second = p.substring(i, p.length());
            count = count + countPermutations(up.substring(1), first + ch + second);
        }
        return count;
    }

    private static List<String> permutationsOfAString2(String up, String p) {
        if (up.isEmpty()) {
            List<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        List<String> ans = new ArrayList<>();
        char ch = up.charAt(0);

        for (int i = 0; i <= p.length(); i++) {
            String first = p.substring(0, i);
            String second = p.substring(i, p.length());
            ans.addAll(permutationsOfAString2(up.substring(1), first + ch + second));
        }
        return ans;
    }

    private static List<String> permutationsOfAString(String up, String p, List<String> ans) {
        if (up.isEmpty()) {
            ans.add(p);
            return ans;
        }

        char ch = up.charAt(0);

        for (int i = 0; i <= p.length(); i++) {
            String first = p.substring(0, i);
            String second = p.substring(i, p.length());
            permutationsOfAString(up.substring(1), first + ch + second, ans);
        }
        return ans;
    }

    private static List<List<Integer>> subSetsIterativeDuplicates(int[] arr) {
        List<List<Integer>> outer = new ArrayList<>();

        //Array should be sorted for this approach to work
        Arrays.sort(arr);

        outer.add(new ArrayList<>());
        int start;
        int end = 0;
        for (int i = 0; i < arr.length; i++) {
            int n = outer.size();
            start = 0;
            //if current and prev element are same, then start = end + 1
            if (i >  0 && arr[i] == arr[i-1]) {
                start = end + 1;
            }
            end = n - 1;
            for (int j = start; j < n; j++) {
                List<Integer> internal = new ArrayList<>(outer.get(j));
                internal.add(arr[i]);
                outer.add(internal);
            }
        }

        return outer;
    }

    private static List<List<Integer>> subSetsIterative(int[] arr) {
        List<List<Integer>> outer = new ArrayList<>();

        outer.add(new ArrayList<>());

        for (int num : arr) {
            int n = outer.size();
            for (int i = 0; i < n; i++) {
                List<Integer> internal = new ArrayList<>(outer.get(i));
                internal.add(num);
                outer.add(internal);
            }
        }

        return outer;
    }

    private static void subSets(int[] arr, String ans) {
        if (arr.length == 0) {
            System.out.println(ans.length()==0 ? ans : ans.substring(0, ans.length()-1)); //to not include the comma at the end
            return;
        }

        subSets(Arrays.copyOfRange(arr, 1, arr.length), ans + arr[0] + ",");
        subSets(Arrays.copyOfRange(arr, 1, arr.length), ans);
    }

    private static List<String> subSequences2(String str, String ans) { // passing the arraylist in each individual recursive call
        if (str.isEmpty()) {
            List<String> list = new ArrayList<>();
            list.add(ans);
            return list;
        }

        List<String> ansFrom1stCalls = subSequences2(str.substring(1), ans + str.charAt(0));
        List<String> ansFrom2ndCalls = subSequences2(str.substring(1), ans);
        List<String> ansFrom3rdCallsAscii = subSequences2(str.substring(1), ans + (str.charAt(0) + 0));

        ansFrom1stCalls.addAll(ansFrom2ndCalls);
        ansFrom1stCalls.addAll(ansFrom3rdCallsAscii);

        return ansFrom1stCalls;
    }

    private static void subSequences(String str, String ans) {
        if (str.isEmpty()) {
            System.out.println(ans);
            return;
        }

        subSequences(str.substring(1), ans + str.charAt(0));
        subSequences(str.substring(1), ans);
    }

    private static String skipAStringButNotSkip(String str, String toSkip, String notSkip, String ans) {
        if (str.isEmpty()) {
            return ans;
        }

        if (str.startsWith(toSkip) && !str.startsWith(notSkip)) {
            return skipAStringButNotSkip(str.substring(toSkip.length()), toSkip, notSkip, ans);
        }
        return skipAStringButNotSkip(str.substring(1), toSkip, notSkip, ans + str.charAt(0));
    }

    private static String skipAString(String str, String toSkip, String ans) {
        if (str.isEmpty()) {
            return ans;
        }

        if (str.startsWith(toSkip)) { //if (str.substr(0, 5).equalsIgnoreCase(toSkip)
            return skipAString(str.substring(toSkip.length()), toSkip, ans);
        }
        return skipAString(str.substring(1), toSkip, ans + str.charAt(0));
    }

    private static String skipACharacter2(String str, String ans) {
        if (str.isEmpty()) {
            return ans;
        }

        char ch = str.charAt(0);
        if (ch == 'a') {
            return skipACharacter2(str.substring(1), ans);
        }
        return skipACharacter2(str.substring(1),ans + ch);
    }

    private static String skipACharacter(String str, int index, String ans) {
        if (index >= str.length()) {
            return ans;
        }

        if (str.charAt(index) == 'a') {
            return skipACharacter(str, index + 1, ans);
        }
        return skipACharacter(str, index + 1, ans + str.charAt(index));
    }
}