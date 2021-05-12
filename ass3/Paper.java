import java.time.LocalDate;

public class Paper
{
    private Integer id;
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
        this.id = id;
        this.authorId = authorId;
        this.conferenceId = conferenceId;
        this.topic = topic;
        this.name = name;
        this.format = format;
        this.state = state;
        this.submitTime = submitTime;
    }

    public Integer getId() {
        return id;
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

    public void setId(Integer id) {
        this.id = id;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public void setConferenceId(Integer conferenceId) {
        this.conferenceId = conferenceId;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setSubmitTime(LocalDate submitTime) {
        this.submitTime = submitTime;
    }

    @Override
    public String toString() {
        return "Paper{" +
                "id=" + id +
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

