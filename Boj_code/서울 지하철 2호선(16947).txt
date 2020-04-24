import java.io.*;
import java.util.*;
public class b_16947 {

	static int N;
	static ArrayList<Integer> ar[];
	static int cycle[];
	static int flag=0;
	static int point=0;
	
	static void DFS(int start,int pr) {
		cycle[start]++;
		if(cycle[start]==2) {
			flag=1;
			point=start;
			return;
		}
		for(int i=0;i<ar[start].size();i++) {
			int y=ar[start].get(i);
			if(y!=pr) {
				DFS(y,start);
				if(start==point)
					flag=2;
				
				if(flag==1) {
					cycle[start]++;
					return;
				}
				else if(flag==2) {
					return;
				}
			}
		}
	}
	
	static int BFS(int start) {
		boolean check[]=new boolean[N+1];
		int dist[]=new int[N+1];
		Queue<Integer> q=new LinkedList<Integer>();
		check[start]=true;
		q.offer(start);

		while(!q.isEmpty()) {
			int y=q.poll();
			if(cycle[y]==2) {
				return dist[y];
			}
			for(int i=0;i<ar[y].size();i++) {
				int x=ar[y].get(i);
				if(!check[x]) {
					q.offer(x);
					dist[x]=dist[y]+1;
					check[x]=true;
				}
			}
		}
		return -1;
	}
	
	public static void main(String[] args)throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		
		N=Integer.parseInt(bf.readLine());
		ar=(ArrayList<Integer>[])new ArrayList[N+1];
		for(int i=1;i<=N;i++) {
			ar[i]=new ArrayList<Integer>();
		}
		
		for(int i=0;i<N;i++) {
			String line=bf.readLine();
			StringTokenizer st=new StringTokenizer(line," ");
			int x=Integer.parseInt(st.nextToken());
			int y=Integer.parseInt(st.nextToken());
			
			ar[x].add(y);
			ar[y].add(x);
		}
		cycle=new int[N+1];
		DFS(1,-1);
		
		for(int i=1;i<=N;i++) {
			if(cycle[i]==2) {
				sb.append(0+" ");
			}
			else {
				sb.append(BFS(i)+" ");
			}
		}
		System.out.print(sb);
	}
}
