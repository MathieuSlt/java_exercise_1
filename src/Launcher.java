import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class Launcher {
    public static void main(String[] args) {
        System.out.println("Welcome, please enter a command. If you want to quit enter 'quit'");
        while (true) {
            Scanner input = new Scanner(System.in);
            String word = input.nextLine();

            if (word.equals("quit")) {
                break;
            }
            else if (word.equals("fibo")) {
                System.out.println("Please enter a number and I will give you its Fibonacci's value");
                Scanner sc = new Scanner(System.in);
                int n = sc.nextInt();
                sc.nextLine();
                System.out.println(fib(n));
            }
            else if (word.equals("freq")) {
                System.out.println("Please give me the path to a file you wish to know the 3 most used word in it");
                Scanner sc = new Scanner(System.in);
                String s = sc.nextLine();
                Path p = Paths.get(s);
                try {
                    String content = java.nio.file.Files.readString(p);
                    String[] lines = content.toLowerCase().split("\\r?\\n");
                    for (String line : lines) {
                        String[] newline = line.replaceAll("[()',.;:?!-]+"," ").split("\\s+");
                        System.out.println();
                        System.out.println(Arrays.toString(newline));
                    }
                } catch (IOException e) {
                    System.out.println("Unreadable file: " + e.getMessage());
                }

            }
            else {
                System.out.println("Unknown command");
            }
        }
    }
    public static int fib(int n) {
        if (n <= 1) return n;
        else return fib(n-1) + fib(n-2);
    }
}
//C:\Users\Mathieu\OneDrive\Bureau\dossier_de_loc.txt