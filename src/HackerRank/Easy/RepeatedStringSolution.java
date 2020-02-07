package HackerRank.Easy;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class RepeatedStringSolution {

    // Complete the repeatedString function below.
    static long repeatedString(String s, long n) {
        long sumOfAs = 0;
        char[] tmpArr = s.toCharArray();
        int arrLength =  tmpArr.length;
        for(int i = 0; i < arrLength; i++) {
            if(tmpArr[i] == 'a') {
                sumOfAs++;
            }
        }
        int aInRemainder = 0;
        char[] newCharArray = Arrays.copyOfRange(tmpArr, 0, Math.toIntExact(n%arrLength));
        for(int j = 0; j < newCharArray.length; j++) {
            if(newCharArray[j] == 'a') {
                aInRemainder++;
            }
        }
        long result = (sumOfAs * (long) Math.floor(n/arrLength)) + aInRemainder;
        
        return result;
    }


    public static void main(String[] args) throws IOException {
        
    }
}
