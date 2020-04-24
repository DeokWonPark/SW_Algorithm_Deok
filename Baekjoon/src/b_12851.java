import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
public class b_12851 {
	
	static int check[];
	static ArrayList<Integer> result;
	
	static void BFS(int node,int k,ArrayList<Integer>[] ar) {
		Queue<Integer> q=new LinkedList<Integer>();
		check[node]=0;
		q.add(node);
		
		while(!q.isEmpty()) {
			int y=q.poll();
			if(k==y) {
				result.add(check[y]);
			}
			for(int i=0;i<ar[y].size();i++) {
				int y_=ar[y].get(i);
				if(check[y_]==0 || y_==k) {
					q.add(y_);
					check[y_]=check[y]+1;
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		
		String line[]=bf.readLine().split(" ");
		int N=Integer.parseInt(line[0]);
		int K=Integer.parseInt(line[1]);
		
		int max=Math.max(N, K);
		int min=Math.min(N, K);
		check=new int[100001];
		result=new ArrayList<Integer>();
		
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
		
		BFS(N,K,ar);
		Collections.sort(result);
		int length=1;
		int small=result.get(0);
		for(int i=1;i<result.size();i++) {
			if(small==result.get(i)) {
				length++;
			}
			else
				break;
		}
		System.out.print(small+"\n"+length);
	}

}
