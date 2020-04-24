package dp;
import java.io.*;
public class b_11055 {

	public static void main(String[] args)throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(bf.readLine());
		int memo[][]=new int[N][2];
		String arr[]=bf.readLine().split(" ");
		
		for(int i=0;i<N;i++) {
			memo[i][1]=Integer.parseInt(arr[i]);
		}
		int result=0;
		for(int i=0;i<N;i++) {
			int max=0;
			for(int j=0;j<i;j++) {
				if(memo[j][1]<memo[i][1]) {
					if(max<memo[j][0]) {
						max=memo[j][0];
					}
				}
			}
			memo[i][0]=memo[i][1]+max;
			if(result<memo[i][0]) {
				result=memo[i][0];
			}
		}
		System.out.print(result);
	}
}
