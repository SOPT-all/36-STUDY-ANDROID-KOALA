import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static List<Integer>[] computerGraph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int computerNumbers = Integer.parseInt(br.readLine());
        int computerLinks = Integer.parseInt(br.readLine());

        computerGraph = new ArrayList[computerNumbers+1];
        visited = new boolean[computerNumbers+1];

        for (int i = 0; i <= computerNumbers; i++) {
            computerGraph[i] = new ArrayList<>();
        }

        for (int i = 0; i < computerLinks; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int firstNum = Integer.parseInt(st.nextToken());
            int secondNum = Integer.parseInt(st.nextToken());

            computerGraph[firstNum].add(secondNum);
            computerGraph[secondNum].add(firstNum);
        }

        int answer = DFS(1)-1;
        bw.write(answer + "\n");

        bw.flush();
        br.close();
        bw.close();
    }

    static int DFS(int node){
        visited[node] = true;
        int count = 1;
        for (int childNode: computerGraph[node]){
            if (!visited[childNode]){
                count += DFS(childNode);
            }
        }
        return count;
    }
}