import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Conference {
    private Integer conferenceId;
    private String conferenceName;
    private String conferenceTitle;
    private String conferenceTopics;
    private String acceptFormat;
    private LocalDate submitDeadline;

    public Conference(Integer conferenceId, String conferenceName, String conferenceTitle, String conferenceTopics, String acceptFormat, LocalDate submitDateline) {
        this.conferenceId = conferenceId;
        this.conferenceName = conferenceName;
        this.conferenceTitle = conferenceTitle;
        this.conferenceTopics = conferenceTopics;
        this.acceptFormat = acceptFormat;
        this.submitDeadline = submitDateline;
    }

    public Integer getConferenceId() {
        return conferenceId;
    }

    public static Integer setConferenceId(ArrayList arrayList) {
        return arrayList.size() + 1;
    }

    public String getConferenceName() {
        return conferenceName;
    }

    public static String setConferenceName(ArrayList arrayList) {
        boolean correctName = false;
        String newConferenceName = "";
        while (!correctName) {
            System.out.print("Enter conference name: ");
            Scanner scanner = new Scanner(System.in);
            String name = scanner.nextLine().trim(); // remove blank in the begin and end

            if (arrayList.contains(name))// check if name have already exist
            {
                System.out.println("     sorry, " + name + " already registered!");
                System.out.println();
            } else {
                newConferenceName = name;// give name value to newName
                System.out.println("     Name successfully set");
                System.out.println();
                correctName = true;//end the loop
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
        return scanner.nextLine().trim(); // remove blank in the begin and end
    }

    public String getConferenceTopics() {
        return conferenceTopics;
    }

    public static String setConferenceTopics(){
        return Paper.setTopics();
    }

    public String getAcceptFormat() {
        return acceptFormat;
    }

    public static String setAcceptFormat() {
        Display.showFileFormat();
        String newFormat = "";
        boolean exit = false;
        while (!exit) {
            Scanner scanner = new Scanner(System.in);
            String option = scanner.nextLine();
            switch (option) {
                case "1" -> {
                    newFormat = "docx";
                    exit = true;
                }
                case "2" -> {
                    newFormat = "PDF";
                    exit = true;
                }
                default -> Display.invalidInput();
            }
        }
        return newFormat;
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
            String inputDate = scanner.nextLine().trim(); // remove blank in the begin and end
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

    @Override
    public String toString() {
        return
                "conferenceId=" + conferenceId +
                ", conferenceName='" + conferenceName + '\'' +
                ", conferenceTitle='" + conferenceTitle + '\'' +
                ", conferenceTopics='" + conferenceTopics + '\'' +
                ", acceptFormat='" + acceptFormat + '\'' +
                ", submitDeadline=" + submitDeadline;
    }
}


