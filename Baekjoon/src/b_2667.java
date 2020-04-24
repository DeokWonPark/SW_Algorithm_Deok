import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
public class b_2667 {

	static boolean check[][];
	static boolean map[][];
	static int N;
	static int count;
	static void DFS(int x,int y) {
		check[x][y]=true;
		count++;
		if(x+1<N) {
			if(check[x+1][y]==false && map[x+1][y]==true) {
				DFS(x+1,y);
			}
		}
		if(x-1>=0) {
			if(check[x-1][y]==false && map[x-1][y]==true) {
				DFS(x-1,y);
			}
		}
		if(y+1<N) {
			if(check[x][y+1]==false && map[x][y+1]==true) {
				DFS(x,y+1);
			}
		}
		if(y-1>=0) {
			if(check[x][y-1]==false && map[x][y-1]==true) {
				DFS(x,y-1);
			}
		}
	}
	public static void main(String[] args)throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		N=Integer.parseInt(bf.readLine());
		check=new boolean[N][N];
		map=new boolean[N][N];
		
		for(int i=0;i<N;i++) {
			String line=bf.readLine();
			for(int j=0;j<N;j++) {
				if(line.charAt(j)=='1')
					map[i][j]=true;
			}
		}
		ArrayList<Integer> ar=new ArrayList<Integer>();
		int result=0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				count=0;
				if(check[i][j]==false && map[i][j]==true) {
					DFS(i,j);
					result++;
					ar.add(count);
				}
			}
		}
		sb.append(result+"\n");
		Collections.sort(ar);
		for(int i=0;i<ar.size();i++) {
			sb.append(ar.get(i)+"\n");
		}
		System.out.print(sb);
	}
}
