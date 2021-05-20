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

    public ArrayList<User> getUserlist() {
        return userList;
    }

    public void readfile() {
        Scanner scanner = null;
        String filename = ("userdatabase.txt");
        try {
            FileReader reader = new FileReader(filename);
            scanner = new Scanner(reader);
            while (scanner.hasNextLine())//make sure read every line in the file
            {
                String line = scanner.nextLine();
                if (line != null && !line.equals("")) {
                    String[] values = line.split(",");//split every word by ","
                    User userread = new User(Integer.parseInt(values[0]), values[1], values[2], values[3], values[4]);
                    userList.add(userread);
                }

            }
        } catch (FileNotFoundException exception) {
            System.out.println(filename + " not found"); // print this if can't find file
        } catch (IOException exception) {
            System.out.println("Unexpected I/O error occurred"); // print this when something wrong
        } finally {
            if (scanner != null)
                scanner.close();
        }
    }

    public void writeFile() {
        String filename = ("userdatabase.txt");

        try {
            PrintWriter outputFile = new PrintWriter(filename);
            for (int i = 0; i < userList.size(); i++) {
                outputFile.println(userList.get(i).getUserid() + "," + userList.get(i).getUserName()
                        + "," + userList.get(i).getUserEmail() + "," + userList.get(i).getUserPassword() + "," + userList.get(i).getUserType());

            }
            outputFile.close();
        } catch (IOException e) {
            System.out.println("Unexpected I/O error occurred");// print this when something wrong
        }
    }

    public ArrayList getIdList() {
        ArrayList<Integer> idlist = new ArrayList<>();
        for (int i = 0; i < userList.size(); i++) {
            idlist.add(userList.get(i).getUserid());
        }
        return idlist;
    }

    public ArrayList getNameList() {
        ArrayList<String> nameList = new ArrayList<>();
        for (int i = 0; i < userList.size(); i++) {
            nameList.add(userList.get(i).getUserName());
        }
        return nameList;
    }

    public ArrayList getEmailList() {
        ArrayList<String> emailList = new ArrayList<>();
        for (int i = 0; i < userList.size(); i++) {
            emailList.add(userList.get(i).getUserName());
        }
        return emailList;
    }

    public void registration() {
        User newUser = new User(User.setUserid(getIdList()), User.setUserName(getNameList()),
                User.setUserEmail(getEmailList()), User.setUserPassword(), User.setUserType());
        userList.add(newUser);
    }

    public User logIn(String email, String password) {
        try {
            User targetUser = userList.stream()
                    .filter(user -> user.getUserEmail().equals(email))
                    .findFirst()
                    .orElseThrow(() -> new Exception("user not exist"));

            if (!targetUser.getUserPassword().equals(password)) {
                throw new Exception("password wrong");

            }
            System.out.println("log in successful");
            return targetUser;

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}





