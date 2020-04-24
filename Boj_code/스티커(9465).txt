package dp;
import java.io.*;
public class b_9465 {

	public static void main(String[] args)throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		int count=Integer.parseInt(bf.readLine());
		
		for(int c=0;c<count;c++) {
			int N=Integer.parseInt(bf.readLine());
			String arr1[]=bf.readLine().split(" ");
			String arr2[]=bf.readLine().split(" ");
			
			int A[]=new int[N];
			int B[]=new int[N];
			
			for(int s=0;s<N;s++) {
				A[s]=Integer.parseInt(arr1[s]);
				B[s]=Integer.parseInt(arr2[s]);
			}
			
			int memo[][]=new int[N][3];
			memo[0][0]=0;
			memo[0][1]=A[0];
			memo[0][2]=B[0];
			
			for(int i=1;i<N;i++) {
				memo[i][0]=Math.max(Math.max(memo[i-1][0], memo[i-1][1]),memo[i-1][2]);
				memo[i][1]=Math.max(memo[i-1][0], memo[i-1][2])+A[i];
				memo[i][2]=Math.max(memo[i-1][0], memo[i-1][1])+B[i];
			}
			int result=Math.max(Math.max(memo[N-1][0], memo[N-1][1]),memo[N-1][2]);
			sb.append(result+"\n");
		}
		System.out.print(sb);
	}
}
