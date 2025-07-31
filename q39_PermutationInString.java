import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class q39_PermutationInString {
    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "lecabee";
        System.out.println(checkInclusion(s1,s2));
        System.out.println(checkInclusion2(s1,s2));
        System.out.println(checkInclusion3(s1,s2));
    }
    public static boolean checkInclusion(String s1, String s2) {
        // brute force
        // time = o(n^3 logn) and space = o(n)

        char[] s1Array = s1.toCharArray();
        Arrays.sort(s1Array);
        String sortedS1 = new String(s1Array);

        for (int i = 0; i < s2.length(); i++) {
            for (int j = i; j < s2.length(); j++) {
                char[] subStr = s2.substring(i, j+1).toCharArray();
                Arrays.sort(subStr);
                String sortedSubStr = new String(subStr);

                if (sortedSubStr.equals(sortedS1))
                    return true;
            }
        }

        return false;
    }
    public static boolean checkInclusion2(String s1, String s2) {
        // using HashMap
        // time = o(n*m) and space = o(1)
        Map<Character, Integer> mapCount1 = new HashMap<>();                               // frequency map
        for (char c : s1.toCharArray()) {
            mapCount1.put(c, mapCount1.getOrDefault(c,0) + 1);                  // make map for s1
        }

        int need = mapCount1.size();
        for (int i=0; i < s2.length(); i++) {
            Map<Character, Integer> mapCount2 = new HashMap<>();                           // map for s2
            int curr = 0;

            for (int j=i; j < s2.length(); j++) {
                char c = s2.charAt(j);
                mapCount2.put(c, mapCount2.getOrDefault(c, 0) + 1);             // put jth char (from s2) in map

                if (mapCount1.getOrDefault(c,0) < mapCount2.get(c))             // check with from map of s1 (0<1)
                    break;

                if (mapCount1.getOrDefault(c,0) == mapCount2.get(c))            // if found (1==1), curr+1
                    curr++;

                if (curr == need)                                                          // if curr meets size of s1, true
                    return true;
            }
        }
        return false;
    }

    public static boolean checkInclusion3(String s1, String s2) {
        // sliding window
        // time = o(n) and space = o(1)

        if (s1.length() > s2.length())
            return false;

        int[] s1Count = new int[26];                            // fixed array of length 26
        int[] s2Count = new int[26];

        for (int i=0; i < s1.length(); i++) {                   // initializing array with 1 (size = s1= window size)
            s1Count[s1.charAt(i) - 'a']++;                      // getting ASCII value
            s2Count[s2.charAt(i) - 'a']++;
        }

        int matches = 0;
        for (int i=0; i<26; i++) {                              // this is one time iteration to calculate matches = o(26)
            if (s1Count[i] == s2Count[i])
                matches++;
        }

        int left = 0;                                           // sliding window, right is at: s1 size = window size
        for (int right = s1.length(); right < s2.length(); right++) {
            if (matches == 26)
                return true;

            int index = s2.charAt(right) - 'a';                 // window: adding to right
            s2Count[index]++;                                   // add right element in s2
            if (s1Count[index] == s2Count[index])               // if at index, s1 s2 match, so (match + 1)
                matches++;
            else if (s1Count[index] + 1 == s2Count[index])      // if at index, s1 s2 doesn't match, so (match -1)... (s1+1) because s2 is already +1 (for checking)
                matches --;

            index = s2.charAt(left) - 'a';                      // window: removing from left
            s2Count[index]--;                                   // remove left element in s2
            if (s1Count[index] == s2Count[index])
                matches++;
            else if (s1Count[index] - 1 == s2Count[index])
                matches--;

            left++;
        }

        return matches ==26;
    }
}
