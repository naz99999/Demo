package stack;

import java.util.Arrays;
import java.util.Stack;

public class InterviewQues {
    public static void main(String args[]) {
        int maxSum = 10;
        int[] a = {1, 2, 3, 4, 5};
        int[] b = {6, 7, 8, 9};
        //-1 because last call would break the condition and yet would be added to the count
        //System.out.println(gameOfStacks(a, b, maxSum) - 1);
        System.out.println(minInsertions(")))())("));
    }

    private static int gameOfStacks(int[] a, int[] b, int maxSum) {
        int sum = 0, count = 0;
        return func(a, b, sum, count, maxSum);
    }

    private static int func(int[] a, int[] b, int sum, int count, int maxSum) {
        if (sum > maxSum)
            return count;

        if (a.length == 0 || b.length == 0) {
            return count;
        }

        int count1 = func(Arrays.copyOfRange(a, 1, a.length), b, sum + a[0], count + 1, maxSum);
        int count2 = func(a, Arrays.copyOfRange(b, 1, b.length), sum + b[0], count + 1, maxSum);

        return Math.max(count1, count2);
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else {
                if (ch == ')') {
                    if (stack.isEmpty() || stack.pop()!='(') {
                        return false;
                    }
                }
                if (ch == '}') {
                    if (stack.isEmpty() || stack.pop()!='{') {
                        return false;
                    }
                }
                if (ch == ']') {
                    if (stack.isEmpty() || stack.pop()!='[') {
                        return false;
                    }
                }
            }
        }
        return stack.empty();
    }

    public int minAddToMakeValid(String s) {
        Stack<Character> stack = new Stack<>();
        int minAdd = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                stack.push(ch);
                minAdd++;
            } else {
                if (ch == ')') {
                    if (stack.isEmpty()) {
                        minAdd++;
                    } else if (stack.pop()=='(') {
                        minAdd--;
                    }
                }
            }
        }
        return minAdd;
    }

    //https://leetcode.com/problems/minimum-insertions-to-balance-a-parentheses-string/
    public static int minInsertions(String s) {
        Stack<Character> stack=new Stack<>();
        int count=0;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c == '('){
                stack.push(c);
            }
            else{
                if(i+1<s.length()&& s.charAt(i+1)==')'){
                    i++;
                }
                else {
                    count++;
                }

                if(!stack.isEmpty()){
                    stack.pop();
                }
                else{
                    count++;
                }
            }
        }
        count += 2*stack.size();
        return count;
    }
}


