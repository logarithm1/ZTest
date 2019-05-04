package solves.old;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class rounding {

	
	private void process(int caseNum) throws IOException {
		
		int N = ni();
		int L = ni();
		int remaining=N;
		int MID=(N+1)/2;
		Factors[] fac = new Factors[L];
		for(int i=0;i<L;i++) {
			int val=ni();
			remaining-=val;
			int bal=val*100%N;
			fac[i]=new Factors(val,bal);
		}
		Arrays.sort(fac, Collections.reverseOrder());
		int per=0;
		for(Factors f:fac) {
			if(f.bal>=MID) {
				per+=(f.val*100+N-1)/N;
			} else {
				while(remaining>0 && f.bal<MID) {
					remaining--;
					f.val++;
					f.bal=f.val*100%N;
				}
				
				if(f.bal>=MID) {
					per+=(f.val*100+N-1)/N;
				} else {
					per+=(f.val*100)/N;
				}
				
			}
		}
		
		if(remaining>0) {
			int minval=1;
			//remaining--;
			int bal=minval*100%N;
			while(bal<MID) {
				//remaining--;
				minval++;
				bal=minval*100%N;
			}
			int minper=(minval*100+N-1)/N;
			
			while(remaining>0) {
				if(remaining>=minval) {
					remaining-=minval;
					per+=minper;
				} else {
					remaining=0;
					per+=(remaining*100)/N;
				}
			}
			
		}
		output(caseNum, per);
	}
	
	class Factors implements Comparable<Factors> {
		public int bal;
		public int val;
		@Override
		public int compareTo(Factors o) {
			// TODO Auto-generated method stub
			return this.bal-o.bal;
		}
		
		public Factors(int val,int bal) {
			this.val=val;
			this.bal=bal;
		}
		
		
	}
	
	
	Scanner in;

	public rounding() throws IOException {
	  in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

	}

	public static void main(String[] args) throws IOException {
		rounding s = new rounding();
		s.solve();
	}
	
	private int ni() { return Integer.parseInt(in.next()); }
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

}
