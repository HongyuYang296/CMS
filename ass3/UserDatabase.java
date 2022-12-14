import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Write a description of class user here.
 *
 * @author team56
 * @version 1.0 (28 Apr 2021)
 */

public class UserDatabase {
    private ArrayList<User> userList;

    public UserDatabase() {
        this.userList = new ArrayList<>();
    }

    public ArrayList<User> getUserList() {
        return userList;
    }
    /**
     * This method read "userDatabase.txt" line by line and save information into userList
     */
    public void readFile() {
        Scanner scanner = null;
        String filename = ("userDatabase.txt");
        try {
            FileReader reader = new FileReader(filename);
            scanner = new Scanner(reader);
            while (scanner.hasNextLine())//make sure read every line in the file
            {
                String line = scanner.nextLine();
                if (line != null && !line.equals("")) {
                    String[] values = line.split(",");//split every word by ","
                    User userRead = new User(Integer.parseInt(values[0]), values[1], values[2], values[3], values[4]);
                    userList.add(userRead);
                }

            }
        }  catch (IOException exception) {
            System.out.println("Unexpected I/O error occurred"); // print this when something wrong
        } finally {
            if (scanner != null)
                scanner.close();
        }
    }
    /**
     * This method write user arraylist into "userDatabase.txt"
     * split by ","
     */
    public void writeFile() {
        String filename = ("userDatabase.txt");
        try {
            PrintWriter outputFile = new PrintWriter(filename);
            for (User user : userList) {
                outputFile.println(user.getUserId() + "," + user.getUserName()
                        + "," + user.getUserEmail() + "," + user.getUserPassword() + "," + user.getUserType());
            }
            outputFile.close();
        } catch (IOException e) {
            System.out.println("Unexpected I/O error occurred");// print this when something wrong
        }
    }

    public ArrayList getIdList() {
        ArrayList<Integer> idList = new ArrayList<>();
        for (User user : userList) {
            idList.add(user.getUserId());
        }
        return idList;
    }

    public ArrayList getNameList() {
        ArrayList<String> nameList = new ArrayList<>();
        for (User user : userList) {
            nameList.add(user.getUserName());
        }
        return nameList;
    }

    public ArrayList getEmailList() {
        ArrayList<String> emailList = new ArrayList<>();
        for (User user : userList) {
            emailList.add(user.getUserEmail());
        }
        return emailList;
    }

    /**
     * This method create new user by using method from User class
     *
     * @see User#User(int, String, String, String, String)
     * @see User#setUserid(ArrayList)
     * @see User#setUserName(ArrayList)
     * @see User#setUserEmail(ArrayList)
     * @see User#setUserPassword()
     * @see User#setUserType()
     */
    public void registration() {
        User newUser = new User(User.setUserid(getIdList()), User.setUserName(getNameList()),
                User.setUserEmail(getEmailList()), User.setUserPassword(), User.setUserType());
        userList.add(newUser);
    }

    /**
     * This method ask user input email and password and validate
     *
     * @return targetUser
     */
    public User logIn() {
        Scanner input = new Scanner(java.lang.System.in);
        java.lang.System.out.println("input email: ");
        String email = input.nextLine();
        java.lang.System.out.println("input pass: ");
        String password = input.nextLine();
        try {
            User targetUser = userList.stream()
                    .filter(user -> user.getUserEmail().equals(email))
                    .findFirst()
                    .orElseThrow(() -> new Exception("user not exist!"));

            if (!targetUser.getUserPassword().equals(password)) {
                throw new Exception("password wrong!");
            }
            System.out.println("log in successful!");
            return targetUser;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}






