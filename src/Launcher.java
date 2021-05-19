import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

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
                    String[] lines = content.toLowerCase().replaceAll("[()',.;:?!-]+"," ").split("\\s+");
                    freq(lines, 3);
                } catch (IOException e) {
                    System.out.println("Unreadable file: " + e.getMessage());
                }
            }
            else {
                System.out.println("Unknown command");
            }
        }
    }
    @SuppressWarnings("unchecked")
    public static void freq(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words)
            map.put(word, map.getOrDefault(word, 0) + 1);

        int n = words.length;
        List<String>[] buckets = new List[n + 1];

        for (int i = 0; i < n + 1; i++)
            buckets[i] = new ArrayList<>();
        for (String key : map.keySet())
            buckets[map.get(key)].add(key);

        for (List<String> bucket : buckets)
            Collections.sort(bucket);

        List<String> top = new ArrayList<>();

        for (int i = n; (i >= 0) && (top.size() < k); i--)
            for (int j = 0; (j < buckets[i].size()) && (top.size() < k); j++)
                top.add(buckets[i].get(j));

        System.out.println(top.get(0) + " " + top.get(1) + " " + top.get(2));
    }

    public static int fib(int n) {
        if (n <= 1) return n;
        else return fib(n-1) + fib(n-2);
    }
}
//C:\Users\Mathieu\OneDrive\Bureau\dossier_de_loc.txt