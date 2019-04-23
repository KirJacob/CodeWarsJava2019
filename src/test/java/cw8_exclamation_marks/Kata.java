package cw8_exclamation_marks;


public class Kata {
    /**
     * Description:
     * Remove n exclamation marks in the sentence from left to right. n is positive integer.
     */

    public static String remove(String s, int n) {
        String[] resultArr = s.split("");
        int count = 0;

        for (int i = 0; i < resultArr.length; i++)
            if ((resultArr[i].equals("!")) && (count < n)) {
                resultArr[i] = "";
                count++;
            }
        String resultStr = String.join("", resultArr);
        return resultStr;
    }

    public static String removeSamp1(String s, int n){
        while (n-->0){ //same as while ((n--)<0)
            s = s.replaceFirst("!", "");
        }

        return s;
    }
}
