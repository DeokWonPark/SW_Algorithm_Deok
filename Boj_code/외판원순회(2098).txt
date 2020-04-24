import java.io.*;
import java.util.StringTokenizer;
public class b_2098 {
	static int N;
	static int DP[][];
	static int map[][];

	static int Search(int mask,int start,int num) {
		mask=(mask | (2<<num));
		if(start==N) {
			if(map[num][1]==0) {
				return 100000000;
			}
			else {
				DP[mask][num]=map[num][1];
				return map[num][1];
			}
		}
		else {
			if(DP[mask][num]!=0) {
				return DP[mask][num];
			}
			for(int i=2;i<=N;i++) {
				int temp;
				if(map[num][i]==0) {
					continue;
				}
				if((mask & (2<<i))==0) {
					temp=Search(mask,start+1,i);
					if(DP[mask][num]==0) {
						DP[mask][num]=temp+map[num][i];
					}
					else {
						if(DP[mask][num]>temp+map[num][i])
							DP[mask][num]=temp+map[num][i];
					}
				}
			}
			if(DP[mask][num]==0)
				return 100000000;
			return DP[mask][num];
		}
	}
	public static void main(String args[])throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		
		N=Integer.parseInt(bf.readLine());
		DP=new int[2<<(N+1)][N+1];
		map=new int[N+1][N+1];
		
		for(int i=1;i<=N;i++) {
			String line=bf.readLine();
			StringTokenizer st=new StringTokenizer(line," ");
			for(int j=1;j<=N;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		int value=Search(0,1,1);
		System.out.print(value);
	}
}
