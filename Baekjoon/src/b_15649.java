import java.io.*;
public class b_15649 {
	static int N,M;
	static boolean check[];
	static int arr[];
	static StringBuilder sb=new StringBuilder();
	
	static void N_M(int start) {
		if(start==M) {
			for(int i=0;i<arr.length-1;i++) {
				sb.append(arr[i]+" ");
			}
			sb.append(arr[arr.length-1]+"\n");
			return;
		}
		
		for(int i=1;i<=N;i++) {
			if(!check[i]) {
				check[i]=true;
				arr[start]=i;
				N_M(start+1);
				check[i]=false;
			}
		}
	}

	public static void main(String[] args)throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		String line[]=bf.readLine().split(" ");
		N=Integer.parseInt(line[0]);
		M=Integer.parseInt(line[1]);
		check=new boolean[N+1];
		arr=new int[M];
		N_M(0);
		System.out.print(sb);
	}
}
