public class A0345ReverseVowelsofaString {

    public String reverseVowels(String s) {
        int first = 0, last = s.length() - 1;
        char[] array = s.toCharArray();
        while(first < last){
            while(first < last && !isVowel(array[first])){
                first++;
            }
            while(first < last && !isVowel(array[last])){
                last--;
            }
            char temp = array[first];
            array[first] = array[last];
            array[last] = temp;
            first++;
            last--;
        }
        return new String(array);
    }

    private boolean isVowel(char c){
        return c=='a'||c=='e'||c=='i'||c=='o'||c=='u'||c=='A'||c=='E'||c=='I'||c=='O'||c=='U';
    }
}
