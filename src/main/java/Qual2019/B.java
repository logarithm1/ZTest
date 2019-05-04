package Qual2019;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class B {


    private void process(int caseNum) {

        int size=ni();
        String path = ns();
        char[] res = new char[path.length()];

        char start = path.charAt(0);
        char end = path.charAt(path.length() - 1);

        //optimize for easy case
        if(start != end) {
            Arrays.fill(res, 0, size-1, end);
            Arrays.fill(res, size-1, path.length(), start);
            output(caseNum, String.valueOf(res));
            return;
        }

        Point[][] grid = new Point[size][size];

        // init points method
        Arrays.asList(grid).
            forEach(q -> Arrays.asList(q).
                replaceAll(x -> new Point()));
        Arrays.asList(grid[size-1]).forEach(q -> q.isSouth=false);
        Arrays.asList(grid).forEach(q -> q[size-1].isEast=false);

        // traverse existing path method
        int row=0, col=0;
        for(int i=0; i<path.length(); i++) {
            if(path.charAt(i) == 'E') {
                grid[row][col].isEast=false;
                col++;
            } else {
                grid[row][col].isSouth=false;
                row++;
            }
        }

        // build new path greedy method
        char[] result = new char[path.length()];
        row=0; col=0;
        for(int i=0; i< path.length(); i++) {
            Point curr = grid[row][col];
            if(end =='E') {
                if(curr.isEast) {
                    result[i]='E';
                    col++;
                } else {
                    result[i]='S';
                    row++;
                }
            } else {
                if(curr.isSouth) {
                    result[i]='S';
                    row++;
                } else {
                    result[i]='E';
                    col++;
                }
            }
        }


        // test
        output(caseNum, String.valueOf(result));
    }

    class Point {
        boolean isEast = true;
        boolean isSouth = true;
    }



    /***********boilerplate
     * ***************************************************************************************************************
     * ***************************************************************************************************************
     */

    private final Scanner in;

    private B() {
        in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

    }

    public static void main(String[] args) {
        B s = new B();
        s.solve();
    }

    private String ns() { return in.next(); }

    private int ni() { return Integer.parseInt(in.next()); }

    private void solve() {

        int numCases = in.nextInt();
        for (int i = 1; i <= numCases; i++) {
            process(i);
        }
        in.close();
    }
    private void output(int caseNum, String string) {
        System.out.println("Case #" + caseNum + ": " + string );
    }


}
