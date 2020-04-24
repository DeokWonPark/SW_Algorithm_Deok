import java.io.*;
public class b_10997 {

	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		
		int count=Integer.parseInt(bf.readLine());
		
		if(count==1) {
			System.out.print("*");
			return;
		}
		
		boolean arr[][]=new boolean [(count-1)*4+3][(count-1)*4+1];
		int x=(count-1)*4,y=0;
		
		for(int i=0;i<count-1;i++) {
			
			//first
			for(int j=x;j>=i*2;j--) {
				arr[y][j]=true;
				x--;
			}
			x++;
			//second
			y++;
			for(int j=y;j<(count-1)*4+3-(2*i);j++) {
				arr[j][x]=true;
				y++;
			}
			y--;
			//three
			x++;
			for(int j=x;j<(count-1)*4+1-(2*i);j++) {
				arr[y][j]=true;
				x++;
			}
			x--;
			//four
			y--;
			for(int j=y;j>=2+(2*i);j--) {
				arr[j][x]=true;
				y--;
			}
			y++;
			x--;
		}
		arr[y][x]=true;
		arr[y][--x]=true;
		arr[++y][x]=true;
		arr[++y][x]=true;
		
		
		for(int i=0;i<(count-1)*4+3;i++) {
			for(int j=0;j<(count-1)*4+1;j++) {
				if(i==1 && j==1)
					break;
				if(arr[i][j]==true) {
					sb.append("*");
				}
				else {
					sb.append(" ");
				}
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}
}
