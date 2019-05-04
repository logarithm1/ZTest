package solves.C2017;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.InputMismatchException;

public class C {
	public static void main(String[] args) throws FileNotFoundException {
		FastScannerC sc = new FastScannerC(new FileInputStream(new File("inputC.txt")));
		PrintWriter pw = new PrintWriter(new File("outputC.txt"));
		
		int T = sc.nextInt();
		for(int t = 1; t <= T; t++){
			StringBuilder sb = new StringBuilder();
			
			int N = sc.nextInt();
			int K = sc.nextInt();
			
			Pancake[] arr = new Pancake[N];
			for(int i = 0; i<N; i++){
				long r = sc.nextInt();
				long h = sc.nextInt();
				arr[i] = new Pancake(r, h);
			}
			Arrays.sort(arr);
			
			long maxArea = -1;
			
			for(int i = 0; i < N; i++){
				//boolean[] visited = new boolean[N];
				//visited[i] = true;
				int size = 1;
				long area = arr[i].area;
				for(int j = 0; j < N && size < K; j++){
					if(i == j) continue;
					if(arr[i].r >= arr[j].r){
						size++;
						area += arr[j].area;
						if(size == K) break;
					}
				}
				if(size == K){
					long aa = area * 2 + (long)arr[i].r * arr[i].r;
					
					maxArea = Math.max(maxArea, aa);
				}
			}
			
			double ans = Math.PI * maxArea;
			
			sb.append("Case #");
			sb.append(t);
			sb.append(": ");
			sb.append(ans);
			sb.append('\n');
			System.out.print(sb);
			pw.write(sb.toString());
		}
		
		pw.close();
	}
}

class Pancake implements Comparable<Pancake>{
	long r;
	long h;
	long area;
	Pancake(long rr, long hh){
		r = rr;
		h = hh;
		area = (long)r * h;
	}
	
	public int compareTo(Pancake p) {
		long res = p.area - area;
		if(res < 0) return -1;
		else if(res == 0) return 0;
		else return 1;
	}
}

class FastScannerC{
    private InputStream stream;
    private byte[] buf = new byte[1024];
    private int curChar;
    private int numChars;
    private SpaceCharFilter filter;

    public FastScannerC(InputStream stream)
    {
        this.stream = stream;
    }

    public int read()
    {
        if (numChars == -1)
            throw new InputMismatchException();
        if (curChar >= numChars)
        {
            curChar = 0;
            try
            {
                numChars = stream.read(buf);
            } catch (IOException e)
            {
                throw new InputMismatchException();
            }
            if (numChars <= 0)
                return -1;
        }
        return buf[curChar++];
    }

    public int nextInt()
    {
        int c = read();
        while (isSpaceChar(c))
            c = read();
        int sgn = 1;
        if (c == '-')
        {
            sgn = -1;
            c = read();
        }
        int res = 0;
        do
        {
            if (c < '0' || c > '9')
                throw new InputMismatchException();
            res *= 10;
            res += c - '0';
            c = read();
        } while (!isSpaceChar(c));
        return res * sgn;
    }

    public String next()
    {
        int c = read();
        while (isSpaceChar(c))
            c = read();
        StringBuilder res = new StringBuilder();
        do
        {
            res.appendCodePoint(c);
            c = read();
        } while (!isSpaceChar(c));
        return res.toString();
    }
    
    public String nextLine()
    {
        int c = read();
        StringBuilder res = new StringBuilder();
        do
        {
            res.appendCodePoint(c);
            c = read();
        } while (!isLineEndChar(c));
        return res.toString();
    }    
    
    public double nextDouble() {
        int c = read();
        while (isSpaceChar(c))
            c = read();
        int sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = read();
        }
        double res = 0;
        while (!isSpaceChar(c) && c != '.') {
            if (c == 'e' || c == 'E')
                return res * Math.pow(10, nextInt());
            if (c < '0' || c > '9')
                throw new InputMismatchException();
            res *= 10;
            res += c - '0';
            c = read();
        }
        if (c == '.') {
            c = read();
            double m = 1;
            while (!isSpaceChar(c)) {
                if (c == 'e' || c == 'E')
                    return res * Math.pow(10, nextInt());
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                m /= 10;
                res += (c - '0') * m;
                c = read();
            }
        }
        return res * sgn;
    }
    
    public long nextLong() {
        int c = read();
        while (isSpaceChar(c))
            c = read();
        int sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = read();
        }
        long res = 0;
        do {
            if (c < '0' || c > '9')
                throw new InputMismatchException();
            res *= 10;
            res += c - '0';
            c = read();
        } while (!isSpaceChar(c));
        return res * sgn;
    }
    
    public boolean isSpaceChar(int c)
    {
        if (filter != null)
            return filter.isSpaceChar(c);
        return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
    }
    
    public boolean isLineEndChar(int c)
    {
        if (filter != null)
            return filter.isSpaceChar(c);
        return c == '\n' || c == '\r' || c == -1;
    }

    public interface SpaceCharFilter
    {
        public boolean isSpaceChar(int ch);
    }
}