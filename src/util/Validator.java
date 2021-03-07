package util;

import java.sql.Date;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

    public static boolean validate(Vector<String> fields, int modelNumber){
        switch (modelNumber){
            case 0:
                if(fields.get(1).isEmpty() || LengthBiggerThan(fields.get(1), 128) || notOnlyLetters(fields.get(1)))
                    return false;
                if(fields.get(2).isEmpty() || LengthBiggerThan(fields.get(2), 128) || notOnlyLetters(fields.get(2)))
                    return false;
                if(LengthBiggerThan(fields.get(3), 128)
                        || notOnlyLetters(fields.get(3)))
                    return false;
                if(notOnlyNumbers(fields.get(4)) || notOnlyNumbers(fields.get(5)))
                    return false;
                if(!fields.get(6).equals("м") && !fields.get(6).equals("ж"))
                    return false;
                if(fields.get(7).isEmpty() || fields.get(9).isEmpty() || fields.get(11).isEmpty())
                    return false;
                if(notDate(fields.get(8)) || notDate(fields.get(10)))
                    return false;
                if(!fields.get(14).equals("да") && !fields.get(14).equals("нет"))
                    return false;
                break;
            case 1:
                if(fields.get(1).isEmpty() || notOnlyLetters(fields.get(1)))
                    return false;
                if(fields.get(2).isEmpty() || LengthBiggerThan(fields.get(2), 128) || notOnlyLetters(fields.get(2)))
                    return false;
                break;

            default:
                break;
        }
        return true;
    }

    private static boolean notDate(String str){
        Date.valueOf(str);
        return false;
    }

    private static boolean LengthBiggerThan(String str, int length){
        return str.length() > length;
    }

    private static boolean notOnlyNumbers(String str){
        Pattern pattern = Pattern.compile("[^0123456789]", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(str);
        return matcher.find();
    }

    private static boolean notOnlyLetters(String str){
        Pattern pattern = Pattern.compile("[^абвгдеёжзийклмнопрстуфхцчшщъыьэюяabcdefghijklmnopqrstuvwxyz]", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(str);
        return matcher.find();
    }
}
