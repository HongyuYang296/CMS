import java.util.ArrayList;
import java.util.Scanner;
/**
 * This is the main class -> Conference Management System(CMS) class
 * CMS class aim to control sign up/log in and going to different home page base on different user type.
 *
 * @author team56
 * @version 2.0 (21 May 2021)
 */

public class CMS {
    private final UserDatabase users;
    private final PaperDatabase paperList;
    private final ConferenceDatabase conferenceList;
    private final ReviewerDatabase reviewerDatabase;
    private boolean exitCMS;

    /**
     * constructor for class CMS
     */
    public CMS() {
        this.users = new UserDatabase();
        this.paperList = new PaperDatabase();
        this.conferenceList = new ConferenceDatabase();
        this.reviewerDatabase = new ReviewerDatabase();
        this.exitCMS = false;
    }

    /**
     * read the all .txt file by calling function from other class
     *
     * @see UserDatabase#readFile()
     * @see ReviewerDatabase#readFile()
     * @see PaperDatabase#readFile()
     * @see ConferenceDatabase#readFile()
     */
    private void readTxtFiles(){
        users.readFile();
        reviewerDatabase.readFile();
        paperList.readFile();
        conferenceList.readFile();
    }

    /**
     * re-write the all .txt file by calling function from other class
     *
     * @see UserDatabase#writeFile()
     * @see ReviewerDatabase#writeFile()
     * @see PaperDatabase#writeFile()
     * @see ConferenceDatabase#writeFile()
     */
    private void writeTxtFiles(){
        users.writeFile();
        paperList.writeFile();
        conferenceList.writeFile();
        reviewerDatabase.writeFile();
    }

    /**
     * show the main page of this system
     * use while loop to re-display menu / use switch to get into different options
     *
     * @see UserDatabase#registration()
     * @see Display#invalidInput()
     */
    private void mainPage(){
        while (!exitCMS) {
            Display.printMenu();
            Scanner scanner = new Scanner(java.lang.System.in);
            String option = scanner.nextLine();
            switch (option) {
                case "1" -> users.registration();
                case "2" -> logIN();
                case "3" -> {
                    java.lang.System.out.println("Goodbye!!  thanks! ");
                    writeTxtFiles();
                    exitCMS = true;//end the while loop
                }
                default -> Display.invalidInput();
            }
        }
    }

    /**
     * This method log into system and automatically go to different user page based on different role of users
     *
     * @see UserDatabase#logIn()
     */
    private void logIN(){
        User user = users.logIn();
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
        else if (user == null)  tryAgain();
    }

    /**
     * This method run when log in failed ask user log in again or exit.
     *
     * @see UserDatabase#logIn()
     * @see Display#showTry()
     * @see Display#invalidInput()
     */
    private void tryAgain(){
        boolean exit = false;
        while (!exit) {
            Display.showTry();
            Scanner input2 = new Scanner(java.lang.System.in);
            String option = input2.nextLine();
            switch (option) {
                case "1" -> logIN();
                case "2" -> {
                    mainPage();
                    exit = true;
                }
                default -> Display.invalidInput();
            }
        }
    }

