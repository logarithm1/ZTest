package Qual2019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

@SuppressWarnings("all")
public class D {


	private void process(int caseNum) throws IOException {

		int N = ni();
		int B = ni();
		int F = ni();

		//int r = ni();
		// test
		//output(caseNum, "aaa");

		int[] invalidbits = new int[N];
		int blocksize=16;
		while(blocksize>=N) {

			blocksize/=2;
		}

		int prevBlockSize = blocksize;


		while (blocksize > 0) {
			String requestBits = generateQuery(N, blocksize);

			System.out.println(requestBits);

			String response = ns();

			populateInvalidBits(N, invalidbits, blocksize, response, prevBlockSize);

			prevBlockSize=blocksize;
			blocksize/=2;
		}
	}

	private void populateInvalidBits(int n, int[] invalidbits, int blocksize, String response, int prevBlockSize) {
		int respbit=1;

		int responseindex=0;

		for(int i=0; i<response.length(); ) {
			int count = countbits(response, i, respbit);
			int invalid = blocksize-count;
		}
		for(int i=0; i<n;i+=prevBlockSize) {
			int currentInvlid = invalidbits[i];
			String subresp = response.substring(responseindex,
				Math.max(n,responseindex+ prevBlockSize-currentInvlid));

			populateSubResponse(invalidbits, i, blocksize, subresp);

		}
		for(int i=0; i<response.length(); i++) {
			char rc = response.charAt(i);
			if(rc == respbit+'0') {
				//count++;
			} else {
				invalidbits[0]=blocksize- n;
				//count=0;
				respbit^=1;
			}
		}
	}

	private int countbits(String response, int index, int respbit) {
		int res=0;
		while(index<response.length() && response.charAt(index)-'0'==respbit) {
			res++;index++;
		}
		return res;
	}

	private void populateSubResponse(int[] invalidbits, int startIdx, int blocksize, String subresp) {

		int ones=(int) subresp.chars().filter(q -> q=='1').count();;
		int zeros= (int) subresp.chars().filter(q -> q=='0').count();

		invalidbits[startIdx]=Math.min(blocksize, invalidbits.length-startIdx) - ones;
		if(startIdx+blocksize<invalidbits.length) {
			invalidbits[startIdx+blocksize]=Math.min(blocksize, invalidbits.length-(startIdx+blocksize))-zeros;
		}

	}

	private String generateQuery(int n, int blocksize) {
		int[] question = new int[n];
		int bit=0;
		for(int i=0; i< n; i++) {
			if( i%blocksize == 0) {
				bit=bit^1;
			}
			question[i]=bit;
		}
		return Arrays.stream(question).
			mapToObj(String::valueOf).collect(Collectors.joining());
	}


	/***********boiler plate
	 * ***************************************************************************************************************
	 * ***************************************************************************************************************
	 */
	@SuppressWarnings("squid:S00112")
	private class 	Obj implements Comparable<Obj> {
		public Double t;
		public int S;
		public int R;

		public Obj(Double t, int S,int R) {
			this.R=R;
			this.S=S;
			this.t=t;
		}
		public int compareTo(Obj arg0) {
			return this.t.compareTo(t);
		}

	}
	Scanner in;

	public D() throws IOException {
	  in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

	}

	public static void main(String[] args) throws IOException {

		D s = new D();


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
