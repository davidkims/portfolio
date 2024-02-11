import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Mains {

    private static final int MAX = 999999;
    private static final int RED = 0;
    private static final int BLUE = 1;
    private static final int RED_START = 1;
    private static final int BLUE_START = 2;
    private static final int RED_END = 3;
    private static final int BLUE_END = 4;
    private static final int BLOCK = 5;

    private static final boolean[][][] visited = new boolean[4][4][2];
    private static final int[][] map = new int[4][4];
    static final boolean isRedEnd;
    private static Point red;
    private static Point blue;
    private static Point curRed;
    private static Point curBlue;
    private static Point p;
    private static int i;

    static {
        isRedEnd = false;
    }

    static final boolean isBlueEnd;

    static {
        isBlueEnd = false;
    }

    private static int n;
    private static int m;

    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        int[][] maze = {
                {5, 1, 0, 0},
                {0, 5, 5, 0},
                {0, 0, 5, 5},
                {0, 0, 2, 4}
        };

        solution(maze);
    }

    private static boolean check(Point red, Point blue, Point curRed, Point curBlue) {
        Mains.red = red;
        Mains.blue = blue;
        Mains.curRed = curRed;
        Mains.curBlue = curBlue;
        // Check boundaries and obstacles
        // Check if both balls are in the same position
        // Check if either ball reaches the end point
        // Implement your check logic here
        return true;
    }

    private static Point move() {
        return move(null, 0);
    }

    private static Point move(Point p, int i) {
        Mains.p = p;
        Mains.i = i;
        // Implement move logic here
        return new Point(p.x, p.y);
    }

    private static int backtracking(Point red, Point blue, int result) {
        // Implement backtracking logic here
        return MAX;
    }

    public static void solution(int[][] maze) {
        Point red = null;
        Point blue = null;

        n = maze.length;
        m = maze[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = maze[i][j];

                if (maze[i][j] == RED_START) {
                    red = new Point(i, j);
                    visited[i][j][RED] = true;
                } else if (maze[i][j] == BLUE_START) {
                    blue = new Point(i, j);
                    visited[i][j][BLUE] = true;
                }
            }
        }

        int answer = backtracking(red, blue, 0);
        System.out.println(answer);
    }

    private static void saveToFile(String path, String content) {
        try {
            FileWriter writer = new FileWriter(new File(path));
            writer.write(content);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}