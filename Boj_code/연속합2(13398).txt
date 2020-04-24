import java.io.*;
import java.util.*;
public class b_13398 {

	public static void main(String[] args) throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(bf.readLine());
		String arr[]=bf.readLine().split(" ");
		int arri[]=new int[N];
		int memo[][]=new int [N][2];
		
		for(int i=0;i<N;i++) {
			arri[i]=Integer.parseInt(arr[i]);
		}
		
		memo[0][0]=arri[0];
		int result=memo[0][0];
		for(int i=1;i<N;i++) {
			int num=arri[i];
			memo[i][0]=Math.max(num, memo[i-1][0]+num);
			if(result<memo[i][0])
				result=memo[i][0];
		}
		
		memo[N-1][1]=arri[N-1];
		for(int i=N-2;i>=0;i--) {
			int num=arri[i];
			memo[i][1]=Math.max(num, memo[i+1][1]+num);
			
		}
		
		for(int i=1;i<N-1;i++) {
			if(result<memo[i-1][0]+memo[i+1][1]) {
				result=memo[i-1][0]+memo[i+1][1];
			}
		}
		System.out.print(result);
	}
}
