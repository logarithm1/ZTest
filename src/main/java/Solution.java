
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

@SuppressWarnings("all")
public class Solution {


    private void process(int caseNum) throws IOException {


        char[] results = new char[5];

        char[][] players = new char[119][5];

        int[] counts = new int[5];
        for(int i=0; i<119; i++ ) {
            System.out.println(i*5+1);
            char c = ns().charAt(0);
            if(c == 'N') throw new RuntimeException();
            players[i][0]=c;
            counts[c-'A']++;
        }

        //praa(players);
        getmissing(results, counts, 23, 0);
        System.err.println("match 23");

        counts = readvalues(results, players, 1, 0);
        getmissing(results, counts, 5, 1);
        //praa(players);
        System.err.println("match 5");

        counts = readvalues(results, players, 2, 1);
        getmissing(results, counts, 1, 2);
        //praa(players);
        System.err.println("match 1");

        counts = readvalues(results, players, 3, 2);
        getmissing(results, counts, 0, 3);

        System.err.println("match 0");

        //praa(players);

        Set<Character> allChars = new HashSet<>(Arrays.asList('A','B','C','D','E'));
        for(int i=0;i<4;i++) {
            allChars.remove(results[i]);
        }

        results[4]=allChars.iterator().next();
        // test
        System.out.println(new String(results));
        System.err.println("result:" + new String(results));
        char c = ns().charAt(0);
        System.err.println("result c:" +c);

        if(c == 'N') throw new RuntimeException();

    }

    private int[] readvalues(char[] results, char[][] players, int column, int prevcol) {
        int[] counts;
        counts = new int[5];
        for(int row=0; row<119; row++ ) {
            if(isqueryrow(players, results, row, prevcol)) {
                System.out.println(row*5+column+1);

                char c = ns().charAt(0);
                if(c == 'N') throw new RuntimeException();
                System.err.println("Result :" + c);
                System.err.println("Query :" + row*5+column+1);

                players[row][column]=c;
                counts[c-'A']++;
            }
        }
        return counts;
    }

    private boolean isqueryrow(char[][] players, char[] results, int row, int prevcol) {

        for(int col = 0;col<=prevcol; col++) {
            if(players[row][prevcol] != results[prevcol]) {
                return false;
            }
        }
        return true;
    }

    private void getmissing(char[] results, int[] counts, int match, int resultidx) {
        for(int i=0;i<5;i++) {
            if(counts[i] == match && notresulthas(results, resultidx,(char)('A'+i))) {
                results[resultidx]=(char)('A'+i);
            }
        }
    }

    private boolean notresulthas(char[] results, int resultidx, char c) {
        for(int i=0;i<resultidx ;i++) {
            if(results[i]==c) return false;
        }

        return true;
    }

    private void solve() throws IOException {

        int numCases = ni();
        int F = ni();

        for (int i = 1; i <= numCases; i++) {
            process(i);
        }
        in.close();
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

    public Solution() throws IOException {
        in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

    }


    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
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
