import java.util.Scanner;

public class Launcher {
    public static void main(String[] args) {
        System.out.println("Welcome, please enter a word. If you want to quit enter 'quit'");

        Scanner input = new Scanner(System.in);
        String word = input.nextLine();
        if (word.equals("quit")) {
            ;
        } else {
            System.out.println("Unknown command");
        }

    }
}
