public class A0055JumpGame {
    public boolean canJump(int[] nums) {
        int i = nums.length-2;
        while ( i >=0 ) {
            if(nums[i]==0){
                int j = i-1;
                int c = i;
                boolean flag=false;
                while (j>=0){
                    if(c-j<nums[j]){
                        flag=true;
                        break;
                    }
                    if(nums[j]!=0){
                        i--;
                    }
                    j--;
                }
                if(!flag){
                    return false;
                }
            }
            i--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new A0055JumpGame().canJump(new int[]{3,2,0,0,4}));
        System.out.println(new A0055JumpGame().canJump(new int[]{2,3,1,1,4}));
        System.out.println(new A0055JumpGame().canJump(new int[]{3,2,1,0,4}));
        System.out.println(new A0055JumpGame().canJump(new int[]{3,3,0,0,4}));
    }
}
