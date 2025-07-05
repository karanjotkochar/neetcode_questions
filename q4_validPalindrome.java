public class q4_validPalindrome {

    public static void main(String[] args) {
            String s = "Was it a car or a cat I saw?";
        System.out.println(isPalindrome(s));
        System.out.println(isPalindrome2(s));
    }
    public static boolean isPalindrome(String s) {
        // brute force method
        // time O(n) = n and space O(n) = n
        StringBuilder newStr = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                newStr.append(Character.toLowerCase(c));
            }
        }

        return newStr.toString().equals(newStr.reverse().toString());
    }
    public static boolean isPalindrome2(String s) {
        // two pointer method
        // time O(n) = n and space O(n) = 1
        int l = 0;
        int r = s.length() - 1;
        while(l < r) {
            while(l < r && !isAlphaNumeric(s.charAt(l))) {
                l++;
            }
            while(r > l && !isAlphaNumeric(s.charAt(r))) {
                r--;
            }
            if (Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r)))
            {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    public static boolean isAlphaNumeric(char c) {
        return (c >= 'A' && c<= 'Z' ||
                c >= 'a' && c<= 'z' ||
                c >= '0' && c<= '9' );
    }

}
