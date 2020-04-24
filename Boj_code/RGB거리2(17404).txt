import java.io.*;
public class b_17404 {

	public static void main(String[] args)throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(bf.readLine());
		
		int r[][]=new int[N][3];
		int g[][]=new int[N][3];
		int b[][]=new int[N][3];
		int max=10000000;
		
		for(int i=0;i<N;i++) {
			String arr[]=bf.readLine().split(" ");
			for(int j=0;j<3;j++) {
				if(i==0) {
					r[i][j]=Integer.parseInt(arr[0]);
					g[i][j]=Integer.parseInt(arr[1]);
					b[i][j]=Integer.parseInt(arr[2]);
					continue;
				}
				if(i==1) {
					if(j==0) {
						r[i][j]=max;
						g[i][j]=r[i-1][0]+Integer.parseInt(arr[1]);
						b[i][j]=r[i-1][0]+Integer.parseInt(arr[2]);
					}
					else if(j==1) {
						r[i][j]=g[i-1][0]+Integer.parseInt(arr[0]);
						g[i][j]=max;
						b[i][j]=g[i-1][0]+Integer.parseInt(arr[2]);
					}
					else {
						r[i][j]=b[i-1][0]+Integer.parseInt(arr[0]);
						g[i][j]=b[i-1][0]+Integer.parseInt(arr[1]);
						b[i][j]=max;
					}
					continue;
				}
				r[i][j]=Math.min(g[i-1][j], b[i-1][j])+Integer.parseInt(arr[0]);
				g[i][j]=Math.min(r[i-1][j], b[i-1][j])+Integer.parseInt(arr[1]);
				b[i][j]=Math.min(g[i-1][j], r[i-1][j])+Integer.parseInt(arr[2]);
				
			}
			if(i==N-1) {
				r[i][0]=max;
				g[i][1]=max;
				b[i][2]=max;
			}
		}
		int min=max;
		for(int i=0;i<3;i++) {
			if(r[N-1][i]<min)
				min=r[N-1][i];
			if(g[N-1][i]<min)
				min=g[N-1][i];
			if(b[N-1][i]<min)
				min=b[N-1][i];
		}
		System.out.print(min);
	}
}
