public class q60_NumberOfOneBits {

    public static void main(String[] args) {
        int n = 00000000000000000000000000010111;
//        hammingWeight(n);
        System.out.println(hammingWeight(n));

    }
    public static int hammingWeight(int n) {

        // number / 2 --> get bits right shifted (one's place gone)
        // number % 2 --> get remainder

        // time = O(32) --> O(1)        // input is 32 bit
        // space = O(1)
        int result = 0;

        while (n != 0) {
            result = result + (n%2);

            n = n/2;
        }

        return result;
    }
    public static int hammingWeight2(int n) {
        return 0;
    }
}
