import java.io.*;
public class b_2225 {

	public static void main(String[] args)throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		
		String arr[]=bf.readLine().split(" ");
		int N=Integer.parseInt(arr[0]);
		int K=Integer.parseInt(arr[1]);
		
		int memo[][]=new int[K+1][N+1];
		int r=1000000000;
		
		for(int i=1;i<=K;i++) {
			for(int j=0;j<=N;j++) {
				if(i==1) {
					memo[i][j]=1;
					continue;
				}
				for(int n=0;n<=j;n++) {
					memo[i][j]=(memo[i][j]%r)+(memo[i-1][j-n]%r)%r;
				}
			}
		}
		System.out.print(memo[K][N]);
	}
}
