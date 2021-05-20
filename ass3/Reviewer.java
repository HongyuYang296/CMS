import java.util.ArrayList;
import java.util.Scanner;

public class Reviewer {
    private int id;
    private String name;
    private String relevantTopics;
    private ArrayList<Integer> paperList;




    public Reviewer(int id, String name,String relevantTopics,ArrayList<Integer> paperList) {
        this.id = id;
        this.name = name;
        this.relevantTopics = relevantTopics;
        this.paperList = paperList;
    }

    public Reviewer(int id, String name){
        this.id = id;
        this.name = name;
    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getRelevantTopics() {
        return relevantTopics;
    }

    public ArrayList<Integer> getPaperList() {
        return paperList;
    }

    public void setTopics(String topics){
        relevantTopics = topics;

    }

    public static String setTopic() {
        Dispaly.showTopics();
        String newTopics = "";
        boolean exit = false;
        while (!exit) {
            Scanner scanner = new Scanner(System.in);
            String option = scanner.nextLine();
            switch (option) {
                case "1" -> {
                    newTopics = "IT";
                    exit = true;
                }
                case "2" -> {
                    newTopics = "Medicine";
                    exit = true;
                }
                case "3" -> {
                    newTopics = "Education";
                    exit = true;
                }
                case "4" -> {
                    newTopics = "Art";
                    exit = true;
                }
                case "5" -> {
                    newTopics = "History";
                    exit = true;
                }
                case "6" -> {
                    newTopics = "Geography";
                    exit = true;
                }
                case "7" -> {
                    newTopics = "Biology";
                    exit = true;
                }
                case "8" -> {
                    newTopics = "Math";
                    exit = true;
                }
                case "9" -> {
                    newTopics = "Economy";
                    exit = true;
                }
                case "10" -> {
                    newTopics = "Others";
                    exit = true;
                }
                default -> Dispaly.invalidInput();

            }
        }
        System.out.println("you have choose: " + newTopics);
        System.out.println();
        return newTopics;
    }

    public void addPaper(Integer paperId){
//        paperList = new ArrayList<>();
        paperList.add(paperId);
    }



    public void removePaper(Paper paper){
        paperList.remove(paper);
    }



    @Override
    public String toString() {
        return "Reviewer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", relevantTopics='" + relevantTopics + '\'' +
                ", paperList=" + paperList +
                '}';
    }

}