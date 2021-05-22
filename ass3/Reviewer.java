import java.util.ArrayList;
/**
 *This class manage reviewer, set and get reviewer attributes
 *
 * @author team56
 * @version 2.0 (21 May 2021)
 */
public class Reviewer {
    private int id;
    private String name;
    private String relevantTopics;
    private ArrayList<Integer> paperList;

    /**
     * constructor of Reviewer class
     * @param id from user class
     * @param name from user class
     * @param relevantTopics relevant topics
     * @param paperList paper under reviewing
     */
    public Reviewer(int id, String name,String relevantTopics,ArrayList<Integer> paperList) {
        this.id = id;
        this.name = name;
        this.relevantTopics = relevantTopics;
        this.paperList = paperList;
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
        System.out.println("successfully add one paper --> paperID: " + paperId);
    }

    /**
     * this method remove select paper
     * @param paperID input paper id
     */
    public void removePaper(int paperID){
        int i = 0;
        while (i < paperList.size()) {
            if (paperID == paperList.get(i)) {
                paperList.remove(i);
                System.out.println("successfully remove one paper --> paperID: " + paperID);
            }
            i++;
        }
    }

    @Override
    public String toString() {
        return
                "reviewerId=" + id +
                ", name='" + name + '\'' +
                ", relevantTopics='" + relevantTopics + '\'' +
                ", paperList=" + paperList;
    }

}