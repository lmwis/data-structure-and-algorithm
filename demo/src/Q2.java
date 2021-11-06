import java.util.Arrays;

/**
 * @Description: TODO
 * @Author: lmwis
 * @Data: 2021/11/4 11:19 上午
 * @Version: 1.0
 */
public class Q2 {
    public static void main(String[] args) {
        Arrays.stream(new Q2().move(new int[]{1, 2, 3, 0, 5,7}))
                .forEach(System.out::println);
    }

    public int[] move(int[] arr){
        int index = 0;
        for (int i = 0; i < arr.length; i++) {

            if(arr[index]!=0){
                while(index<arr.length){
                    index++;
                    if(arr[index]==0){
                        i=index;
                        break;
                    }
                }
            }else{
                if(arr[i]!=0){
                    int temp = arr[i];
                    arr[i] = arr[index];
                    arr[index]=temp;
                }
            }
        }

        return arr;
    }
}
