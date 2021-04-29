import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class userDatabase {
    private ArrayList<User> userlist;

    public userDatabase() {
        this.userlist = new ArrayList<>();
    }

    public ArrayList<User> getUserlist() {
        return userlist;
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
                String[] values = line.split(",");//split every word by ","

                int idlist = Integer.parseInt(values[0]);
                String namelist = values[1];
                User userread = new User(idlist, namelist);
                userlist.add(userread);



            }
        }
        catch(FileNotFoundException exception)
            {
                System.out.println(filename + " not found"); // print this if can't find file
            }
        catch(IOException exception)
            {
                System.out.println("Unexpected I/O error occurred"); // print this when something wrong
            }
        finally
            {
                if (scanner != null)
                    scanner.close();
            }
        }

        public void registration () {
            int newUserid = 0;
            String newUserName = "";


            System.out.print("Enter user id: ");
            Scanner scanner1 = new Scanner(System.in);
            String inputId = scanner1.nextLine();
            int id = Integer.parseInt(inputId.trim());
            newUserid = id;

            System.out.print("Enter user name: ");
            Scanner scanner2 = new Scanner(System.in);
            String inputName = scanner2.nextLine();
            newUserName = inputName.trim();

            User user1 = new User(newUserid, newUserName);
            userlist.add(user1);
            show();

        }


        public void show () {
            for (int i = 0; i < userlist.size(); i++) {
                System.out.println(i + "." + userlist.get(i));
            }

        }

    public static void main(String[] args) {


    }


}




