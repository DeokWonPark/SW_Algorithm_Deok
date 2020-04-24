import java.io.*;
public class b_4963 {

	static int H,W;
	static void DFS(int x,int y,boolean check[][],boolean map[][]) {
		check[x][y]=true;
		for(int i=x-1;i<=x+1;i++) {
			if(i<0 || i>=H)
				continue;
			for(int j=y-1;j<=y+1;j++) {
				if(j<0 || j>=W)
					continue;
				if(check[i][j]==false && map[i][j]==true)
					DFS(i,j,check,map);
			}
		}
		
	}
	public static void main(String[] args)throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		while(true) {
			String lines[]=bf.readLine().split(" ");
			W=Integer.parseInt(lines[0]);
			H=Integer.parseInt(lines[1]);
			if(W==0 && H==0)
				break;
			
			boolean check[][]=new boolean[H][W];
			boolean map[][]=new boolean[H][W];
			
			for(int i=0;i<H;i++) {
				String line[]=bf.readLine().split(" ");
				for(int j=0;j<W;j++) {
					if(line[j].equals("1"))
						map[i][j]=true;
				}
			}
			int result=0;
			for(int i=0;i<H;i++) {
				for(int j=0;j<W;j++) {
					if(check[i][j]==false && map[i][j]==true) {
						DFS(i,j,check,map);
						result++;
					}
				}
			}
			sb.append(result+"\n");
		}
		System.out.print(sb);
	}
}
