import java.io.*;
import java.util.StringTokenizer;
public class b_14501 {
	static int N;
	static int T[];
	static int P[];
	static int max=0;
	
	static void End(int start,int sum) {
		if(start==N) {
			if(max<sum)
				max=sum;
			return;
		}
		if(start+T[start]<=N) {
			End(start+T[start],sum+P[start]);
		}
		End(start+1,sum);
	}

	public static void main(String[] args)throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		
		N=Integer.parseInt(bf.readLine());
		T=new int[N];
		P=new int[N];
		for(int i=0;i<N;i++) {
			String line=bf.readLine();
			StringTokenizer st=new StringTokenizer(line," ");
			T[i]=Integer.parseInt(st.nextToken());
			P[i]=Integer.parseInt(st.nextToken());
		}
		End(0,0);
		System.out.print(max);
	}
}
