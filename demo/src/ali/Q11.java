//评测题目: 
/**题目1：有一个仓库，容量为N。有若干生产者，将生产的产品存入到仓库，除非仓库已满。
 又有若干消费者，从仓库中取出产品消费，除非仓库已空。请写一段程序让这个模式正常运转

 题目2：一个已排好序的数组（数组中没有重复项，升序排序）。
 要求，
 1.在预先未知的某个旋转轴上进行旋转一次，如（1、2、4、5、6、9可能成为4、5、6、9、1、2）；
 2.给你一个搜索的目标值。如果在数组中找到，返回它的索引值，否则返回- 1

 题目3：删除子字符串的最大得分
 难度中等8收藏分享切换为英文接收动态反馈
 给你一个字符串 s 和两个整数 x 和 y 。你可以执行下面两种操作任意次。
 •	删除子字符串 "ab" 并得到 x 分。
 o	比方说，从 "cabxbae" 删除 ab ，得到 "cxbae" 。
 •	删除子字符串"ba" 并得到 y 分。
 o	比方说，从 "cabxbae" 删除 ba ，得到 "cabxe" 。
 请返回对 s 字符串执行上面操作若干次能得到的最大得分。

 示例 ：
 输入：s = "cdbcbbaaabab", x = 4, y = 5
 输出：19
 解释：
 - 删除 "cdbcbbaaabab" 中加粗的 "ba" ，得到 s = "cdbcbbaaab" ，加 5 分。
 - 删除 "cdbcbbaaab" 中加粗的 "ab" ，得到 s = "cdbcbbaa" ，加 4 分。
 - 删除 "cdbcbbaa" 中加粗的 "ba" ，得到 s = "cdbcba" ，加 5 分。
 - 删除 "cdbcba" 中加粗的 "ba" ，得到 s = "cdbc" ，加 5 分。
 总得分为 5 + 4 + 5 + 5 = 19 。*/

// 题目1
public class Main{

    public static void main(String[] args){

        Main m = new Main();
        m.doBusiness();


    }

    public void doBusiness(){
        Store store = new Store(10);

        for(int i=0;i<10;i++){
            Producer p = new Producer();
            new Thread(()->{
                p.doProduce();
                Thread.sleep(10);
            }).start();

        }
        for(int i=0;i<10;i++){
            Custmer c = new Custmer();
            new Thread(()->{
                c.doCustme();
                Thread.sleep(10);
            }).start();
        }
    }

    class Producer{
        public void doProduce(Store store){
            store.put();
        }
    }

    class Custmer{

        public void doCustme(Store store){
            store.get();
        }

    }

    class Store{
        // 容量
        private AutomicInteger current = new AutomicInteger(n);
        private ReertenLock lock =
        private int n;


        public Store (int n){
            this.n = n;
        }
        // 消费
        public void get(){
            lock.lock();
            do{
                if(current>0){
                    n.decrease();
                    break;
                }
            }while(current<=0);

            lock.unlock();

        }
        // 生产
        public void put(){
            lock.lock();
            do{
                if(current<=n){
                    n.decrease();
                    break
                }
            }while(current>n);

            lock.unlock();
        }
    }
}

// 题目二

public class Q2{
    public static void main(String[] args){


    }

    public int getNum(int k,int num,int[] arr){ // k为旋转轴，num为目标数字

        int res =  divid(0,arr.length,arr,num);
        if(res <0){
            return res;
        }
        // 1、2、4、5、6、9   4、5、6、9、1、2
        return (res+k)%arr.length-1; // 减不1取决于k从0还是1计算

    }

    public int divid(int left,int right,int[] arr,int num){

        if((left==right)||(left>right)){
            return -1; // 表示不存在
        }
        int index = (0+arr.length)/2;

        if(arr[index]>num){ // 取左边
            return divid(left,index-1,arr,num);
        }else if(arr[index]<num){
            return divid(index+1,right,arr,num);
        }else{
            return index;
        }

    }
}

// 题目三

public class Q3{
    public static void main(String[] args){


    }
    public int getMax(String s,int x,int y){  // ba > ab

        if(x>y){
            return doMax(s,x,y,"ab","ba");
        }else{
            return doMax(s,y,x,"ba","ab");
        }

    }

    // 认为x最大
    public int doMax(String s,int x,int y,String sx,String sy){
        int sum=0;
        while(true){
            if(s.indexOf(sx)){
                String s1 = s.subString(0,s.indexOf(sx));
                String s2 = s.subString(s.indexOf(sx)+2,s.length());
                s = s1+s2;
                sum+=x;
            }else if(s.indexOf(sy)){
                String s1 = s.subString(0,s.indexOf(sy));
                String s2 = s.subString(s.indexOf(sy)+2,s.length());
                s = s1+s2;
                sum+=y;
            }else{
                break;
            }
        }
        return sum;
    }
}