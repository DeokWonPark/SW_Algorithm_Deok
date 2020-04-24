import java.io.*;
public class b_11727 {

	public static void main(String[] args) throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(bf.readLine());
		
		int memo[]=new int [n+1];
		memo[1]=1;
		if(n==1) {
			System.out.print(1);
			return;
		}
		memo[2]=3;
		for(int i=3;i<=n;i++) {
			memo[i]=((memo[i-1]%10007)+((2*memo[i-2])%10007))%10007;
		}
		System.out.print(memo[n]);
	}
}
