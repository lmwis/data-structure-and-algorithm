package wangyi;

/**
 * @Description:
 * @Author: lmwis
 * @Date 2021-04-10 15:43
 * @Version 1.0
 */
public class Q3 {
    public int canCompleteRace (int[] e, int[] c) {
        // write code here
        int index = 0;
        int current = 0;
        while(index<e.length){
            int i=index;
            for(;i<(i+5);i++){
                current +=e[i%e.length];
                if(current<c[i%e.length]){
                    break;
                }else {
                    current -=c[i%e.length];
                }
            }
            if(i==(index+5)){ // 循环完了
                return index;
            }
            index++;
        }
        if(index>=e.length){
            return -1;
        }
        return index;

    }
}
