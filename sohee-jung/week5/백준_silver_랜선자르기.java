import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int K = sc.nextInt();
        int N = sc.nextInt();

        long[] cables = new long[K];
        long maxLenth = 0;

        for (int i = 0; i < K; i++) {
            cables[i] = sc.nextLong();
            if (cables[i] > maxLenth) {
                maxLenth = cables[i];
            }
        }

        long left = 1;
        long right = maxLenth;
        long result = 0;

        while (left <= right) {
            long mid = (left + right) / 2;
            long count = countCables(cables, mid);

            if (count >= N) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(result);
    }

    private static long countCables(long[] cables, long length) {
        long count = 0;
        for (long cable : cables) {
            count += cable / length;
        }
        return count;
    }
}