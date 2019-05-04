package reference;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

@SuppressWarnings("all")
public class SolutionInteractive {

    private void solve() throws IOException {
        int numCases = ni();
        int F = ni(); // single for complete testset
        for (int i = 1; i <= numCases; i++) {
            process(i);
        }
        in.close();
    }

    private void process(int caseNum) throws IOException {

        String response = interact("question", "-1", true);

        String result = "";

        interact(result, "-1", true);
    }

    private String interact(String question, String errorResponse, boolean debug) {
        System.out.println(question);
        String answer = ns();
        if(answer.equals(errorResponse)) throw new RuntimeException("got error");
        if(debug)
            System.err.println("question: "+ question + " answer: " + answer);
        return answer;
    }

    /*********** clean up ************/
    @SuppressWarnings("squid:S00112")
    private class 	Obj implements Comparable<Obj> {
        public Double t;
        public int S;
        public int R;

        public Obj(Double t, int S,int R) {
            this.R=R;
            this.S=S;
            this.t=t;
        }
        public int compareTo(Obj arg0) {
            return this.t.compareTo(t);
        }

    }
    Scanner in;

    public SolutionInteractive() throws IOException {
        in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

    }


    public static void main(String[] args) throws IOException {
        SolutionInteractive s = new SolutionInteractive();
        s.solve();
    }

    private String ns() { return in.next(); }
    private String nline() { return in.nextLine(); }
    private int ni() { return Integer.parseInt(in.next()); }
    private long nl() { return Long.parseLong(in.next()); }
    private int[] na(int n) { int[] a = new int[n]; for(int i = 0;i < n;i++)a[i] = ni(); return a; }
    private long[] nal(int n) { long[] a = new long[n]; for(int i = 0;i < n;i++)a[i] = nl(); return a; }
    private double nd() { return Double.parseDouble(in.next()); }
    private double[] nad(int n) { double[] a = new double[n]; for(int i = 0;i < n;i++)a[i] = nd(); return a; }
    private void tr(Object... o) { System.out.println(Arrays.deepToString(o)); }

    private int[][] naa(int r, int c) {
        int[][]  res = new int[r][c];
        for(int i=0;i<r;i++) {
            for(int j=0;j<c;j++) {
                res[i][j]=ni();
            }
        }
        return res;
    }
    private void praa(Object[][] itm) {
        for(int i=0;i<itm.length;i++) {
            for(int j=0;j<itm[0].length;j++) {
                System.out.print(itm[i][j] + ", ");
            }
            System.out.println();
        }
    }

    private void praa(char[][] itm) {
        for(int i=0;i<itm.length;i++) {
            for(int j=0;j<itm[0].length;j++) {
                System.err.print(itm[i][j] + ", ");
            }
            System.err.println();
        }
    }

    private void output(int caseNum, int string) throws IOException {
        System.out.println("Case #" + caseNum + ": " + string);
    }
    private void output(int caseNum, Double string) throws IOException {
        System.out.println("Case #" + caseNum + ": " + String.format( "%.6f", string ) );
    }
    private void output(int caseNum, String string) throws IOException {
        System.out.println("Case #" + caseNum + ": " + string );
    }
    private void output(String string) throws IOException {
        System.out.println( string );
    }
}
