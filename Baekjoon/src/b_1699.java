import java.io.*;
public class b_1699 {

	public static void main(String[] args) throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(bf.readLine());
		int memo[]=new int[N+1];
		
		for(int i=1;i<=N;i++) {
			int min=i;
			int gun;
			for(gun=(int) Math.sqrt(i);gun>=1;gun--) {
				int gun2=gun*gun;
				if(min>memo[i-gun2]+1) {
					min=memo[i-gun2]+1;
				}
			}
			memo[i]=min;
		}
		System.out.print(memo[N]);
	}
}
