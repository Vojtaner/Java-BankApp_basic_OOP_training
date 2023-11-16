public class BankApp {
    private Menu menu;

    public BankApp() {
        this.menu = new Menu();

    }
    public void run (){
        menu.start();
    }
    public static void stop(){System.exit(0);}
}
