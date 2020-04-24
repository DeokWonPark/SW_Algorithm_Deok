import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class x_y{
	int x;
	int y;
	int count;
	x_y(int x,int y,int count){
		this.x=x;
		this.y=y;
		this.count=count;
	}
}

public class b_2178_bfs {

	static int N,M;
	static boolean check[][];
	static boolean map[][];
	static int count=0;
	
	static void BFS(int x,int y) {
		Queue<x_y> q=new LinkedList<x_y>();
		check[x][y]=true;
		x_y tok=new x_y(x,y,1);
		q.offer(tok);
		while(!q.isEmpty()) {
			x_y temp=q.poll();
			if(temp.x==N-1 && temp.y==M-1) {
				count=temp.count;
				break;
			}
			if(temp.x-1>=0) {
				if(check[temp.x-1][temp.y]==false && map[temp.x-1][temp.y]==true) {
					check[temp.x-1][temp.y]=true;
					x_y toki=new x_y(temp.x-1,temp.y,temp.count+1);
					q.offer(toki);
				}
			}
			if(temp.y-1>=0) {
				if(check[temp.x][temp.y-1]==false && map[temp.x][temp.y-1]==true) {
					check[temp.x][temp.y-1]=true;
					x_y toki=new x_y(temp.x,temp.y-1,temp.count+1);
					q.offer(toki);
				}
			}
			if(temp.x+1<N) {
				if(check[temp.x+1][temp.y]==false && map[temp.x+1][temp.y]==true) {
					check[temp.x+1][temp.y]=true;
					x_y toki=new x_y(temp.x+1,temp.y,temp.count+1);
					q.offer(toki);
				}	
			}
			if(temp.y+1<M) {
				if(check[temp.x][temp.y+1]==false && map[temp.x][temp.y+1]==true) {
					check[temp.x][temp.y+1]=true;
					x_y toki=new x_y(temp.x,temp.y+1,temp.count+1);
					q.offer(toki);
				}
			}
			count=temp.count;
		}
					
	}
	public static void main(String[] args)throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		String lines[]=bf.readLine().split(" ");
		N=Integer.parseInt(lines[0]);
		M=Integer.parseInt(lines[1]);
		
		check=new boolean[N][M];
		map=new boolean[N][M];
		
		for(int i=0;i<N;i++) {
			String line=bf.readLine();
			for(int j=0;j<M;j++) {
				if(line.charAt(j)=='1')
					map[i][j]=true;
			}
		}

		BFS(0,0);
		System.out.print(count);
	}
}
