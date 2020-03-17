public class A0038CountandSay {
    public String countAndSay(int n) {
        String line = "1";
        for (int i = 1; i < n; i++) {
            line = countAndSayLine(line);
        }
        return line;
    }

    private String countAndSayLine(String line) {
        StringBuilder newLine = new StringBuilder();
        char[] lineChar = line.toCharArray();
        int i = 0;
        int count = 0;
        while (i < line.length()) {
            if (i == 0 || lineChar[i] == lineChar[i - 1]) {
                count++;
            } else {
                newLine.append(count).append(lineChar[i - 1]);
                count = 1;
            }
            if (i == line.length() - 1) {
                newLine.append(count).append(lineChar[i ]);
            }
            i++;
        }
        return newLine.toString();
    }

    public static void main(String[] args) {
        System.out.println(new A0038CountandSay().countAndSay(5));
    }
}
