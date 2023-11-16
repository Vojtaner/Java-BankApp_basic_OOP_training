
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LoginHandler {
    public Map<String, Runnable> options;
    Scanner scanner;
    String loginName;
    String loginPassword;

    public LoginHandler() {
        options = new HashMap<>();
        initializeChoice();
        scanner = new Scanner(System.in);
    }

    private void initializeChoice() {
        options.clear();
        var accountCreator = new AccountCreator();
        options.put("1", accountCreator::createUser);
        options.put("2", this::logIn);
        options.put("3",BankApp::stop);
    }

    private void logIn (){
        System.out.println("\n\n----------------------------------------\n\n");
        System.out.println("\nPlease login:");
        System.out.print("User Name: ");
        loginName = scanner.nextLine();
        System.out.print("Password: ");
        loginPassword = scanner.nextLine();
        if (UserManager.isUserRegistered(loginName,loginPassword)) {
            System.out.println("Succcess");
            System.out.println("You are logged!");
            User user = UserManager.getUserInstance();
            Menu.next(user);
          }
        else {
        ErrorBankManager.wrongCredentials();
        logIn();
        }
    }

    public void displayLoginPage() {
        System.out.println("____WELCOME IN OUR BANK____\n");
        System.out.println("Please login or create an account:\n");
        System.out.println("1. Create an account");
        System.out.println("2. Login");
        System.out.println("3. End program\n");
    }
}
