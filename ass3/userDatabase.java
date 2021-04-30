import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Write a description of class user here.
 *
 * @author team56
 * @version 1.0 (28 Apr 2021)
 */

public class userDatabase {
    private ArrayList<User> userList;

    public userDatabase() {
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

                    int idlist = Integer.parseInt(values[0]);
                    String namelist = values[1];
                    String maillist = values[2];
                    String passwordlist = values[3];
                    String tpyelist = values[4];
                    User userread = new User(idlist, namelist, maillist, passwordlist, tpyelist);
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
        int newUserid = User.setUserid(getIdList());
        String newUserName = User.setUserName(getNameList());
        String newUserEmail = User.setUserEmail(getEmailList());
        String newUserPassword = User.setUserPassword();
        String newUserType = User.setUserType();
        User newUser = new User(newUserid, newUserName, newUserEmail, newUserPassword, newUserType);
        userList.add(newUser);
    }
}





