import java.io.*;
import java.util.*;
public class b_11053 {

	public static void main(String[] args) throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		
		int N=Integer.parseInt(bf.readLine());
		int memo[][]=new int[N][2];
		
		String line=bf.readLine();
		StringTokenizer st=new StringTokenizer(line," ");
		int max=1;
		for(int i=0;i<N;i++) {
			int num=Integer.parseInt(st.nextToken());
			int temp=0;
			if(i==0) {
				memo[i][0]=1;
				memo[i][1]=num;
				continue;
			}
			
			for(int j=0;j<i;j++) {
				if(memo[j][1]<num) {
					if(memo[j][0]>temp) {
						temp=memo[j][0];
					}
				}
			}
			memo[i][0]=temp+1;
			memo[i][1]=num;
			if(max<memo[i][0])
				max=memo[i][0];
		}
		System.out.print(max);
	}
}
