public class Verififer {

    public static boolean isalphabetic(String str)
    {
        boolean isalphabetic = false;
        for (int i = 0; i < str.length(); i++)
        {
            if (!Character.isLetter(str.charAt(i)) || str.contains(",") )
            {
                isalphabetic = false;
            }
            else
                isalphabetic = true;
        }
        return isalphabetic;
    }

    /**
     * check if the input is unmeric or not
     *
     * @parameter: string str
     * @local variable: boolean isNumeric
     */
    public static boolean isNumeric(String str)
    {
        boolean isNumeric = false;
        for (int i = 0; i < str.length(); i++)
        {
            if (!Character.isDigit(str.charAt(i)))
            {
                isNumeric = false;
            }
            else
                isNumeric = true;
        }
        return isNumeric ;
    }
}