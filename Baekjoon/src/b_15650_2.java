import java.io.*;
public class b_15650_2 {

	static int N,M;
	static int arr[];
	static StringBuilder sb=new StringBuilder();
	
	static void N_M(int start,int m) {
		if(m==M) {
			for(int i=0;i<M-1;i++) {
				sb.append(arr[i]+" ");
			}
			sb.append(arr[M-1]+"\n");
			return;
		}
		if(start>N)
			return;
		arr[m]=start;
		N_M(start+1,m+1);
		N_M(start+1,m);
	}
	
	public static void main(String[] args)throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		String line[]=bf.readLine().split(" ");
		N=Integer.parseInt(line[0]);
		M=Integer.parseInt(line[1]);
		
		arr=new int[M];
		N_M(1,0);
		System.out.print(sb);
	}
}
