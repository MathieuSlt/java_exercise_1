import java.util.Scanner;

public class Predict implements Command {

    @Override
    public String name() {
        return "predict";
    }

    @Override
    public boolean run(Scanner sc) {
        return false;
    }
}
