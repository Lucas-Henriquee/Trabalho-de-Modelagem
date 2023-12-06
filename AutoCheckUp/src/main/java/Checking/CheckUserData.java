package Checking;

import java.util.regex.*;

public class CheckUserData {
    public static boolean checkName(String str){
        String regex = "([A-Z][a-z]+)(\\sd[a|e|i|o|u])?(\\s[A-Z][a-z]+)*";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }

    public static boolean checkEmail(String str){
        String regex = "[a-z-_.0-9]+@([a-z]+\\.)+[a-z]+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }
}
