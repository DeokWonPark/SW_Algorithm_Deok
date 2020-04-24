import java.io.*;
import java.util.Arrays;
public class b_15655 {
	static int N,M;
	static int arr[];
	static StringBuilder sb=new StringBuilder();
	
	static void N_M(int start, int m,int toks[]) {
		if(m==M) {
			for(int i=0;i<M-1;i++) {
				sb.append(arr[i]+" ");
			}
			sb.append(arr[M-1]+"\n");
			return;
		}
		if(start>=N)
			return;
		arr[m]=toks[start];
		N_M(start+1,m+1,toks);
		N_M(start+1,m,toks);
	}

	public static void main(String[] args)throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		String line[]=bf.readLine().split(" ");
		
		N=Integer.parseInt(line[0]);
		M=Integer.parseInt(line[1]);
		arr=new int[M];
		
		String line2[]=bf.readLine().split(" ");
		int toks[]=new int[N];
		for(int i=0;i<N;i++) {
			toks[i]=Integer.parseInt(line2[i]);
		}
		Arrays.sort(toks);
		N_M(0,0,toks);
		System.out.print(sb);
	}
}
