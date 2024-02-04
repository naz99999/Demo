package pattern;

public class Diamond {
    public static void main(String[] args) {

        int n = 5;

        for(int row = 1; row <= 2 * n - 1; row++) {
            int totalSpaces = row > n ? row - n : n - row;
            for(int space = 1; space <= totalSpaces; space++) {
                System.out.print(" ");
            }
            int totalColumns = row > n ? 2 * n - row : row;
            for(int col = 1; col <= totalColumns; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }

    }
}
