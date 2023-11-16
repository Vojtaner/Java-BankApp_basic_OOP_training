//class BankAccount
//- methods: createAccount,deleteAccount

import java.util.Random;

public class BankAccount {


    public static String generateAccountNumber() {
        byte length = 8;
        var random = new Random();
        var sb = new StringBuilder(length);
        for(byte i = 0;i < length;i++){
            sb.append(random.nextInt(10));
        } return sb.toString();
    }
}
