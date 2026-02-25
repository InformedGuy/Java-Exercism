class Matrix {

    private static int[][] rowMatrix;
    private static int[][] columnMatrix;

    Matrix(String matrixAsString) {
        String[] matrix = matrixAsString.split("\n");

        int numberOfRows = matrix.length;
        int numberOfColumns = (int) matrix[0].chars()
                .filter(c -> c == ' ')
                .count() + 1;

        createMatrix(matrix, numberOfRows, numberOfColumns);
    }

    int[] getRow(int rowNumber) {
        return rowMatrix[rowNumber - 1];
    }

    int[] getColumn(int columnNumber) {
        return columnMatrix[columnNumber - 1];
    }

    private void createMatrix(String[] matrix, int numberOfRows, int numberOfColumns) {
        rowMatrix = new int[numberOfRows][numberOfColumns];
        columnMatrix = new int[numberOfColumns][numberOfRows];

        for (int i = 0; i < numberOfRows; i++) {
            String[] row = matrix[i].split(" ");

            for (int j = 0; j < numberOfColumns; j++) {
                int currentNumber = Integer.parseInt(row[j]);

                rowMatrix[i][j] = currentNumber;
                columnMatrix[j][i] = currentNumber;
            }
        }
    }
}
