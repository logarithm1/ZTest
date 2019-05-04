import java.io.*;
import java.util.*;

public class Solve {

    private static final double EPSILON = 1e-10;

    public static double[] lsolve(double[][] A, double[] b) {
        int n = b.length;

        for (int p = 0; p < n; p++) {

            // find pivot row and swap
            int max = p;
            for (int i = p + 1; i < n; i++) {
                if (Math.abs(A[i][p]) > Math.abs(A[max][p])) {
                    max = i;
                }
            }
            double[] temp = A[p];
            A[p] = A[max];
            A[max] = temp;
            double t = b[p];
            b[p] = b[max];
            b[max] = t;

            // singular or nearly singular
            if (Math.abs(A[p][p]) <= EPSILON) {
                throw new ArithmeticException("Matrix is singular or nearly singular");
            }

            // pivot within A and b
            for (int i = p + 1; i < n; i++) {
                double alpha = A[i][p] / A[p][p];
                b[i] -= alpha * b[p];
                for (int j = p; j < n; j++) {
                    A[i][j] -= alpha * A[p][j];
                }
            }
        }

        // back substitution
        double[] x = new double[n];
        for (int i = n - 1; i >= 0; i--) {
            double sum = 0.0;
            for (int j = i + 1; j < n; j++) {
                sum += A[i][j] * x[j];
            }
            x[i] = (b[i] - sum) / A[i][i];
        }
        return x;
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner();
//		PrintWriter out = new PrintWriter(System.out);
        int tc = sc.nextInt();
        for (int t = 1; t <= tc; t++) {
            int W = sc.nextInt();
            System.err.println("debug log: W "+ W + " test case: " + t );
            long[] a = new long[7];
            for (int i = 1; i <= 6; i++) {
                System.out.println(i);
                a[i] = sc.nextLong();
            }

            double[][] A = { { 2, 1, 0, 0, 0, 0 },
                { 4, 0, 1, 0, 0, 0 },
                { 8, 2, 0, 1, 0, 0 },
                { 16, 0, 0, 0, 1, 0 },
                { 32, 4, 2, 0, 0, 1 },
                { 2, 1, 1, 1, 1, 1 } };
            double[] b = new double [6];
            for(int i=0;i<5;i++)
                b[i]=a[i+2]-a[i+1];
            b[5]=a[1];
            double[] ans = lsolve(A, b);


            for(int i=0;i<6;i++) {
                System.err.print((int)Math.round(ans[i])+((i==5)?"\n":" "));
                System.out.print((int)Math.round(ans[i])+((i==5)?"\n":" "));

            }
        }

//		out.close();

    }

    static class Scanner {
        BufferedReader br;
        StringTokenizer st;

        Scanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        Scanner(String fileName) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(fileName));
        }

        String next() throws IOException {
            while (st == null || !st.hasMoreTokens())
                st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }

        String nextLine() throws IOException {
            return br.readLine();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        long nextLong() throws NumberFormatException, IOException {
            return Long.parseLong(next());
        }

        double nextDouble() throws NumberFormatException, IOException {
            return Double.parseDouble(next());
        }

    }

}
