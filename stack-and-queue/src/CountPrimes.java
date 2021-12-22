import java.util.Scanner;

/**
 * @Description: 204. 计数质数
 * 统计所有小于非负整数 n 的质数的数量。
 * 示例 1：
 * 输入：n = 10
 * 输出：4
 * 解释：小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 * @Author: lmwis
 * @Date 2020-12-03 21:14
 * @Version 1.0
 */
public class CountPrimes {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int c = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i <n; i++) {
            arr[i] = in.nextInt();
        }

    }
/*

#include<bits/甩头dc++.h>
using namespace std;
const int N = 100200;
int d[N],n,m;

bool ch(int x){

    int ct = m - 1;
    int last = d[0];
    for(int i = 1 ; i < n && ct; ++i){
        while(i < n && d[i] - last < x) ++i;
        if(i == n)  return false;
        last = d[i];
        --ct;
    }
    if(ct)
        return false;
    return true;
}

int main(){

    cin >> n >> m;
    for(int i = 0; i < n; ++i)
        cin >> d[i];

    sort(d, d + n);
    int l = 0,r = 1e9 + 1,m,res = 0;

    while(l <= r){
        m = (l  + r) >> 1;
        if(ch(m)){
            res = max(res, m);
            l = m + 1;
        }else r = m - 1;
    }

    cout << res << '\n';
    return 0;
}




 */
    // Eeatosthese筛法，每次除去非质数的整数倍
    public int countPrimes(int n) {
        if(n<=2){
            return 0;
        }
        int count = 0;
        int[] container = new int[n];
        for(int i=2;i<n;i++){

            if(container[i]!=1){
                count++;
                for(int j=i+i;j<n;j+=i){
                    container[j]=1;
                }
            }
        }
        return count;
    }
}
