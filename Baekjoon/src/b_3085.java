import java.io.*;
public class b_3085 {
	
	static int count(char arr[][],int N,int max) {
		int s=1;
		for(int r=0;r<N;r++) {
			s=1;
			for(int h=0;h<N-1;h++) {
				if(arr[r][h]==arr[r][h+1]) {
					s++;
					if(h==N-2) {
						if(max<s) {
							max=s;
							s=1;
						}
					}
				}
				else {
					if(max<s) {
						max=s;
					}
					s=1;
				}
			}
			s=1;
			for(int h=0;h<N-1;h++) {
				if(arr[h][r]==arr[h+1][r]) {
					s++;
					if(h==N-2) {
						if(max<s) {
							max=s;
							s=1;
						}
					}
				}
				else {
					if(max<s) {
						max=s;
					}
					s=1;
				}
			}	
		}
		return max;
	}

	public static void main(String[] args) throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(bf.readLine());
		char arr[][]=new char[N][N];
		for(int i=0;i<N;i++) {
			String line=bf.readLine();
			for(int j=0;j<N;j++) {
				arr[i][j]=line.charAt(j);
			}
		}
		
		int max=1;
		
		for(int i=0;i<N;i++) {
			char temp;
			for(int j=0;j<N;j++) {
				
				if(j!=N-1) {
					temp=arr[i][j];
					arr[i][j]=arr[i][j+1];
					arr[i][j+1]=temp;
					
					max=count(arr,N,max);
					arr[i][j+1]=arr[i][j];
					arr[i][j]=temp;
				}
			}
			
			for(int j=0;j<N;j++) {
				temp=arr[i][j];
				
				if(i!=N-1) {
					temp=arr[i][j];
					arr[i][j]=arr[i+1][j];
					arr[i+1][j]=temp;
					
					max=count(arr,N,max);
					arr[i+1][j]=arr[i][j];
					arr[i][j]=temp;
				}
				
			}
		}
		System.out.print(max);
	}
}
