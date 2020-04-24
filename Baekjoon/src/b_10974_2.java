import java.io.*;
public class b_10974_2 {
	static int N;
	static int arr[];
	static boolean check[];
	static StringBuilder sb=new StringBuilder();

	private static void N_M(int start) {
		if(start==N) {
			for(int i=0;i<N-1;i++) {
				sb.append(arr[i]+" ");
			}
			sb.append(arr[N-1]+"\n");
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
		N=Integer.parseInt(bf.readLine());
		arr=new int[N];
		check=new boolean[N+1];
		N_M(0);
		System.out.print(sb);
	}
}
