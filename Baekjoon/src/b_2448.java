import java.io.*;
public class b_2448 {

	public static void main(String [] args)throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		
		int count=Integer.parseInt(bf.readLine());
		
		int k=0;
		int temp=3;
		
		while(true) {
			if(temp>=count) {
				break;
			}
			temp*=2;
			k++;
		}
		
		int rl=3;
		int cl=2*rl-1;
		int rl_f=(int)(rl*Math.pow(2,k));
		
		boolean arr[][][]=new boolean[k][rl_f][rl_f*2-1];
		boolean start[][]=new boolean[3][5];
		
		for(int i=0;i<rl;i++) {  //초기값 세팅
			for(int j=0;j<cl;j++) {
				if(i==0 && j==rl-1) {
					//arr[0][i][j]=true;
					start[i][j]=true;
					break;
				}
				else if(i==1) {
					if(j==rl || j==rl-2)
						start[i][j]=true;
						//arr[0][i][j]=true;

				}
				else if(i==2) {
					//arr[0][i][j]=true;
					start[i][j]=true;
				}
			}
		}
		if(count==3) {
			for(int i=0;i<3;i++) {
				for(int j=0;j<5;j++) {
					if(start[i][j]==true) {
						sb.append("*");
					}
					else
						sb.append(" ");
				}
				sb.append("\n");
			}
			
			System.out.print(sb);
			return;
		}
		
		
		for(int i=0;i<k;i++) {
			
			for(int r=0;r<rl;r++) {
				for(int c=0;c<cl;c++) {
					if(i==0) {
						arr[i][r][c+rl]=start[r][c];
						arr[i][r+rl][c]=start[r][c];
						arr[i][r+rl][c+cl+1]=start[r][c];
					}
					else {
						arr[i][r][c+rl]=arr[i-1][r][c];
						arr[i][r+rl][c]=arr[i-1][r][c];
						arr[i][r+rl][c+cl+1]=arr[i-1][r][c];
					}
				}
			}
			
			rl=2*rl;
			cl=2*rl-1;
		}
		
		for(int i=0;i<rl;i++) {
			for(int j=0;j<cl;j++) {
				if(arr[k-1][i][j]==true) {
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
