import java.io.*;
import java.util.ArrayList;
import java.util.List;
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
                if (line != null && !line.equals("")){
                String[] values = line.split(",");//split every word by ","

                int idlist = Integer.parseInt(values[0]);
                String namelist = values[1];
                User userread = new User(idlist, namelist);
                userlist.add(userread);
                }
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

    public void writeFile() {
        String filename = ("userdatabase.txt");

        try {
            PrintWriter outputFile = new PrintWriter(filename);
            for(int i = 0; i < userlist.size(); i++){
                outputFile.println(userlist.get(i));

            }
            outputFile.close();
        }
        catch(IOException e)
        {
            System.out.println("Unexpected I/O error occurred");// print this when something wrong
        }


    }
        public void registration () {
            boolean correctname = false;
            boolean correctid = false;
//            boolean correctemail = false;
//            boolean correctPassword = false;
//            boolean correctType = false;
            int newUserid = 0;
            String newUserName = "";
            boolean a = false;
            while (!correctid)
            {
                System.out.print("Enter user id: ");
                Scanner scanner = new Scanner(System.in);
                String inputid = scanner.nextLine();
                try
                {

                    int id = Integer.parseInt(inputid.trim());
                    List<Integer> idlist = new ArrayList<>();
                     for(int i = 0;i < userlist.size(); i ++){
                         idlist.add(userlist.get(i).getUserid());
                     }
                        if (idlist.contains(id)) {
                            System.out.println("     Sorry, " + id + " is already used");
                            System.out.println("");

                        }
                        else {
                            newUserid = id;
                            System.out.println("     Id successfully set");
                            System.out.println("");
                            correctid = true;

                        }
                }
                catch (NumberFormatException e)
                {
                    System.out.println("     id must be integer");
                    System.out.println("");
                }
            }


            while (!correctname)
            {
                Verififer V = new Verififer();
                System.out.print("Enter user name: ");
                Scanner scanner = new Scanner(System.in);
                String inputname = scanner.nextLine();
                String name = inputname.trim(); // remove blank in the begain and end
                List<String> namelist = new ArrayList<>();
                for(int i = 0;i < userlist.size(); i ++){
                    namelist.add(userlist.get(i).getUserName());
                }
                if (!V.isalphabetic(name)) // use a method from Verifier Class to check the string "name"
                {
                    System.out.println("     name must not be blank, must be alphabetic, must not contain commas");
                    System.out.println("");
                }
                else if (namelist.contains(name))// check if name have already exist
                {
                    System.out.println("     sorry, " + name + " already registered!");
                    System.out.println("");
                }
                else
                {
                    newUserName = name;// give name value to newname
                    System.out.println("     Name successfully set");
                    System.out.println("");
                    correctname = true;//end the loop
                }
            }

//            System.out.print("Enter user name: ");
//            Scanner scanner2 = new Scanner(System.in);
//            String inputName = scanner2.nextLine();
//            newUserName = inputName.trim();
            User user1 = new User(newUserid, newUserName);
            userlist.add(user1);

        }

        public void show () {
            System.out.println("these are users");
            for (int i = 0; i < userlist.size(); i++) {
                System.out.println(userlist.get(i));

            }

        }

    public static void main(String[] args) {


    }


}




