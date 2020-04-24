import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
class tomato{
	int x;
	int y;
	int count;
	tomato(int x,int y,int count){
		this.x=x;
		this.y=y;
		this.count=count;
	}
}
public class b_7576 {

	static int N,M;
	static int map[][];
	static ArrayList<tomato> ar;
	static int count=0;
	
	static void BFS() {
		Queue<tomato> q=new LinkedList<tomato>();
		for(int i=0;i<ar.size();i++) {
			tomato tok=ar.get(i);
			q.offer(tok);
		}
		while(!q.isEmpty()) {
			tomato Y=q.poll();
			if(Y.x-1>=0) {
				if(map[Y.x-1][Y.y]==0) {
					tomato go=new tomato(Y.x-1,Y.y,Y.count+1);
					map[Y.x-1][Y.y]=1;
					q.offer(go);
				}
			}
			if(Y.y-1>=0) {
				if(map[Y.x][Y.y-1]==0) {
					tomato go=new tomato(Y.x,Y.y-1,Y.count+1);
					map[Y.x][Y.y-1]=1;
					q.offer(go);
				}
			}
			if(Y.x+1<N) {
				if(map[Y.x+1][Y.y]==0) {
					tomato go=new tomato(Y.x+1,Y.y,Y.count+1);
					map[Y.x+1][Y.y]=1;
					q.offer(go);
				}
			}
			if(Y.y+1<M) {
				if(map[Y.x][Y.y+1]==0) {
					tomato go=new tomato(Y.x,Y.y+1,Y.count+1);
					map[Y.x][Y.y+1]=1;
					q.offer(go);
				}
			}
			count=Y.count;
		}
	}
	public static void main(String[] args)throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		String lines[]=bf.readLine().split(" ");
		
		M=Integer.parseInt(lines[0]);
		N=Integer.parseInt(lines[1]);
		
		map=new int[N][M];
		ar=new ArrayList<tomato>();
		
		for(int i=0;i<N;i++) {
			String line=bf.readLine();
			StringTokenizer st=new StringTokenizer(line," ");
			for(int j=0;j<M;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				if(map[i][j]==1) {
					tomato tok=new tomato(i,j,0);
					ar.add(tok);
				}
			}
		}
		BFS();
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j]==0) {
					System.out.print(-1);
					return;
				}
			}
		}
		System.out.print(count);
	}
}
