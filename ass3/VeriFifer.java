/**
 * This class contain all the validate methods
 * to check if the input have correct format
 *
 * @author team 56
 * @version  2.0 (21 May 2021)
 */
public class VeriFifer {

    /**
     * This method checks the input is alphabetic or not
     *
     * @param str input String
     * @return isAlphabetic if the input is Alphabetic and don't have "," return true, else return false.
     */
    public static boolean isAlphabetic(String str) {
        boolean isAlphabetic = false;
        for (int i = 0; i < str.length(); i++) {
            isAlphabetic = Character.isLetter(str.charAt(i)) && !str.contains(",");
        }
        return isAlphabetic;
    }

    /**
     * This method check if the input is numeric or not
     *
     * @param str input String
     * @return isNumeric if the input is numeric return true, else return false.
     */
    public static boolean isNumeric(String str) {
        boolean isNumeric = false;
        for (int i = 0; i < str.length(); i++) {
            isNumeric = Character.isDigit(str.charAt(i));
        }
        return isNumeric;
    }

    /**
     * This method
     * @param email
     * @return
     */
    public static boolean isValid(String email) {
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        return email.matches(regex);
    }
    public static boolean issValid(String email) {
        String regex = "\\p{Alpha} + \\p{Digit} + ";
        return email.matches(regex);
    }

    public static boolean validPassword(String password) {
        String regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;.',?/*~$^+=<>]).{6,20}$";
        return password.matches(regex);
    }
}


