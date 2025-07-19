import java.util.HashMap;

public class q29_LongRepeatCharReplacement {
    public static void main(String[] args) {
        String s = "XYYX";
        int k = 2;
        System.out.println(characterReplacement(s, k));
        System.out.println(characterReplacement2(s,k));

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

    public static int characterReplacement2(String s, int k) {
        // sliding window
        // time = o(n) and space = o(n)
        HashMap<Character, Integer> count = new HashMap<>();
        int left = 0;
        int result = 0;
        int maxf = 0;

        for (int right = 0; right<s.length(); right++) {
            count.put(s.charAt(right), count.getOrDefault(s.charAt(right), 0) + 1);
            maxf = Math.max(maxf, count.get(s.charAt(right)));

            while ((right-left+1) - maxf > k) {
                count.put(s.charAt(left), count.get(s.charAt(left)) - 1 );
                left++;
            }
            result = Math.max(result, right-left+1);
        }
        return result;
    }

    // TODO: Again

}
