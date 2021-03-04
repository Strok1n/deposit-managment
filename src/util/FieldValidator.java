package util;

import java.sql.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FieldValidator {

    public static boolean hasNumbers(String string){
        Pattern p = Pattern.compile("[0-9]", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(string);
        return m.find();
    }

    public static boolean isStringValid(String string, int length, boolean isSymbolsAllowed){
        if(string.length() > length){
            System.out.println("SYMBOLS1");
                return false;}
        if(!isSymbolsAllowed){
            char[] arr = string.toCharArray();
            for( char c : arr){
                if(c == '!')
                    return false;
            }
        }
        if(string.isEmpty()){
            System.out.println(string);              System.out.println("SYMBOLS3");
            return false;}
        return true;
    }

    public static boolean isDateValid(String date){
        try {
            Date.valueOf(date);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public static boolean isNumberValid(String number){
        try {
            int parsedInt = Integer.parseInt(number);
            return true;
        }catch (Exception e){
            return false;
        }
    }
    public static boolean isEmailValid(String email){
        if(email.lastIndexOf("@") >= email.lastIndexOf(".")
                || email.lastIndexOf("@") == -1
                || email.lastIndexOf(".") == -1)
            return false;
        return true;
    }



}
