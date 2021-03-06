import java.io.*;
import java.util.*;
public class b_1260_2 {

	static int N,M,start;
	static boolean check1[],check2[];
	static ArrayList<Integer>graph[];
	static StringBuilder sb=new StringBuilder();
	
	static void DFS(int start) {
		check1[start]=true;
		sb.append(start+" ");
		for(int i=0;i<graph[start].size();i++) {
			int y=graph[start].get(i);
			if(!check1[y]) {
				DFS(y);
			}
		}
	}
	
	static void BFS(int start) {
		Queue<Integer>q=new LinkedList<Integer>();
		check2[start]=true;
		q.offer(start);
		while(!q.isEmpty()) {
			int x=q.poll();
			sb.append(x+" ");
			for(int i=0;i<graph[x].size();i++) {
				int y=graph[x].get(i);
				if(!check2[y]) {
					check2[y]=true;
					q.offer(y);
				}
			}
		}
	}
	
	public static void main(String[] args)throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		String line=bf.readLine();
		StringTokenizer st=new StringTokenizer(line," ");
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		start=Integer.parseInt(st.nextToken());
		check1=new boolean[N+1];
		check2=new boolean[N+1];
		graph=(ArrayList<Integer>[])new ArrayList[N+1];
		for(int i=1;i<=N;i++) {
			graph[i]=new ArrayList<Integer>();
		}
		
		for(int i=0;i<M;i++) { //그래프 초기화 작업
			line=bf.readLine();
			StringTokenizer sts=new StringTokenizer(line," ");
			int x,y;
			x=Integer.parseInt(sts.nextToken());
			y=Integer.parseInt(sts.nextToken());
			graph[x].add(y);graph[y].add(x);
		}
		
		for(int i=1;i<=N;i++) {
			Collections.sort(graph[i]);
		}
		
		DFS(start);
		sb.append("\n");
		BFS(start);
		System.out.print(sb);
	}
}
