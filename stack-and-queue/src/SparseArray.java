import java.io.*;

/**
 * @Description:
 * @Author: lmwis
 * @Date 2020-09-26 16:01
 * @Version 1.0
 */
public class SparseArray {
    public static void main(String[] args) throws IOException {
        // 创建一个原始的二维数组11 * 11
        // 0：表示没有棋子，1表示黑子 2表示蓝子
        int[][] chessArr1 = getDataFromFile();
        // 输出原始的二维数组
        for (int[] ints : chessArr1) {
            for (int data : ints) {
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }
        // 将二维数组转稀疏数组
        // 1.先遍历二维数组，得到非0 的个数
        int sum = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if(chessArr1[i][j]!=0) {
                    sum++;
                }
            }
        }
        // 2.创建稀疏数组
        int[][] sparseArr = new int[sum+1][3];
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = sum;
        int count=1;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if(chessArr1[i][j]!=0) {
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArr1[i][j];
                    count++;
                }
            }
        }
        // 输出稀疏数组的形式
        System.out.println();
        System.out.println("稀疏数组形式：");
        for (int[] ints : sparseArr) {
            System.out.printf("%d\t%d\t%d",ints[0],ints[1],ints[2]);
            System.out.println();
        }
        // 将稀疏数组恢复为原始二维数组
        int a = sparseArr[0][0];
        int b = sparseArr[0][1];
        int[][] chessArray2 = new int[a][b];
        for (int i = 1; i < sparseArr.length; i++) {
            chessArray2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }
        System.out.println("稀疏数组转换二维数组形式：");
        // 输出转化后的二维数组
        for (int[] ints : chessArray2) {
            for (int data : ints) {
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }
//        saveToFile(sparseArr);
    }

    public static void saveToFile(int[][] sparseArr) throws IOException {
        File file = new File("sparse_array.data");
        FileWriter ots = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(ots);
        for (int[] ints : sparseArr) {
            bw.write(ints[0]+"-"+ints[1]+"-"+ints[2]+"\n");
            bw.flush();
        }
        bw.close();
        ots.close();
    }

    public static int[][] getDataFromFile() throws IOException {
        File file = new File("sparse_array.data");
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String str ="";
        boolean flag=false;
        int[][] parseArray=null;
        while ((str = br.readLine())!=null){
            String[] split = str.split("-");
            // 第一行创建二维数组
            if (!flag){
                parseArray = new int[new Integer(split[0])][new Integer(split[1])];
                System.out.println("行："+new Integer(split[0]));
                System.out.println("列："+new Integer(split[1]));
                flag = true;

            }else {
                // 其余行赋值
                parseArray[new Integer(split[0])][new Integer(split[1])]=new Integer(split[2]);
            }
        }
        return parseArray;
    }

    public static int[][] getDataFromStaticData(){
        int[][] chessArr1 = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        chessArr1[4][5] = 2;
        return chessArr1;
    }
}
