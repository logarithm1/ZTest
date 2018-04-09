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

@SuppressWarnings("unused")
public class dragonbuff {

	
	int Hd ;
	int Ad;
	int Hk;
	int Ak;
	int B;
	int D;

	private void process(int caseNum) throws IOException {
		
		 Hd = ni();
		 Ad = ni();
		 Hk = ni();
		 Ak = ni();
		 B = ni();
		 D = ni();
		
		 int min=Integer.MAX_VALUE;
		for(int di=0;di<Hk;di++) {
			for(int bi=0;bi<Hk;bi++) {
				int res =play(di,bi,Hd,Ad,Hk,Ak);
				if(res !=-1) {
					if(min>res) min=res;
				}
			}
		}
		if(min==Integer.MAX_VALUE) {
			output(caseNum, "IMPOSSIBLE");
		} else
		
		output(caseNum, min);
	}

	private int play(int di, int bi, int Hd, int Ad, int Hk, int Ak) {
		
		
		int count=0;
		boolean reload=false;
		while(di>0) {
			count++;
			if(Hd<=Ak-D) {
				if(reload) return -1;
				Hd=this.Hd;
				reload=true;
			} else {
				reload=false;
				di--;
				Ak-=D;
				if(Ak<0) Ak=0;
			}
			Hd-=Ak;
			if(Hd<=0) return -1;
		}
		
		while(bi>0) {
			count++;
			if(Hd<=Ak) {
				if(reload) return -1;
				Hd=this.Hd;
				reload=true;
			} else {
				reload=false;
				bi--;
				Ad+=B;
				if(Ad>1000000000) break;
			}
			Hd-=Ak;
			if(Hd<=0) return -1;
		}
		
		while(Hk>0) {
			count++;
			if(Hd<=Ak && Hk>Ad) {
				if(reload) return -1;
				Hd=this.Hd;
				reload=true;
			} else {
				reload=false;
				bi++;
				Hk-=Ad;
				if(Ad>1000000000) break;
			}
			Hd-=Ak;
		}
		
		return count;
	}

	private int tps(int Hd, int Ak) {
		int Akd=Ak;
		if(Hd<Akd) return 0;
		return (Hd-Akd-1)/Akd;
	}
	
	
	
	
	
	
	
	
	
	
	

	
	
	/***************************************************************************************************************
	 */
	Scanner in;
	BufferedWriter out = new BufferedWriter(new FileWriter("prob.out"));;

	public dragonbuff() throws IOException {
		 in = new Scanner(new File("prob.in"));
	}

	public static void main(String[] args) throws IOException {
		dragonbuff s = new dragonbuff();
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
			System.out.println("************** Case " + i);
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
