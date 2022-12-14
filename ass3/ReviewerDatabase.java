import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * This class manage ReviewerDatabase, read and write file to "reviewerDatabase.txt"
 *
 *
 * @author team56
 * @version 2.0 (21 May 2021)
 */
public class ReviewerDatabase {
    private ArrayList<Reviewer> reviewerArrayList;

    /**
     * constructor of ReviewerDatabase
     */
    public ReviewerDatabase(){
        this.reviewerArrayList = new ArrayList<>();
    }

    public ArrayList getIdList(){
        ArrayList<Integer> idList = new ArrayList<>();
        for (Reviewer reviewer : reviewerArrayList) {
            idList.add(reviewer.getId());
        }
        return idList;
    }

    /**
     * This method read "userDatabase.txt"
     * select user type which is reviewer and upload to reviewer arraylist
     * @see Reviewer#Reviewer(int, String, String, ArrayList)
     */
    public void upload() {
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
                    if (values[4].equals("Reviewer")){
                        ArrayList<Integer> arrayList = new ArrayList<>();
                        String topics = "null";
                        Reviewer newReviewer = new Reviewer(Integer.parseInt(values[0]), values[1], topics, arrayList);
                        if (!getIdList().contains(newReviewer.getId())) {
                            reviewerArrayList.add(newReviewer);
                        }
                    }
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
     * This method read "reviewerDatabase.txt" line by line and save information into reviewerArraylist
     * because one reviewer can max have 3 papers so there are 3 different situations
     *
     * @see Reviewer#Reviewer(int, String, String, ArrayList)
     */
    public void readFile() {
    Scanner scanner = null;
    String filename = ("reviewerDatabase.txt");
        try {
        FileReader reader = new FileReader(filename);
        scanner = new Scanner(reader);
        while (scanner.hasNextLine())//make sure read every line in the file
        {
            String line = scanner.nextLine();
            if (line != null && !line.equals("")) {
                String [] values = line.replace("[", "").replace(" ","")
                        .replace("]","").split(",");//split every word by ","
                switch (values.length){
                    case 3 -> {
                        ArrayList<Integer> paperList = new ArrayList<>();
                        Reviewer newReviewer = new Reviewer(Integer.parseInt(values[0]), values[1],
                                values[2],paperList);
                        reviewerArrayList.add(newReviewer);
                    }
                    case 4 -> {
                        ArrayList<Integer> paperList = new ArrayList<>();
                        paperList.add(Integer.parseInt(values[3]));
                        Reviewer newReviewer = new Reviewer(Integer.parseInt(values[0]), values[1],
                                values[2],paperList);
                        reviewerArrayList.add(newReviewer);
                    }
                    case 5 -> {
                        ArrayList<Integer> paperList = new ArrayList<>();
                        paperList.add(Integer.parseInt(values[3]));
                        paperList.add(Integer.parseInt(values[4]));
                        Reviewer newReviewer = new Reviewer(Integer.parseInt(values[0]), values[1],
                                values[2],paperList);
                        reviewerArrayList.add(newReviewer);
                    }
                    case 6 -> {
                        ArrayList<Integer> paperList = new ArrayList<>();
                        paperList.add(Integer.parseInt(values[3]));
                        paperList.add(Integer.parseInt(values[4]));
                        paperList.add(Integer.parseInt(values[5]));
                        Reviewer newReviewer = new Reviewer(Integer.parseInt(values[0]), values[1],
                                values[2],paperList);
                        reviewerArrayList.add(newReviewer);
                    }
                }
            }
        }
    }  catch (
    IOException exception) {
        System.out.println("Unexpected I/O error occurred"); // print this when something wrong
    } finally {
        if (scanner != null)
            scanner.close();
    }
    }



    public void setTopics(int index){
        getReviewerArrayList().get(index).setTopics(Reviewer.setTopic());
    }

    /**
     * This method input reviewer index and paper id,
     * check if there are already have 3 paper and if input paper already in the list
     * then add paper in paper list of reviewer
     *
     * @param index reviewer index
     * @param paperID paper id
     */
    public void selectPaper(int index, int paperID){
        if (getReviewerArrayList().get(index).getPaperList().size() >= 3)
            System.out.println("one reviewer can only select max 3 papers!");
        else if (reviewerArrayList.get(index).getPaperList().contains(paperID)){
            System.out.println("Reviewer has already have this paper!");
        }
        else {
            getReviewerArrayList().get(index).addPaper(paperID);
        }
    }

    /**
     * This method write reviewer arraylist into "reviewerDatabase.txt"
     * split by ","
     */
    public void writeFile() {
        String filename = ("reviewerDatabase.txt");
        try {
            PrintWriter outputFile = new PrintWriter(filename);
            for (Reviewer reviewer : reviewerArrayList) {
                outputFile.println(reviewer.getId()
                        + "," + reviewer.getName()
                        + "," + reviewer.getRelevantTopics()
                        + "," + reviewer.getPaperList());
            }
            outputFile.close();
        } catch (IOException e) {
            System.out.println("Unexpected I/O error occurred");// print this when something wrong
        }
    }

    public ArrayList<Reviewer> getReviewerArrayList() {
        return reviewerArrayList;
    }

}
