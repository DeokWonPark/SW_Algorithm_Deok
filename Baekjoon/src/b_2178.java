import java.io.*;
public class b_2178 {

	static int N,M;
	static int check[][];
	static boolean map[][];
	static int result=100000;
	
	static void DFS(int x,int y,int count) {
		if(x==N-1 && y==M-1) {
			if(result>count)
				result=count;
			return;
		}
		check[x][y]=count;
		if(x-1>=0) {
			if(check[x-1][y]>count+1 && map[x-1][y]==true)
				DFS(x-1,y,count+1);
		}
		if(x+1<N) {
			if(check[x+1][y]>count+1 && map[x+1][y]==true)
				DFS(x+1,y,count+1);
		}
		if(y-1>=0) {
			if(check[x][y-1]>count+1 && map[x][y-1]==true)
				DFS(x,y-1,count+1);
		}
		if(y+1<M) {
			if(check[x][y+1]>count+1 && map[x][y+1]==true)
				DFS(x,y+1,count+1);
		}
					
	}
	public static void main(String[] args)throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		String lines[]=bf.readLine().split(" ");
		N=Integer.parseInt(lines[0]);
		M=Integer.parseInt(lines[1]);
		
		check=new int[N][M];
		map=new boolean[N][M];
		
		for(int i=0;i<N;i++) {
			String line=bf.readLine();
			for(int j=0;j<M;j++) {
				if(line.charAt(j)=='1')
					map[i][j]=true;
			}
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				check[i][j]=100000;
			}
		}

		DFS(0,0,1);
		System.out.print(result);
	}
}
