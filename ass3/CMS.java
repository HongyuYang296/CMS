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
            adminPage();
        }
        else if (user != null && "Author".equals((user.getUserType()))){
            authorPage(user);
    }
        else if (user != null && "Chair".equals((user.getUserType()))){
            chairPage();
        }
        else if (user != null && "Reviewer".equals((user.getUserType()))){
            reviewerPage();
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

    private void authorPage(User user) {
        boolean exit = false;
        while (!exit) {
            Dispaly.showAuthorPage();
            Scanner input2 = new Scanner(java.lang.System.in);
            String option = input2.nextLine();
            switch (option) {
                case "1" -> submitPaper(user);
                case "2" -> {
                    mainPage();
                    exit = true;
                }
            }
        }
    }

    private void reviewerPage() {
        Dispaly.showReviewerPage();
        boolean exit = false;
        while (!exit) {
            Dispaly.showAuthorPage();
            Scanner input2 = new Scanner(java.lang.System.in);
            String option = input2.nextLine();
            switch (option) {
                case "1" -> notfineshed();
                case "2" -> notfineshed();
                case "3" -> {
                    mainPage();
                    exit = true;

                }
            }
        }
    }

    private void chairPage(){
        Dispaly.showChairPage();
        boolean exit = false;
        while (!exit) {
            Dispaly.showAuthorPage();
            Scanner input2 = new Scanner(java.lang.System.in);
            String option = input2.nextLine();
            switch (option) {
                case "1" -> creatConference();
                case "2" -> assignPaper();
                case "3" -> {
                    mainPage();
                    exit = true;

                }
            }
        }
    }

    private void creatConference(){

    }

    private void assignPaper(){

    }

    private void submitPaper(User user){
        paperList.submitPaper(user);


    }

    private void showUserList() {
        String listName = "users";
        Dispaly.show(users.getUserlist(), listName);
    }

    private void showPaperList(){
        String listName = "papers";
        Dispaly.show(paperList.getPaperList(), listName);
    }

    private void notfineshed(){
        System.out.println("not finished");
    }

    public static void main(String[] args) {
        CMS s = new CMS();
        s.readUserdatabase();
        s.readPaperDatabase();
        s.run();
    }




}
