import java.util.Scanner;

public class Quit implements Command {
    @Override
    public String name() {
        return "quit";
    }

    @Override
    public boolean run(Scanner sc) {
        return true;
    }
}

