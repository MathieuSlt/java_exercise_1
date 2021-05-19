import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Launcher {

    public static void main(String[] args) {

        List<Command> c = List.of(new Quit(), new Fibo(), new Freq());
        Scanner input = new Scanner(System.in);

        do {
            System.out.println("Please enter a command. If you want to quit enter 'quit'");
            String command = input.nextLine();
            boolean found = false;
            for (var i : c) {
                if (i.name().equals(command)) {
                    if (i.run(input))
                        return;
                    found = true;
                }
            }
            if (!found)
                System.out.println("Unknown command");
        } while (true);
    }
}

//C:\Users\Mathieu\OneDrive\Bureau\dossier_de_loc.txt