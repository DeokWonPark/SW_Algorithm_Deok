import java.io.*;
import java.util.*;
class nite{
	int x;
	int y;
	int count;
	nite(int x,int y,int count){
		this.x=x;
		this.y=y;
		this.count=count;
	}
}
public class b_7562 {
	
	static int count=0;
	
	static void BFS(nite start,int endx,int endy,boolean check[][],int N) {
		check[start.x][start.y]=true;
		Queue<nite> q=new LinkedList<nite>();
		int mask[][]= {{-2,-1},{-2,1},{-1,-2},{-1,2},{1,-2},{1,2},{2,-1},{2,1}};
		q.offer(start);
		while(!q.isEmpty()) {
			nite Y=q.poll();
			if(Y.x==endx && Y.y==endy) {
				count=Y.count;
				return;
			}
			for(int i=0;i<8;i++) {
				int x=mask[i][0];
				int y=mask[i][1];
				if(Y.x+x>=0 && Y.x+x<N && Y.y+y>=0 && Y.y+y<N) {
					if(check[Y.x+x][Y.y+y]==false) {
						check[Y.x+x][Y.y+y]=true;
						nite go=new nite(Y.x+x,Y.y+y,Y.count+1);
						q.offer(go);
					}
				}
			}
		}
	}

	public static void main(String[] args)throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		int iter=Integer.parseInt(bf.readLine());
		for(int c=0;c<iter;c++) {
			count=0;
			int N=Integer.parseInt(bf.readLine());
			
			boolean check[][]=new boolean[N][N];
			
			String line1[]=bf.readLine().split(" ");
			int x=Integer.parseInt(line1[0]);
			int y=Integer.parseInt(line1[1]);
			
			String line2[]=bf.readLine().split(" ");
			int end_x=Integer.parseInt(line2[0]);
			int end_y=Integer.parseInt(line2[1]);
			
			nite start=new nite(x,y,0);
			BFS(start,end_x,end_y,check,N);
			sb.append(count+"\n");
		}
		System.out.print(sb);
	}
}
