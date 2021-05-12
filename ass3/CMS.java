import java.util.Scanner;

/**
 * Write a description of class here.
 *
 * @author team56
 * @version 1.0 (28 Apr 2021)
 */

public class CMS {
    private final UserDatabase users;
    private final PaperDatabase paperList;
    private boolean exitCMS;

    public CMS() {
        this.users = new UserDatabase();
        this.paperList = new PaperDatabase();
        this.exitCMS = false;
    }

    private void readUserdatabase(){
        users.readfile();

    }

    private void readPaperDatabase(){
        paperList.readFile();
    }
    private  void run() {
        mainPage();
    }

    private void mainPage(){
        while (!exitCMS) {
            Dispaly.printMenu();
            Scanner scanner = new Scanner(java.lang.System.in);
            String option = scanner.nextLine();
            switch (option) {
                case "1" -> registration1();
                case "2" -> logIN();
                case "3" -> {
                    java.lang.System.out.println("Goodbye!!  thanks! ");
                    users.writeFile();
                    exitCMS = true;//end the while loop
                }
                default -> {
                    Dispaly.invalidInput();
                }
            }
        }


    }

    private void registration1() {
        users.registration();
    }


    private void logIN(){
        Scanner input = new Scanner(java.lang.System.in);
        java.lang.System.out.println("imput email: ");
        String email = input.nextLine();
        java.lang.System.out.println("imput pass: ");
        String password = input.nextLine();
        User user = users.logIn(email,password);
        if (user != null && "Admin".equals((user.getUserType()))){
            java.lang.System.out.println(user);
            adminPage();
        }
        else if (user != null && "Author".equals((user.getUserType()))){
            authorPage();

    }

    }

    private void adminPage(){
        boolean exit = false;
        while (!exit) {
            Dispaly.showAdminPage();
            Scanner input2 = new Scanner(java.lang.System.in);
            String option = input2.nextLine();
            switch (option) {
                case "1" -> showUserList();
                case "2" -> showPaperList();
                case "3" -> {
                    mainPage();
                    exit = true;
                }
            }
        }
    }

    private void authorPage() {
        boolean exit = false;
        while (!exit) {
            Dispaly.showAuthorPage();
            Scanner input2 = new Scanner(java.lang.System.in);
            String option = input2.nextLine();
            switch (option) {
                case "1" -> submitPaper();
                case "2" -> {
                    mainPage();
                    exit = true;
                }
            }
        }
    }

    private void submitPaper(){
        java.lang.System.out.println("select one submit");

    }


    private void showUserList() {
        Dispaly.show(users.getUserlist());
    }

    private void showPaperList(){
        Dispaly.show(paperList.getPaperList());
    }

    public static void main(String[] args) {
        CMS s = new CMS();
        s.readUserdatabase();
        s.readPaperDatabase();
        s.run();
    }

}
