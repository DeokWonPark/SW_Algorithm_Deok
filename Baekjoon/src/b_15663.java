import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
public class b_15663 {
	static int N,M;
	static int arr[];
	static boolean check[];
	static ArrayList<Integer> toks;
	static StringBuilder sb=new StringBuilder();
	static HashSet<String> set;
	
	static void N_M(int start) {
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
		
		for(int i=0;i<toks.size();i++) {
			if(!check[i]) {
				check[i]=true;
				arr[start]=toks.get(i);
				N_M(start+1);
				check[i]=false;
			}
		}
	}
	

	public static void main(String[] args) throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		String line[]=bf.readLine().split(" ");
		N=Integer.parseInt(line[0]);
		M=Integer.parseInt(line[1]);
		arr=new int[M];
		
		String line2[]=bf.readLine().split(" ");
		set =new HashSet<String>();
		toks=new ArrayList<Integer>();
		for(int i=0;i<N;i++) {
			toks.add(Integer.parseInt(line2[i]));
		}
		
		Collections.sort(toks);
		check=new boolean[N];
		N_M(0);
		System.out.print(sb);
	}
}
