import java.io.*;
import java.util.HashSet;
public class b_6064 {

	static int GCD(int M,int N) {
		if(N==0)
			return M;
		else
			return GCD(N,M%N);
	}
	public static void main(String[] args)throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		int count=Integer.parseInt(bf.readLine());
		
		for(int c=0;c<count;c++) {
			String arr[]=bf.readLine().split(" ");
			HashSet<Integer> check=new HashSet<Integer>();
			int M=Integer.parseInt(arr[0]);
			int N=Integer.parseInt(arr[1]);
			int x=Integer.parseInt(arr[2]);
			int y=Integer.parseInt(arr[3]);
			
			check.add(x);
			if(!check.add(y)) {
				sb.append(x+"\n");
				continue;
			}
			
			int X=x+M,Y=y+N;
			int gcd=GCD(M,N);
			while(true) {
				if(X>(M*N)/gcd && Y>(M*N)/gcd) {
					sb.append(-1+"\n");
					break;
				}
				if(!check.add(X)) {
					sb.append(X+"\n");
					break;
				}
				
				if(!check.add(Y)) {
					sb.append(Y+"\n");
					break;
				}
				X+=M;
				Y+=N;
			}
		}
		System.out.print(sb);
	}
}
