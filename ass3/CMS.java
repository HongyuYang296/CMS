import java.util.ArrayList;
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
    private final ConferenceDatabase conferenceList;
    private final ReviewerDatabase reviewerDatabase;
    private boolean exitCMS;

    public CMS() {
        this.users = new UserDatabase();
        this.paperList = new PaperDatabase();
        this.conferenceList = new ConferenceDatabase();
        this.reviewerDatabase = new ReviewerDatabase();
        this.exitCMS = false;
    }

    private void readUserDatabase(){
        users.readFile();
    }

    private void readReviewerDatabase(){
        reviewerDatabase.readFile();
    }

    private void readPaperDatabase(){
        paperList.readFile();
    }

    private void readConferenceDatabase(){
        conferenceList.readFile();
    }
    private  void run() {
        mainPage();
    }

    private void mainPage(){
        while (!exitCMS) {
            Display.printMenu();
            Scanner scanner = new Scanner(java.lang.System.in);
            String option = scanner.nextLine();
            switch (option) {
                case "1" -> registration1();
                case "2" -> logIN();
                case "3" -> {
                    java.lang.System.out.println("Goodbye!!  thanks! ");
                    users.writeFile();
                    paperList.writeFile();
                    conferenceList.writeFile();
                    reviewerDatabase.writeFile();
                    exitCMS = true;//end the while loop
                }
                default -> Display.invalidInput();

            }
        }
    }
    private void registration1() {
        users.registration();
    }



    private void logIN(){
        Scanner input = new Scanner(java.lang.System.in);
        java.lang.System.out.println("input email: ");
        String email = input.nextLine();
        java.lang.System.out.println("input pass: ");
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
            reviewerPage(user);
        }

    }

    private void adminPage(){
        boolean exit = false;
        while (!exit) {
            Display.showAdminPage();
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
            Display.showAuthorPage();
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

    private void reviewerPage(User user) {
        reviewerDatabase.upload();
        boolean exit = false;
        while (!exit) {
            Display.showReviewerPage();
            Scanner input2 = new Scanner(java.lang.System.in);
            String option = input2.nextLine();
            switch (option) {
                case "1" -> selectTopics(user);
                case "2" -> selectPaper(user);
                case "3" -> giveEvaluation(user);
                case "4" -> {
                    mainPage();
                    exit = true;
                }
            }
        }
    }

    private void chairPage(){
        boolean exit = false;
        while (!exit) {
            Display.showChairPage();
            Scanner input2 = new Scanner(java.lang.System.in);
            String option = input2.nextLine();
            switch (option) {
                case "1" -> createConference();
                case "2" -> assignPaper();
                case "3" -> finalDecision();
                case "4" -> {
                    mainPage();
                    exit = true;
                }
            }
        }
    }

    private void createConference(){
        conferenceList.creatConference();
    }

    public Integer getIndex(Integer inputId){
        Integer index = null;
        for (int i = 0; i < reviewerDatabase.getReviewerArrayList().size(); i++) {
            if (inputId == reviewerDatabase.getReviewerArrayList().get(i).getId()){
                index = i;
            }
        }
        return index;
    }
    private void selectTopics(User user){
        reviewerDatabase.setTopics(getIndex(user.getUserid()));
    }

    private void selectPaper(User user){
        boolean exit = false;
        while (!exit) {
            showPaperList();
            System.out.println("please select one paper to review: ");
            Scanner input = new Scanner(java.lang.System.in);
            int selectPaper = Integer.parseInt(input.nextLine());
            if (selectPaper < 0 || selectPaper > paperList.getPaperList().size()){
                System.out.println("selected paper not exit!");
            }
            else {
                reviewerDatabase.selectPaper(getIndex(user.getUserid()), selectPaper);
                exit = true;
            }
        }
    }


    private void assignPaper(){
        boolean exit = false;
//        reviewerDatabase.getReviewerArrayList().get(reviewerDatabase.getIndex(user.getUserid()));
        while (!exit) {
            showPaperList();
            System.out.println("please select one paper for assign: ");
            Scanner input = new Scanner(java.lang.System.in);
            int selectPaper = Integer.parseInt(input.nextLine());
            if (selectPaper < 0 || selectPaper > paperList.getPaperList().size()){
                System.out.println("selected paper not exit!");
            }
            else {
                assignPaper2(selectPaper);
                exit = true;
            }
        }
    }


    private void assignPaper2(int selectPaper){
        boolean exit = false;
        while (!exit){
            showReviewerList();
            System.out.println("please select one reviewer for assign: ");
            Scanner input2 = new Scanner(java.lang.System.in);
            int selectReviewer = Integer.parseInt(input2.nextLine());
            if (!reviewerDatabase.getIdList().contains(selectReviewer)){
                System.out.println("selected reviewer not exit!");
            }
            else {
                reviewerDatabase.selectPaper(getIndex(selectReviewer), selectPaper);
                System.out.println("assign paper finished!");
                exit = true;
            }
        }
    }

    private int getPaperIndex(int input){
        int index = 0;
        for (int i = 0; i < paperList.getPaperList().size(); i++) {
            if (input == paperList.getPaperList().get(i).getPaperId()) {
                index = i;
            }
        }
        return index;
    }

    private void giveEvaluation(User user){
        System.out.println("please select one paper for giving evaluation(input paper ID)");
        showReviewerPaper(reviewerDatabase.getReviewerArrayList().get(getIndex(user.getUserid())).getPaperList());
        System.out.println("please select your options: ");
        Scanner input = new Scanner(java.lang.System.in);
        int selectPaper = Integer.parseInt(input.nextLine());
        boolean exit = false;
        while (!exit){
            if (!paperList.getIdList().contains(selectPaper)){
                System.out.println("paper not exit!");
            }
            else {
                paperList.getPaperList().get(getPaperIndex(selectPaper)).setEvaluation();
                exit = true;
            }
        }
    }

    private void finalDecision(){
        int selectPaper = selectPaper();
        boolean exit = false;
        while (!exit) {
            Display.finalDecision();
            Scanner input = new Scanner(java.lang.System.in);
            String option = input.nextLine();
            switch (option) {
                case "1" ->  {
                    paperList.getPaperList().get(getPaperIndex(selectPaper)).setState1("accept");
                    exit = true;
                }


                case "2" -> {
                    paperList.getPaperList().get(getPaperIndex(selectPaper)).setState1("reject");
                    exit = true;
                }

                case "3" -> {
                    selectPaper();
                    exit = true;
                }
            }
        }
    }

    private int selectPaper(){
        boolean exit = false;
        int choosePaperID = 0;
        while (!exit) {
            showPaperList();
            Scanner input = new Scanner(java.lang.System.in);
            int selectPaper = Integer.parseInt(input.nextLine());
            if (!paperList.getIdList().contains(selectPaper)){
                System.out.println("paper not exit!");
            }
            else {
                System.out.println();
                System.out.println("you have choose: ");
                System.out.println("paper id: " + paperList.getPaperList().get(getPaperIndex(selectPaper)).getPaperId()
                        + ", paper name: " + paperList.getPaperList().get(getPaperIndex(selectPaper)).getName() + ", evaluation: "
                        + paperList.getPaperList().get(getPaperIndex(selectPaper)).getEvaluation());
                choosePaperID = selectPaper;
                exit = true;
            }
        }
        return choosePaperID;
    }


    private void showReviewerPaper(ArrayList<Integer> reviewerPaperList){
        for (Integer integer : reviewerPaperList) {
            System.out.println(paperList.getPaperList().get(getPaperIndex(integer)));
        }
    }


    private void showReviewerList(){
        String listName = "reviewer";
        Display.show(reviewerDatabase.getReviewerArrayList(), listName);
    }


    private void submitPaper(User user){
        paperList.submitPaper(user);

    }

    private void showUserList() {
        String listName = "users";
        Display.show(users.getUserList(), listName);
    }

    private void showPaperList(){
        String listName = "papers";
        Display.show(paperList.getPaperList(), listName);
        System.out.println("please select your options: ");
    }


    public static void main(String[] args) {
        CMS s = new CMS();
        s.readUserDatabase();
        s.readPaperDatabase();
        s.readConferenceDatabase();
        s.readReviewerDatabase();
        s.run();
    }
}
