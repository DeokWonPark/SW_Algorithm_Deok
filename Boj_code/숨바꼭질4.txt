import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
public class b_13913 {
	
	static int check[];
	static int pre[];
	
	static int BFS(int node,int k,ArrayList<Integer>[] ar) {
		Queue<Integer> q=new LinkedList<Integer>();
		check[node]=0;
		pre=new int[100001];
		q.add(node);
		
		while(!q.isEmpty()) {
			int y=q.poll();
			if(k==y) {
				return check[y];
			}
			for(int i=0;i<ar[y].size();i++) {
				int y_=ar[y].get(i);
				if(check[y_]==0) {
					q.add(y_);
					check[y_]=check[y]+1;
					pre[y_]=y;
				}
			}
		}
		return -1;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		
		String line[]=bf.readLine().split(" ");
		int N=Integer.parseInt(line[0]);
		int K=Integer.parseInt(line[1]);
		
		int max=Math.max(N, K);
		int min=Math.min(N, K);
		check=new int[100001];
		
		ArrayList<Integer> ar[]=(ArrayList<Integer>[])new ArrayList[100001];
		
		for(int i=0;i<100001;i++) {
			ar[i]=new ArrayList<Integer>();
		}
		
		for(int i=0;i<=100000;i++) {
			if(i-1>=0) {
				ar[i].add(i-1);
			}
			if(i+1<100001) {
				ar[i].add(i+1);
			}
			if(i*2<100001) {
				ar[i].add(i*2);
			}
		}
		
		sb.append(BFS(N,K,ar)+"\n");
		if(N==K) {
			sb.append(N);
			System.out.print(sb);
			return;
		}
		Stack<Integer> sk=new Stack<Integer>();
		int p=K;
		while(true) {
			sk.push(p);
			p=pre[p];
			if(p==N) {
				sk.push(p);
				break;
			}
		}
		
		while(!sk.isEmpty()) {
			sb.append(sk.pop()+" ");
		}
		System.out.print(sb);
	}

}
