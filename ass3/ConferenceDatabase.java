import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ConferenceDatabase {
    private ArrayList<Conference> conferenceArrayList;

    public ConferenceDatabase() {
        this.conferenceArrayList = new ArrayList<>();
    }

    public ArrayList<Conference> getConferenceArrayList() {
        return conferenceArrayList;
    }

    public ArrayList getNameList(){
        ArrayList<String> nameList = new ArrayList<>();
        for (Conference conference : conferenceArrayList) {
            nameList.add(conference.getConferenceName());
        }
        return nameList;

    }

    private ArrayList getIdList(){
        ArrayList<Integer> idList = new ArrayList<>();
        for (Conference conference : conferenceArrayList) {
            idList.add(conference.getConferenceId());
        }
        return idList;
    }


    public void readFile(){
        Scanner scanner = null;
        String filename = ("conferenceDatabase.txt");
        try {
            FileReader reader = new FileReader(filename);
            scanner = new Scanner(reader);
            while (scanner.hasNextLine())//make sure read every line in the file
            {
                String line = scanner.nextLine();
                if (line != null && !line.equals("")) {
                    String[] values = line.split(",");//split every word by ","
                    Conference readConference = new Conference(Integer.parseInt(values[0]), (values[1]),
                            (values[2]),(values[3]),(values[4]),TimeConvert.toDate(values[5]));
                    conferenceArrayList.add(readConference);
                }
            }
        }
        catch (IOException exception) {
            System.out.println("Unexpected I/O error occurred"); // print this when something wrong
        }
        finally {
            if (scanner != null)
                scanner.close();
        }
    }


    public Integer selectConference(){
        readFile();
        boolean exit = false;
        String inputValue = "";
        while (!exit) {
            System.out.println();
            System.out.println("=====================================================================================");
            System.out.println("conferences list: ");
            for (int i = 0; i < conferenceArrayList.size(); i++) {
                System.out.println("     " + (i+1) + ". " + conferenceArrayList.get(i));
            }
            System.out.println("=====================================================================================");
            System.out.println("please select one conference: ");
            Scanner input = new Scanner(java.lang.System.in);
            inputValue = input.nextLine();
            if (VeriFifer.isNumeric(inputValue))// call function from Verifier class
            {
                int selectConference = Integer.parseInt(inputValue);
                if (selectConference > conferenceArrayList.size() || selectConference < 1)
                    System.out.println("don't have this conference");

                else {
                    System.out.println("you have choose " + getConferenceArrayList().get(selectConference - 1));// selection-1 means get index
                    exit = true;//end the loop
                }
            } else {
                System.out.println("not digit input, please input again");
            }
        }
        return Integer.parseInt(inputValue);


    }
    public void writeFile() {
        String filename = ("conferenceDatabase.txt");
        try {
            PrintWriter outputFile = new PrintWriter(filename);
            for (Conference conference : conferenceArrayList) {
                outputFile.println(conference.getConferenceId()
                        + "," + conference.getConferenceName()
                        + "," + conference.getConferenceTitle()
                        + "," + conference.getConferenceTopics()
                        + "," + conference.getAcceptFormat()
                        + "," + conference.getSubmitDateline());
            }
            outputFile.close();
        } catch (IOException e) {
            System.out.println("Unexpected I/O error occurred");// print this when something wrong
        }
    }

    public void creatConference(){
        Conference newConference = new Conference(Conference.setConferenceId(getIdList()),
                Conference.setConferenceName(getNameList()), Conference.setConferenceTitle(),
                Conference.setConferenceTopics(), Conference.setAcceptFormat(),Conference.setSubmitDeadline());
        conferenceArrayList.add(newConference);
        System.out.println();
        System.out.println("conference create successfully");
    }


}




