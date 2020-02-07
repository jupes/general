/*


Imagine we have an image. We'll represent this image as a simple 2D array where every pixel is a 1 or a 0. The image you get is known to have a single rectangle of 0s on a background of 1s.

Write a function that takes in the image and returns one of the following representations of the rectangle of 0's: top-left coordinate and bottom-right coordinate OR top-left coordinate, width, and height.

image1 = [
  [1, 1, 1, 1, 1, 1, 1],
  [1, 1, 1, 1, 1, 1, 1],
  [1, 1, 1, 0, 0, 0, 1],
  [1, 1, 1, 0, 0, 0, 1],
  [1, 1, 1, 1, 1, 1, 1],
]

Sample output variations (only one is necessary):

findRectangle(image1) =>
  x: 3, y: 2, width: 3, height: 2
  2,3 3,5 -- row,column of the top-left and bottom-right corners

Other test cases:

image2 = [
  [1, 1, 1, 1, 1, 1, 1],
  [1, 1, 1, 1, 1, 1, 1],
  [1, 1, 1, 1, 1, 1, 1],
  [1, 1, 1, 1, 1, 1, 1],
  [1, 1, 1, 1, 1, 1, 0],
]

findRectangle(image2) =>
  x: 6, y: 4, width: 1, height: 1
  4,6 4,6

image3 = [
  [1, 1, 1, 1, 1, 1, 1],
  [1, 1, 1, 1, 1, 1, 1],
  [1, 1, 1, 1, 1, 1, 1],
  [1, 1, 1, 1, 1, 0, 0],
  [1, 1, 1, 1, 1, 0, 0],
]

findRectangle(image3) =>
  x: 5, y: 3, width: 2, height: 2
  3,5 4,6
  
image4 = [
  [0, 1, 1, 1, 1, 1, 1],
  [1, 1, 1, 1, 1, 1, 1],
  [1, 1, 1, 1, 1, 1, 1],
  [1, 1, 1, 1, 1, 1, 1],
  [1, 1, 1, 1, 1, 1, 1],
]

findRectangle(image4) =>
  x: 0, y: 0, width: 1, height: 1
  0,0 0,0

image5 = [
  [0],
]

findRectangle(image5) =>
  x: 0, y: 0, width: 1, height: 1
  0,0 0,0

n: number of rows in the input image
m: number of columns in the input image



*/

import java.io.*;
import java.util.*;

public class findRectangles {
  public static void main(String[] argv) {
    int[][] image1 = {
      {1, 1, 1, 1, 1, 1, 1},
      {1, 1, 1, 1, 1, 1, 1},
      {1, 1, 1, 0, 0, 0, 1},
      {1, 1, 1, 0, 0, 0, 1},
      {1, 1, 1, 1, 1, 1, 1}
    };

    int[][] image2 = {
      {1, 1, 1, 1, 1, 1, 1},
      {1, 1, 1, 1, 1, 1, 1},
      {1, 1, 1, 1, 1, 1, 1},
      {1, 1, 1, 1, 1, 1, 1},
      {1, 1, 1, 1, 1, 1, 0}
    };

    int[][] image3 = {
      {1, 1, 1, 1, 1, 1, 1},
      {1, 1, 1, 1, 1, 1, 1},
      {1, 1, 1, 1, 1, 1, 1},
      {1, 1, 1, 1, 1, 0, 0},
      {1, 1, 1, 1, 1, 0, 0}
    };

    int[][] image4 = {
      {0, 1, 1, 1, 1, 1, 1},
      {1, 1, 1, 1, 1, 1, 1},
      {1, 1, 1, 1, 1, 1, 1},
      {1, 1, 1, 1, 1, 1, 1},
      {1, 1, 1, 1, 1, 1, 1}
    };

    int[][] image5 = {
      {0}
    };
    // IT WORKS! 
    System.out.println(findRectangle(image1));
    System.out.println(findRectangle(image2));
    System.out.println(findRectangle(image3));
    System.out.println(findRectangle(image4));
    System.out.println(findRectangle(image5));

  }
  public static String findRectangle(int[][] matrix) {
    int rows = matrix.length;
    int cols = matrix[0].length;
    int width = 0;
    int height = 0;
    
    for(int i = 0; i < rows; i++) {
      for(int j = 0; j < cols; j++) {
        // go until find 0
        if(matrix[i][j] == 0) {
          // found 0, look for right and left bound
          width = findRowRectangleBound(matrix[i], j);
          height = findColRectangleBound(matrix, i, j);
          //  Starting Point i, j width: x, height y
          return printer(i,j,width,height);
        }
      }
    }
    return "something went wrong/ no rec found";
  }
  
  public static int findRowRectangleBound(int[] row, int start) {
    int width = 0;
    for(int j = start; j < row.length; j++) {
      if(row[j] == 0) {
        width++;
      } else {
        break;
      }
    }
    return width;
  }
  
  public static int findColRectangleBound(int[][] colMatrix, int row, int col) {
    int height = 0;
    for(int i = row; i < colMatrix.length; i++) {
      if(colMatrix[i][col] == 0) {
        height++;
      } else {
        break;
      }
    }
    return height;
  }
  
  // Nice print function
  public static String printer(int i, int j, int width, int height) {
    return ("Starting Point " + i + ", " + j + " width: " + width + ", height: " + height);
  }
  
}
