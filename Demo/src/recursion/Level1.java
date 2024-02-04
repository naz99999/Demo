package recursion;

public class Level1 {
    public static void main(String[] args) {
        int n = 1001;
        //System.out.println(rev (n));
        //System.out.println(rev2 (n));
        //System.out.println(palindromeOrNot(n));
        System.out.println(countNoOfZeroes(n));
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
        return helperCountNoOfZeroes2(n, count);
        //return helperCountNoOfZeroes(n, count);
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

    private static int helperCountNoOfZeroes(int n, int count) {
        if (n==0) {
            return 0;
        }

        int ans = helperCountNoOfZeroes(n/10, count);
        if (n%10 == 0) {
            count++;
        }
        return count + ans;
    }
}
