public class A0278FirstBadVersion {

    public int firstBadVersion(int n) {
        int mid = n/2;
        int left = 1;
        int right = n;
        while (left<right){
            mid=left/2+right/2; //注意防止int越界
            if(isBadVersion(mid)){
                right=mid;
            }else {
                left=mid+1;
            }
        }
        return left;
    }

    boolean isBadVersion(int version){
        if(version>=1) {
            return true;
        }else {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(new A0278FirstBadVersion().firstBadVersion(1));
    }
}
