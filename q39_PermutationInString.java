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
        Map<Character, Integer> mapCount1 = new HashMap<>();
        for (char c : s1.toCharArray()) {
            mapCount1.put(c, mapCount1.getOrDefault(c,0)+1);
        }

        int need = mapCount1.size();
        for (int i=0; i < s2.length(); i++) {
            Map<Character, Integer> mapCount2 = new HashMap<>();
            int curr = 0;

            for (int j=i; j < s2.length(); j++) {
                char c = s2.charAt(j);
                mapCount2.put(c, mapCount2.getOrDefault(c, 0) + 1);

                if (mapCount1.getOrDefault(c,0) < mapCount2.get(c))
                    break;

                if (mapCount1.getOrDefault(c,0) == mapCount2.get(c))
                    curr++;

                if (curr == need)
                    return true;
            }
        }
        return false;
    }

    public static boolean checkInclusion3(String s1, String s2) {
        if (s1.length() > s2.length())
            return false;

        int[] s1Count = new int[26];
        int[] s2Count = new int[26];

        for (int i=0; i < s1.length(); i++) {
            s1Count[s1.charAt(i) - 'a']++;
            s2Count[s2.charAt(i) - 'a']++;
        }

        int matches = 0;
        for (int i=0; i<26; i++) {
            if (s1Count[i] == s2Count[i])
                matches++;
        }

        int left = 0;
        for (int right = s1.length(); right < s2.length(); right++) {
            if (matches == 26)
                return true;

            int index = s2.charAt(right) - 'a';
            s2Count[index]++;
            if (s1Count[index] == s2Count[index])
                matches++;
            else if (s1Count[index] + 1 == s2Count[index])
                matches --;

            index = s2.charAt(left) - 'a';
            s2Count[index]--;
            if (s1Count[index] == s2Count[index])
                matches++;
            else if (s1Count[index] - 1 == s2Count[index])
                matches--;

            left++;
        }

        return matches ==26;
    }
}
