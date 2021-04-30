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

    public static int setUserid(ArrayList arrayList) {
        boolean correctid = false;
        int newUserid = 0;

        while (!correctid)
        {
            System.out.print("Enter user id: ");
            Scanner scanner = new Scanner(System.in);
            String inputid = scanner.nextLine();
            try
            {

                int id = Integer.parseInt(inputid.trim());

                if (arrayList.contains(id)) {
                    System.out.println("     Sorry, " + id + " is already used");
                    System.out.println();
                }
                else
                    newUserid = id;
                System.out.println("     Id successfully set");
                System.out.println();
                correctid = true;
            }
            catch (NumberFormatException e)
            {
                System.out.println("     id must be integer");
                System.out.println();
            }
        }
        return newUserid;
    }

    public String getUserName() {
        return userName;
    }

    public static String setUserName(ArrayList arrayList) {
        boolean correctname = false;
        String newUserName = "";

        while (!correctname)
        {
            System.out.print("Enter user name: ");
            Scanner scanner = new Scanner(System.in);
            String inputname = scanner.nextLine();
            String name = inputname.trim(); // remove blank in the begain and end

            if (!Verififer.isalphabetic(name)) // use a method from Verifier Class to check the string "name"
            {
                System.out.println("     name must not be blank, must be alphabetic, must not contain commas");
                System.out.println();
            }
            else if (arrayList.contains(name))// check if name have already exist
            {
                System.out.println("     sorry, " + name + " already registered!");
                System.out.println();
            }
            else
            {
                newUserName = name;// give name value to newName
                System.out.println("     Name successfully set");
                System.out.println();
                correctname = true;//end the loop
            }
        }
        return newUserName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public static String setUserEmail(ArrayList arrayList) {
        boolean correctemail = false;
        String newUserEmail = "";
        while (!correctemail)
        {

            System.out.print("Enter user email: ");
            Scanner scanner = new Scanner(System.in);
            String inputemail = scanner.nextLine().trim();
            try
            {
                if (arrayList.contains(inputemail)) {
                    System.out.println("     Sorry, " + inputemail + " is already used");
                    System.out.println();
                }
                else if(!Verififer.isValid(inputemail)){
                    System.out.println("      wrong email format");
                    System.out.println();
                }
                else {
                    newUserEmail = inputemail;
                    System.out.println("      email successfully set");
                    System.out.println();
                    correctemail = true;
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

    public static String setUserPassword() {
        boolean correctPassword = false;
        String newUserPassword = "";
        while (!correctPassword)
        {
            Dispaly.showPasswordTips();
            Scanner scanner = new Scanner(System.in);
            String inputpassword = scanner.nextLine().trim();
            try
            {
                if(!Verififer.validPassword(inputpassword)){
                    System.out.println("      wrong password format");
                    System.out.println();
                }
                else {
                    newUserPassword = inputpassword;
                    System.out.println("      email successfully set");
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

    public static String setUserType() {
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
                default -> {
                    Dispaly.invalidInput();
                }
            }
        }
        return newUserType;
    }

    @Override
    public String toString() {
        return "userID: " + userid + ", userName: " + userName+ ", " +
                "userEmail: " + userEmail + ", userPassword: "
                + userPassword + ", userType: " + userType;
    }

}


