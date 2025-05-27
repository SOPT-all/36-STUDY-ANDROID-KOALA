import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer>[] arrayList;
    static boolean[] visitedDfs;
    static int answer = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int firstPerson = Integer.parseInt(st.nextToken());
        int secondPerson = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());

        arrayList = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            arrayList[i] = new ArrayList<>();
        }

        visitedDfs = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            arrayList[x].add(y);
            arrayList[y].add(x);
        }

        for (int i = 0; i <= n; i++) {
            Collections.sort(arrayList[i]);
        }

        dfs(firstPerson, secondPerson, 0);
        bw.write(answer+ "\n");

        bw.flush();
        bw.close();
        br.close();
    }

    private static void dfs(int current, int target, int depth) {
        if (current == target) {
            answer = depth;
            return;
        }
        visitedDfs[current] = true;

        for (int next : arrayList[current]) {
            if (!visitedDfs[next]) {
                dfs(next, target, depth + 1);
            }
        }
    }
}