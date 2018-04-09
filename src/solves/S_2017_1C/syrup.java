package solves.S_2017_1C;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
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
public class syrup {

	
	private void process(int caseNum) throws IOException {
		
		int N = ni();
		int K = ni();
		Obj[] cakes=new Obj[N];
		for(int i=0;i<N;i++) {
			cakes[i] = new Obj(ni(),ni(),i );
		}
		Arrays.sort(cakes,Collections.reverseOrder());
		Obj[] cakesVV = Arrays.copyOf(cakes,N);
		Arrays.sort(cakesVV,new ObjC());
		
		Double max=0D;
		int prevR=-1;
		for(int i=0;i<=N-K;i++) {
			Obj cake=cakes[i];
			//if(cake.R==prevR) continue;
			//prevR=cake.R;
			double vol = addCakes(cakesVV,cake,N,K-1) + cake.R*cake.R + cake.VV;
			if(max<vol) max=vol;
		}
		
		
		
		output(caseNum, max*Math.PI);
	}
	

	
	
	private double addCakes(Obj[] cakesVV, Obj cake, int N, int K) {
		double res=0;
		int i=0;int k=0;
		while(k<K && i<N) {
			if(cakesVV[i].R<=cake.R && cakesVV[i].id!=cake.id) {
				res+=cakesVV[i].VV;
				k++;
			}
			i++;
		}
		return res;
	}




	/***************************************************************************************************************
	 * ***************************************************************************************************************
	 * ***************************************************************************************************************
	 */
	
	class Obj implements Comparable<Obj> {
		//public Double t;
		public int id;
		public int R;
		public int H;
		public Double VV;
		
		public Obj( int R,int H,int id) {
			this.R=R;
			this.H=H;
			this.id=id;
			this.VV=2.0D*R*H;
		//	this.t=t;
		}
		@Override
		public int compareTo(Obj arg0) {

			if(this.R!=arg0.R) return this.R-arg0.R;
			return this.H-arg0.H;
		}
	}
	class ObjC implements Comparator<Obj> {

		@Override
		public int compare(Obj o1, Obj o2) {
			return o2.VV.compareTo(o1.VV);
		}
		
	}
	Scanner in;
	BufferedWriter out = new BufferedWriter(new FileWriter("prob.out"));;

	public syrup() throws IOException {
		 in = new Scanner(new File("prob.in"));
	}

	public static void main(String[] args) throws IOException {
		syrup s = new syrup();
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
	public void output(int caseNum, String string) throws IOException {
		out.write("Case #" + caseNum + ": " + string + "\n");
	}
	public void output(int caseNum, Double string) throws IOException {
		out.write("Case #" + caseNum + ": " + String.format( "%.6f", string ) + "\n");
	}
	public void output(String string) throws IOException {
		out.write( string + "\n");
	}

}
