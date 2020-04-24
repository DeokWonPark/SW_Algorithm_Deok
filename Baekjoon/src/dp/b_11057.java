package dp;
import java.io.*;
public class b_11057 {

	public static void main(String[] args) throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(bf.readLine());
		int memo[][]=new int[N+1][10];
		
		for(int i=1;i<=N;i++) {
			for(int j=0;j<10;j++) {
				if(i==1 || j==0) {
					memo[i][j]=1;
					continue;
				}
				memo[i][j]=((memo[i-1][j]%10007)+(memo[i][j-1]%10007))%10007;
			}
		}
		int result=memo[N][0];
		for(int i=1;i<10;i++) {
			result=((result%10007)+(memo[N][i]%10007))%10007;
		}
		System.out.print(result);
	}
}
