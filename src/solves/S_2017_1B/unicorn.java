package solves.S_2017_1B;
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
public class unicorn {

	
	private void process(int caseNum) throws IOException {
		
		int N = ni();
		int R = ni();
		int O = ni();
		int Y = ni();
		int G = ni();
		int B = ni();
		int V = ni();

		
		if(B<O || Y<V || R<G) {
			output(caseNum, "IMPOSSIBLE"); return;
		}
		if(edgecase(caseNum, B, O, Y, G, R, V, "BO")) return;
		if(edgecase(caseNum, Y, V, R, G, B, O,"YV")) return;
		if(edgecase(caseNum, R, G, Y, O, B, V,"RG")) return;
		B=B-O; //BOB
		Y=Y-V; //YVY
		R=R-G; // RGR
		
		Queue<Color> q = new PriorityQueue<>(Collections.reverseOrder());
		if(R>0)q.add(new Color('R',R));
		if(Y>0)q.add(new Color('Y',Y));
		if(B>0)q.add(new Color('B',B));
		
		char[] res=new char[N];
		int count=0;
		char prev='x';
		while(q.size()>1) {
			Color c1=q.remove();
			Color c2=q.remove();
			if(prev==c1.c) {
				res[count++]=c2.c;
				res[count++]=c1.c;
				prev=c1.c;
			} else {
				res[count++]=c1.c;
				res[count++]=c2.c;
				prev=c2.c;
			}
			c1.i--;c2.i--;
			if(c1.i>0) q.add(c1);
			if(c2.i>0) q.add(c2);
		}
		
		if(q.size()>0) {
			Color c=q.remove();
			if(c.i>1) {
				output(caseNum, "IMPOSSIBLE"); return;
			} else {
				if(count >0 &&res[count-1]==c.c) {output(caseNum, "IMPOSSIBLE"); return;}
				res[count]=c.c;
			}
		}
		if(res[0]==res[N-1]) {
			output(caseNum, "IMPOSSIBLE");
		
		}else {
			String s=new String(res);
			String OO = "";
			String VV = "";
			String GG = "";
			
			if(B<O || Y<V || R<G) {
				output(caseNum, "IMPOSSIBLE"); return;
			}
			if(O>0) {
				 OO = getString(O,"BO","B");
				 s=s.replaceFirst("B", OO);
			}
			if(V>0) {
				 VV = getString(V,"YV","Y");
				 s=s.replaceFirst("Y", VV);
			}
			if(G>0) {
				 GG = getString(G,"RG","R");
				 s=s.replaceFirst("R", GG);
			}
			s=s.trim();
			if(s.length()>1 && s.charAt(0)==s.charAt(s.length()-1)) {
				output(caseNum, "IMPOSSIBLE"); return;
			}
			
			output(caseNum, new String(res).trim());

		}
	}

	private String getString(int o, String s1, String s2) {
		
		String s="";
		for (int i=0;i<o;i++) {
			s+=s1;
		}
		return s+s2;
	}

	private boolean edgecase(int caseNum, int B, int O, int R, int Y, int G, int V, String s) throws IOException {
		if(B==O && B>0) {
			if(Y+V+R+G>0) {
				output(caseNum, "IMPOSSIBLE"); return true;
			} else {
				output(caseNum,  getString(O,s,"")); return true;
			}
		}
		return false;
	}
	
	class Color  implements Comparable<Color>{
		public char c;
		public int i;
		public int oi;
		Color (char c, int i) {
			this.c=c;
			this.i=i;
			this.oi=i;
		}
		@Override
		public int compareTo(Color o) {
			// TODO Auto-generated method stub
			if(this.i!=o.i)
				return this.i-o.i;
			
			if(this.oi!=o.oi)
				return this.oi-o.oi;
			
			return this.c-o.c;
		}
	}
	
	
	
	
	
	
	
	
	
	

	
	
	/***************************************************************************************************************
	 */
	Scanner in;
	BufferedWriter out = new BufferedWriter(new FileWriter("prob.out"));;

	public unicorn() throws IOException {
		 in = new Scanner(new File("prob.in"));
	}

	public static void main(String[] args) throws IOException {
		unicorn s = new unicorn();
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
	public void output(String string) throws IOException {
		out.write( string + "\n");
	}

}
