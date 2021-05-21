import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class PaperDatabase {
    private ArrayList<Paper> paperArrayList;

    public PaperDatabase(){
        this.paperArrayList = new ArrayList<>();
    }

    public ArrayList<Paper> getPaperList(){
        return paperArrayList;

    }


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

    public ArrayList getIdList(){
        ArrayList<Integer> idList = new ArrayList<>();
        for (Paper paper : paperArrayList) {
            idList.add(paper.getPaperId());
        }
        return idList;
    }



    public static String selectPaper(){
        String path = "papers";
        File file = new File(path);
        File[] fs = file.listFiles();
        boolean exit = false;
        String inputValue = "";
        while (!exit) {
            System.out.println();
            System.out.println("========================");
            for (int i = 0; i < fs.length; i++) {
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
                    System.out.println("don't have this conference");

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

    public static String getFileType(String file){
        String[] strArray = file.split("\\.");
        int suffixIndex = strArray.length -1;
        return strArray[suffixIndex];
    }
    public static String getFileName(String file){
        return file.substring(0,file.lastIndexOf("."));
    }


    public void submitPaper(User user){
        String file = selectPaper();
        ConferenceDatabase conferenceList = new ConferenceDatabase();
        int conId = conferenceList.selectConference();
        LocalDate deadLine = conferenceList.getConferenceArrayList().get(conId-1).getSubmitDateline();

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
            Paper submitPaper = new Paper(Paper.setPaperId(getIdList()), Paper.setAuthorId(user.getUserid()), Paper.setConferenceId(conId),
                    Paper.setTopic(), Paper.setName(getFileName(file)), Paper.setFormat(getFileType(file)), Paper.setState("submitted"), Paper.setSubmitTime(), newEvaluation);
            paperArrayList.add(submitPaper);
            System.out.println();
            System.out.println("paper upload successfully!");
        }


    }
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
