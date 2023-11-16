//class Credentials
//- methods: changeName,changePassword,changeAddress
//    - inherited by Employee,Customer

//class BankAccount
//- methods: createAccount,deleteAccount

//class Admin:
//methods: blockAccount,viewAccountDetails,resetPassword

//class Authentication
//methods: authenticate,changeAuthenticationSetting,
//         logOut,logIn,secureLogOut

//class InterestCalculation:
//methods: increaseInterest,setInterest,getInterest

//class ErrorHandler:
// methods: insufficientBalance,wrongCredentials


public class Main {
    public static void main(String[] args) {
        var bank = new BankApp();
        bank.run();
    }
}