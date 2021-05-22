import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *This class manage paper, set and get paper attributes
 *
 * @author team56
 * @version 2.0 (21 May 2021)
 */
public class Paper
{
    private Integer paperId;
    private Integer authorId;
    private Integer conferenceId;
    private String topic;
    private String name;
    private String format;
    private String state;
    private LocalDate submitTime;
    private String evaluation;

    /**
     * constructor of paper class
     * @param id id
     * @param authorId author id same with user class
     * @param conferenceId conference id from conference class
     * @param topic topic
     * @param name name
     * @param format format
     * @param state state(submitted, accept, reject)
     * @param submitTime submit local time
     * @param evaluation evaluation(HD,D,C,P,N)
     */
    public Paper(Integer id, Integer authorId, Integer conferenceId,
                 String topic, String name, String format,
                 String state, LocalDate submitTime, String evaluation) {
        this.paperId = id;
        this.authorId = authorId;
        this.conferenceId = conferenceId;
        this.topic = topic;
        this.name = name;
        this.format = format;
        this.state = state;
        this.submitTime = submitTime;
        this.evaluation = evaluation;
    }

    public Integer getPaperId() {
        return paperId;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public Integer getConferenceId() {
        return conferenceId;
    }

    public String getTopic() {
        return topic;
    }

    public String getName() {
        return name;
    }

    public String getFormat() {
        return format;
    }

    public String getState() {
        return state;
    }

    public LocalDate getSubmitTime() {
        return submitTime;
    }

    public String getEvaluation(){
        return evaluation;
    }

    /**
     * set paper ID automatically, increased by 1
     * @param arrayList input paper arraylist
     * @return new paper id
     */
    public static Integer setPaperId(ArrayList arrayList) {
        return arrayList.size() + 1;
    }

    public static Integer setAuthorId(Integer userId) {
        return userId;
    }

    public static Integer setConferenceId(Integer conferenceId) {
        return conferenceId;
    }

    public static String setTopic() {
        String newTopics = setTopics();
        System.out.println("you have choose: " + newTopics);
        System.out.println();
        return newTopics;
    }

    /**
     * this method use switch to ask user select topics
     * @return newTopics select topic
     */
    public static String setTopics(){
        Display.showTopics();
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
                default -> Display.invalidInput();

            }
        }
        return newTopics;
    }

    public static String setName(String name) {
        return name;
    }

    public static String setFormat(String format) {
        return format;
    }

    public static String setState(String str) {
        return str;
    }

    public void setState1(String str){
        state = str;
    }


    public static LocalDate setSubmitTime() {
        return LocalDate.now();
    }

    /**
     * This method use switch ask user select evaluations(HD,D,C,P,N)
     */
    public void setEvaluation() {
        Display.showEvaluation();
        String newEVA = "";
        boolean exit = false;
        while (!exit) {
            Scanner scanner = new Scanner(System.in);
            String option = scanner.nextLine();
            switch (option) {
                case "1" -> {
                    newEVA = "HD";
                    exit = true;
                }
                case "2" -> {
                    newEVA = "D";
                    exit = true;
                }
                case "3" -> {
                    newEVA = "C";
                    exit = true;
                }
                case "4" -> {
                    newEVA = "P";
                    exit = true;
                }
                case "5" -> {
                    newEVA = "N";
                    exit = true;
                }
            }
        }
        evaluation = newEVA;
    }

    @Override
    public String toString() {
        return "paperId=" + paperId +
                ", authorId=" + authorId +
                ", conferenceId=" + conferenceId +
                ", topic='" + topic + '\'' +
                ", name='" + name + '\'' +
                ", format='" + format + '\'' +
                ", state='" + state + '\'' +
                ", submitTime=" + submitTime +
                ", evaluation='" + evaluation + '\'';
    }
}

