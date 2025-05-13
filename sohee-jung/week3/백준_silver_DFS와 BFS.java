import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int M;
    static int[][] map;
    static boolean[] visitDfs;
    static boolean[] visitBfs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        map = new int[N + 1][N + 1];
        visitDfs = new boolean[N + 1];
        visitBfs = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int firstVertex = Integer.parseInt(st.nextToken());
            int secondVertex = Integer.parseInt(st.nextToken());

            map[firstVertex][secondVertex] = 1;
            map[secondVertex][firstVertex] = 1;
        }

        dfs(V, bw);
        bw.write("\n");
        bfs(V, bw);

        bw.flush();
        br.close();
        bw.close();
    }

    public static void dfs(int start, BufferedWriter bw) throws IOException {
        visitDfs[start] = true;
        bw.write(start + " ");

        for (int i = 1; i <= N; i++) {
            if (map[start][i] == 1 && !visitDfs[i]) {
                dfs(i, bw);
            }
        }
    }

    public static void bfs(int start, BufferedWriter bw) throws IOException {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        visitBfs[start] = true;

        while (!queue.isEmpty()){
            int current = queue.poll();
            bw.write(current + " ");

            for (int i = 1; i <= N; i++) {
                if (map[current][i] == 1 && !visitBfs[i]){
                    queue.add(i);
                    visitBfs[i] = true;
                }

            }
        }
    }
}