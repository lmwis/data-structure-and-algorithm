package string;
/**
 * @Description: 长按键入
 * @Author: lmwis
 * @Date 2020-10-21 17:54
 * @Version 1.0
 */
public class LongPressedName {
    public static void main(String[] args) {
        LongPressedName longPressedName = new LongPressedName();
        //"pyplrz"
        //"ppyypllr"
        System.out.println(longPressedName.isLongPressedName("pyplrz","ppyypllr"));
    }


    public boolean isLongPressedName(String name, String typed) {
        int i=0;
        int j=0;
        while(j<typed.length()){
            if(i<name.length() && name.charAt(i)==typed.charAt(j)){
                i++;
                j++;
            }else if(j>0 && typed.charAt(j)==typed.charAt((j-1))){
                j++;
            }else {
                return false;
            }
        }
        return i==name.length();
    }

}
