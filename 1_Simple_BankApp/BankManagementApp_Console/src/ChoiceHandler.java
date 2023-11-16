import java.util.Map;
import java.util.Scanner;

public class ChoiceHandler {
    public ChoiceHandler() {

    }

    private static String getUserChoice() {
        var scanner = new Scanner(System.in);
        System.out.print("Input your choice: ");
        return scanner.nextLine();
    }

    static void handleChoice(Map<String, Runnable> options) {
        String choice;
        do {
            choice = getUserChoice();
            Runnable action = options.getOrDefault(choice, () -> System.out.println("Invalid choice. Please try again."));
            action.run();
        } while (!options.containsKey(choice));

    }
}