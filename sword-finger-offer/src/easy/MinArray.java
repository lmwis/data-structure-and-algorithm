package easy;

/**
 * @Description:
 * @Author: lmwis
 * @Date 2021-01-28 12:27
 * @Version 1.0
 */
public class MinArray {
    /**
     * 简单思路：找到不升序的第一个
     *
     * @param numbers
     * @return
     */
    public int minArray(int[] numbers) {

        for(int i=0;i<numbers.length-1;i++){
            if(numbers[i]>numbers[i+1]){
                return numbers[i+1];
            }
        }
        return numbers[0];
    }
    public int minArrayDivideTwo(int[] numbers){

            return 0;

    }
}
