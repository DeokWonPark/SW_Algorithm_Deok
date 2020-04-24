import java.io.*;
import java.util.Arrays;
public class b_15656 {
	static int N,M;
	static int arr[];
	static int toks[];
	static StringBuilder sb=new StringBuilder();
	
	static void N_M(int start) {
		if(start==M) {
			for(int i=0;i<M-1;i++) {
				sb.append(arr[i]+" ");
			}
			sb.append(arr[M-1]+"\n");
		}
		else {
			for(int i=0;i<N;i++) {
				arr[start]=toks[i];
				N_M(start+1);
			}
		}
	}

	public static void main(String[] args)throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		String line[]=bf.readLine().split(" ");
		N=Integer.parseInt(line[0]);
		M=Integer.parseInt(line[1]);
		arr=new int[M];
		
		String line2[]=bf.readLine().split(" ");
		toks=new int[N];
		for(int i=0;i<N;i++) {
			toks[i]=Integer.parseInt(line2[i]);
		}
		Arrays.sort(toks);
		N_M(0);
		System.out.print(sb);
	}
}
