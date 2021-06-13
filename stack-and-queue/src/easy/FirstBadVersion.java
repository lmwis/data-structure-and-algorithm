package easy;

public class FirstBadVersion {

    public boolean isBadVersion(int version){
        return true;
    }
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        int current = n;
        while(right-left>=1){
            current = left + (right - left) / 2; // int 类型可能会溢出，因此不能使用(left+right)/2;
            if(isBadVersion(current)){
                // 往左找
                right = current ;
            }else{
                left = current+1 ;
            }

            // current = (left+right)/2;
        }

        return isBadVersion(current)?current:current+1;
    }

}
