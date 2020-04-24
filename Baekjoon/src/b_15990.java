import java.io.*;
public class b_15990 {

	public static void main(String[] args) throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		
		long memo[][]=new long[100001][5];
		
		for(int i=1;i<=2;i++) {
			memo[i][i]=1;
			memo[i][4]=1;
		}
		memo[3][1]=1;
		memo[3][2]=1;
		memo[3][3]=1;
		memo[3][4]=3;
		long r=1000000009;
		for(int i=4;i<=100000;i++) {
			memo[i][1]=((memo[i-1][2]%r)+(memo[i-1][3]%r))%r;
			memo[i][2]=((memo[i-2][1]%r)+(memo[i-2][3]%r))%r;
			memo[i][3]=((memo[i-3][1]%r)+(memo[i-3][2]%r))%r;
			memo[i][4]=((memo[i][1]%r)+(memo[i][2]%r)+(memo[i][3]%r))%r;
		}
		
		int count=Integer.parseInt(bf.readLine());
		for(int i=0;i<count;i++) {
			int num=Integer.parseInt(bf.readLine());
			sb.append(memo[num][4]+"\n");
		}
		System.out.print(sb);
	}
}
