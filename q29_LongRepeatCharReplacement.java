import java.util.HashMap;

public class q29_LongRepeatCharReplacement {
    public static void main(String[] args) {
        String s = "XYYX";
        int k = 2;
        System.out.println(characterReplacement(s, k));

    }
    public static int characterReplacement(String s, int k) {
        // brute force
        // time = o(n*n) and space = o(n)
        int result = 0;

        for (int i=0; i<s.length(); i++) {
            HashMap<Character, Integer> count = new HashMap<>();
            int maxf= 0;

            for (int j=i; j<s.length(); j++) {
                count.put(s.charAt(j), count.getOrDefault(s.charAt(j), 0) + 1);
                maxf = Math.max(maxf, count.get(s.charAt(j)));
                if ((j-i+1)-maxf <= k) {
                    result = Math.max(result, j - i + 1);
                }
            }
        }

        return result;
    }

}
