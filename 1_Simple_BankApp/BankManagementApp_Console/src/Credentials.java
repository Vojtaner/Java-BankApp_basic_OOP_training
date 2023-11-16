//class Credentials
//- methods: changeName,changePassword,changeAddress


import java.security.SecureRandom;
import java.util.LinkedHashMap;
import java.util.Map;

public class Credentials {
    private String userName;
    private String adress;
    private static final String LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static final String NUMBERS = "0123456789";
//    private static final String SPECIAL_CHARS = "!@#$%^&*()-_=+[]{}|;:,.<>?";
    public static boolean passwordExists = false;
    public Map<String,String> credentialDetails = new LinkedHashMap<>();




    private String generatePassword() {
        byte length = 8;
        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int type = random.nextInt(2);
            switch (type) {
                case 0: // Add a random letter
                    password.append(LETTERS.charAt(random.nextInt(LETTERS.length())));
                    break;
                case 1: // Add a random number
                    password.append(NUMBERS.charAt(random.nextInt(NUMBERS.length())));
                    break;
//                case 2: // Add a random special character
//                    password.append(SPECIAL_CHARS.charAt(random.nextInt(SPECIAL_CHARS.length())));
//                    break;
            }
        }return password.toString();
    }

    public Map<String,String> createCredentials (String userName,String address) {
        credentialDetails.put("User Name",userName);
        credentialDetails.put("Address", address);
        credentialDetails.put("Password",generatePassword());
        return credentialDetails;
    }

    public void show(){
        System.out.println("Please note your credentials for later sign in.");
        for (Map.Entry<String, String> value : credentialDetails.entrySet()) {
            System.out.println(value.getKey() + ": " + value.getValue());
        }
    }
}

