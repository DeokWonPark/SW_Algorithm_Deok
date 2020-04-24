import java.io.*;
public class b_2747 {

	public static void main(String[] args)throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(bf.readLine());
		long memo[]=new long[N+1];
		memo[0]=0;
		if(N==0) {
			System.out.print(memo[N]);
			return;
		}
		memo[1]=1;
		for(int i=2;i<=N;i++) {
			memo[i]=memo[i-1]+memo[i-2];
		}
		System.out.print(memo[N]);
	}
}
