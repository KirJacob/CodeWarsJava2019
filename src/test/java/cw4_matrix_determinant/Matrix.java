package cw4_matrix_determinant;

public class Matrix {
    /*  1 2 5
        3 4 6
        7 8 1  */

    public static String printMatrix(int[][] matrix) {
        int size = matrix.length;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++) {
                stringBuilder.append(matrix[i][j]);
                if (j != size - 1) stringBuilder.append(" ");
                else stringBuilder.append("\n");
            }
        return stringBuilder.toString();
    }

    static int[][] getLefting(int[][] matrix, int x, int y) {
        int size = matrix.length - 1;
        int[][] result = new int[size][size];
        int ex = 0, ey;
        for (int ox = 0; ox < matrix.length; ox++) {
            ey = 0;
            for (int oy = 0; oy < matrix.length; oy++) {
                if (ox != x)
                    if (oy != y) {
                        result[ex][ey] = matrix[ox][oy];
                        ey++;
                    }
            }
            if (ox != x) ex++;
        }
        return result;
    }

    static int determinant(int[][] matrix) {
        int size = matrix.length;
        int detResult = 0;

        if (size == 1) return matrix[0][0];
        for (int i = 0; i < size; i++) {
            int minus = (int)Math.pow(-1, i);
            int[][]lefting = getLefting(matrix, 0, i);
            detResult = detResult + matrix[0][i]*(minus)*determinant(lefting);
        }
        return detResult;
    }

    public static void main(String[] args) {
        int[][]matrix2 = new int[][]{{1,2},{3,4}};
        System.out.println(printMatrix(matrix2));
        System.out.println(determinant(matrix2));

        int[][]matrix3 = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(printMatrix(matrix3));
        System.out.println(determinant(matrix3));

        int[][] matrix4 = new int[][]{{1, 2, 1, 5}, {4, 5, 1, 9}, {8, 9, 0, 2}, {9, 9, 1, 3}};
        System.out.println(printMatrix(matrix4));
        System.out.println(determinant(matrix4));
    }
}
