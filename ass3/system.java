import java.util.Scanner;

public class system {
    private userDatabase users;

    private void regist() {
        boolean exit1 = false;
        while (!exit1) {
            printMenu1();
            Scanner scanner = new Scanner(System.in);
            String option = scanner.nextLine();
            if (option.equals("1"))
                registration1();

            else if (option.equals("2")) {
                System.out.println("Goodbye!!  thanks! ");

                exit1 = true;//end the while loop
            } else {
                System.out.println("##ERROR: Invalid input##");
                System.out.println("please enter again");
                System.out.println("");
                System.out.println("================================");
                System.out.println("");
            }
        }
    }

    private void registration1(){
        users.registration();
    }
    private void printMenu1() {
        System.out.println("1. REGIST");
        System.out.println("2. EXIT");
        System.out.println("please enter your choose: ");
    }

    public void run(){
        userDatabase users = new userDatabase();
        regist();
    }
    public static void main(String[] args) {
        system s = new system();
        s.run();
    }
}
