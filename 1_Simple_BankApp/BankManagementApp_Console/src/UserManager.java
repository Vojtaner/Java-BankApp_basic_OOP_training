import java.util.ArrayList;
import java.util.List;

public class UserManager {
    private static List<User> users = new ArrayList<>();
    private static User userInstance;

    public static void addUserToDatabase(User user){
        users.add(user);
    }

    public static User getUserInstance() {
        return userInstance;
    }

    public static void showUsers(){
        System.out.println("All registered users are:");
        for (User user : users) {
            System.out.println(user.getName()+" - "+ user.getRole());
        }
    }

    public static boolean isUserRegistered (String name,String password) {
        for (User user : users) {
            String concatenatedValues = user.getName()+user.getPassword();
            if (concatenatedValues.equals(name+password)) {
                userInstance = user;
                return true;
            }
        }
        return false; }

    public static List<User> getUsers(){
        return users;
    }
}

