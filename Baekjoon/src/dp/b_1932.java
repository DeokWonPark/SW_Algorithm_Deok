package dp;
import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;
public class b_1932 {

	public static void main(String[] args)throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(bf.readLine());
		int num1=Integer.parseInt(bf.readLine());
		int memo[][]=new int[N][N];
		memo[0][0]=num1;
		for(int i=1;i<N;i++) {
			String arr[]=bf.readLine().split(" ");
			for(int j=0;j<arr.length;j++) {
				int num=Integer.parseInt(arr[j]);
				if(j==0) {
					memo[i][j]=memo[i-1][j]+num;
				}
				else if(j==arr.length-1) {
					memo[i][j]=memo[i-1][j-1]+num;
				}
				else {
					memo[i][j]=Math.max(memo[i-1][j-1], memo[i-1][j])+num;
				}
			}
		}
		Arrays.sort(memo[N-1]);
		System.out.print(memo[N-1][N-1]);
	}
}
