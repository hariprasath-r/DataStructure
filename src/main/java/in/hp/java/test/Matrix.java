package in.hp.java.test;

class Mainn {
    public static void main(String[] args) {
        Matrix matrix = new Matrix();
        int result = matrix.countSquares(new int[][]{
                {0, 1, 1, 1},
                {1, 1, 1, 1},
                {0, 1, 1, 1}
        });

        System.out.println(result);
//        {1, 1, 1, 1, 1},
//        {1, 1, 1, 1, 0},
//        {1, 1, 1, 1, 1},
//        {0, 1, 1, 1, 0}
    }
}

public class Matrix {

    int[][] matrix;
    int[][] flagMatrix;
    int rowLength;
    int columnLength;
    int sum = 0;

    public int countSquares(int[][] matrix) {
        this.matrix = matrix;
        this.rowLength = matrix.length;
        this.columnLength = matrix[0].length;

        if (rowLength == 0 && columnLength == 0)
            return 0;

        int side1 = 0;
        for (int i = 0; i < rowLength; i++)
            for (int j = 0; j < columnLength; j++)
                side1 += matrix[i][j];

        this.sum += side1;
        recurseDimension(2);
        return this.sum;
    }

    private void sumOfSides(int r, int c, int dimension, boolean colFlag) {
        if (dimension + r > rowLength || dimension + c > columnLength || this.flagMatrix[r][c] == 1)
            return;

        int checkValue = dimension * dimension;
        this.flagMatrix[r][c] = 1;

        int sum = 0;
        for (int i = r; i < dimension + r; i++) {
            for (int j = c; j < dimension + c; j++)
                sum += matrix[i][j];
        }

        if (sum == checkValue)
            this.sum += 1;

        if (!colFlag)
            sumOfSides(r + 1, c, dimension, false);
        sumOfSides(r, c + 1, dimension, true);
    }


    private void recurseDimension(int dimension) {
        if (dimension > rowLength || dimension > columnLength) {
            return;
        }
        this.flagMatrix = new int[rowLength][columnLength];
        sumOfSides(0, 0, dimension, false);
        recurseDimension(++dimension);
    }
}
