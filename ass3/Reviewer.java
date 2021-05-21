import java.util.ArrayList;

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
        String newTopics = Paper.setTopics();
        System.out.println("you have choose: " + newTopics);
        System.out.println();
        return newTopics;
    }

    public void addPaper(Integer paperId){
        paperList.add(paperId);
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