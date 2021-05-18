import java.util.Scanner;

public class Launcher {
    public static void main(String[] args) {
        System.out.println("Welcome, please enter a command. If you want to quit enter 'quit'");
        boolean test = true;

        while (test) {
            Scanner input = new Scanner(System.in);
            String word = input.nextLine();

            if (word.equals("quit")) {
                test = false;
            } else if (word.equals("fibo")) {
                System.out.println("Please enter a number and I will give you its Fibonacci's value");
                Scanner sc = new Scanner(System.in);
                int n = sc.nextInt();
                sc.nextLine();

                System.out.println(fib(n));
                //System.out.println(sum);
            } else {
                System.out.println("Unknown command");
            }
        }
    }
    private static int fib(int n) {
        if (n <= 1) return n;
        else return fib(n-1) + fib(n-2);
    }
}
