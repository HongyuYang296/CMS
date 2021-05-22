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
     * @return true input is alphabetic and don't contains ",", false input not alphabetic
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
     * @return true input is numeric, false input not numeric
     */
    public static boolean isNumeric(String str) {
        boolean isNumeric = false;
        for (int i = 0; i < str.length(); i++) {
            isNumeric = Character.isDigit(str.charAt(i));
        }
        return isNumeric;
    }

    /**
     * This method validate if email has correct format
     * @param email input email
     * @return true format correct, false format incorrect
     */
    public static boolean isValid(String email) {
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        return email.matches(regex);
    }

    /**
     * This method validate if password has correct format
     *
     * @param password input password
     * @return true format correct, false format incorrect
     */
    public static boolean validPassword(String password) {
        String regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;.',?/*~$^+=<>]).{6,20}$";
        return password.matches(regex);
    }
}


