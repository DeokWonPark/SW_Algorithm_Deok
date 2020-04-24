package dp;
import java.io.*;
public class b_2156 {

	public static void main(String[] args)throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(bf.readLine());
		int memo[][]=new int[N][3];
		for(int i=0;i<N;i++) {
			int num=Integer.parseInt(bf.readLine());
			if(i==0) {
				memo[i][0]=0;
				memo[i][2]=0;
				memo[i][1]=num;
				continue;
			}
			memo[i][0]=Math.max(Math.max(memo[i-1][0], memo[i-1][1]), memo[i-1][2]);
			memo[i][1]=memo[i-1][0]+num;
			memo[i][2]=memo[i-1][1]+num;
		}
		System.out.print(Math.max(Math.max(memo[N-1][0], memo[N-1][1]), memo[N-1][2]));
	}
}
