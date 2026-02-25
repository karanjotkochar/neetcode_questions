public class q74_ReverseBits {

    public static void main(String[] args) {

        // decimal = 21
        // binary = 0b00000000000000000000000000010101
        // octal 00000000000000000000000000010101 = 4161
        // hex = ox15
        int n = 0b00000000000000000000000000010101;
        reverseBits(n);

    }

    public static int reverseBits(int n) {
        // Bit Manipulation
        // TC = O(1)
        // SC= O(1)

        int res = 0;
        for (int i=0; i<32; i++) {

            int bit = (n >>> i) & 1;                    // Get what is at the 0's place by doing AND Shifting bit to right by using RIGHT operator
            res = res + (bit << (31 - i));              // Put it at (31-i)'s place
        }

        System.out.println(Integer.toUnsignedString(res));
        System.out.println(Integer.toBinaryString(res));
        return res;
    }

}