public class ErrorBankManager {

    public static void wrongCredentials() {
        System.out.println("ERROR:\nIncorrect credentials or user does not exist!");
    }

    public static void insufficientBalance() {
        System.out.println("ERROR:\nYour bank account balance is to low.");
    }
}
