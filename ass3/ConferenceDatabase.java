import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * This class manage conferenceDatabase, read and write file to "conferenceDatabase.txt"
 *
 *
 * @author team56
 * @version 2.0 (21 May 2021)
 */
public class ConferenceDatabase {
    private ArrayList<Conference> conferenceArrayList;

    /**
     * constructor of ConferenceDatabase class
     */
    public ConferenceDatabase() {
        this.conferenceArrayList = new ArrayList<>();
    }

    public ArrayList<Conference> getConferenceArrayList() {
        return conferenceArrayList;
    }

    /**
     * This class use for loop get conference name arraylist
     * @return nameList conference name arraylist
     */
    public ArrayList getNameList(){
        ArrayList<String> nameList = new ArrayList<>();
        for (Conference conference : conferenceArrayList) {
            nameList.add(conference.getConferenceName());
        }
        return nameList;
    }

    /**
     * This class use for loop get conference ID arraylist
     * @return idList conference ID arraylist
     */
    public ArrayList getIdList(){
        ArrayList<Integer> idList = new ArrayList<>();
        for (Conference conference : conferenceArrayList) {
            idList.add(conference.getConferenceId());
        }
        return idList;
    }


    /**
     * This method read "conferenceDatabase.txt" line by line and save information into conferenceArrayList
     */
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

    /**
     * This method select conference by conference id
     *
     * @return selectConferenceID
     * @see Display#show(ArrayList, String)
     * @exception NumberFormatException
     */
    public int selectConference(){
        int selectConferenceID = 0;
        boolean exit = false;
        while (!exit){
            Display.show(conferenceArrayList, "Conference");
            System.out.println("please select one conference: ");
            try {
                Scanner input = new Scanner(java.lang.System.in);
                int selectConference = Integer.parseInt(input.nextLine());
                if (!getIdList().contains(selectConference)) {
                    System.out.println("Conference not exit!");
                } else {
                    selectConferenceID = selectConference;
                    System.out.println("you have choose: " + conferenceArrayList.get(selectConferenceID - 1));
                    System.out.println();
                    exit = true;
                }
            }
            catch (NumberFormatException e) {
                Display.invalidInput();
            }
        }
        return selectConferenceID;
    }

    /**
     * This method write conference arraylist into "conferenceDatabase.txt"
     * split by ","
     */
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

    /**
     * This method use method from conference to create new conference
     *
     * @see Conference#setConferenceId(ArrayList)
     * @see Conference#setConferenceName(ArrayList)
     * @see Conference#setConferenceTitle()
     * @see Conference#setConferenceTopics()
     * @see Conference#setAcceptFormat()
     * @see Conference#setSubmitDeadline()
     */
    public void createConference(){
        Conference newConference = new Conference(Conference.setConferenceId(getIdList()),
                Conference.setConferenceName(getNameList()), Conference.setConferenceTitle(),
                Conference.setConferenceTopics(), Conference.setAcceptFormat(),Conference.setSubmitDeadline());
        conferenceArrayList.add(newConference);
        System.out.println();
        System.out.println("conference create successfully");
    }
}




