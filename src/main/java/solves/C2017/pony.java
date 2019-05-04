package solves.C2017;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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

@SuppressWarnings("unused")
public class pony {

	
	private void process(int caseNum) throws IOException {
		
		int N = ni();
		int Q = ni();
		
		int[][] RS = naa(N,2);
		int[][] DS = naa(N,N);
		
		int[][] targ = naa(Q,2);
		
		Obj[][] H_DC = new Obj[N][N];
		for(int i=0;i<N;i++) {
			int RR=RS[i][0];
			int SS=RS[i][1];
			for(int j=i+1;j<N && RR>0 ;j++) {
				
				int dist=DS[j-1][j];
				if(RR<dist) break;
				double time=(double)dist/(double)SS;
				
				H_DC[i][j]= new Obj(time,RR,SS);
				RR-=DS[i][j];
				
			}
		}
		praa(H_DC);
		//System.out.println(Arrays.deepToString(H_DC));
		for(int DC=N-2;DC>=0;DC--) {
			for(int Hr=DC-1;Hr>=0;Hr--) {
				Obj currDViasrc=H_DC[Hr][DC];
				
				if(currDViasrc!=null) {
					Obj continuecurrent=H_DC[Hr][DC+1];
					Obj changeHor = H_DC[DC][DC+1];
					Double currTime=getTime(continuecurrent);
					Double changetime=getTime(changeHor);

					currDViasrc.t+=Math.min(currTime, changetime);
				}
			}
		}
		System.out.println("***************");
		
		System.out.println();
		praa(H_DC);
		output(caseNum, H_DC[0][1].t);
		
	}
	
	private Double getTime(Obj o) {
		
		if(o!=null && o.t !=null) return o.t;
		return Double.MAX_VALUE;
	}

	/***************************************************************************************************************
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
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return t + "";
		}
		
	}
	Scanner in;
	BufferedWriter out = new BufferedWriter(new FileWriter("prob.out"));;

	public pony() throws IOException {
		 in = new Scanner(new File("prob.in"));
	}

	public static void main(String[] args) throws IOException {
		pony s = new pony();
		s.solve();
	}
	
	private String ns() { return in.next(); }
	private String nline() { return in.nextLine(); }
	private int ni() { return Integer.parseInt(in.next()); }
	private long nl() { return Long.parseLong(in.next()); }
	private int[] na(int n) { int[] a = new int[n]; for(int i = 0;i < n;i++)a[i] = ni(); return a; }
	private long[] nal(int n) { long[] a = new long[n]; for(int i = 0;i < n;i++)a[i] = nl(); return a; }
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
				System.out.print(itm[i][j] + "\t");
			}
			System.out.println();
		}
	}
	private double nd() { return Double.parseDouble(in.next()); }
	private double[] nad(int n) { double[] a = new double[n]; for(int i = 0;i < n;i++)a[i] = nd(); return a; }
	private void tr(Object... o) { System.out.println(Arrays.deepToString(o)); }


	public void solve() throws IOException {

		int numCases = in.nextInt();
		for (int i = 1; i <= 1; i++) {
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
		out.write("Case #" + caseNum + ": " + String.format( "%.6f", string ) + "\n");
	}
	public void output(int caseNum, String string) throws IOException {
		out.write("Case #" + caseNum + ": " + string + "\n");
	}
	public void output(String string) throws IOException {
		out.write( string + "\n");
	}

}
