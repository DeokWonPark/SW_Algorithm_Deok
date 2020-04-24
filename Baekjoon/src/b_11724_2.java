import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;
public class b_11724_2 {
	static boolean check[];
	static ArrayList<Integer> ar[];
	
	static void DFS(int start) {
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
		String lines[]=bf.readLine().split(" ");
		int N=Integer.parseInt(lines[0]);
		int E=Integer.parseInt(lines[1]);
		
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
		int result=0;
		for(int i=1;i<=N;i++) {
			if(!check[i]) {
				DFS(i);
				result++;
			}
		}
		System.out.print(result);
	}
}
