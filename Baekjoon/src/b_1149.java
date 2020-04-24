import java.io.*;
public class b_1149 {

	public static void main(String[] args)throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		
		int N=Integer.parseInt(bf.readLine());
		int memo[][]=new int[N][3];
		
		for(int i=0;i<N;i++) {
			String arr[]=bf.readLine().split(" ");
			if(i==0) {
				memo[i][0]=Integer.parseInt(arr[0]);
				memo[i][1]=Integer.parseInt(arr[1]);
				memo[i][2]=Integer.parseInt(arr[2]);
				continue;
			}
			memo[i][0]=Math.min(memo[i-1][1],memo[i-1][2])+Integer.parseInt(arr[0]);
			memo[i][1]=Math.min(memo[i-1][0],memo[i-1][2])+Integer.parseInt(arr[1]);
			memo[i][2]=Math.min(memo[i-1][1],memo[i-1][0])+Integer.parseInt(arr[2]);
		}
		int mini;
		mini=Math.min(memo[N-1][0], memo[N-1][1]);
		mini=Math.min(mini, memo[N-1][2]);
		System.out.print(mini);
	}
}
