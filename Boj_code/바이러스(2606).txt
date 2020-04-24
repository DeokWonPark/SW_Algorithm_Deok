import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;
public class b_2606 {
	static int N;
	static boolean check[];
	static ArrayList<Integer> ar[];
	static int count=-1;
	
	static void DFS(int start) {
		count++;
		check[start]=true;
		for(int i=0;i<ar[start].size();i++) {
			int y=ar[start].get(i);
			if(!check[y]) {
				DFS(y);
			}
		}
	}

	public static void main(String[] args)throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		
		N=Integer.parseInt(bf.readLine());
		int E=Integer.parseInt(bf.readLine());
		check=new boolean[N+1];
		ar=(ArrayList<Integer>[])new ArrayList[N+1];
		
		for(int i=1;i<=N;i++) {
			ar[i]=new ArrayList<Integer>();
		}
		
		for(int i=0;i<E;i++) {
			String line=bf.readLine();
			StringTokenizer st=new StringTokenizer(line," ");
			int x=Integer.parseInt(st.nextToken());
			int y=Integer.parseInt(st.nextToken());
			ar[x].add(y);
			ar[y].add(x);
		}
		DFS(1);
		System.out.print(count);
	}
}
