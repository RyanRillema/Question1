package Backend;

public class Processor {

    public static final int SORTMODE_BUBBLE = 1;
    public static final int SORTMODE_JAVA_UTILS = 2;

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

}