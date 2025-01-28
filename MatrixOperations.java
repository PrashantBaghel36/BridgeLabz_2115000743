import java.util.*;
public class MatrixOperations {
    public static void main(String[] args) {
        int rows = 2;
        int cols = 2;
        int[][] matrix1 = createRandomMatrix(rows, cols);
        int[][] matrix2 = createRandomMatrix(rows, cols);
        int[][] sum = addMatrices(matrix1, matrix2);
        int[][] difference = subtractMatrices(matrix1, matrix2);
        int[][] product1 = multiplyMatrices(matrix1, matrix2);
        int[][] product2 = multiplyMatrices(matrix2, matrix1);
        int[][] transpose1 = transposeMatrix(matrix1);
        int[][] transpose2 = transposeMatrix(matrix2);
        int determinant1 = findDeterminant(matrix1);
        int determinant2 = findDeterminant(matrix2);
        System.out.println("Matrix 1:");
        displayMatrix(matrix1);
        System.out.println("Matrix 2:");
        displayMatrix(matrix2);
        System.out.println("Sum:");
        displayMatrix(sum);
        System.out.println("Difference:");
        displayMatrix(difference);
        System.out.println("Product (matrix1 * matrix2):");
        displayMatrix(product1);
        System.out.println("Product (matrix2 * matrix1):");
        displayMatrix(product2);
        System.out.println("Transpose of Matrix 1:");
        displayMatrix(transpose1);
        System.out.println("Transpose of Matrix 2:");
        displayMatrix(transpose2);
        System.out.println("Determinant of Matrix 1: " + determinant1);
        System.out.println("Determinant of Matrix 2: " + determinant2);
    }
    public static int[][] createRandomMatrix(int rows, int cols) {
        int[][] matrix = new int[rows][cols];
        Random rand = new Random();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = rand.nextInt(10);
            }
        }
        return matrix;
    }
    public static int[][] addMatrices(int[][] matrix1, int[][] matrix2) {
        int rows = matrix1.length;
        int cols = matrix1[0].length;
        int[][] result = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
        return result;
    }
    public static int[][] subtractMatrices(int[][] matrix1, int[][] matrix2) {
        int rows = matrix1.length;
        int cols = matrix1[0].length;
        int[][] result = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = matrix1[i][j] - matrix2[i][j];
            }
        }
        return result;
    }
    public static int[][] multiplyMatrices(int[][] matrix1, int[][] matrix2) {
        int rows1 = matrix1.length;
        int cols1 = matrix1[0].length;
        int rows2 = matrix2.length;
        int cols2 = matrix2[0].length;
        if (cols1 != rows2) {
            return null; // Matrices cannot be multiplied
        }
        int[][] result = new int[rows1][cols2];
        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < cols2; j++) {
                for (int k = 0; k < cols1; k++) {
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        return result;
    }
    public static int[][] transposeMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] result = new int[cols][rows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[j][i] = matrix[i][j];
            }
        }
        return result;
    }
    public static int findDeterminant(int[][] matrix) {
        if (matrix.length != 2 || matrix[0].length != 2) {
            return 0; // Only for 2x2 matrices
        }
        return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
    }

    public static void displayMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
