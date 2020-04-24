import java.io.*;
public class b_9095_recursive {
	private static int N;
	private static int count;
	
	private static void Plus(int sum) {
		if(sum>N) {
			return;
		}
		if(sum==N) {
			count++;
			return;
		}
		
		for(int i=1;i<=3;i++) {
			Plus(sum+i);
		}
	}
	

	public static void main(String[] args)throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		int T=Integer.parseInt(bf.readLine());
		
		for(int i=0;i<T;i++) {
			N=Integer.parseInt(bf.readLine());
			int sum=0;
			count=0;
			Plus(sum);
			sb.append(count+"\n");
		}
		System.out.print(sb);
	}
}
