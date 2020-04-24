import java.io.*;
public class b_10994 {

	public static void main(String[] args) throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		
		int count=Integer.parseInt(bf.readLine());
		if(count==1) {
			System.out.print("*");
			return;
		}

		boolean arr[][][]=new boolean[count-1][4*(count-1)+1][4*(count-1)+1];
		
		for(int i=0;i<count-1;i++) {
			int length=4*(i+1)+1;
			for(int j=0;j<length;j++) {
				for(int l=0;l<length;l++) {
					if(j==0 || j==length-1) {
						arr[i][j][l]=true;
					}
					else {
						if(l==0 || l==length-1) {
							arr[i][j][l]=true;
						}
					}
			
					if(j>=2 && j<=length-3) {
						if(l>=2 && l<=length-3) {
							if(i==0) {
								arr[i][j][l]=true;
								continue;
							}
							arr[i][j][l]=arr[i-1][j-2][l-2];
						}
					}
				}
			}
		}
		
		for(int i=0;i<4*(count-1)+1;i++) {
			for(int j=0;j<4*(count-1)+1;j++) {
				if(arr[count-2][i][j]==true) {
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