    /**
     * This method show admin page
     *
     * @see Display#invalidInput()
      */
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
                default -> Display.invalidInput();
            }
        }
    }

    /**
     * This method using while to re-display author page
     * using switch to get into different sub method
     *
     * @see PaperDatabase#submitPaper(User)
     * @see Display#invalidInput()
     * @param user insert user information from log in
     */
    private void authorPage(User user) {
        boolean exit = false;
        while (!exit) {
            Display.showAuthorPage();
            Scanner input2 = new Scanner(java.lang.System.in);
            String option = input2.nextLine();
            switch (option) {
                case "1" -> paperList.submitPaper(user);
                case "2" -> {
                    mainPage();
                    exit = true;
                }
                default -> Display.invalidInput();
            }
        }
    }

    /**
     * This method using while to re-display reviewer page
     * using switch to get into different sub method
     *
     * @see ReviewerDatabase#upload()
     * @see Display#invalidInput()
     * @param user insert user information from log in
     */
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
                default -> Display.invalidInput();
            }
        }
    }

    /**
     * This method using while to re-display chair page
     * using switch to get into different sub method
     *
     * @see Display#invalidInput()
     */
    private void chairPage(){
        boolean exit = false;
        while (!exit) {
            Display.showChairPage();
            Scanner input = new Scanner(java.lang.System.in);
            String option = input.nextLine();
            switch (option) {
                case "1" -> createConference();
                case "2" -> assignPaper();
                case "3" -> finalDecision();
                case "4" -> {
                    mainPage();
                    exit = true;
                }
                default -> Display.invalidInput();
            }
        }
    }

    /**
     * This method create new conference by calling method from class ConferenceDatabase
     *
     * @see ConferenceDatabase#createConference()
     */
    private void createConference(){
        conferenceList.createConference();
    }

    /**
     * This method can get index of reviewer from reviewer arraylist when input reviewer ID
     *
     * @see ReviewerDatabase#getReviewerArrayList()
     * @see Reviewer#getId()
     * @param inputId input reviewer ID
     * @return index index of reviewer arraylist
     */
    public Integer getIndex(Integer inputId){
        Integer index = null;
        for (int i = 0; i < reviewerDatabase.getReviewerArrayList().size(); i++) {
            if (inputId == reviewerDatabase.getReviewerArrayList().get(i).getId()){
                index = i;
            }
        }
        return index;
    }

    /**
     * This method select topics for reviewer
     *
     * @see ReviewerDatabase#setTopics(int)
     * @param user user who log in
     */
    private void selectTopics(User user){
        reviewerDatabase.setTopics(getIndex(user.getUserId()));
    }

    /**
     * This method ask reviewer select paper to review
     *
     * @see PaperDatabase#getPaperList()
     * @see ReviewerDatabase#selectPaper(int, int)
     * @see Display#invalidInput()
     * @param user user who log in
     * @exception NumberFormatException e when input not int, throw out exception
     */
    private void selectPaper(User user){
        boolean exit = false;
        while (!exit) {
            showPaperList();
            System.out.println("please select one paper to review: ");
            try {
                Scanner input = new Scanner(java.lang.System.in);
                int selectPaper = Integer.parseInt(input.nextLine());
                if (selectPaper < 0 || selectPaper > paperList.getPaperList().size()) {
                    System.out.println("selected paper not exit!");
                } else {
                    reviewerDatabase.selectPaper(getIndex(user.getUserId()), selectPaper);
                    exit = true;
                }
            }
            catch (NumberFormatException e) {
                Display.invalidInput();
            }
        }
    }

    /**
     * This method select one paper for assign
     *
     * @see PaperDatabase#getPaperList()
     * @see Display#invalidInput()
     * @exception NumberFormatException e when input not int, throw out exception
     */
    private void assignPaper(){
        boolean exit = false;
        while (!exit) {
            showPaperList();
            System.out.println("please select one paper for assign: ");
            try {
                Scanner input = new Scanner(java.lang.System.in);
                int selectPaper = Integer.parseInt(input.nextLine());
                //Check if the input int in the paper arraylist
                if (selectPaper < 0 || selectPaper > paperList.getPaperList().size()) {
                    System.out.println("selected paper not exit!");
                } else {
                    assignReviewer(selectPaper);
                    exit = true;
                }
            }
            catch (NumberFormatException e){
                Display.invalidInput();
            }
        }
    }

    /**
     * This method select reviewer for assign
     *
     * @see ReviewerDatabase#getIdList()
     * @see ReviewerDatabase#selectPaper(int, int)
     * @see Display#invalidInput()
     * @param selectPaper inset paperID to identity which paper being assign to this reviewer
     *  @exception NumberFormatException e when input not int, throw out exception
     */
    private void assignReviewer(int selectPaper){
        boolean exit = false;
        while (!exit){
            showReviewerList();
            System.out.println("please select one reviewer for assign(input reviewerID): ");
            try {
                Scanner input2 = new Scanner(java.lang.System.in);
                int selectReviewer = Integer.parseInt(input2.nextLine());
                if (!reviewerDatabase.getIdList().contains(selectReviewer)) {
                    System.out.println("selected reviewer not exit!");
                } else {
                    reviewerDatabase.selectPaper(getIndex(selectReviewer), selectPaper);
                    exit = true;
                }
            }
            catch (NumberFormatException e) {
                Display.invalidInput();
            }
        }
    }

    /**
     * This method can get paper index for paper arraylist when input paperID
     *
     * @see PaperDatabase#getPaperList()
     * @param input input paperID
     * @return index index of paper arraylist
     */
    private int getPaperIndex(int input){
        int index = 0;
        for (int i = 0; i < paperList.getPaperList().size(); i++) {
            if (input == paperList.getPaperList().get(i).getPaperId()) {
                index = i;
            }
        }
        return index;
    }

    /**
     * This method get and show all paper reviewer already have and ask them select one to give evaluation
     * when evaluation successfully set, remove this paper from arraylist of paper of this reviewer
     *
     * @see ReviewerDatabase#getReviewerArrayList()
     * @see Reviewer#getPaperList()
     * @see PaperDatabase#getPaperList()
     * @see Paper#setEvaluation()
     * @see Display#show(ArrayList, String)
     * @param user user who log in
     * @exception NumberFormatException e when input not int, throw out exception
     */
    private void giveEvaluation(User user){
        boolean exit = false;
        while (!exit){
            System.out.println("Paper under reviewing: ");
            // show all the paper of reviewer
            Display.show(reviewerDatabase.getReviewerArrayList().get(getIndex(user.getUserId())).getPaperList(),
                    " already have paper");
            System.out.println();
            System.out.println("Please please select one paper for giving evaluation(Please input paper ID): ");
            try {
                Scanner input = new Scanner(java.lang.System.in);
                int selectPaper = Integer.parseInt(input.nextLine());
                // check if the select paper exit in reviewer's paper list
                if (!reviewerDatabase.getReviewerArrayList().get(getIndex(user.getUserId())).getPaperList().contains(selectPaper)) {
                    System.out.println("Paper not exit!");
                    System.out.println();
                } else {
                    System.out.println("you have choose" + paperList.getPaperList().get(getPaperIndex(selectPaper)));
                    paperList.getPaperList().get(getPaperIndex(selectPaper)).setEvaluation();
                    // when give evaluation remove it from arraylist
                    reviewerDatabase.getReviewerArrayList().get(getIndex(user.getUserId())).removePaper(selectPaper);
                    exit = true;
                }
            }
            catch (NumberFormatException e){
                Display.invalidInput();
            }
        }
    }

    /**
     * This method allowed chair to give final decision of accept or reject of paper
     * use method "getSelectPaper()" to select one paper then give decision
     * then use method "setState1()" to set state
     *
     * @see Display#invalidInput()
     * @see PaperDatabase#getPaperList()
     * @see Paper#setState(String)
     */
    private void finalDecision(){
        int selectPaper = getSelectPaper();
        boolean exit = false;
        while (!exit) {
            Display.finalDecision();
            Scanner input = new Scanner(java.lang.System.in);
            String option = input.nextLine();
            switch (option) {
                case "1" ->  {
                    paperList.getPaperList().get(getPaperIndex(selectPaper)).setState1("accept");
                    System.out.println("Paper accept");
                    exit = true;
                }
                case "2" -> {
                    paperList.getPaperList().get(getPaperIndex(selectPaper)).setState1("reject");
                    System.out.println("Paper reject");
                    exit = true;
                }
                case "3" -> {
                    chairPage();
                    exit = true;
                }
                default -> Display.invalidInput();
            }
        }
    }

    /**
     * This method show all the paper from select conference
     * then ask chair to select one paper for final decision
     *
     * @see ConferenceDatabase#selectConference()
     * @see PaperDatabase#getPaperList()
     * @exception NumberFormatException e when input not int, throw out exception
     * @return choosePaperID
     */
    private int getSelectPaper(){
        int selectConference = conferenceList.selectConference();
        boolean exit = false;
        int choosePaperID = 0;
        while (!exit) {
            showSelectConferencePaper(selectConference);
            System.out.println("Please select one paper for detail information: ");
            try {
                Scanner input = new Scanner(java.lang.System.in);
                int selectPaper = Integer.parseInt(input.nextLine());
                if (!paperList.getIdList().contains(selectPaper)) {
                    System.out.println("paper not exit!");
                } else {
                    System.out.println();
                    System.out.println("you have choose: ");
                    System.out.println(paperList.getPaperList().get(getPaperIndex(selectPaper)));
                    choosePaperID = selectPaper;
                    exit = true;
                }
            }
            catch (NumberFormatException e) {
                Display.invalidInput();
            }
        }
        return choosePaperID;
    }

    /**
     * This method shows all the paper form select conference
     *
     * @see PaperDatabase#getPaperList()
     * @see Paper#getConferenceId()
     *
     * @param conferenceId input select conference ID to identity conference
     */
    private void showSelectConferencePaper(int conferenceId){
        System.out.println("paper list of conference" + conferenceId + "(conference ID): ");
        for (int i=0; i < paperList.getPaperList().size(); i++){
            // if input conference ID == conference ID from paper, print paper
            if (conferenceId == paperList.getPaperList().get(i).getConferenceId()){
                System.out.println("paperID: " + paperList.getIdList().get(i) + "  paper name: " + paperList.getNameList().get(i));
            }
        }
    }

    /**
     * This method shows all elements of reviewer arraylist
     */
    private void showReviewerList(){
        Display.show(reviewerDatabase.getReviewerArrayList(), "reviewer");
    }

    /**
     * This method shows all elements of user arraylist
     */
    private void showUserList() {
        Display.show(users.getUserList(), "users");
    }

    /**
     * This method shows all elements of paper arraylist
     */
    private void showPaperList(){
        Display.show(paperList.getPaperList(), "papers");
        System.out.println();
    }

    /**
     * This is the main method to run this program.
     *
     * @param args args
     */
    public static void main(String[] args) {
        CMS s = new CMS();
        s.readTxtFiles();
        s.mainPage();
    }
}
