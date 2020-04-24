import java.io.*;
import java.util.StringTokenizer;
public class b_15661 {

	static int N;
	static int toks[][];
	static int min=100000;
	
	static void Team(int start,boolean arr[]) {
		if(start==N) {
			int sum1=0,sum2=0;
			for(int i=0;i<N;i++) {
				if(arr[i]==true) {
					for(int j=i;j<N;j++) {
						if(arr[j]==true) {
							sum1+=toks[i][j];
							sum1+=toks[j][i];
						}
					}
				}
				else {
					for(int j=i;j<N;j++) {
						if(arr[j]==false) {
							sum2+=toks[i][j];
							sum2+=toks[j][i];
						}
					}
				}
			}
			if(min>Math.abs(sum1-sum2)) {
				min=Math.abs(sum1-sum2);
			}
			return;
		}
		Team(start+1,arr);
		arr[start]=true;
		Team(start+1,arr);
		arr[start]=false;
	}
	public static void main(String[] args)throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(bf.readLine());
		boolean arr[]=new boolean[N];
		arr[0]=true;
		
		toks=new int[N][N];
		for(int i=0;i<N;i++) {
			String line=bf.readLine();
			StringTokenizer st=new StringTokenizer(line," ");
			for(int j=0;j<N;j++) {
				toks[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		Team(0,arr);
		System.out.print(min);
	}
}
