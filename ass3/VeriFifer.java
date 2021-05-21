/**
 * check if the input is numeric or not
 *
 * @ parameter: string str
 * @ local variable: boolean isNumeric
 */
public class VeriFifer {

    public static boolean isAlphabetic(String str) {
        boolean isAlphabetic = false;
        for (int i = 0; i < str.length(); i++) {
            isAlphabetic = Character.isLetter(str.charAt(i)) && !str.contains(",");
        }
        return isAlphabetic;
    }

    public static boolean isNumeric(String str) {
        boolean isNumeric = false;
        for (int i = 0; i < str.length(); i++) {
            isNumeric = Character.isDigit(str.charAt(i));
        }
        return isNumeric;
    }

    public static boolean isValid(String email) {
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        return email.matches(regex);
    }

    public static boolean validPassword(String password) {
        String regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;.',?/*~$^+=<>]).{6,20}$";
        return password.matches(regex);
    }
}


