
import java.io.*;
import java.util.*;

public class Welcome {
    // task 1 c)
    public static void sum(String inputLine) throws IOException {

        String[] integers = inputLine.split(" ");
        int sum = 0;
        for (int i = 0; i < integers.length; i++) {
            sum += Integer.parseInt(integers[i]);
        }

        System.out.println(sum);
        FileWriter OutStream = new FileWriter("eclipse_test.txt", true);
        PrintWriter printer = new PrintWriter(OutStream);
        printer.println(Integer.toString(sum));
        OutStream.close();
    }// end of sum method

    public static void main(String[] args) throws Exception {
        PrintWriter OutW = new PrintWriter("eclipse_test.txt");
        // Task 1 a)
        System.out.println("Welcome to Java");
        // Task 1 b)
        System.out.println(System.currentTimeMillis());
        String time = String.valueOf(((long) System.currentTimeMillis()));
        OutW.println(time);
        OutW.close();
        // task 1 c)
        try (Scanner scan = new Scanner(System.in)) {
            String lineOfIntegers = scan.nextLine();
            sum(lineOfIntegers);
        }

    }// end of main
}// end of welcome class
