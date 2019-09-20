/*
 * Write an algorithm such that if an element in an MxN matrix is 0, 
 * its entire row and column is set to 0.
 */
package array_string;

import java.util.Arrays;

/**
 *
 * @author Milad
 */
public class Seven {
    public static void main(String[] args){
        int[][] matrix = {{1,2,3},{4,0,6}, {7,8,9}};
        int[][] result = setZero(matrix);
        int[][] result2 = setZero2(matrix);
                
        for(int i = 0; i < result.length; i++){
                for(int j = 0; j < result[0].length; j++){
                    System.out.print(result[i][j] + "  ");
                }
                System.out.println("");
        }
        for(int i = 0; i < result2.length; i++){
                for(int j = 0; j < result2[0].length; j++){
                    System.out.print(result2[i][j] + "  ");
                }
                System.out.println("");
        }
    }
    
    /////Solution 1: Mine
    public static int[][] setZero(int[][] matrix){
        //It is neccessary to copy matrix to newMatrix one by one element. If we just use newMatrix = matrix it cause that both variable refer to same address point
        int[][] newMatrix = new int[matrix.length][matrix[0].length];
        for(int i = 0; i < matrix.length; i++)
            for(int j = 0; j < matrix[0].length; j++)
                newMatrix[i][j] = matrix[i][j];
        
        
        for(int i = 0; i < matrix.length; i++)
            for(int j = 0; j < matrix[0].length; j++)
                if(matrix[i][j] == 0)
                    putZero(newMatrix, i, j);  
        return newMatrix;
    }
    
    public static void putZero(int[][] newMatrix, int i, int j){
        
        for(int m = 0; m < newMatrix[0].length; m++)
            newMatrix[i][m] = 0;
        for(int n = 0; n < newMatrix.length; n++)
            newMatrix[n][j] = 0;
    }
    ///////////////////
    
    /////Solution 2: Book's
    public static int[][] setZero2(int[][] matrix){
        int[] row = new int[matrix.length];
        int[] column = new int[matrix[0].length];
        
        for(int i = 0; i < matrix.length; i++)
            for(int j = 0; j < matrix[0].length; j++)
                if(matrix[i][j] == 0){
                    row[i] = 1;
                    column[j] =1;
                }
        for(int i = 0; i < matrix.length; i++)
            for(int j = 0; j < matrix[0].length; j++)
                if(row[i] == 1 || column[j] == 1)
                    matrix[i][j] = 0;
        return matrix;
    }
}
