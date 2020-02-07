// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class findIntGap {
    public int solution(int[] A) {
        // write your code in Java SE 8
        //sort the array
        Arrays.sort(A);
        
        //handle edge cases where all negative or no 1
        if(A[0] > 1 || A[A.length-1] < 0 ) {
            return 1;
        }
        
        //check for gaps, return if found
        for(int i = 0; i < A.length-1; i++) {
            //ignore duplicate values
            if (A[i] == A[i+1] || A[i] < 0) {
                continue;
            }
            if (A[i] + 1 != A[i+1]) {
                return A[i]+1;
            }
                
        }
        //if here then array has no gaps and starts at 1
        return A[A.length-1]+1;
    }
}