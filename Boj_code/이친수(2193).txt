import java.io.*;
public class b_2193 {

	public static void main(String[] args) throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		
		int N=Integer.parseInt(bf.readLine());
		long memo[][]=new long [N+1][2];
		memo[1][0]=0;
		memo[1][1]=1;
		
		for(int i=2;i<=N;i++) {
			memo[i][0]=memo[i-1][0]+memo[i-1][1];
			memo[i][1]=memo[i-1][0];
		}
		System.out.print(memo[N][0]+memo[N][1]);
	}
}
