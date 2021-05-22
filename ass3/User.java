import java.util.ArrayList;
import java.util.Scanner;
/**
 * Write a description of class user here.
 *
 * @author team56
 * @version 1.0 (28 Apr 2021)
 */
public class User{
    private   int userid;
    private   String userName;
    private   String userEmail;
    private  String userPassword;
    private String userType;

    /**
     * Constructor for objects of class Borrower
     */
    public User(int userid, String userName, String userEmail, String userPassword, String userType) {
        this.userid = userid;
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.userType = userType;
    }


    public int getUserid() {
        return userid;
    }

    /**
     * set user id
     * @param arrayList     id are stored in arraylist
     * @return              Numbers in the same order as id in the ArrayList
     */
    public static int setUserid(ArrayList arrayList) {
        return arrayList.size() + 1;
    }

    public String getUserName() {
        return userName;
    }

    /**
     *set user name and validate input name
     * @param arrayList    arraylist store user name
     * @return             new user name
     */
    public static String setUserName(ArrayList arrayList) {
        boolean correctName = false;
        String newUserName = "";
        while (!correctName)
        {
            System.out.print("Enter user name: ");
            Scanner scanner = new Scanner(System.in);
            String inputName = scanner.nextLine();
            String name = inputName.trim(); // remove blank in the begin and end

            if (!VeriFifer.isAlphabetic(name)) // use a method from Verifier Class to check the string "name"
            {
                System.out.println("     name must not be blank, must be alphabetic, must not contain commas");
                System.out.println();
            }
            else if (arrayList.contains(name))// check if name have already exist
            {
                System.out.println("     sorry, " + name + " already registered!");
                System.out.println();
            }
            else if (VeriFifer.isNumeric(name))
            {
                System.out.println("     name must not be blank, must be alphabetic, must not contain commas");
                System.out.println();
            }
            else
            {
                newUserName = name;// give name value to newName
                System.out.println("     Name successfully set");
                System.out.println();
                correctName = true;//end the loop
            }
        }
        return newUserName;
    }

    public String getUserEmail() {
        return userEmail;
    }
    /**
     *set user email and validate input email
     * @param arrayList    arraylist store user email
     * @return             new user email
     */
    public static String setUserEmail(ArrayList arrayList) {
        boolean correctEmail = false;
        String newUserEmail = "";
        while (!correctEmail)
        {

            System.out.print("Enter user email: ");
            Scanner scanner = new Scanner(System.in);
            String inputEmail = scanner.nextLine().trim();
            try
            {
                if (arrayList.contains(inputEmail)) {
                    System.out.println("     Sorry, " + inputEmail + " is already used");
                    System.out.println();
                }
                else if(!VeriFifer.isValid(inputEmail)){
                    System.out.println("      wrong email format");
                    System.out.println();
                }
                else {
                    newUserEmail = inputEmail;
                    System.out.println("      email successfully set");
                    System.out.println();
                    correctEmail = true;
                }
            }
            catch (NumberFormatException e)
            {
                System.out.println("      invalid input");
                System.out.println();
            }
        }
        return newUserEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    /**
     * set user password and validate input password
     * @return   new user password
     */
    public static String setUserPassword() {
        boolean correctPassword = false;
        String newUserPassword = "";
        while (!correctPassword)
        {
            Display.showPasswordTips();
            Scanner scanner = new Scanner(System.in);
            String inputPassword = scanner.nextLine().trim();
            try
            {
                if(!VeriFifer.validPassword(inputPassword)){
                    System.out.println("      wrong password format");
                    System.out.println();
                }
                else {
                    newUserPassword = inputPassword;
                    System.out.println("      password successfully set");
                    System.out.println();
                    correctPassword = true;
                }
            }
            catch (NumberFormatException e)
            {
                System.out.println("      invalid input");
                System.out.println();
            }
        }
        return newUserPassword;
    }

    public String getUserType() {
        return userType;
    }

    /**
     * choose user type
     * @return          new user type
     */
    public static String setUserType() {
        Display.showUserType();
        String newUserType = "";
        boolean exit = false;
        while (!exit) {
            Scanner scanner = new Scanner(System.in);
            String option = scanner.nextLine();
            switch (option) {
                case "1" -> {
                   newUserType = "Author";
                   exit = true;
                }
                case "2" -> {
                    newUserType = "Chair";
                    exit = true;
                }
                case "3" -> {
                    newUserType = "Reviewer";
                    exit = true;
                }
                case "4" -> {
                    newUserType = "Admin";
                    exit = true;
                }
                default -> Display.invalidInput();

            }
        }
        System.out.println("type successfully selected");
        System.out.println("---------------------------");
        System.out.println("  Sign up successfully  ");
        return newUserType;
    }


    @Override
    public String toString() {
        return "userID: " + userid + ", userName: " + userName+ ", " +
                "userEmail: " + userEmail + ", userPassword: "
                + userPassword + ", userType: " + userType;
    }

}


