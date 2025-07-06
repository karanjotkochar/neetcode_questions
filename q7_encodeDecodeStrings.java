import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class q7_encodeDecodeStrings {
    public static void main(String[] args) {

        String[] arr = {"neet","code","love","you"};
        List<String> ls = Arrays.asList(arr);
//        encode(ls);
        decode(encode(ls));
    }
    public static String encode(List<String> strs) {
        // optimal solution
        // time O(n) = O(n) and space = O(m + n)

       StringBuilder result = new StringBuilder();
       for (String s : strs) {
           result.append(s.length()).append('#').append(s);
       }
       System.out.println(result);

       return result.toString();
    }

    public static List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        int i = 0;

        while (i < str.length()) {
            int j = i;
            while (str.charAt(j) != '#') {
                j++;
            }
            int length = Integer.parseInt(str.substring(i,j));

            i = j + 1;
            j= i + length;

            result.add(str.substring(i,j));
            i = j;
        }

        System.out.println(result);
        return result;
    }

}
