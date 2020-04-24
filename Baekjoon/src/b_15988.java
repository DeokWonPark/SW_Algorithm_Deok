import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class b_15988 {

	public static void main(String[] args) throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		
		int count=Integer.parseInt(bf.readLine());
		long memo[]=new long[1000001];
		memo[1]=1;
		memo[2]=2;
		memo[3]=4;
		long r=1000000009;
		for(int i=4;i<=1000000;i++) {
			memo[i]=((memo[i-1]%r)+(memo[i-2]%r)+(memo[i-3]%r))%r;
		}
		
		for(int i=0;i<count;i++) {
			int num=Integer.parseInt(bf.readLine());
			sb.append(memo[num]+"\n");
		}
		System.out.print(sb);
	}
}
