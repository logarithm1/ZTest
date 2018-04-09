import java.util.Scanner;

public class Solution {
  public static void solve(Scanner in, int A) {

		
		int row=2;
		int col=2;
		int loop=0;
		if(A<=20) { 
			loop=3;
		} else {
			loop=23;
		}
		
		System.err.println("Started  " +A);
		
		int[][] data = new int[210][210];

		for(int i=0;i<loop;i++) {
			int turns=0;
			System.err.println("Loop Count" + i);

			while(true) {
				System.out.println(row + " " + col);
				int rd=Integer.parseInt(in.next());
				int cd=Integer.parseInt(in.next());

				//System.err.println("System Guessed " + rd + " " + cd);
				
				data[rd][cd]=1;
				turns++;
				
				// Adding this since simulation has A=10
				if(rd<=0) return;

				if(turns>=9 && complete(data,row,col)) {
					break;
				}
				
			}
			row+=3;
		}
		
		//System.err.println("loop broken");

		row-=2;
		int turns=0;
		while( true) {
			turns++;
			System.out.print(row + " " + col);

			int rd=Integer.parseInt(in.next());
			int cd=Integer.parseInt(in.next());
			
			//System.err.println("New Guess: " + rd + " col  " + cd);

			if(rd<=0) {
				break;
			}
		}
		
  }
  
	private static boolean complete(int[][] data, int row, int col) {
		for(int i=row-1;i<=row+1;i++) {
			for(int j=col-1;j<=col+1;j++) {
				if(data[i][j] == 0) {
					return false;
				}
			}
		}
		return true;
	}

  public static void main(String args[]) {
    Scanner input = new Scanner(System.in);
    int T = input.nextInt();
    for (int ks = 1; ks <= T; ks++) {
      int a = input.nextInt();
     
      solve(input, a );
    }
  }
}

