package solves;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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

@SuppressWarnings("unused")
public class B {

	
	private void process(int caseNum) throws IOException {
		
		int N = ni();
		int K = ni();
		
		Integer[] val = na(N);
		
		long sum=0;
		if(K==0) {
			for(int v:val) sum+=v;
			double average = 1.0d * sum / N;
			output(caseNum, average);
			return;
		}
		
		Arrays.sort(val,Collections.reverseOrder());
		
		if(val[0].equals(val[N-1])) {
			output(caseNum, val[0]);
			return;
		}
		
		int count=1;
		Integer max=val[0];
		long sumr=0;
		for(int i=1;i<N;i++) {
			if(val[i].equals(max)) {
				count++;
			} else {
				sumr+=val[i];
			}
		}
		int rem=N-count;
		double avgr=1.0d*sumr/rem;
		
		double prem = Math.pow(1.0d*rem/N, 2.0);
		double pmax = 1.0d - prem;
		 double res = pmax*max + prem*avgr;
		 
		 System.out.println(" case" + caseNum + " prem " + prem + " pmax " + pmax + " N : " + N + " R " + rem + " dup " + (N-rem));
		output(caseNum, res);
	}
	

	
	
	/***************************************************************************************************************
	 * ***************************************************************************************************************
	 * ***************************************************************************************************************
	 */
	
	class Obj implements Comparable<Obj> {
		public Double t;
		public int S;
		public int R;
		
		public Obj(Double t, int S,int R) {
			this.R=R;
			this.S=S;
			this.t=t;
		}
		@Override
		public int compareTo(Obj arg0) {

			return this.t.compareTo(t);
		}
		
	}
	Scanner in;
	BufferedWriter out = new BufferedWriter(new FileWriter("src\\prob.out"));;

	public B() throws IOException {
		 in = new Scanner(new File("src\\prob.in"));
	}

	public static void main(String[] args) throws IOException {
		B s = new B();
		s.solve();
	}
	
	private String ns() { return in.next(); }
	private String nline() { return in.nextLine(); }
	private int ni() { return Integer.parseInt(in.next()); }
	private long nl() { return Long.parseLong(in.next()); }
	private Integer[] na(int n) { Integer[] a = new Integer[n]; for(int i = 0;i < n;i++)a[i] = ni(); return a; }
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

	public void solve() throws IOException {

		int numCases = in.nextInt();
		for (int i = 1; i <= numCases; i++) {
			process(i);
		}
		out.close();
		in.close();
		System.out.println("************** Complete ******************");
	}
	public void output(int caseNum, int string) throws IOException {
		out.write("Case #" + caseNum + ": " + string + "\n");
	}
	public void output(int caseNum, Double string) throws IOException {
		out.write("Case #" + caseNum + ": " + String.format( "%.8f", string ) + "\n");
	}
	public void output(int caseNum, String string) throws IOException {
		out.write("Case #" + caseNum + ": " + string + "\n");
	}
	public void output(String string) throws IOException {
		out.write( string + "\n");
	}

}
