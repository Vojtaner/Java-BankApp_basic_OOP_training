import java.util.HashMap;
import java.util.Map;


public class Menu {
    private static Map<String, Runnable> options;

    public Menu() {
        options = new HashMap<>();
    }


    private static void initializeCustomerMenu(User user) {
        options.clear();
        options.put("1", user::withdraw);
        options.put("2", user::deposit);
        options.put("3", user::transferTo);
        options.put("4", Menu::start);

        System.out.println("\n\n----------------------------------------\n\n");
        System.out.println("1. Withdraw money?");
        System.out.println("2. Deposit money?");
        System.out.println("3. Transfer money to?");
        System.out.println("4. Log out?");

        ChoiceHandler.handleChoice(options);
        initializeCustomerMenu(user);
    }

    private static void initializeAdminMenu(User user){
        options.clear();
        options.put("1", user::deleteAccountTo);
        options.put("2",user::showAllAccounts);
        options.put("3",Menu::start);

        System.out.println("\n\n----------------------------------------\n\n");
        System.out.println("1. Delete account?");
        System.out.println("2. Show all accounts?");
        System.out.println("3. Log out?");

        ChoiceHandler.handleChoice(options);
        initializeAdminMenu(user);
    }
    private static void initializeEmployeeMenu(User user){
        options.clear();
        options.put("1", user::showAccountCredentialsOf);
        options.put("2",Menu::start);

        System.out.println("\n\n----------------------------------------\n\n");
        System.out.println("1. Show account credentials of...?");
        System.out.println("2. Log out?");
        ChoiceHandler.handleChoice(options);
        initializeEmployeeMenu(user);
    }

    public static void start() {

        var login = new LoginHandler();
        login.displayLoginPage();
        ChoiceHandler.handleChoice(login.options);
    }

    public static void next(User user){
        switch (user.getRole()){
            case "admin": {
                Menu.initializeAdminMenu(user);
            };
            case "customer":{
                Menu.initializeCustomerMenu(user);
            };
            case "employee":{
                Menu.initializeEmployeeMenu(user);
            };
        }
    }
}
