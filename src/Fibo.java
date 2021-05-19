import java.util.Scanner;

public class Fibo implements Command {

    @Override
    public String name() {
        return "fibo";
    }

    @Override
    public boolean run(Scanner sc){
        System.out.println("Please enter a number and I will give you its Fibonacci's value");
        int n = sc.nextInt();
        sc.nextLine();
        System.out.println(fib(n));
        return false;
    }

    private static int fib(int n) {
        if (n <= 1) return n;
        else return fib(n-1) + fib(n-2);
    }
}
