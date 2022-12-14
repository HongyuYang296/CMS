import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
/**
 * This class manage paperDatabase, read and write file to "paperDatabase.txt"
 *
 *
 * @author team56
 * @version 2.0 (21 May 2021)
 */
public class PaperDatabase {
    private ArrayList<Paper> paperArrayList;

    /**
     * constructor of PaperDatabase class
     */
    public PaperDatabase(){
        this.paperArrayList = new ArrayList<>();
    }

    public ArrayList<Paper> getPaperList(){
        return paperArrayList;
    }

    /**
     * This method read "paperDatabase.txt" line by line and save information into paperArrayList
     */
    public void readFile(){
        Scanner scanner = null;
        String filename = ("paperDatabase.txt");
        try {
            FileReader reader = new FileReader(filename);
            scanner = new Scanner(reader);
            while (scanner.hasNextLine())//make sure read every line in the file
            {
                String line = scanner.nextLine();
                if (line != null && !line.equals("")) {
                    String[] values = line.split(","); //split every word by ","
                    Paper paperRead = new Paper(Integer.parseInt(values[0]), Integer.parseInt(values[1]),
                            Integer.parseInt(values[2]), values[3], values[4], values[5],values[6],
                            TimeConvert.toDate(values[7]),values[8]);
                    paperArrayList.add(paperRead);
                }
            }
        } catch (IOException exception) {
            System.out.println("Unexpected I/O error occurred"); // print this when something wrong
        } finally {
            if (scanner != null)
                scanner.close();
        }
    }

    /**
     * This method use for loop get paper ID arraylist
     * @return idList paper ID arraylist
     */
    public ArrayList getIdList(){
        ArrayList<Integer> idList = new ArrayList<>();
        for (Paper paper : paperArrayList) {
            idList.add(paper.getPaperId());
        }
        return idList;
    }

    /**
     * This method use for loop get paper name arraylist
     * @return idList paper name arraylist
     */
    public ArrayList getNameList(){
        ArrayList<String> nameList = new ArrayList<>();
        for (Paper paper : paperArrayList) {
            nameList.add(paper.getName());
        }
        return nameList;
    }

    /**
     * This method read and list all the paper in folder "papers"
     * then ask user to select one
     *
     * @see VeriFifer#isNumeric(String)
     * @return select paper name
     */
    public static String selectPaper(){
        String path = "papers";
        File file = new File(path);
        File[] fs = file.listFiles();
        boolean exit = false;
        String inputValue = "";
        while (!exit) {
            System.out.println();
            System.out.println("========================");
            // make sure fs not null
            for (int i = 0; i < Objects.requireNonNull(fs).length; i++) {
                System.out.println((i+1) + ". " + fs[i].getName());
            }
            System.out.println("========================");
            System.out.println("Please select submit paper: ");
            Scanner input = new Scanner(java.lang.System.in);
            inputValue = input.nextLine();
            if (VeriFifer.isNumeric(inputValue))// call function from Verifier class
            {
                int selectConference = Integer.parseInt(inputValue);
                if (selectConference > fs.length || selectConference < 1)
                    System.out.println("don't have this paper");

                else {
                    System.out.println("you have choose " + fs[selectConference-1 ].getName());// selection-1 means get index
                    exit = true;//end the loop
                }
            } else {
                System.out.println("not digit input, please input again");
            }
        }
        return fs[Integer.parseInt(inputValue) -1].getName();
    }

    /**
     * This method input file full name eg: xxx.PDF, then get file type
     * file type is part after "."
     *
     * @param file file full name
     * @return file type name
     */
    public static String getFileType(String file){
        String[] strArray = file.split("\\.");
        int suffixIndex = strArray.length -1;
        return strArray[suffixIndex];
    }
    /**
     * This method input file full name eg: xxx.PDF, then get file name
     * file type is part before "."
     *
     * @param file file full name
     * @return file type name
     */
    public static String getFileName(String file){
        return file.substring(0,file.lastIndexOf("."));
    }

    /**
     * This method check the deadline and format
     * then create new paper by using method from Paper class
     *
     * @param user user who log in
     * @see Paper#setPaperId(ArrayList)
     * @see Paper#setAuthorId(Integer)
     * @see Paper#setConferenceId(Integer)
     * @see Paper#setName(String)
     * @see Paper#setFormat(String)
     * @see Paper#setState(String)
     * @see Paper#setSubmitTime()
     * @see Paper#setEvaluation()
     * @see Paper#Paper(Integer, Integer, Integer, String, String, String, String, LocalDate, String)
     */
    public void submitPaper(User user){
        String file = selectPaper();
        ConferenceDatabase conferenceList = new ConferenceDatabase();
        conferenceList.readFile();
        int conId = conferenceList.selectConference();
        LocalDate deadLine = conferenceList.getConferenceArrayList().get(conId-1).getSubmitDateline();
        // check the deadline and format
        if (!Paper.setSubmitTime().isBefore(deadLine)
                && !getFileType(file).equals(conferenceList.getConferenceArrayList().get(conId-1).getAcceptFormat())){
            Display.uploadFailed("Later than deadline & Wrong format");
        }
        else if (!Paper.setSubmitTime().isBefore(deadLine)) {
            Display.uploadFailed("Later than deadline");
        }
        else if (!getFileType(file).equals(conferenceList.getConferenceArrayList().get(conId-1).getAcceptFormat())){
            Display.uploadFailed("Wrong format");
        }
        else {
            String newEvaluation = "null";
            Paper submitPaper = new Paper(Paper.setPaperId(getIdList()), Paper.setAuthorId(user.getUserId()), Paper.setConferenceId(conId),
                    Paper.setTopic(), Paper.setName(getFileName(file)), Paper.setFormat(getFileType(file)), Paper.setState("submitted"), Paper.setSubmitTime(), newEvaluation);
            paperArrayList.add(submitPaper);
            System.out.println();
            System.out.println("paper upload successfully!");
        }
    }

    /**
     * This method write paper arraylist into "paperDatabase.txt"
     * split by ","
     */
    public void writeFile() {
        String filename = ("paperDatabase.txt");
        try {
            PrintWriter outputFile = new PrintWriter(filename);
            for (Paper paper : paperArrayList) {
                outputFile.println(paper.getPaperId() + "," + paper.getAuthorId()
                        + "," + paper.getConferenceId() + "," + paper.getTopic()
                        + "," + paper.getName() + "," + paper.getFormat()
                        + "," + paper.getState() + "," + paper.getSubmitTime()
                        + "," + paper.getEvaluation());
            }
            outputFile.close();
        } catch (IOException e) {
            System.out.println("Unexpected I/O error occurred");// print this when something wrong
        }
    }
}
