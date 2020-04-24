import java.io.*;
public class b_2447 {

	public static void main(String[] args) throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		
		int count=Integer.parseInt(bf.readLine());
		int temp=3;
		int three=0;
		while(true) {
			if(temp>=count)
				break;
			temp*=3;
			three++;
		}
		boolean arr[][][]=new boolean[three+1][count][count];
		
		for(int i=0;i<3;i++) { //초기값 세팅
			for(int j=0;j<3;j++) {
				if(i==1 && j==1) {
					continue;
				}
				arr[0][i][j]=true;
			}
		}
		
		int length=3;
		
		for(int i=1;i<=three;i++) {
			for(int r=0;r<3;r++) {
				for(int c=0;c<3;c++) {
					if(r==1 && c==1)
						continue;
					for(int x=0;x<length;x++) {
						for(int y=0;y<length;y++) {
							arr[i][x+(r*length)][y+(c*length)]=arr[i-1][x][y];
						}
					}
				}
			}
			length*=3;
		}
		
		for(int i=0;i<count;i++) {
			for(int j=0;j<count;j++) {
				if(arr[three][i][j]==true) {
					sb.append("*");
				}
				else
					sb.append(" ");
			}
			sb.append("\n");
		}
		
		System.out.print(sb);
	}
}
