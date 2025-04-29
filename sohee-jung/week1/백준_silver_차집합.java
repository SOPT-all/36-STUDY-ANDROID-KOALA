import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        HashSet<Integer> setA = new HashSet<>();
        HashSet<Integer> setB = new HashSet<>();


        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < A; i++) {
            int tempA = Integer.parseInt(st.nextToken());
            setA.add(tempA);
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < B; i++) {
            int tempB = Integer.parseInt(st.nextToken());
            setB.add(tempB);
        }

        HashSet<Integer> subtract = new HashSet<>(setA);
        subtract.removeAll(setB);

        if (subtract.isEmpty()) {
            bw.write("0\n");
        } else {
            List<Integer> result = new ArrayList<>(subtract);
            Collections.sort(result);

            bw.write(result.size() + "\n");
            for (int i : result) {
                bw.write(i + " ");
            }
        }

        bw.flush();
        bw.close();
    }
}
