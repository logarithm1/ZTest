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
public class copypaste {

	
	private void process(int caseNum) throws IOException {
		
		String S= ns();
		int len = S.length();
		char[] sc = S.toCharArray();
		if(len<=5) {
			output(caseNum, len);
			return;
		}
		int moves=2;
		int min = minify(S,sc,2,null,moves,len-2);
		
		output(caseNum, min);
	}
	private int minify(String S,char[] inp, int done, char[] cb, int moves, int rem) {
		
		if(rem==0) return moves;
		boolean used = false;
		int res = Integer.MAX_VALUE;
		List<String> copies = getCopies(S,inp,done,rem);
		if(!copies.isEmpty()) {
			String copy = copies.get(copies.size()-1);
			int cbl =  cb==null?0:cb.length;
			if(copy.length() >cbl) {
				used=true;
				int res2 = minify(S,inp,done+copy.length(),copy.toCharArray(),moves+2,rem-copy.length());
				res=Math.min(res, res2);
			}
		}
//		for(String copy:copies) {
//			int res2 = minify(S,inp,done+copy.length(),copy.toCharArray(),moves+2,rem-copy.length());
//			res=Math.min(res, res2);
//		}
		if(!used && matches(S,inp,done,cb)) {
			int res2 = minify(S,inp,done+cb.length,cb,moves+1,rem-cb.length);
			res=Math.min(res, res2);
		}

		if(!used) {
			int res2 = minify(S,inp,done+1,cb,moves+1,rem-1);
			res=Math.min(res, res2);
		}
		

		return res;
	}

	private List<String> getCopies(String s, char[] inp, int done, int rem) {
		
		
		List<String> options = new ArrayList<String>();
		for(int i=done+2; i<=s.length();i++) {
			String sub = s.substring(done, i);
			String comple = s.substring(0,done);
			if(comple.indexOf(sub) !=-1) {
				options.add(sub);
			}
		}
		return options;
	}
	private boolean matches(String s, char[] inp, int done, char[] cb) {
		if(cb==null) return false;
		if(s.indexOf(String.valueOf(cb), done) == done) return true;
		return false;
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
	BufferedWriter out = new BufferedWriter(new FileWriter("prob.out"));;

	public copypaste() throws IOException {
		 in = new Scanner(new File("prob.in"));
	}

	public static void main(String[] args) throws IOException {
		copypaste s = new copypaste();
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
			System.out.println(i);
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
