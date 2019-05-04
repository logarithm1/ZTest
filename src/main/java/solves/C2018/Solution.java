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
public class Solution {

	
	private void process(int caseNum) throws IOException {
		
		int R = ni();
		int C = ni();
		int H = ni()+1;
		int V = ni()+1;
		
		int[] rowsum=new int[R];
		int[] colsum =new int[C];
		int[][] data=new int[R][C];
		int total=0;
		for(int i=0;i<R;i++) {
			String s=ns();
			for(int j=0;j<C;j++) {
				if(s.charAt(j) == '@') {
					data[i][j]=1;
					rowsum[i]++;
					colsum[j]++;
					total++;
				}
			}
		}
		if(total% (H*V) >0) {
			
			output(caseNum, "IMPOSSIBLE");
			return;
		}
		
		if(total==0) {
			
			output(caseNum, "POSSIBLE");
			return;
		}

		
		int hh=0; int vv=0; int bal=total/H;

		int[][] rows = new int[H][2];
		int start=0;
		int end=0;
		for(int i=0;i<R;i++) {
			if(rowsum[i]==0) continue;
			bal=bal-rowsum[i];
			if(bal<0 || hh==H) {
				output(caseNum, "IMPOSSIBLE");
				return;
			} else if(bal==0) {
				rows[hh][0]=start;
				rows[hh][1]=i;
				start=i+1;
				hh++;
				bal=total/H;
			}
		}
		if(bal!=total/H || hh!=H) {
			output(caseNum, "IMPOSSIBLE");
			return;
		} 
		
		 bal=total/V;
		 int[][] cols = new int[V][2];
			start=0;
		for(int i=0;i<C;i++) {
			if(colsum[i]==0) continue;
			bal=bal-colsum[i];
			if(bal<0 || vv==V) {
				output(caseNum, "IMPOSSIBLE");
				return;
			} else if(bal==0) {
				cols[vv][0]=start;
				cols[vv][1]=i;
				start=i+1;
				vv++;
				bal=total/V;
			}
		}
		if(bal!=total/V || vv!=V) {
			output(caseNum, "IMPOSSIBLE");
			return;
		} 
		int cellsum=total/(H+V);
		//System.out.println("cellsum " + cellsum);
		for(int[] row : rows) {
			int rs=row[0];
			int re=row[1];
			for(int[] col:cols) {
				int cs=col[0];
				int ce=col[1];
				
				int sum=0;
				for(int i=rs;i<=re;i++) {
					for(int j=cs;j<=ce;j++) {
						sum+=data[i][j];
					}					
				}
				
				if(sum!=total/(H+V)) {
					output(caseNum, "IMPOSSIBLE");
					return;
				}
				
			}			
		}

		output(caseNum, "POSSIBLE");
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
