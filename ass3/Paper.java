import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

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


    public Paper(Integer id, Integer authorId, Integer conferenceId,
                 String topic, String name, String format,
                 String state, LocalDate submitTime) {
        this.paperId = id;
        this.authorId = authorId;
        this.conferenceId = conferenceId;
        this.topic = topic;
        this.name = name;
        this.format = format;
        this.state = state;
        this.submitTime = submitTime;
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

    public static Integer setPaperId(ArrayList arrayList) {
        Integer paperId = arrayList.size() + 1;
        return paperId;
    }

    public static Integer setAuthorId(Integer userId) {
        return userId;
    }

    public static Integer setConferenceId(Integer conferenceId) {
        return conferenceId;
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
                    newTopics = "topic1";
                    exit = true;
                }
                case "2" -> {
                    newTopics = "topic2";
                    exit = true;
                }
                case "3" -> {
                    newTopics = "topic3";
                    exit = true;
                }
                case "4" -> {
                    newTopics = "topic4";
                    exit = true;
                }
                case "5" -> {
                    newTopics = "topic5";
                    exit = true;
                }
                case "6" -> {
                    newTopics = "topic6";
                    exit = true;
                }
                case "7" -> {
                    newTopics = "topic7";
                    exit = true;
                }
                case "8" -> {
                    newTopics = "topic8";
                    exit = true;
                }
                case "9" -> {
                    newTopics = "topic9";
                    exit = true;
                }
                case "10" -> {
                    newTopics = "Others";
                    exit = true;
                }
                default -> {
                    Dispaly.invalidInput();
                }
            }
        }
        return newTopics;
    }

    public static String setName() {
        String name = "";
        return name;
    }

    public static String setFormat() {
        String format = "";
        return format;
    }

    public static String setState() {
        String state = "";
        return state;
    }

    public static LocalDate setSubmitTime() {
        LocalDate submitTime = TimeConvert.toDate("0000-00-00");
        return submitTime;
    }

    @Override
    public String toString() {
        return "Paper{" +
                "id=" + paperId +
                ", authorId=" + authorId +
                ", conferenceId=" + conferenceId +
                ", topic='" + topic + '\'' +
                ", name='" + name + '\'' +
                ", format='" + format + '\'' +
                ", state='" + state + '\'' +
                ", submitTime=" + submitTime +
                '}';
    }
}

