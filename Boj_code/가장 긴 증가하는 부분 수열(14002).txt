import java.io.*;
import java.util.*;
public class b_14002 {

	public static void main(String[] args) throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		
		int N=Integer.parseInt(bf.readLine());
		int memo[][]=new int[N][3];
		
		String line=bf.readLine();
		StringTokenizer st=new StringTokenizer(line," ");
		int max=1;
		for(int i=0;i<N;i++) {
			int num=Integer.parseInt(st.nextToken());
			int temp=0;
			if(i==0) {
				memo[i][0]=1;
				memo[i][1]=num;
				memo[i][2]=-1;
				continue;
			}
			memo[i][2]=-1;
			
			for(int j=0;j<i;j++) {
				if(memo[j][1]<num) {
					if(memo[j][0]>temp) {
						temp=memo[j][0];
						memo[i][2]=j;
					}
				}
			}
			memo[i][0]=temp+1;
			memo[i][1]=num;
			if(max<memo[i][0])
				max=memo[i][0];
			
		}
		sb.append(max+"\n");
		int s;
		for(s=0;s<N;s++) {
			if(max==memo[s][0]) {
				break;
			}
		}
		Stack<Integer>sk=new Stack<Integer>();
		while(true) {
			sk.push(memo[s][1]);
			if(memo[s][2]==-1)
				break;
			s=memo[s][2];
		}
		while(!sk.empty()) {
			sb.append(sk.pop()+" ");
		}
		System.out.print(sb);
	}
}
