package DataStructures;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

//TODO try to use just one hash map instead of two
public class HashTableRansomNote {

    public static HashMap<String, Integer> getStringFrequency(String[] text) {
        HashMap<String, Integer> frequencies = new HashMap<String, Integer>();
        for (String word : text) {
            if (!frequencies.containsKey(word)) {
                frequencies.put(word, 0);
            }
            frequencies.put(word, frequencies.get(word) + 1);
        }
        return frequencies;
    }

    public static boolean hasEnoughStrings(HashMap<String, Integer> magFreq, HashMap<String, Integer> noteFreq) {
        for (Map.Entry<String, Integer> entry : noteFreq.entrySet()) {
            String word = entry.getKey();
            if(!magFreq.containsKey(word) || magFreq.get(word) < entry.getValue()) {
                return false;
            }
        }
        return true;
    }

    public static boolean canBuildRansomNote(String[] magazine, String[] note) {
        HashMap<String, Integer> magazineFrequency = getStringFrequency(magazine);
        HashMap<String, Integer> noteFrequency = getStringFrequency(note);
        return hasEnoughStrings(magazineFrequency, noteFrequency);
    }

    public static void main(String[] args) {
        String[] magazine = {"hello", "world", "world"};
        String[] note = {"hello", "world", "world"};
        System.out.println(canBuildRansomNote(magazine, note));
    }
}