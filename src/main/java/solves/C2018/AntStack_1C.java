package solves.C2018;


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

@SuppressWarnings("unused")
public class AntStack_1C {

	
	private void process(int caseNum) throws IOException {
		
		int N = ni();
		long[] weights = nal(N);
		
		AntStack[] stacks = new AntStack[N];
		List<List<AntStack>> possibleValues = new ArrayList<>();
		
		for(int i=0;i<N;i++) {
			long currWt=weights[i];
			long possiblewt=currWt*6;
			long minwt=currWt;
			int maxsize=1;
			List<AntStack> currStacks=new ArrayList<>();
			currStacks.add(new AntStack(minwt, maxsize));
			
			for(int j=0;j<i;j++) {

				List<AntStack> possibleStacks=possibleValues.get(j);
				minwt=currWt;
				maxsize=1;
				
				for(AntStack stepstack:possibleStacks) {
					
					if(stepstack.tw<=possiblewt) {
						currStacks.add(new AntStack(stepstack.tw+currWt, stepstack.size+1));
//						if(stepstack.size+1>maxsize) {
//							maxsize=stepstack.size+1;
//							minwt=stepstack.tw+currWt;
//						} else if(stepstack.size+1==maxsize) {
//							minwt=Math.min(minwt, stepstack.tw+currWt);
//						}
					}
				}
//				if(maxsize>1)
//				currStacks.add(new AntStack(minwt, maxsize));

			}
			//stacks[i]=new AntStack(minwt, maxsize);
			
			possibleValues.add(currStacks);

		}
		int maxheight=0;
		for(List<AntStack> st1:possibleValues) {
			for(AntStack st2:st1) {
				if(st2.size>maxheight) {
					maxheight=st2.size;
				}
			}
		}
		
		output(caseNum, maxheight);
	}
	
	class AntStack implements Comparable<AntStack> {
		public long tw;
		public int size;
		public AntStack(long tw, int size) {
			this.tw=tw;
			this.size=size;
		}
		@Override
		public int compareTo(AntStack o) {
			if(this.size!=o.size) {
				return this.size-o.size;
			}
			return o.tw>this.tw?1:-1;
		}
		
		
	}

	
	
	/***********boiler plate
	 * ***************************************************************************************************************
	 * ***************************************************************************************************************
	 */
	
	private class Obj implements Comparable<Obj> {
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

	public AntStack_1C() throws IOException {
	  in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

	}

	public static void main(String[] args) throws IOException {
		AntStack_1C s = new AntStack_1C();
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

	private void solve() throws IOException {

		int numCases = in.nextInt();
		for (int i = 1; i <= numCases; i++) {
			process(i);
		}
		in.close();
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
