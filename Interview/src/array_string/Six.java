/*
 * Given an image represented by an NxN matrix, where each pixel in the image is 4 bytes, 
 * write a method to rotate the image by 90 degrees. Can you do this in place?
 */
package array_string;

/**
 *
 * @author Milad
 */
public class Six {
    public static void main(String[] args){
        char[][] matrix = {
            {'a','b','c'},
            {'d','e','f'},
            {'g','h','i'},
        };
        
        System.out.println(matrix.length);
        
        char[][] result = rotate(matrix);
        if(result == null) {
            System.out.println("Rows and Columns are not equal!");
        } else{
            for(int i = 0; i < result.length; i++){
                for(int j = 0; j < result.length; j++){
                    System.out.print(result[i][j] + "  ");
                }
                System.out.println("");
            }
        }
    }
    
    public static char[][] rotate(char[][] m1){
        
        int row = m1.length;
        int column = m1[0].length;
        if(row != column)
            return null;
        char[][] m2 = new char[row][column];
        
        for(int i = 0; i < row; i++){
            for(int j = 0; j < column; j++){
                m2[i][j] = m1[(row-1)-j][i];
            }
        }
        return m2;
    }
}
