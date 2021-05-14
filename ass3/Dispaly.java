import java.util.ArrayList;

/**
 * Write a description of class here.
 *
 * @author team56
 * @version 1.0 (28 Apr 2021)
 */

public class Dispaly {

    public static void printMenu() {
        System.out.println();
        System.out.println("============================");
        System.out.println("1. REGIST");
        System.out.println("2. LOG IN");
        System.out.println("3. EXIT");
        System.out.println("============================");
        System.out.println("please enter your choose: ");
    }


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

    public static void show(ArrayList arrayList, String listName) {
        System.out.println(listName + " list: ");
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println((i + 1) + ". " + arrayList.get(i));
        }
    }

    public static void invalidInput() {
        System.out.println("##ERROR: Invalid input##");
        System.out.println("please enter again");
        System.out.println();
        System.out.println("================================");
        System.out.println();
    }

    public static void showUserType() {
        System.out.println("please choose one type");
        System.out.println("                      (1) Author ");
        System.out.println("                      (2) Chair");
        System.out.println("                      (3) Reviewer");
        System.out.println("                      (4) Admin");
        System.out.println("type selected successfully");

    }

    public static void showAdminPage(){
        System.out.println();
        System.out.println("================================");
        System.out.println("this is the admin page");
        System.out.println("    (1) display all users");
        System.out.println("    (2) display all papers");
        System.out.println("    (3) Log off");
        System.out.println("================================");
        System.out.println("select your options: ");
    }

    public static void showChairPage(){
        System.out.println();
        System.out.println("=============================");
        System.out.println("this is the Chair page");
        System.out.println("    (1) Creat Conference");
        System.out.println("    (2) Assign papers");
        System.out.println("    (3) Log off");
        System.out.println("=============================");
        System.out.println("select your options: ");
    }

    public static void showAuthorPage(){
        System.out.println();
        System.out.println("===============================");
        System.out.println("this is the Author page");
        System.out.println("    (1) submit paper");
        System.out.println("    (2) Log off");
        System.out.println("===============================");
        System.out.println("select your options: ");
    }

    public static void showReviewerPage(){
        System.out.println();
        System.out.println("===============================");
        System.out.println("this is the Reviewer page");
        System.out.println("    (1) select topics");
        System.out.println("    (2) ");
        System.out.println("    (3) Log off");
        System.out.println("===============================");
        System.out.println("select your options: ");
    }

    public static void showTopics(){
        System.out.println();
        System.out.println("==================================");
        System.out.println("please select the related topic");
        System.out.println("     (1) ");
        System.out.println("     (2) ");
        System.out.println("     (3) ");
        System.out.println("     (4) ");
        System.out.println("     (5) ");
        System.out.println("     (6) ");
        System.out.println("     (7) ");
        System.out.println("     (8) ");
        System.out.println("     (9) ");
        System.out.println("     (10) others");
        System.out.println("===================================");
        System.out.println("select your options: ");
    }




}


