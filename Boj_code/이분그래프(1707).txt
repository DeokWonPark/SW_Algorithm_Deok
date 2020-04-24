import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;
public class b_1707{
	static void DFS(int start,int where, ArrayList<Integer> ar[],int check[]) {
		if(where==1) {
			check[start]=2;
		}
		else {
			check[start]=1;
		}
		for(int i=0;i<ar[start].size();i++) {
			int y=ar[start].get(i);
			if(check[y]==0) {
				DFS(y,check[start],ar,check);
			}
		}
	}
	
	public static void main(String[] args)throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		int count=Integer.parseInt(bf.readLine());
		
		for(int c=0;c<count;c++) {
			String lines[]=bf.readLine().split(" ");
			int N=Integer.parseInt(lines[0]);
			int E=Integer.parseInt(lines[1]);
			
			int check[]=new int[N+1];
			ArrayList<Integer>ar[]=(ArrayList<Integer>[])new ArrayList[N+1];
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
			for(int i=1;i<=N;i++) {
				if(check[i]==0) {
					DFS(i,0,ar,check);
				}
			}
			
			boolean flag=false;
			for(int i=1;i<=N;i++) {
				for(int j=0;j<ar[i].size();j++) {
					int y=ar[i].get(j);
					if(check[i]==check[y]) {
						flag=true;
						break;
					}
				}
				if(flag==true)
					break;
			}
			if(flag) {
				sb.append("NO\n");
			}
			else
				sb.append("YES\n");
		}
		System.out.print(sb);
	}
}