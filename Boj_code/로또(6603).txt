import java.io.*;
import java.util.StringTokenizer;
public class b_6603 {

	private static int N;
	private static int arr[];
	private static StringBuilder sb=new StringBuilder();
	
	private static void rotto(int start,int value,int toks[]) {
		if(start==6) {
			for(int i=0;i<5;i++) {
				sb.append(arr[i]+" ");
			}
			sb.append(arr[5]+"\n");
			return;
		}
		
		for(int i=value;i<=N-6+start;i++) {
			arr[start]=toks[i];
			rotto(start+1,i+1,toks);
		}
	}
	
	public static void main(String[] args)throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			String line=bf.readLine();
			if(line.equals("0")) {
				break;
			}
			StringTokenizer st=new StringTokenizer(line," ");
			N=Integer.parseInt(st.nextToken());
			arr=new int[6];
			int toks[]=new int[N];
			for(int i=0;i<N;i++) {
				toks[i]=Integer.parseInt(st.nextToken());
			}
			rotto(0,0,toks);
			sb.append("\n");
		}
		System.out.print(sb);
	}
}
