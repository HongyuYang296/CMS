import java.util.Scanner;

public class system {
    private userDatabase users;

    public system(){
        this.users = new userDatabase();
    }

    private void regist() {
        users.readfile();
        boolean exit1 = false;
        while (!exit1) {
            printMenu1();
            Scanner scanner = new Scanner(System.in);
            String option = scanner.nextLine();
            if (option.equals("1"))
                registration1();

            else if (option.equals("2")) {
                show1();
            }


            else if (option.equals("3")) {
                System.out.println("Goodbye!!  thanks! ");
                users.writeFile();

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
    private void show1(){

        users.show();
    }

    private void registration1(){
        users.registration();
    }
    private void printMenu1() {
        System.out.println("");
        System.out.println("============================");
        System.out.println("1. REGIST");
        System.out.println("2. show");
        System.out.println("3. EXIT");
        System.out.println("please enter your choose: ");
    }

    public void run(){
        regist();


    }
    public static void main(String[] args) {
        system s = new system();
        s.run();
    }
}
