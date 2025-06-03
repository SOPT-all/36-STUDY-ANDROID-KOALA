import java.io.*;
import java.util.*;

public class Main {
    static int M, N, H;
    static int[][][] tomatoBoxes;
    static Queue<int[]> queue = new LinkedList<>();

    static int[] dz = {-1, 1, 0, 0, 0, 0};
    static int[] dx = {0, 0, -1, 1, 0, 0};
    static int[] dy = {0, 0, 0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        tomatoBoxes = new int[H][N][M];

        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                st = new StringTokenizer(br.readLine());
                for (int m = 0; m < M; m++) {
                    tomatoBoxes[h][n][m] = Integer.parseInt(st.nextToken());
                    if (tomatoBoxes[h][n][m] == 1) {
                        queue.offer(new int[]{h, n, m});
                    }
                }
            }
        }

        int days = bfs();

        if (allRipened()) {
            System.out.println(days);
        } else {
            System.out.println(-1);
        }
    }

    private static int bfs() {
        int day = -1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int s = 0; s < size; s++) {
                int[] cur = queue.poll();
                int z = cur[0];
                int x = cur[1];
                int y = cur[2];

                for (int i = 0; i < 6; i++) {
                    int nz = z + dz[i];
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    if (nz >= 0 && nz < H && nx >= 0 && nx < N && ny >= 0 && ny < M) {
                        if (tomatoBoxes[nz][nx][ny] == 0) {
                            tomatoBoxes[nz][nx][ny] = 1;
                            queue.offer(new int[]{nz, nx, ny});
                        }
                    }
                }
            }
            day++;
        }
        return day;
    }

    private static boolean allRipened() {
        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                for (int m = 0; m < M; m++) {
                    if (tomatoBoxes[h][n][m] == 0) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}