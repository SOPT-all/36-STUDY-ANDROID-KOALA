import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int R, C;
    static char[][] maze;
    static Queue<Pair> fire = new LinkedList<>();
    static Queue<Pair> jihoon = new LinkedList<>();

    static int[] dx = { 1, -1, 0, 0 };
    static int[] dy = { 0, 0, 1, -1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        maze = new char[R][C];

        for (int r = 0; r < R; r++) {
            String line = br.readLine();
            for (int c = 0; c < C ; c++) {
                maze[r][c] = line.charAt(c);

                if (maze[r][c] == 'J') {
                    jihoon.add(new Pair(r, c));
                } else if (maze[r][c] == 'F') {
                    fire.add(new Pair(r, c));
                }
            }
        }

        int result = bfs();
        if (result == -1){
            bw.write("IMPOSSIBLE\n");
        } else {
            bw.write(result + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static int bfs(){
        int time = 0;

        while (!jihoon.isEmpty()) {
            time++;

            int fireSize = fire.size();
            while (fireSize-- > 0) {
                Pair f = fire.poll();
                for (int i = 0; i < 4; i++) {
                    int nx = f.x + dx[i];
                    int ny = f.y + dy[i];
                    if (nx >= 0 && ny >= 0 && nx < R && ny < C) {
                        if (maze[nx][ny] == '.' || maze[nx][ny] == 'J') {
                            maze[nx][ny] = 'F';
                            fire.add(new Pair(nx, ny));
                        }
                    }
                }
            }

            int jihoonSize = jihoon.size();
            while (jihoonSize-- > 0) {
                Pair j = jihoon.poll();
                for (int i = 0; i < 4; i++) {
                    int nx = j.x + dx[i];
                    int ny = j.y + dy[i];
                    if (nx < 0 || ny < 0 || nx >= R || ny >= C) {
                        return time;
                    }
                    if (maze[nx][ny] == '.') {
                        maze[nx][ny] = 'J';
                        jihoon.add(new Pair(nx, ny));
                    }
                }
            }
        }
        return -1;
    }

}

class Pair {
    int x, y;
    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}