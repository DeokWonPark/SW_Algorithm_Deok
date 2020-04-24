import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
public class b_16964 {

	static int parent[];
	static int q[];
	static ArrayList<Integer> ar[];
	static int start=0;
	static boolean flag=false;
	
	static void DFS() {
		int val=q[start];
		int count=ar[val].size()-1;
		if(start==0)
			count++;
		for(int i=0;i<count;i++) {
			if(flag==true)
				return;
			int cal=q[start+1];
			if(val==parent[cal]) {
				start++;
				DFS();
			}
			else {
				System.out.print("0");
				flag=true;
				return;
			}
		}
	}
	
	public static void main(String[] args)throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		
		int N=Integer.parseInt(bf.readLine());
		ar=(ArrayList<Integer>[])new ArrayList[N+1];
		
		for(int i=1;i<=N;i++) {
			ar[i]=new ArrayList<Integer>();
		}
		
		for(int i=0;i<N-1;i++) {
			String line=bf.readLine();
			StringTokenizer st=new StringTokenizer(line," ");
			int x=Integer.parseInt(st.nextToken());
			int y=Integer.parseInt(st.nextToken());
			
			ar[x].add(y);
			ar[y].add(x);
		}
		
		String lines[]=bf.readLine().split(" ");
		q=new int[N];
		parent=new int[N+1];
		
		for(int i=0;i<lines.length;i++) {
			q[i]=Integer.parseInt(lines[i]);
		}
		if(q[0]!=1) {
			System.out.print("0");
			return;
		}
		
		for(int i=2;i<=N;i++) {
			Collections.sort(ar[i]);
			parent[i]=ar[i].get(0);
		}
		DFS();
		if(flag==true)
			return;
		System.out.print("1");
		
	}
}
