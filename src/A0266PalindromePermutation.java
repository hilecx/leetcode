public class A0266PalindromePermutation {
    public boolean canPermutePalindrome(String s) {
        int[] map = new int[128];
        char[] c = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            map[c[i]]++;
        }
        int count = 0;
        for (int key = 0; key < map.length && count <= 1; key++) {
            count += map[key] % 2;
            if(count==2){
                return false;
            }
        }
        return true;
    }
}
