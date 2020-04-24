import java.io.*;
import java.util.StringTokenizer;
public class b_10971 {

	static int N;
	static boolean check[];
	static int W[][];
	static int arr[];
	static int min=10000001;
	static int first;
	
	private static void Search(int start,int value) {
		if(start==N-1) {
			if(W[value][first]==0) {
				return;
			}
			int sum=0;
			for(int i=0;i<N-1;i++) {
				sum+=arr[i];
			}
			sum+=W[value][first];
			if(min>sum)
				min=sum;
			return;
		}
		
		for(int i=0;i<N;i++) {
			if(W[value][i]==0)
				continue;
			if(start==0) {
				first=value;
				check[first]=true;
			}
			if(!check[i]) {
				check[i]=true;
				arr[start]=W[value][i];
				Search(start+1,i);
				check[i]=false;
			}
		}
	}
	
	public static void main(String[] args)throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(bf.readLine());
		check=new boolean[N];
		arr=new int[N];
		W=new int[N][N];
		
		for(int i=0;i<N;i++) {
			String line=bf.readLine();
			StringTokenizer st=new StringTokenizer(line," ");
			for(int j=0;j<N;j++) {
				W[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		Search(0,0);		
		System.out.print(min);
	}
}

// Áß¿ä ¹Ý·Ê
//4
//0 1 100 100
//0 0 3 0
//0 200 0 400
//1 1 1 0
