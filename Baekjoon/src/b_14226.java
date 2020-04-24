import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class sk{
	int s;
	int k;
	sk(int s_,int k_){
		this.s=s_;
		this.k=k_;
	}
}

public class b_14226 {
	
	static int check[][];
	
	static int BFS(sk node,int size,int S) {
		check[node.s][node.k]=1;
		Queue<sk> q=new LinkedList<sk>();
		q.add(node);
		
		while(!q.isEmpty()) {
			sk y=q.poll();
			if(y.s==S) {
				return check[y.s][y.k];
			}
			if(y.s+y.k>=0) {
				if(check[y.s+y.k][y.k]==0) {
					check[y.s+y.k][y.k]=check[y.s][y.k]+1;
					sk y_=new sk(y.s+y.k,y.k);
					q.add(y_);
				}
			}
			
			if(y.s-1>=0) {
				if(check[y.s-1][y.k]==0) {
					check[y.s-1][y.k]=check[y.s][y.k]+1;
					sk y_=new sk(y.s-1,y.k);
					q.add(y_);
				}
			}
			
			if(check[y.s][y.s]==0) {
				check[y.s][y.s]=check[y.s][y.k]+1;
				sk y_=new sk(y.s,y.s);
				q.add(y_);
			}
		}
		return -1;
	}

	public static void main(String[] args)throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		
		int S=Integer.parseInt(bf.readLine());
		
		int size=10*S+1;
		check=new int[size][size];
		sk start=new sk(1,0);
		
		System.out.print(BFS(start,size,S)-1);
	}
}
