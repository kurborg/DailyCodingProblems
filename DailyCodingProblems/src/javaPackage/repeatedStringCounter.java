package javaPackage;

import java.io.*;

public class repeatedStringCounter {

    /*
     * Complete the 'repeatedString' function below.
     *
     * The function is expected to return a LONG_INTEGER. The function accepts
     * following parameters: 1. STRING s 2. LONG_INTEGER n
     */

    public static long counter(String s, long end) {
        int count = 0;

        for (int i = 0; i < end; i++) {
            char c = s.charAt(i);
            if (c == 'a')
                count++;
        }

        return count;
    }

    public static long repeatedString(String s, long n) {
        // Write your code here

        long numberOfRepeats = n / s.length();
        long remainder = n % s.length();

        if (!s.contains("a"))
            return 0;
        else {
            if (s.length() > n)
                return (counter(s, n));
            else
                return (numberOfRepeats * counter(s, s.length()) + counter(s, remainder));
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        long n = Long.parseLong(bufferedReader.readLine().trim());

        long result = repeatedString(s, n);

        bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }

}
