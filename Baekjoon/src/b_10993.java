import java.io.*;
public class b_10993 {

	public static void main(String[] agrs) throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		
		int count=Integer.parseInt(bf.readLine());
		if(count==1) {
			System.out.print("*");
			return;
		}
		int H,W;
		H=1;
		
		for(int i=1;i<count;i++) {
			H=H*2+1;
		}
		W=2*H-1;
		byte arr[][][]=new byte[count-1][H][W];
		
		int h=1;
		for(int i=0;i<count-1;i++) {
			int h_c=2*h+1;
			int w=2*h_c-1;
			
			if(i%2!=0) { //올바른 삼각형
				int right=0;
				int left=0;
				int start=0;
				for(int j=0;j<h_c-1;j++) {
					if(j==0) {
						arr[i][j][2*h]=100;
						right=2*h+1;
						left=2*h-1;
						continue;
					}
					if(j>=h) { //전 삼각형 채우기
						if(j==h) {
							start=left;
						}
						for(int l=1;l<=2*h-1;l++) {
							arr[i][j][start+l]=(byte) (arr[i-1][j-h][l-1]-1);
						}
					}
					arr[i][j][right++]=100;
					arr[i][j][left--]=30;
				}
				
				for(int j=0;j<w;j++) {
					arr[i][h_c-1][j]=30;
				}

				
				h=h_c;
			}
			
			
			else { //역삼각형
				int right=w-2;
				int left=1;
				int check=0;
				int start=0;
				for(int j=0;j<w;j++) {
					arr[i][0][j]=30;
				}
				for(int j=1;j<h_c-1;j++) {
					if(j<=h) {
						if(j==h) {
							start=left;
						}
						if(i==0) {
							if(check==0) {
								arr[i][j][left+1]=30;
								check++;
							}
						}
						else {
							for(int l=1;l<=2*h-1;l++) {
								arr[i][j][h+l]=(byte) (arr[i-1][check][l-1]-1);
							}
							check++;
						}
					}
					arr[i][j][right--]=100;
					arr[i][j][left++]=30;
				}
				arr[i][h_c-1][right]=100;		
				
				h=h_c;
			}
		}
		
		
		for(int i=0;i<H;i++) {
			for(int j=0;j<W;j++) {
				if(arr[count-2][i][j]>=1) {
					sb.append("*");
					if(arr[count-2][i][j]>=100) {
						break;
					}
						
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
