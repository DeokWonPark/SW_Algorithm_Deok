import java.io.*;
public class b_2133 {

	public static void main(String[] args)throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(bf.readLine());
		if(N%2!=0) {
			System.out.print(0);
			return;
		}
		int memo[][]=new int[N/2][3];
		memo[0][0]=1;
		memo[0][1]=1;
		memo[0][2]=1;
		for(int i=1;i<N/2;i++) {
			memo[i][0]=memo[i-1][0]+memo[i-1][1]+memo[i-1][2];
			memo[i][1]=memo[i-1][0]+memo[i-1][1]+memo[i-1][2];
			memo[i][2]=memo[i-1][0]+memo[i-1][1]+memo[i-1][2];
		}
		System.out.print(memo[N/2-1][0]+memo[N/2-1][1]+memo[N/2-1][2]);
	}
}
