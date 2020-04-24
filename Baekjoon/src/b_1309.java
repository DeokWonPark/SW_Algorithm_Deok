import java.io.*;
public class b_1309 {

	public static void main(String[] args) throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		
		int N=Integer.parseInt(bf.readLine());
		int memo[][]=new int[N][3];
		
		memo[0][0]=1;
		memo[0][1]=1;
		memo[0][2]=1;
		int r=9901;
		for(int i=1;i<N;i++) {
			memo[i][0]=((memo[i-1][2]%r)+(memo[i-1][1]%r))%r;
			memo[i][1]=((memo[i-1][2]%r)+(memo[i-1][0]%r))%r;
			memo[i][2]=((memo[i-1][2]%r)+(memo[i-1][1]%r)+(memo[i-1][0]%r))%r;
		}
		int result=((memo[N-1][2]%r)+(memo[N-1][1]%r)+(memo[N-1][0]%r))%r;
		System.out.print(result);
	}
}
 