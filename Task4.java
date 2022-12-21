public class Task4 {

    static boolean isCorrectSingle(boolean[][] board, int[] position) {
        for (int i = 0; i < 8; i++) {
            if (board[position[0]][i] && position[1] != i) {
                return false;
            }
            if (board[i][position[1]] && position[0] != i) {
                return false;
            }
        }
        int x = position[0];
        int y = position[1];
        while (x > 0 && y > 0) {
            x--;
            y--;
            if (board[x][y]) {
                return false;
            }
        }
        x = position[0];
        y = position[1];
        while (x < 7 && y < 7) {
            x++;
            y++;
            if (board[x][y]) {
                return false;
            }
        }
        x = position[0];
        y = position[1];
        while (x < 7 && y > 0) {
            x++;
            y--;
            if (board[x][y]) {
                return false;
            }
        }
        x = position[0];
        y = position[1];
        while (x > 0 && y < 7) {
            x--;
            y++;
            if (board[x][y]) {
                return false;
            }
        }
        return true;
    }

    static boolean isCorrect(boolean[][] board, int[][] positions) {
        for (int i = 0; i < 8; i++) {
            if (!isCorrectSingle(board, positions[i])) {
                return false;
            }
        }
        return true;
    }

    static void setAll(boolean[][] board, int[][] positions, boolean value) {
        for (int[] pos : positions) {
            board[pos[0]][pos[1]] = value;
        }
    }

    static int[][] queenPositions() {
        boolean[][] board = new boolean[8][8];
        int[][]positions = new int[8][2];
        for (int i = 0; i < 57; i++) {
            positions[0] = new int[]{i / 8, i % 8};
            for (int j = i + 1; j < 58; j++) {
                positions[1] = new int[]{j / 8, j % 8};
                for (int k = j + 1; k < 59; k++) {
                    positions[2] = new int[] {k / 8, k % 8};
                    for (int l = k + 1; l < 60; l++) {
                        positions[3] = new int[]{l / 8, l % 8};
                        for (int m = l + 1; m < 61; m++) {
                            positions[4] = new int[]{m / 8, m % 8};
                            for (int n = m + 1; n < 62; n++) {
                                positions[5] = new int[]{n / 8, n % 8};
                                for (int o = n + 1; o < 63; o++) {
                                    positions[6] = new int[]{o / 8, o % 8};
                                    for (int p = o + 1; p < 64; p++) {
                                        positions[7] = new int[]{p / 8, p % 8};
                                        setAll(board, positions, true);
                                        if (isCorrect(board, positions)) {
                                            return positions;
                                        }
                                        setAll(board, positions, false);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return new int[0][0];
    }

    static char posIntToChar(int pos) {
        return (char)(pos + 65);
    }

    static void printPositions(int[][] positions) {
        for (int i = 0; i < 7; i++) {
            System.out.printf("%c%d, ", posIntToChar(positions[i][0]), positions[i][1] + 1);
        }
        System.out.printf("%c%d\n", posIntToChar(positions[7][0]), positions[7][1] + 1);
    }

    public static void main(String[] args) {
        printPositions(queenPositions());
    }
}
