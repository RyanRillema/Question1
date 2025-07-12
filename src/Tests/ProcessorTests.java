package Tests;

import Backend.Processor;
import static org.junit.Assert.*;

import org.junit.Test;

public class ProcessorTests {
        
    @Test
    public void sortStringTest_InvlaidMode() {
        sortStringTest_InvalidMode(0,"Invalid Mode");
    }

    @Test
    public void sortStringTest_BubbleSort() {        
        sortStringTest_SharedTests(Backend.Processor.SORTMODE_BUBBLE,"Bubble Sort");
    }

    @Test
    public void sortStringTest_JavaUtilsSort() {        
        sortStringTest_SharedTests(Backend.Processor.SORTMODE_JAVA_UTILS,"Java Utils");
    }
    
    public void sortStringTest_SharedTests(Integer sortMode, String modeString) {
        //Shared tests for different sorting algorythms
        
        long startTime = System.nanoTime();

        // Simple test cases
        String result = Processor.sortString("cba",sortMode);
        assertEquals("abc", result);
        result = Processor.sortString("abcdefghijklmnopqrstuvwxyz",sortMode);
        assertEquals("abcdefghijklmnopqrstuvwxyz", result);
        result = Processor.sortString("zyxwvutsrqponmlkjihgfedcba",sortMode);
        assertEquals("abcdefghijklmnopqrstuvwxyz", result);
        result = Processor.sortString("Input String",sortMode);
        assertEquals("giinnprsttu", result);

        // Punctuation and spaces test cases
        result = Processor.sortString("Input String",sortMode);
        assertEquals("giinnprsttu", result);
        result = Processor.sortString("I!n@p#u$t S*t(ri)n+g",sortMode);
        assertEquals("giinnprsttu", result);

        // UTF-8 characters test cases (ensure we handle characters that are greater than 1 byte)
        result = Processor.sortString("café",sortMode);
        assertEquals("acfé", result);
        result = Processor.sortString("caf€",sortMode);
        assertEquals("acf€", result);

        // Edge cases
        result = Processor.sortString("",sortMode);
        assertEquals("", result);
        result = Processor.sortString(" ",sortMode);
        assertEquals("", result);
        result = Processor.sortString("!\"#$%&'()*+,-./:;<=>?@[]^_`{|}~",sortMode);
        assertEquals("", result);
        result = Processor.sortString("!\"#$%&'()*+,-./:;<=>?@[]^_`{|}~a",sortMode);
        assertEquals("a", result);

        //Use case test
        result = Processor.sortString("Contrary to popular belief, the pink unicorn flies east",sortMode);
        assertEquals("aaabcceeeeeffhiiiiklllnnnnooooppprrrrssttttuuy", result);
        result = Processor.sortString("The café sells pâté, piñata, and açai but we must pay in € :(",sortMode);
        assertEquals("aaaaaaabcdeeefhiiillmnnpppssstttttuuwyâçééñ€", result);

        // Larger strings
        result = Processor.sortString("pppppppppppp eeeeeeeeeeeeeeeeeeeeeeeeeee qqqqqqqqqqqqqqqqqqqqqqqqq ddddddddddddddddddddd aaaaaaaaaaaaaaaaaaaaaaaaaaaa lllllllllllllllllllllllllllll vvvvvvvvvvvvvvvvvvvvvv ttttttttttttttttttttttttttt bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk $$ sssssssssssssssssssssss zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz",sortMode);
        assertEquals("aaaaaaaaaaaaaaaaaaaaaaaaaaaabbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbdddddddddddddddddddddeeeeeeeeeeeeeeeeeeeeeeeeeeekkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkklllllllllllllllllllllllllllllppppppppppppqqqqqqqqqqqqqqqqqqqqqqqqqssssssssssssssssssssssstttttttttttttttttttttttttttvvvvvvvvvvvvvvvvvvvvvvzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz", result);
        
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        System.out.println("sortStringTest duration (nanoseconds) "+ modeString +"\t" + duration);
        
    }

    public void sortStringTest_InvalidMode(Integer sortMode, String modeString) {
        //Test invalid mode
        String result = Processor.sortString("abc",sortMode);
        assertEquals("Invalid mode", result);
    }
}
