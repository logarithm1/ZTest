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
public class newword {

	
	private void process(int caseNum) throws IOException {
		
		int N = ni();
		int L = ni();
		
		String[] word = nsa(N);
		Set<String> wordset = new HashSet<>();
		for(String w:word) {
			wordset.add(w);
		}
		List<Set<Character>> charset = new ArrayList<>();
		for(int i=0;i<L;i++) {
			charset.add(new HashSet<Character>());
		}
		for(int i=0;i<L;i++) {
			Set<Character> currset = charset.get(i);
			for(int j=0;j<N;j++) {
				Character curr = word[j].charAt(i);
				currset.add(curr);
			}
		}
		
		char[] wordout= new char[L];
		String result = recurse(charset,0,L,wordset,wordout);
		
		
		output(caseNum, result!=null?result:"-");
	}
	

	
	
	private String recurse(List<Set<Character>> charset, int idx, int L, Set<String> wordset, char[] wordout) {
		
		if(idx==L) {
			String s = new String(wordout);
			if(!wordset.contains(s)) {
				return s;
			} else {
				return null;
			}
		}
		
		Set<Character> currSet = charset.get(idx);
		for(Character c:currSet) {
			wordout[idx]=c;
			String result=recurse(charset, idx+1, L, wordset, wordout);
			if(result !=null) {
				return result;
			}
				
		}
		
		
		return null;
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

	public newword() throws IOException {
	  in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

	}

	public static void main(String[] args) throws IOException {
		newword s = new newword();
		s.solve();
	}
	
	private String ns() { return in.next(); }
	private String nline() { return in.nextLine(); }
	private int ni() { return Integer.parseInt(in.next()); }
	private long nl() { return Long.parseLong(in.next()); }
	private int[] na(int n) { int[] a = new int[n]; for(int i = 0;i < n;i++)a[i] = ni(); return a; }
	private String[] nsa(int n) { String[] a = new String[n]; for(int i = 0;i < n;i++)a[i] = ns(); return a; }
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
