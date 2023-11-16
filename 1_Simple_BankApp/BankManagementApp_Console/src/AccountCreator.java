

import java.util.Scanner;

public class AccountCreator {
    private Scanner scanner;
    private UserManager users = new UserManager();
    private User user;

    public AccountCreator() {
        this.scanner = new Scanner(System.in);
    }

    public void createUser() {
        System.out.println("\n\n----------------------------------------\n\n");
        System.out.println("You are creating your account.\n" +
                "We need your name and adress.\n" +
                "Password and bankaccount will be generated.\n");
        System.out.print("Name: ");
        String userName = scanner.nextLine();
        System.out.print("Adress: ");
        String address = scanner.nextLine();
        System.out.println("What account? admin/customer/employee");
        String role = scanner.nextLine();
        System.out.println("\n\n----------------------------------------\n\n");
        user = new User(userName, address,role);
        UserManager.addUserToDatabase(user);
        System.out.println("\n\n----------------------------------------\n\n");
        Menu.start();
    }
}