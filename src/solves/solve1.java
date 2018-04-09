package solves;



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

public class solve1 {

	Scanner in;
	BufferedWriter out = new BufferedWriter(new FileWriter("prob.out"));;

	public solve1() throws IOException {
		 in = new Scanner(new File("prob.in"));
	}

	public static void main(String[] args) throws IOException {
		String input="the the";
		System.out.println(input);
		System.out.println(input .replaceAll("[\\u201C\\u201D]", "\""));
		System.out.println("|||".replace("|", "A"));
		Double d = Math.pow(10, -323);
		System.out.println(d);
		solve1 s = new solve1();
		//s.solve();
	}

	public void solve() throws IOException {

		int numCases = in.nextInt();
		for (int i = 1; i <= numCases; i++) {
			goodluck(i);
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
	public void output(String string) throws IOException {
		out.write( string + "\n");
	}
	private void goodluck(int caseNum) throws IOException {
		
		int N = in.nextInt();
		int P = in.nextInt();
		int[] base = new int[N];
		int[][] weights = new int[N][P];
		int[][][] range = new int[N][P][2];
		for(int i=0;i<N;i++) {
			base[i]=in.nextInt();
		}
		
		List<LinkedList<range>> lists=new ArrayList<LinkedList<range>>();
			
		for(int i=0;i<N;i++) {
			int wt=in.nextInt();
			for(int j=0;j<P;j++) {
				weights[i][j]=wt;
			}
			Arrays.sort(weights[i]);
			
			LinkedList<range> ranges= new LinkedList<solve1.range>();
			lists.add(ranges);
			for(int j=0;j<P;j++) {
				ranges.add(new range(low(wt,base[i]),high(wt, base[i])));
			}
		}
		
		int low=0;
		int high=Integer.MAX_VALUE;
		int count=0;
		while(true) {
			range lr=getLow(lists);
			if(range !=null) {
				for(LinkedList<range> ll:lists) {
					boolean present=forward(ll);
					if(!present) {
						continue;
					}
				}
				count++;
				forwardsingle(lists);
			} else {
				break;
			}
		}
		
		System.out.println();

	}
	private void forwardsingle(List<LinkedList<range>> lists) {
		for(LinkedList ll:lists) {
			ll.pop();
		}
		
	}

	private boolean forward(LinkedList<range> ll) {
		// TODO Auto-generated method stub
		return false;
	}

	private solves.solve1.range getLow(List<LinkedList<range>> lists) {
		
		return null;
	}
	class range {
		public int l;
		public int h;
		public range(int l,int h) {
			this.l=l;
			this.h=h;
		}
	}

	private int findlow(int[][][] range, int[] idx) {
		// TODO Auto-generated method stub
		return 0;
	}

	private int low(int wt, int base) {
		// TODO Auto-generated method stub
		int count = (int)Math.ceil((float)wt/((float)base*1.1));
		return count;
	}
	private int high(int wt, int base) {
		// TODO Auto-generated method stub
		int count = (int)Math.floor((float)wt/((float)base*.9));
		return count;
	}
}
