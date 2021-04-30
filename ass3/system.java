import java.util.Scanner;

/**
 * Write a description of class here.
 *
 * @author team56
 * @version 1.0 (28 Apr 2021)
 */

public class system {
    private final userDatabase users;

    public system() {
        this.users = new userDatabase();
    }

    private void run() {
        users.readfile();
        boolean exit1 = false;
        while (!exit1) {
            Dispaly.printMenu();
            Scanner scanner = new Scanner(System.in);
            String option = scanner.nextLine();
            switch (option) {
                case "1" -> registration1();
                case "2" -> showUserList();
                case "3" -> {
                    System.out.println("Goodbye!!  thanks! ");
                    users.writeFile();
                    exit1 = true;//end the while loop
                }
                default -> {
                    Dispaly.invalidInput();
                }
            }
        }
    }

    private void registration1() {
        users.registration();
    }

    private void showUserList() {
        Dispaly.show(users.getUserlist());
    }


    public static void main(String[] args) {
        system s = new system();
        s.run();
    }
}
