import javax.xml.namespace.QName;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Freq implements Command {
    @Override
    public String name() {
        return "freq";
    }

    @Override
    public boolean run(Scanner sc) {
        System.out.println("Please give me the path to a file you wish to know the 3 most used word in it");
        String s = sc.nextLine();
        Path p = Paths.get(s);
        try {
            String content = java.nio.file.Files.readString(p);
            String[] lines = content.toLowerCase().replaceAll("[()',.;:?!-]+"," ").split("\\s+");
            freq(lines, 3);
        } catch (IOException e) {
            System.out.println("Unreadable file: " + e.getMessage());
        }
        return false;
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
}
