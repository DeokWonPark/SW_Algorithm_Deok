import java.util.*;
import java.io.*;

class dfsbfs{
	int vertex;
	int edge;
	int start_v;
	boolean check[];
	ArrayList<Integer>[]ar;
	StringBuilder sb=new StringBuilder();
	dfsbfs(int v,int e,int s){
		this.vertex=v;
		this.edge=e;
		this.start_v=s;
		check=new boolean[v+1];
		ar=(ArrayList<Integer>[])new ArrayList[v+1];
		for(int i=1;i<=v;i++) {
			ar[i]=new ArrayList<Integer>();
		}
	}
	void init(int n1,int n2) {
		ar[n1].add(n2);
		ar[n2].add(n1);
	}
	void sort() {
		for(int i=1;i<=vertex;i++) {
			Collections.sort(ar[i]);
		}
	}
	void dfs(int x) {
		check[x]=true;
		sb.append(x+" ");
		for(int i=0;i<ar[x].size();i++) {
			int y=ar[x].get(i);
			if(check[y]==false) {
				dfs(y);
			}
		}
	}
	void bfs(int x) {
		check[x]=true;
		LinkedList<Integer>queue=new LinkedList<Integer>();
		queue.offer(x);
		while(!queue.isEmpty()) {
			int z=queue.pop();
			sb.append(z+" ");
			for(int i=0;i<ar[z].size();i++) {
				int y=ar[z].get(i);
				if(check[y]==false) {
					check[y]=true;
					queue.offer(y);
				}
			}
		}
	}
}
public class b_1260 {

	public static void main(String[] args) throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		String line=bf.readLine();
		StringTokenizer st=new StringTokenizer(line);
		int vertex=Integer.parseInt(st.nextToken());
		int edge=Integer.parseInt(st.nextToken());;
		int start_v=Integer.parseInt(st.nextToken());
		
		dfsbfs search=new dfsbfs(vertex,edge,start_v);
		for(int i=0;i<edge;i++) {
			String lines[]=bf.readLine().split(" ");
			search.init(Integer.parseInt(lines[0]), Integer.parseInt(lines[1]));
		}
		search.sort();
		search.dfs(start_v);
		search.sb.append("\n");
		for(int i=1;i<=vertex;i++) {
			search.check[i]=false;
		}
		search.bfs(start_v);
		System.out.print(search.sb);
	}

}
