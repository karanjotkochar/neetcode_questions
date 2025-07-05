import java.util.*;

public class q5_groupAnagrams {
    public static void main(String[] args) {
        String[] strs = {"act","pots","tops","cat","stop","hat"};
        groupAnagrams(strs);
    }

    public static List<List<String>> groupAnagrams(String[] strs) {

        // time o(n) for sort: O(m * nlogn)
        // m = no. of string
        // n = length of longest string
        Map<String, List<String>> result = new HashMap<>();

        for (String s : strs) {
            // sort char array
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            String sortedS = new String(charArray);

            result.putIfAbsent(sortedS, new ArrayList<>());
            result.get(sortedS).add(s);
        }

        System.out.println(result.values());
        return new ArrayList<>(result.values());
    }

//    TODO: method 2

}
