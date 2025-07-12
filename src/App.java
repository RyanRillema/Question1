import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        
        Implementation();
          
    }   

    public static void Implementation() {
        //Foreground implementation of Processor.sortString()

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter input: "); 

        //Wait for user input
        String input = scanner.nextLine();

        String result = Backend.Processor.sortString(input,1);
        System.out.println("Result: " + result);

        scanner.close();
    }

}
