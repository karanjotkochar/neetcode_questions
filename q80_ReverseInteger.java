public class q80_ReverseInteger {

    public static void main(String[] args) {
        int x = -1234;
        System.out.println(reverse(x));
        System.out.println(reverse2(x));
    }

    public static int reverse(int x) {
        // Brute force
        // TC = O(1)
        // SC = O(1)

        // -2^31     = -2147483648
        // 2^31 - 1  =  2147483647

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

    public static int reverse2(int x) {
        // Iteration
        // TC = O()
        // SC = O()

        final int MIN = -2147483648;
        final int MAX = 2147483647;
        int result = 0;

        while (x != 0) {
            int digit = x % 10;                             // take the value
            x = x / 10;                                     // divide x / 10

            // Condition check for limits
            if (result > MAX/10 || (result == MAX/10 && digit > MAX % 10) ) {           // doing MAX/10 --> check if (res * 10) + digit -- exceeds limit
                return 0;
            }
            if (result < MIN/10 || (result == MIN/10 && digit < MIN % 10) ) {
                return 0;
            }

            result = (result * 10) + digit;                 // add that value*10 to result
        }

        return result;
    }
}
