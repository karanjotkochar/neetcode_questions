public class q80_ReverseInteger {

    public static void main(String[] args) {
        int x = -1234;
        System.out.println(reverse(x));
    }

    public static int reverse(int x) {

        // Brute force
        // TC = O(1)
        // SC = O(1)

        // 2^31     = 2147483648
        // 2^31 - 1 = 2147483647

        int original = x;                   // save original value of x
        x = Math.abs(x);                    // take only +ve value

        long result = Long.parseLong(new StringBuilder( String.valueOf(x) ).reverse().toString());      // int --> string --> reverse --> integer

        if (original < 0) {                 // if original was -ve --> make -ve
            result = result * (-1);
        }

        if (result < -(1 << 31) || result > (1 << 31) - 1 ) {
            return 0;
        }

        return (int) result;
    }

}
