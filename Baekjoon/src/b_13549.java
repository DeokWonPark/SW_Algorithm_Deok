import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
public class b_13549 {
	
	static int check[];
	
	static int BFS(int node,int k,ArrayList<Integer>[] ar) {
		Deque<Integer> q=new ArrayDeque<Integer>();
		check[node]=1;
		q.add(node);
		
		while(!q.isEmpty()) {
			int y=q.poll();
			if(k==y) {
				return check[y];
			}
			for(int i=0;i<ar[y].size();i++) {
				int y_=ar[y].get(i);
				if(check[y_]==0) {
					if(y*2==y_) {
						q.addFirst(y_);
						check[y_]=check[y];
					}
					else {
						q.add(y_);
						check[y_]=check[y]+1;
					}
				}
			}
		}
		return -1;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		
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
		
		System.out.print(BFS(N,K,ar)-1);
	}

}
