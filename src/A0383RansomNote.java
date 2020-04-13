public class A0383RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] x = new int[123];
        char[] ransoms = ransomNote.toCharArray();
        char[] mags = magazine.toCharArray();
        for (int i = 0; i < ransomNote.length(); i++) {
            x[ransoms[i]]--;
        }
        for (int i = 0; i < magazine.length(); i++) {
            x[mags[i]]++;
        }
        for (int i = 97; i < x.length; i++) {
            if(x[i]<0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new A0383RansomNote().canConstruct("aca","aabc"));
        System.out.println(new A0383RansomNote().canConstruct("addca","aabc"));
        System.out.println(new A0383RansomNote().canConstruct("acdfdca","aabc"));
    }
}
