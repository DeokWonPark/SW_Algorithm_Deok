import java.io.*;
import java.util.StringTokenizer;
public class b_14889_bitmask {

	public static void main(String[] args)throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		
		int N=Integer.parseInt(bf.readLine());
		int toks[][]=new int[N][N];
		
		for(int i=0;i<N;i++) {
			String line=bf.readLine();
			StringTokenizer st=new StringTokenizer(line," ");
			for(int j=0;j<N;j++) {
				toks[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		int min=10000;
		for(int s=((1<<(N/2))-1);s<(1<<N);s++) {
			int count=0;
			int sum1=0,sum2=0;
			for(int i=0;i<N;i++) {
				if((s & (1<<i))!=0) {
					count++;
				}
				if(count==N/2) {
					for(int j=0;j<N;j++) {
						if((s & (1<<j))!=0) {
							for(int k=j;k<N;k++) {
								if((s & (1<<k))!=0) {
									sum1+=toks[j][k];
									sum1+=toks[k][j];
								}
							}
						}
						else {
							if((s & (1<<j))==0) {
								for(int k=j;k<N;k++) {
									if((s & (1<<k))==0) {
										sum2+=toks[j][k];
										sum2+=toks[k][j];
									}
								}
							}
						}
						
					}
					if(min>Math.abs(sum1-sum2))
						min=Math.abs(sum1-sum2);
					break;
				}
			}
		}
		System.out.print(min);
	}
}
