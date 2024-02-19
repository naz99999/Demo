package backtracking;

public class Maze {
    public static void main(String[] args) {
        int[][] maze = new int[3][3];
        System.out.println(countNoOfPaths(maze, 3, 3));
        displayNoOfPaths(maze, 3, 3, "");
        //mazeWithObstacles()
    }

    private static void displayNoOfPaths(int[][] maze, int r, int c, String path) {
        if (r == 1 && c == 1) {
            System.out.println(path);
        }
        if (r > 1 && c > 1) {
            displayNoOfPaths(maze, r - 1, c - 1, path + "S"); //DIAGONAL
        }
        if (r > 1) {
            displayNoOfPaths(maze, r - 1, c, path + "D"); //DOWN
        }
        if (c > 1) {
            displayNoOfPaths(maze, r, c - 1, path + "R"); //RIGHT
        }
    }

    private static int countNoOfPaths(int[][] maze, int r, int c) {
        if (r == 1 && c == 1) {
            return 1;
        }
        int count = 0;
        if (r > 1 && c > 1) {
            count += countNoOfPaths(maze, r - 1, c - 1); //DIAGONAL
        }
        if (r > 1) {
            count += countNoOfPaths(maze, r - 1, c); //DOWN
        }
        if (c > 1) {
            count += countNoOfPaths(maze, r, c - 1); //RIGHT
        }
        return count;
    }
}
