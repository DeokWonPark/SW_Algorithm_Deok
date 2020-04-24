import java.util.*;
import java.io.*;

class graph{
	int node;
	int edge;
	int count;
	ArrayList<Integer> ar[];
	ArrayList<Integer> check;
	graph(int v,int e){
		this.node=v;
		this.edge=e;
		count=0;
		ar=(ArrayList<Integer>[])new ArrayList[v+1];
		for(int i=1;i<=v;i++) {
			ar[i]=new ArrayList<Integer>();
		}
		check=new ArrayList<Integer>();
	}
	void init(int n1,int n2) {
		ar[n1].add(n2);
		ar[n2].add(n1);
	}
	void dfs(int x) {
		check.add(x);
		for(int i=0;i<ar[x].size();i++) {
			int y=ar[x].get(i);
			if(!check.contains(y)) {
				dfs(y);
			}
		}
	}
	void bfs(int x) {
		check.add(x);
		LinkedList<Integer> queue=new LinkedList<Integer>();
		queue.offer(x);
		while(!queue.isEmpty()) {
			int z=queue.pop();
			for(int i=0;i<ar[z].size();i++) {
				int y=ar[z].get(i);
				if(!check.contains(y)) {
					check.add(y);
					queue.offer(y);
				}
			}
		}
	}
	int linkcount() {
		int i=1;
		while(check.size()<node) {
			if(!check.contains(i)) {
				bfs(i);
				count++;
			}
			i++;
		}
		return count;
	}
}
public class b_11724 {

	public static void main(String []args) throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		String [] lines=bf.readLine().split(" ");
		int vertex=Integer.parseInt(lines[0]);
		int edge=Integer.parseInt(lines[1]);
		graph gp=new graph(vertex,edge);
		for(int i=0;i<edge;i++) {
			String line[]=bf.readLine().split(" ");
			gp.init(Integer.parseInt(line[0]), Integer.parseInt(line[1]));
		}
		System.out.print(gp.linkcount());
	}
}
