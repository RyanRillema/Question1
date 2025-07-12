package Backend;

import java.util.Map;
import java.util.TreeMap;

public class Processor {

    public static final int SORTMODE_BUBBLE = 1;
    public static final int SORTMODE_JAVA_UTILS = 2;
    public static final int SORTMODE_TREEMAP = 3;

    public static String sortString(String inputString, Integer sortMode) {
        String returnString;

        // Convert to lowercase
        inputString = inputString.toLowerCase();
        // Remove punctuation
        inputString = inputString.replaceAll("\\p{Punct}", "");
                     
        // Allow different modes to test different sorting algorithms
        if (sortMode == SORTMODE_BUBBLE) {
            returnString = sortString_Bubble(inputString);            
        } else if (sortMode == SORTMODE_JAVA_UTILS) {
            returnString = sortString_JavaUtils(inputString);
        } else if (sortMode == SORTMODE_TREEMAP) {
            returnString = sortString_TreeMap(inputString);
        } else {
            returnString = "Invalid mode";
        }            

        return returnString.trim();
    }
    
    public static String sortString_Bubble(String inputString) {
        //Manual bubble sort. This should be the slowest

        for (int i = 0; i < inputString.length() - 1; i++) {
            for (int j = 0; j < inputString.length() - i - 1; j++) {
                if (inputString.charAt(j) > inputString.charAt(j + 1)) {
                    // Swap characters
                    char temp = inputString.charAt(j);                    
                    inputString = inputString.substring(0, j) + inputString.charAt(j + 1) + temp + inputString.substring(j + 2);
                }
            }
        }
        
        return inputString;
    }

    public static String sortString_JavaUtils(String inputString) {
        // Built in Java tools
              
        char[] charArray = inputString.toCharArray();
        java.util.Arrays.sort(charArray);
        return new String(charArray);
    }

    public static String sortString_TreeMap(String inputString) {
        // Use a sorted map to produce the output. My thinking is rather than sorting the string which involves moving characters around,
        // we can use a map to count the occurrences of each character and then build the sorted string from that.
        
        String returnString = "";
        TreeMap<String, Integer> sortedMap = new TreeMap<>();

        for (char c : inputString.toCharArray()) {
            String key = String.valueOf(c);           

            sortedMap.put(key, sortedMap.getOrDefault(key, 0) + 1);

        }
        
        for (Map.Entry<String, Integer> entry : sortedMap.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            for (int i = 0; i < value; i++) {
                returnString += key;
            }            
        }       
        
        return returnString;

    }

}