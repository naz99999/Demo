package recursion;

public class Level1 {
    public static void main(String[] args) {
        int n = 14;
        //System.out.println(rev (n));
        //System.out.println(rev2 (n));
        //System.out.println(palindromeOrNot(n));
        //System.out.println(countNoOfZeroes(10020030));
        //System.out.println(numberOfStepsToReduceNumberZero(n));
    }

    //Reverse of a number
    private static int rev(int n) {
        if(n==0) {
            return 0;
        }
        return (int) (((n % 10) * Math.pow(10, count(n/10))) + rev(n / 10));
    }

    private static int count(int n) {
        int count = 0;
        while (n!=0) {
            count++;
            n = n/10;
        }
        return count;
    }

    //Reverse of a number2
    private static int rev2(int n) {
        int digits = (int) (Math.log10(n)) + 1;
        return helper(n, digits);
    }

    private static int helper(int n, int digits) {
        if(n==0) {
            return 0;
        }
        return n%10 * (int)(Math.pow(10, digits-1)) + helper(n/10, digits-1);
    }

    //Number palindrome or not
    private static boolean palindromeOrNot(int n) {
        int digits = (int) (Math.log10(n)) + 1;
        return n == helper(n, digits);
    }

    //Count No Of Zeroes
    private static int countNoOfZeroes(int n) {
        int count = 0;
        //return helperCountNoOfZeroes2(n, count);
        return helperCountNoOfZeroes(n);
    }

    //special pattern, how to pass a value to above calls
    private static int helperCountNoOfZeroes2(int n, int count) {
        if (n==0) {
            return count;
        }

        if (n%10 == 0)
            return helperCountNoOfZeroes2(n/10, count+1);
        else
            return helperCountNoOfZeroes2(n/10, count);

    }

    private static int helperCountNoOfZeroes(int n) {
        if (n==0) {
            return 0;
        }
        int count=0;
        if (n%10 == 0) {
            count++;
        }
        count = count + helperCountNoOfZeroes(n/10);

        return count;
    }

    //https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/description/
    private static int numberOfStepsToReduceNumberZero(int n) {
        int count = 0;
        return helperNumberOfStepsToReduceNumberZero(n, count);
    }

    private static int helperNumberOfStepsToReduceNumberZero(int n, int count) {
        if (n==0) {
            return count;
        }

        if (n%2==0) {
            return  helperNumberOfStepsToReduceNumberZero(n/2, count+1);
        } else {
            return  helperNumberOfStepsToReduceNumberZero(n-1, count+1);
        }
    }

}
