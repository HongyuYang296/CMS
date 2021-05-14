import java.io.FileNotFoundException;
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
        for (int i = 0; i < conferenceArrayList.size(); i++) {
            nameList.add(conferenceArrayList.get(i).getConferenceName());
        }
        return nameList;

    }

    private ArrayList getIdList(){
        ArrayList<Integer> idList = new ArrayList<>();
        for (int i = 0; i < conferenceArrayList.size(); i++) {
            idList.add(conferenceArrayList.get(i).getConferenceId());
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
                            (values[2]),(values[3]), TimeConvert.toDate(values[4]));
                    conferenceArrayList.add(readConference);
                }
            }
        } catch (FileNotFoundException exception) {
            System.out.println(filename + " not found"); // print this if can't find file
        }
        catch (IOException exception) {
            System.out.println("Unexpected I/O error occurred"); // print this when something wrong
        }
        finally {
            if (scanner != null)
                scanner.close();
        }
    }

    public void writeFile() {
        String filename = ("conferenceDatabase.txt");
        try {
            PrintWriter outputFile = new PrintWriter(filename);
            for (int i = 0; i < conferenceArrayList.size(); i++) {
                outputFile.println(conferenceArrayList.get(i).getConferenceId()
                        + "," + conferenceArrayList.get(i).getConferenceName()
                        + "," + conferenceArrayList.get(i).getConferenceTitle()
                        + "," + conferenceArrayList.get(i).getConferenceTopics()
                        + "," + conferenceArrayList.get(i).getSubmitDateline());
            }
            outputFile.close();
        } catch (IOException e) {
            System.out.println("Unexpected I/O error occurred");// print this when something wrong
        }
    }

    public void creatConference(){
        Conference newConference = new Conference(Conference.setConferenceId(getIdList()),
                Conference.setConferenceName(getNameList()), Conference.setConferenceTitle(),
                Conference.setConferenceTopics(), Conference.setSubmitDeadline());
        conferenceArrayList.add(newConference);
    }


}




