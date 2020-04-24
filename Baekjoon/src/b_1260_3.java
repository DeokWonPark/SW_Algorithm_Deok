import java.io.*;
import java.util.*;
public class b_1260_3 {

	static int N,M,start;
	static boolean check1[],check2[];
	static String Es[];
	static int E[][];
	static int cnt[];
	static StringBuilder sb=new StringBuilder();
	
	static void DFS(int start) {
		check1[start]=true;
		sb.append(start+" ");
		for(int i=cnt[start-1];i<cnt[start];i++) {
			int y=E[i][1];
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
			for(int i=cnt[x-1];i<cnt[x];i++) {
				int y=E[i][1];
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
		Es=new String[M];
		E=new int[M][2];
		cnt=new int[N+1];
		
		for(int i=0;i<M;i++) { 
			Es[i]=bf.readLine();
		}
		Arrays.sort(Es);
		for(int i=0;i<M;i++) { 
			StringTokenizer sts=new StringTokenizer(Es[i]," ");
			E[i][0]=Integer.parseInt(sts.nextToken());
			E[i][1]=Integer.parseInt(sts.nextToken());
			cnt[E[i][0]]++;
		}
		
		for(int i=1;i<=N;i++) {
			cnt[i]+=cnt[i-1];
		}
		
		
		DFS(start);
		sb.append("\n");
		BFS(start);
		System.out.print(sb);
	}
}
