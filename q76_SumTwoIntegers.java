public class q76_SumTwoIntegers {

    public static void main(String[] args) {
        int a = 1;
        int b = 1;
        //getSum(a, b);
        System.out.println(getSum(a, b));
        System.out.println(getSum2(a, b));
    }

    public static int getSum(int a, int b) {
        // Brute force
        // TC = O(1)
        // SC = (1)
        return a + b;
    }

    public static int getSum2(int a, int b) {
        // Bit Manipulation
        // TC = O(1)
        // SC = O(1)

        while (b != 0) {                // b is used for carry and a for result
            int carry =  (a&b) << 1;
            a = a^b;                    // Step 1: a XOR b
            b = carry;                  // Step 2: calculate carry: (a AND b) << 1 --> used carry because a is modified in step 1
        }

        return a;
    }

}
