import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
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
        String filename = ("paperdatabase.txt");
        try {
            FileReader reader = new FileReader(filename);
            scanner = new Scanner(reader);
            while (scanner.hasNextLine())//make sure read every line in the file
            {
                String line = scanner.nextLine();
                if (line != null && !line.equals("")) {
                    String[] values = line.split(",");//split every word by ","


                    Paper paperRead = new Paper(Integer.parseInt(values[0]), Integer.parseInt(values[1]),
                            Integer.parseInt(values[2]), values[3], values[4], values[5],values[6],
                            TimeConvert.toDate(values[7]));
                    paperArrayList.add(paperRead);
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

    private void writFile(){

    }
}
