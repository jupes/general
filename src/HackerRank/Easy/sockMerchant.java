import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class SockMerchantSolution {

    // Complete the sockMerchant function below.
    static int sockMerchant(int n, int[] ar) {
        HashSet hashSet = new HashSet(n);
        Arrays.sort(ar);
        int count = 0;
        for(int i = 0; i < n; i++) {
            if(hashSet.contains(ar[i])) {
                count++;
                hashSet.remove(ar[i]);
            } else {
                hashSet.add(ar[i]);
            }
        }
        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        // Test Unsorted Array 
        int[] testArray1 = {2,1,1,3,4,5,0,7};
        int result = sockMerchant(n, testArray1);

    }
}