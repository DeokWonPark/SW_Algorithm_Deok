import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
public class b_15664 {

	static int N,M;
	static int arr[];
	static int toks[];
	static boolean check[];
	static HashSet<String> set;
	static StringBuilder sb=new StringBuilder();
	
	private static void N_M(int start, int value) {
		if(start==M) {
			String ck="";
			for(int i=0;i<M-1;i++) {
				ck+=arr[i]+" ";
			}
			ck+=arr[M-1]+"\n";
			if(set.add(ck)) {
				sb.append(ck);
			}
			return;
		}
		for(int i=value;i<N;i++) {
			if(!check[i]) {
				check[i]=true;
				arr[start]=toks[i];
				N_M(start+1,i);
				check[i]=false;
			}
		}
	}
	
	
	public static void main(String[] args)throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		
		String line[]=bf.readLine().split(" ");
		N=Integer.parseInt(line[0]);
		M=Integer.parseInt(line[1]);
		arr=new int[M];
		toks=new int[N];
		check=new boolean[N];
		set=new HashSet<String>();
		
		String line2[]=bf.readLine().split(" ");
		for(int i=0;i<N;i++) {
			toks[i]=Integer.parseInt(line2[i]);
		}
		Arrays.sort(toks);
		N_M(0,0);
		System.out.print(sb);
	}
}
