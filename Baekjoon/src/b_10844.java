import java.io.*;
public class b_10844 {

	public static void main(String[] args) throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		
		int N=Integer.parseInt(bf.readLine());
		int memo[][]=new int[N+1][10];
		memo[1][0]=0;
		for(int i=1;i<10;i++) {
			memo[1][i]=1;
		}
		int r=1000000000;
		for(int i=2;i<=N;i++) {
			for(int j=0;j<10;j++) {
				if(j==0) {
					memo[i][j]=memo[i-1][j+1];
					continue;
				}
				if(j==9) {
					memo[i][j]=memo[i-1][j-1];
					continue;
				}
				memo[i][j]=((memo[i-1][j-1]%r)+(memo[i-1][j+1]%r))%r;
			}
		}
		int result=0;
		for(int i=0;i<10;i++) {
			result=(result+memo[N][i])%r;
		}
		System.out.print(result);
	}
}
