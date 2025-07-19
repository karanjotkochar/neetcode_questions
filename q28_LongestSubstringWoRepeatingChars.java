import java.util.HashSet;
import java.util.Set;

public class q28_LongestSubstringWoRepeatingChars {
    public static void main(String[] args) {
        String s = "zxyzxyz";
        System.out.println(lengthOfLongestSubstring(s));
        System.out.println(lengthOfLongestSubstring2(s));
    }
    public static int lengthOfLongestSubstring(String s) {
        // brute force
        // time = o(n*n) and space = o(n)
        int result = 0;

        for (int i=0; i<s.length(); i++) {
            Set<Character> charSet = new HashSet<>();

            for (int j=i; j<s.length(); j++) {

                if (charSet.contains(s.charAt(j))) {
                    break;
                }
                charSet.add(s.charAt(j));
            }
            result = Math.max(result, charSet.size());

        }
        return result;
    }

    public static int lengthOfLongestSubstring2(String s) {
        // sliding window
        // time = o(n) and space = o(n)
        HashSet<Character> hashSet = new HashSet<>();
        int left = 0;
        int result = 0;

        for (int right = 0; right < s.length(); right++) {
            while(hashSet.contains(s.charAt(right))) {
                hashSet.remove(s.charAt(left));
                left++;
            }
            hashSet.add(s.charAt(right));

            result = Math.max(result, right-left+1);
        }

        return result;
    }

}
