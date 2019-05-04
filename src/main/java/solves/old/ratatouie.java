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
public class ratatouie {

	
	private void process(int caseNum) throws IOException {

		if(caseNum==30) {
			System.out.println("");
		}

		int N = in.nextInt();
		int P = in.nextInt();
		int[] R = new int[N];
		for(int i=0;i<N;i++) {
			R[i]=in.nextInt();
		}
		
		Range[][] wt = new Range[N][P];
		for(int i=0;i<N;i++) {
			for(int j=0;j<P;j++) {
				wt[i][j]=getRange(in.nextInt(), R[i]);
			}
		}
		
		for(int i=0;i<N;i++) {
			Arrays.sort(wt[i]);
		}
		
		if(caseNum==30) {
			System.out.println("11");
		}
		// current index
		int[] idx = new int[N];
		
		int min = findmin(wt,idx, N, P);
		
		boolean matched=false;
		boolean found = false;
		int findcount=0;
		boolean minchanged=false;
		while(!matched) {
			
			for(int i=0;i<N;i++) {
				int st = idx[i];
				found = false;
				minchanged=false;
				for (int j=st; j< P; j++) {
					int l=wt[i][j].l;
					int h=wt[i][j].h;
					if(min>=l && min<=h) {
						found=true;
						idx[i]=j;
						break;
					} else if(l>min) {
						min=l;
						idx[i]=j;
						minchanged=true;
						break;
					}
				}
				if(!found || minchanged) {
					break;
				}
			}
			
			if(minchanged) continue;
			
			if(!found) {
				break;
			}
			else {
				findcount++;
				increment(idx,N);
				min = findmin(wt,idx, N, P);
				if(min==-1) break;
			}
			
		}
		
		output(caseNum, findcount);
	}
	private void increment(int[] idx, int N) {
		for(int i=0;i<N;i++) {
			idx[i]++;
		}		
	}
	private Range getRange(int wt, int base) {
//		int l = (int)Math.ceil((double) wt/(((double)base*1.1)));
//		int h = (int)Math.floor((double) wt/(((double)base*0.9)));
		int l =  (wt*10+base*11-1)/(base*11);
		int h = (wt*10)/(base*9);
		return new Range(l,h);
	}
	private int findmin(Range[][] wt, int[] idx, int N, int P) {
		int min=0;
		for(int i=0;i<N;i++) {
			int curridx=idx[i];
			if(curridx>=P) {
				return -1;
			}
			if(wt[i][curridx].l > min) {
				min = wt[i][idx[i]].l;
			}
		}
		return min;
	}	
	
	class Range implements Comparable<Range>{
		public int l;
		public int h;
		public Range(int l2, int h2) {
			l=l2;
			h=h2;
		}
		@Override
		public int compareTo(Range obj) {
			if(this.l == obj.l) {
				return this.h-obj.h;
			}
			return this.l-obj.l;
		}
	}
	
	
	
	
	
	
	
	
	
	

	
	















	/***************************************************************************************************************
	 */
	Scanner in;
	BufferedWriter out = new BufferedWriter(new FileWriter("prob.out"));;

	public ratatouie() throws IOException {
		 in = new Scanner(new File("prob.in"));
	}

	public static void main(String[] args) throws IOException {
		ratatouie s = new ratatouie();
		s.solve();
	}

	public void solve() throws IOException {
		double d = ((double)3*(double)0.9);
		System.out.println(d);
		System.out.println((1350/2.7));

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
	public void output(String string) throws IOException {
		out.write( string + "\n");
	}

}
