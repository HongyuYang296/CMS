import java.util.ArrayList;
/**
 * Display class aim to display UI design
 *
 *
 * @author team56
 * @version 1.0 (21 May 2021)
 */

public class Display {

    /**
     * This method print main menu
     */
    public static void printMenu() {
        System.out.println();
        System.out.println("----------------------------");
        System.out.println("            CMS");
        System.out.println("============================");
        System.out.println("1. SIGN UP");
        System.out.println("2. LOG IN");
        System.out.println("3. EXIT");
        System.out.println("============================");
        System.out.println("please enter your choose: ");
    }

    /**
     * This method show some requirement of setting password.
     */
    public static void showPasswordTips() {
        System.out.println("Password must contain:");
        System.out.println("                       at least one digit [0-9].");
        System.out.println("                       at least one lowercase Latin character [a-z].");
        System.out.println("                       at least one uppercase Latin character [A-Z].");
        System.out.println("                       at least one special character like ! @ # & ( ).");
        System.out.println("                       a length of at least 6 characters and a maximum of 20 characters.");
        System.out.println();
        System.out.print("Enter user password: ");
    }

    /**
     * This method show all the elements of input arraylist.
     *
     * @param arrayList input a arraylist and using for loop show all elements.
     * @param listName name of input arraylist
     */
    public static void show(ArrayList arrayList, String listName) {
        System.out.println();
        System.out.println(listName + " list: ");
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println((i + 1) + ". " + arrayList.get(i));
        }
    }

    /**
     * This method show invalid input
     */
    public static void invalidInput() {
        System.out.println();
        System.out.println("================================");
        System.out.println("## ERROR: Invalid input ##");
        System.out.println("please enter again");
        System.out.println("================================");
        System.out.println();
    }

    /**
     * This method show different user type for selecting.
     */
    public static void showUserType() {
        System.out.println("please choose one type");
        System.out.println("                      (1) Author ");
        System.out.println("                      (2) Chair");
        System.out.println("                      (3) Reviewer");
        System.out.println("                      (4) Admin");
        System.out.println("select your options: ");
    }

    /**
     *
     */
    public static void showAdminPage(){
        System.out.println();
        System.out.println("================================");
        System.out.println("This is the admin page");
        System.out.println("    (1) display all users");
        System.out.println("    (2) display all papers");
        System.out.println("    (3) Log off");
        System.out.println("================================");
        System.out.println("select your options: ");
    }

    /**
     *
     */
    public static void showChairPage(){
        System.out.println();
        System.out.println("=============================");
        System.out.println("This is the Chair page");
        System.out.println("    (1) Creat Conference");
        System.out.println("    (2) Assign papers");
        System.out.println("    (3) final Decision");
        System.out.println("    (4) Log off");
        System.out.println("=============================");
        System.out.println("select your options: ");
    }

    /**
     *
     */
    public static void showAuthorPage(){
        System.out.println();
        System.out.println("===============================");
        System.out.println("This is the Author page");
        System.out.println("    (1) submit paper");
        System.out.println("    (2) Log off");
        System.out.println("===============================");
        System.out.println("select your options: ");
    }

    /**
     *
     */
    public static void showReviewerPage(){
        System.out.println();
        System.out.println("===============================");
        System.out.println("This is the Reviewer page");
        System.out.println("    (1) select relevant topics");
        System.out.println("    (2) select paper to review");
        System.out.println("    (3) submit evaluation");
        System.out.println("    (4) Log off");
        System.out.println("===============================");
        System.out.println("select your options: ");
    }

    /**
     *
     */
    public static void showTopics(){
        System.out.println();
        System.out.println("==================================");
        System.out.println("Please select the related topic");
        System.out.println("     (1) IT");
        System.out.println("     (2) Medicine");
        System.out.println("     (3) Education");
        System.out.println("     (4) Art");
        System.out.println("     (5) History");
        System.out.println("     (6) Geography");
        System.out.println("     (7) Biology");
        System.out.println("     (8) Math");
        System.out.println("     (9) Economy");
        System.out.println("     (10) others");
        System.out.println("===================================");
        System.out.println("select your options: ");
    }

    /**
     *
     */
    public static void showFileFormat(){
        System.out.println();
        System.out.println("================================");
        System.out.println("Please choose one accept format");
        System.out.println("      (1) docx");
        System.out.println("      (2) PDF");
        System.out.println("================================");
        System.out.println("please select your options: ");
    }

    /**
     * This method shows upload failed information and reason.
     *
     * @param reason input reason of upload failed.
     */
    public static void uploadFailed(String reason){
        System.out.println();
        System.out.println("============================");
        System.out.println("paper upload failed");
        System.out.println("     ----" + reason);
        System.out.println("============================");
    }

    /**
     *
     */
    public static void showEvaluation(){
        System.out.println();
        System.out.println("===========================================================================");
        System.out.println("Please select give the evaluation: ");
        System.out.println("'HD': high distinction, 'D': distinction, 'C': credit, 'P': pass, 'N': fail");
        System.out.println("      (1) HD");
        System.out.println("      (2) D");
        System.out.println("      (3) C");
        System.out.println("      (4) P");
        System.out.println("      (5) N");
        System.out.println("===========================================================================");
        System.out.println("select your options: ");
    }

    /**
     *
     */
    public static void finalDecision(){
        System.out.println();
        System.out.println("=========================================");
        System.out.println("Please give the final decision");
        System.out.println("      (1) Accept");
        System.out.println("      (2) Reject");
        System.out.println("      (3) return to chair page");
        System.out.println("=========================================");
        System.out.println("please select your option: ");
    }

    public static void showTry(){
        System.out.println();
        System.out.println("===========================");
        System.out.println("   (1) try again");
        System.out.println("   (2) return to main menu");
        System.out.println("===========================");
    }
}


