package pl.mikolaj.old.leetcode.zigzag;

public class Solution {
    public String convert(String s, int numRows) {
        int numCols = calculateNumberOfColumns(s, numRows);
        char[][] zigzag = buildZigZag(s, numRows, numCols);
        printZigZag(zigzag);
        return zigZagToString(zigzag);
    }

    private String zigZagToString(char[][] zigzag) {
        StringBuilder sb = new StringBuilder();
        for (char[] row : zigzag) {
            for (char c : row) {
                if (c != 0) {
                    sb.append(c);
                }
            }
        }
        return sb.toString();
    }

    private char[][] buildZigZag(String s, int numRows, int numCols) {
        char[][] zigzag = new char[numRows][numCols];
        if (numRows == 1) {
            for (int i = 0; i < s.length(); i++) {
                zigzag[0][i] = s.charAt(i);
            }
            return zigzag;
        }
        int i = 0;
        int k = 0;
        while (i < s.length()) {
            for (int j = 0; j < numRows && i < s.length(); j++, i++) {
                zigzag[j][k] = s.charAt(i);
            }
            k++;
            for (int j = numRows - 2; j > 0 && i < s.length(); j--, k++, i++) {
                zigzag[j][k] = s.charAt(i);
            }
        }
        return zigzag;
    }

    private int calculateNumberOfColumns(String s, int numRows) {
        if (numRows == 1) {
            return s.length();
        }

        int numCols = 0;
        int i = 0;
        boolean down = true;
        while (i < s.length()) {
            if (down) {
                i += numRows;
                down = false;
                numCols++;
            } else {
                i += numRows - 2;
                down = true;
                numCols += numRows - 2;
            }
        }
        return numCols;
    }

    private void printZigZag(char[][] zigzag) {
        for (int i = 0; i < zigzag.length; i++) {
            for (int j = 0; j < zigzag[i].length; j++) {
                System.out.print(zigzag[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        //String s = "ABCD";
        String s = "PAYPALISHIRING";
        //String s = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Solution solution = new Solution();
        String result = solution.convert(s, 4);
        System.out.println(result);
    }
}
