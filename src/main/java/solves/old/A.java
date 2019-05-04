package solves.old;

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
public class A {

	
	private void process(int caseNum) throws IOException {
		

		String s = ns();
		
		char[] cs = s.toCharArray();
		
		int i=0;
		for(i=0;i<cs.length;i++) {
			int x=cs[i]-'0';
			if(x%2==0) {
				continue;
			}else break;
		}
		s=s.substring(i);
		
		if(s.length()==0) {
			output(caseNum, "0"); return;
		}

		Long l = new Long(s);
		
		if(l==1) {
			output(caseNum, "1"); return;
		}
		
		long up=0;
		long down=0;
		int c0=s.charAt(0)-'0';
		if(c0 == 1) {
			 up = (long) (2*Math.pow(10, s.length()-1));
			
			 down = (long) (8*Math.pow(10, s.length()-2));
		} else if (c0==9) {
			 up = Long.MAX_VALUE;
			 down = (long) (8*Math.pow(10, s.length()-1));
			 
		} else {
			 up = (long) ((c0+1)*Math.pow(10, s.length()-1));
			 down = (long) ((c0-1)*Math.pow(10, s.length()-1));
		}
		
		String ds=down+"";
		ds=ds.replace('0', '8');
		down=Long.valueOf(ds);
		
		System.out.println("" + s + " down: " + down + " up : " + up);
		long upd = up-l;
		long downd=l-down;

		output(caseNum, Math.min(upd, downd));
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

	public A() throws IOException {
		 in = new Scanner(new File("src\\prob.in"));
	}

	public static void main(String[] args) throws IOException {
		A s = new A();
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
	public void output(int caseNum, long string) throws IOException {
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
