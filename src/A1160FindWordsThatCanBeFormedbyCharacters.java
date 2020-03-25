public class A1160FindWordsThatCanBeFormedbyCharacters {
    public int countCharacters(String[] words, String chars) {
        char[] cs = chars.toCharArray();
        int[] charCount = new int[123];
        int r = 0;
        for (int i = 0; i < cs.length; i++) {
            charCount[cs[i]]++;
        }
        for (int i = 0; i < words.length; i++) {
            char[] wordChars= words[i].toCharArray();
            int[] charCountCopy = new int[123];
            System.arraycopy(charCount,0,charCountCopy,0,charCount.length);
            boolean flag = true;
            for (int j = 0; j < words[i].length(); j++) {
                charCountCopy[wordChars[j]]--;
                if (charCountCopy[wordChars[j]]<0){
                    flag=false;
                    break;
                }
            }
            if(flag){
                r+=wordChars.length;
            }
        }
        return r;
    }
}
