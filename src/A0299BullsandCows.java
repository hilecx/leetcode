public class A0299BullsandCows {
    public String getHint(String secret, String guess) {
        int[] s = new int[10];
        int[] t = new int[10];
        int acount = 0;
        char[] secretchar = secret.toCharArray();
        char[] guesschar = guess.toCharArray();
        for (int i = 0; i < secret.length(); i++) {
            if (secretchar[i] == guesschar[i]) {
               acount++;
            }
            s[secretchar[i]-'0']++;
            t[guesschar[i]-'0']++;
        }
        int d = 0;
        for (int i = 0; i < s.length; i++) {
            d+=Math.min(s[i],t[i]);
        }
        StringBuilder res= new StringBuilder();
        res.append(acount);
        res.append('A');
        res.append(d-acount);
        res.append('B');
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(new A0299BullsandCows().getHint("1234","1352"));
    }
}
