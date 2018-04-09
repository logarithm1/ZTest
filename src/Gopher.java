
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

@SuppressWarnings("unused")
public class Gopher {

	
	private static void process(int caseNum, Scanner in) throws IOException {
		
		int A = ni(in);
		//int P = ni();
		
		int row=1;
		int col=1;
		int loop=0;
		if(A==20) {
			loop=2;
		} else {
			loop=22;
		}
		
		int[][] data = new int[3][207];
		for(int i=0;i<loop;i++) {
			
			int turns=0;
			while(true) {
				System.out.println(row + " " + col);
				//res=nline();
				//String[] done = res.split(" ");
//				int rd=Integer.parseInt(done[0]);
//				int cd=Integer.parseInt(done[1]);
				int rd=Integer.parseInt(ns(in));
				int cd=Integer.parseInt(ns(in));

				data[rd][cd]=1;
				turns++;
				if(turns>=9 && complete(data,row,col)) {
					break;
				}
			}
			col+=3;
		}
		col-=2;

		while(true) {
			System.out.println(row + " " + col);
//			String[] done = res.split(" ");
//			int rd=Integer.parseInt(done[0]);
//			int cd=Integer.parseInt(done[1]);				
			int rd=Integer.parseInt(ns(in));
			int cd=Integer.parseInt(ns(in));
			if((rd==0 && cd == 0) || rd==-1) {
				break;
			}
		}

		
		
		//output(caseNum, "");
	}
	

	
	
	private static boolean complete(int[][] data, int row, int col) {
		for(int i=0;i<3;i++) {
			for(int j=col-1;j<=col+1;j++) {
				if(data[i][j] == 0) {
					return false;
				}
			}
		}
		return true;
	}






	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner((System.in));
		//Solution s = new Solution();
		solve(in);
	}
	
	private static String ns(Scanner in) { return in.next(); }
	private static int ni(Scanner in) { return Integer.parseInt(in.next()); }
	private static long nl(Scanner in) { return Long.parseLong(in.next()); }
	private static double nd(Scanner in) { return Double.parseDouble(in.next()); }
	private static void solve(Scanner in) throws IOException {

		int numCases = in.nextInt();
		for (int i = 1; i <= numCases; i++) {
			process(i, in);
		}
		in.close();
	}

}
