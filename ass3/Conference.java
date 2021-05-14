import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Conference {
    private Integer conferenceId;
    private String conferenceName;
    private String conferenceTitle;
    private String conferenceTopics;
    private LocalDate submitDeadline;

    public Conference(Integer conferenceId, String conferenceName, String conferenceTitle, String conferenceTopics, LocalDate submitDateline) {
        this.conferenceId = conferenceId;
        this.conferenceName = conferenceName;
        this.conferenceTitle = conferenceTitle;
        this.conferenceTopics = conferenceTopics;
        this.submitDeadline = submitDateline;
    }

    public Integer getConferenceId() {
        return conferenceId;
    }

    public static Integer setConferenceId(ArrayList arrayList) {
        Integer newConferenceId = arrayList.size() + 1;
        return newConferenceId;
    }

    public String getConferenceName() {
        return conferenceName;
    }

    public static String setConferenceName(ArrayList arrayList) {
        boolean correctname = false;
        String newConferenceName = "";
        while (!correctname) {
            System.out.print("Enter conference name: ");
            Scanner scanner = new Scanner(System.in);
            String name = scanner.nextLine().trim(); // remove blank in the begain and end

            if (arrayList.contains(name))// check if name have already exist
            {
                System.out.println("     sorry, " + name + " already registered!");
                System.out.println();
            } else {
                newConferenceName = name;// give name value to newName
                System.out.println("     Name successfully set");
                System.out.println();
                correctname = true;//end the loop
            }
        }
        return newConferenceName;
    }

    public String getConferenceTitle() {
        return conferenceTitle;
    }

    public static String setConferenceTitle() {
        System.out.print("Enter conference Title: ");
        Scanner scanner = new Scanner(System.in);
        String title = scanner.nextLine().trim(); // remove blank in the begain and end
        return title;
    }

    public String getConferenceTopics() {
        return conferenceTopics;
    }

    public static String setConferenceTopics() {
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


    public LocalDate getSubmitDateline() {
        return submitDeadline;
    }

    public static LocalDate setSubmitDeadline() {
        boolean correctDeadline = false;
        LocalDate newDeadline = LocalDate.now();
        while (!correctDeadline) {
            System.out.print("Enter conference submit deadline(yyyy-mm-dd): ");
            Scanner scanner = new Scanner(System.in);
            String inputDate = scanner.nextLine().trim(); // remove blank in the begain and end
            if (!TimeConvert.isDateVail(inputDate)) {
                System.out.println("please input correct format: yyyy-mm-dd");
                System.out.println();
            } else {
                System.out.println("deadline successfully set");
                newDeadline = TimeConvert.toDate(inputDate);
                correctDeadline = true;
            }
        }
        return newDeadline;
    }

}


