import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
class algo{
	int x,y,length;
	
	algo(int x_,int y_,int length_){
		this.x=x_;
		this.y=y_;
		this.length=length_;
	}
}
public class b_1261 {
	
	static int go[][]= {{1,0},{-1,0},{0,1},{0,-1}};
	
	private static int BFS(algo start,int map[][],int M,int N,boolean check[][]) {
		check[start.x][start.y]=true;
		Deque<algo> q=new ArrayDeque<algo>();
		q.add(start);
		
		while(!q.isEmpty()) {
			algo y=q.poll();
			
			if(y.x==N-1 && y.y==M-1) {
				return y.length;
			}
			for(int i=0;i<4;i++) {
				if(y.x+go[i][0]>=0 && y.x+go[i][0]<N && y.y+go[i][1]>=0 && y.y+go[i][1]<M) {
					if(check[y.x+go[i][0]][y.y+go[i][1]]==false) {
						algo y_n=new algo(y.x+go[i][0],y.y+go[i][1],y.length);
						if(map[y_n.x][y_n.y]==0) {
							check[y_n.x][y_n.y]=true;
							q.addFirst(y_n);
						}
						else {
							check[y_n.x][y_n.y]=true;
							y_n.length+=1;
							q.add(y_n);
						}
					}
				}
			}
		}
		return -1;
	}

	public static void main(String[] args)throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		
		String lines[]=bf.readLine().split(" ");
		int M=Integer.parseInt(lines[0]);
		int N=Integer.parseInt(lines[1]);
		
		int map[][]=new int[N][M];
		
		for(int i=0;i<N;i++) {
			String line=bf.readLine();
			for(int j=0;j<M;j++) {
				map[i][j]=Integer.parseInt(line.substring(j,j+1));
			}
		}
		boolean check[][]=new boolean[N][M];
		
		algo s=new algo(0,0,0);
		System.out.print(BFS(s,map,M,N,check));
	}
}
