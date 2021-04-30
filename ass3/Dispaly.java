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
        System.out.println("2. show");
        System.out.println("3. EXIT");
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

    public static void show(ArrayList arrayList) {
        System.out.println("User list: ");
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

    }
}
