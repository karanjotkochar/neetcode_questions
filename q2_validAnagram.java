import java.util.Arrays;
import java.util.HashMap;

public class q2_validAnagram {
    public static void main(String[] args) {
        String s = "racecar";
        String r = new String("carrace");

        System.out.println(isAnagram(s,r));
        System.out.println(isAnagram2(s,r));
    }

    public static boolean isAnagram(String s, String r) {

        // brute force method
        // sorting
        // time -- O(n) = O(nlogn + mlogm) --> quick sort
        if (s.length() != r.length())
            return false;

        char[] chars1 = s.toCharArray();
        Arrays.sort(chars1);

        char[] chars2 = r.toCharArray();
        Arrays.sort(chars2);

        return Arrays.equals(chars1, chars2);
    }

    public static boolean isAnagram2(String s, String r) {
        // using hashmap
        // count frequency of each character
        if (s.length() != r.length())
            return false;

        HashMap<Character,Integer> countS = new HashMap<>();
        HashMap<Character,Integer> countR = new HashMap<>();
        for (int i=0; i<s.length(); i++) {
            countS.put(s.charAt(i), countS.getOrDefault(s.charAt(i), 0) + 1);
            countR.put(r.charAt(i), countR.getOrDefault(r.charAt(i), 0) + 1);
        }

        return countS.equals(countR);
    }
}
