package dp;

/**
 * @Description:
 * @Author: lmwis
 * @Date 2020-10-25 20:09
 * @Version 1.0
 */
public class LongestMountain {
    public static void main(String[] args) {
        LongestMountain longestMountain = new LongestMountain();
        longestMountain.longestMountain(new int[]{1,2,3,4,5});
    }

    public int longestMountain(int[] A) {
        int n = A.length;
        int ans = 0;
        int left = 0;
        while (left + 2 < n) {
            int right = left + 1;
            if (A[left] < A[left + 1]) {
                while (right + 1 < n && A[right] < A[right + 1]) {
                    ++right;
                }
                if (right < n - 1 && A[right] > A[right + 1]) {
                    while (right + 1 < n && A[right] > A[right + 1]) {
                        ++right;
                    }
                    ans = Math.max(ans, right - left + 1);
                } else {
                    ++right;
                }
            }
            left = right;
        }
        return ans;
    }
}
