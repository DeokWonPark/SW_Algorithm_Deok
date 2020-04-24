import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
public class b_16940 {

	public static void main(String[] args)throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(bf.readLine());
		
		ArrayList<Integer>ar[]=(ArrayList<Integer>[])new ArrayList[N+1];
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
		
		Queue<Integer> q=new LinkedList<Integer>();
		Queue<Integer> temp=new LinkedList<Integer>();
		int parent[]=new int[N+1];
		parent[1]=100;
		
		for(int i=0;i<lines.length;i++) {
			q.add(Integer.parseInt(lines[i]));
			temp.add(Integer.parseInt(lines[i]));
		}
		int first=temp.poll();
		if(first!=1) {
			System.out.print("0");
			return;
		}
		
		while(!q.isEmpty()) {
			int point=q.poll();
			if(q.isEmpty()) {
				break;
			}
			int len=ar[point].size();
			int pre_count=0;
			
			for(int i=0;i<len;i++) {
				int val=ar[point].get(i);
				if(parent[val]!=0) {
					pre_count++;
					continue;
				}
				parent[val]=point;
			}
			len-=pre_count;
			for(int i=0;i<len;i++) {
				int val=temp.poll();
				if(parent[val]!=point) {
					System.out.print("0");
					return;
				}
			}
		}
		System.out.print("1");
	}
}
