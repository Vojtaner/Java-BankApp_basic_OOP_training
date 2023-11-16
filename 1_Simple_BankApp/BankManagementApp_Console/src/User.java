//class Customer
//methods: getAccountDetails,getBalance,
//         getTransactionDetails,deleteMyAccount
//         deposit,withdraw,invest,sendMoneyTo,changePassword,
//         displayInvitation,changeAuthentication

import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class User{
    private final Map<String, String> credentialsMap;
    private int balance = 1000;
    private final String bankAccount;
    private final Scanner scanner = new Scanner(System.in);
    private String userRole;


    public String getBankAccount() {
        return bankAccount;
    }

    public User(String userName, String address, String userRole) {
        System.out.println("\n\n----------------------------------------\n\n");
        System.out.println("Generating " + userRole + "...");
        var credentials = new Credentials();
        credentials.createCredentials(userName, address);
        this.bankAccount = BankAccount.generateAccountNumber() + "/2700";
        credentials.credentialDetails.put("Bank Account", this.bankAccount);
        credentials.credentialDetails.put("Role", userRole);
        this.credentialsMap = credentials.credentialDetails;
        System.out.println(userRole.toUpperCase() + " created!\n");
        credentials.show();
    }

    public void showCredentials() {
        System.out.println("*****YOUR CREDENTIALS*****");
        for (String key : credentialsMap.keySet()) {
            String value = credentialsMap.get(key);
            System.out.println(key + ": " + value);
        }
    }

    public String getName() {
        return credentialsMap.get("User Name");
    }

    public String getPassword() {
        return credentialsMap.get("Password");
    }

    public String getRole() {
        return credentialsMap.get("Role");
    }

    public void withdraw() {
        System.out.println("\n\n----------------------------------------\n\n");
        System.out.print("How much money do you want to withdraw? " + "(balance:" + balance + "$): ");
        int amount = scanner.nextInt();
        if (getBalance() > amount) {
            this.balance = balance - amount;
        } else {
            ErrorBankManager.insufficientBalance();
        }
        System.out.println("Account balance: " + balance);
    }

    public void deposit() {
        System.out.println("\n\n----------------------------------------\n\n");
        System.out.print("How much money do you want to deposit? " + "(balance:" + balance + "$): ");
        int amount = scanner.nextInt();
        this.balance += amount;
        System.out.println("Account balance: " + balance);
    }

    public void addMoney(int amount) {
        balance += amount;
    }

    public void transferTo() {
        System.out.println("\n\n----------------------------------------\n\n");
        System.out.print("How much money do you want to transfer? " + "(balance:" + balance + "$): ");
        int amount = scanner.nextInt();
        System.out.print("Please input target account number: ");
        String bankAccount = scanner.next();
        if (getBalance() > amount) {
            for (User user : UserManager.getUsers()) {
                if (bankAccount.equals(user.getBankAccount())) {
                    user.addMoney(amount);
                    this.balance -= amount;
                }
            }
        } else {
            ErrorBankManager.insufficientBalance();
        }
    }

    public int getBalance() {
        return balance;
    }

    public String getAddress() {
        return credentialsMap.get("Address");
    }

    public void deleteAccountTo() {
        System.out.println("\n\n----------------------------------------\n\n");
        System.out.print("Which account do you want to delete: ");
        String bankAccount = scanner.nextLine();

        boolean accountFound = false;

        Iterator<User> iterator = UserManager.getUsers().iterator();
        while (iterator.hasNext()) {
            User user = iterator.next();
            if (bankAccount.equals(user.getBankAccount())) {
                iterator.remove();
                System.out.println("Bank account successfully deleted!");
                accountFound = true;
                break; // No need to continue the loop once an account is found
            }
        }

        if (!accountFound) {
            System.out.println("Bank account not found!");
            System.out.println("See the list, dear ADMIN");
            showAllAccounts();
        }
    }

    public void showAllAccounts() {
        System.out.println("\n\n----------------------------------------\n\n");
        System.out.println("ADMIN ACCOUNTS DETAILS\n\nName |  Password  |  Address  | Balance |  Bank account\n");

        for (User user : UserManager.getUsers()) {
            System.out.println(user.getName() + " | " + user.getPassword() + " | " + user.getAddress() + " | " + user.getBalance() + " | "+user.getBankAccount());
        }

    }

    public void showAccountCredentialsOf() {
        System.out.println("\n\n----------------------------------------\n\n");
        System.out.print("Which account details do you want to show: ");
        String bankAccount = scanner.nextLine();
        for (User user : UserManager.getUsers()) {
            if (bankAccount.equals(user.getBankAccount())) {
                System.out.println(user.getName() + " | " + user.getPassword() + " | " + user.getAddress() + " | " + user.getBalance());
            }
        }
    }
}

