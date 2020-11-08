import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Description:
 * @Author: lmwis
 * @Date 2020-11-08 14:06
 * @Version 1.0
 */
public class IdParser {
    public static void main(String[] args) throws IdParserException {
        Scanner input = new Scanner(System.in);
        String id = input.next();
        parser(id);
    }

    private static void parser(String id) throws IdParserException {
        if(id.length()!=18){
            throw new IdParserException("身份证号不合法");
        }
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(id.substring(0,id.length()-1));
        if (!isNum.matches()) throw new IdParserException("身份证号不合法");
        try{
            String lastChar = String.valueOf(id.charAt(id.length()-1));
            if(!lastChar.toUpperCase().equals("X")){ //如果不是X
                new Integer(lastChar);
            }
        }catch (Exception e){
            throw new IdParserException("身份证号不合法");
        }
        String gender;
        if(id.charAt(id.length()-2)%2==1) gender="男";
        else gender="女";
        String birthdayYear = id.substring(6,10);
        String birthdayMouth = id.substring(10,12);
        String birthdayDay = id.substring(12,14);
        System.out.println("这个人是"+gender+"性,"+"出生日期是"+birthdayYear
                +"年"+birthdayMouth+"月"+birthdayDay+"日");
    }
    private static class IdParserException extends Throwable {
        public IdParserException(String s) {
            super(s);
        }
    }
}
