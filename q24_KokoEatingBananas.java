import java.util.Arrays;

public class q24_KokoEatingBananas {
    public static void main(String[] args) {
        int[] piles = {3,6,7,11};
        int h = 8;
        System.out.println(minEatingSpeed(piles, h));
        System.out.println(minEatingSpeed2(piles, h));
    }
    public static int minEatingSpeed(int[] piles, int h) {
        // brute force
        // space = o(n*m) and space = o(1)
        // traverse from smallest and as soon as time in limit (<h), get minSpeed
        int speed = 1;
        while (true) {
            long totalTime = 0;
            for (int pile : piles) {
                totalTime = totalTime + (int) Math.ceil((double) pile/speed);
            }

            if (totalTime <= h) {
                return speed;
            }
            speed++;
        }
    }

    public static int minEatingSpeed2(int[] piles, int h) {
        // binary search
        // time = o(n * logm) and space = o(1)

        int left = 1;
        int right = Arrays.stream(piles).max().getAsInt();
        int result = right;

        while (left <= right) {
            int speed = left + ( (right-left)/2 );
            int totalTime = 0;

            for (int pile : piles) {
                totalTime = totalTime + (int) Math.ceil( (double) pile/speed);
            }
            
            if (totalTime <= h){
                result = speed;
                right = speed - 1;
                
            } else {
                left = speed + 1;
            }
        }

        return result;
    }

}
