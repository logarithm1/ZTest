package solves.S_2017_1C;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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
public class parent {

	
	private void process(int caseNum) throws IOException {
		
		int A = ni();
		int B = ni();
		
		Obj[] slots=new Obj[A+B];
		for(int i=0;i<A;i++) {
			slots[i]=new Obj(1,ni(),ni());
		}
		for(int i=A;i<A+B;i++) {
			slots[i]=new Obj(2,ni(),ni());
		}
		
		Arrays.sort(slots);
		
		int TA=0,TB=0;
		List<Integer> HA=new ArrayList<>();
		List<Integer> HB=new ArrayList<>();
		List<Integer> bb=new ArrayList<>();
		//Obj prev = slots[0];
		Obj prev = slots[A+B-1];

		int extra=0;

		for(int i=0;i<A+B;i++) {
			Obj curr=slots[i];
			int P1=prev.P;
			int P2=curr.P;

			if(curr.P==1) {
				TA+=curr.T;
			} else {
				TB+=curr.T;
			}

			int gap=curr.S-prev.E;
			if(gap<0) gap+=1440;
			
			if(P1!=P2) {
				extra++;
			}
			if(gap>0) {
				if(P1==P2) {
					if(P1==1) {
						HA.add(gap);
						TA+=gap;
					} else {
						HB.add(gap);
						TB+=gap;
					}
				} else {
					bb.add(gap);
					TB+=gap;
					
				}
			}
			prev=curr;
		}
		
		Collections.sort(HA, Collections.reverseOrder());
		Collections.sort(HB, Collections.reverseOrder());
		Collections.sort(bb, Collections.reverseOrder());

		if(TB>TA) {
			int gap=720-TA;
			
			for (int val:bb) {
				if(gap<=0) break;
				
				gap-=val;
			}
			if(gap>0)
			for (int val:HB) {

				gap-=val;
				extra+=2;
				if(gap<=0) {
					break;
				}				
			}

		} else if (TA>TB) {
			int gap=720-TB;
			for (int val:HA) {
				
				gap-=val;
				extra+=2;
				if(gap<=0) {
					break;
				}
			}
		}
		
		
		
		output(caseNum, extra);
	}
	

	
	
	/***************************************************************************************************************
	 * ***************************************************************************************************************
	 * ***************************************************************************************************************
	 */
	
	class Obj implements Comparable<Obj> {
		public int P;
		public int S;
		public int E;
		public int T;
		public Obj(int P, int S,int E) {
			this.P=P;
			this.S=S;
			this.E=E;
			this.T=E-S;
		}
		@Override
		public int compareTo(Obj arg0) {

			return this.S-arg0.S;
		}
		
	}
	Scanner in;
	BufferedWriter out = new BufferedWriter(new FileWriter("prob.out"));;

	public parent() throws IOException {
		 in = new Scanner(new File("prob.in"));
	}

	public static void main(String[] args) throws IOException {
		parent s = new parent();
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
