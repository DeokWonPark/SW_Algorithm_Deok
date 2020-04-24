import java.io.*;
import java.util.StringTokenizer;
public class b_2146 {
	static int N;
	static int map[][];
	static int group[][];
	static int go[][]= {{-1,0},{1,0},{0,-1},{0,1}};

	static void DFS(int x,int y,int group_num) {
		group[x][y]=group_num;
		
		for(int i=0;i<4;i++) {
			int x_,y_;
			x_=go[i][0];
			y_=go[i][1];
			if(x+x_>=0 && x+x_<N && y+y_>=0 && y+y_<N) {
				if(map[x+x_][y+y_]==1 && group[x+x_][y+y_]==0) {
					DFS(x+x_,y+y_,group_num);
				}
			}
		}
	}
	public static void main(String[] args)throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		
		N=Integer.parseInt(bf.readLine());
		map=new int[N][N];
		group=new int[N][N];
		
		// 지도 초기화
		for(int i=0;i<10;i++) {
			String line=bf.readLine();
			StringTokenizer st=new StringTokenizer(line," ");
			for(int j=0;j<10;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		int group_n=1;
		
		for(int i=0;i<10;i++) {
			for(int j=0;j<10;j++) {
				if(map[i][j]==1 && group[i][j]==0) {
					DFS(i,j,group_n++);
				}
			}
		}
		System.out.print("\n");
		System.out.print("\n");
		for(int i=0;i<10;i++) {
			for(int j=0;j<10;j++) {
				System.out.print(group[i][j]+" ");
			}
			System.out.print("\n");
		}
	}
}
