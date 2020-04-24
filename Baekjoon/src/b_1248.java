import java.io.*;
public class b_1248 {

	static int N;
	static String toks[];
	static int arr[];
	static int sum[];
	static StringBuilder sb=new StringBuilder();
	static boolean stop=false;
	
	static void Do(int start,int value) {
		if(start==N) {
			for(int i=0;i<N-1;i++) {
				sb.append(arr[i]+" ");
			}
			sb.append(arr[N-1]+"\n");
			stop=true;
			return;
		}
		
		for(int i=-10;i<=10;i++) {
			if(stop)
				return;
			sum[start]=i+value;
			int index=0;
			boolean flag=false;
			
			for(int j=0;j<=start;j++) {
				String tok;
				if(j==0) {
					tok=toks[start];
					index=start;
					if(tok.equals("+")) {
						if(sum[start]<=0) {
							flag=true;
							break;
						}
					}
					else if(tok.equals("-")) {
						if(sum[start]>=0) {
							flag=true;
							break;
						}
					}
					else {
						if(sum[start]!=0) {
							flag=true;
							break;
						}
					}
				}
				else {
					tok=toks[index+N-j];
					index=index+N-j;
					
					if(tok.equals("+")) {
						if(sum[start]-sum[j-1]<=0) {
							flag=true;
							break;
						}
					}
					else if(tok.equals("-")) {
						if(sum[start]-sum[j-1]>=0) {
							flag=true;
							break;
						}
					}
					else {
						if(sum[start]-sum[j-1]!=0) {
							flag=true;
							break;
						}
					}
				}
				
			}
			if(flag) {
				continue;
			}
			else
			{
				arr[start]=i;
				Do(start+1,sum[start]);
			}
		}
	}
	
	public static void main(String[] args)throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		
		N=Integer.parseInt(bf.readLine());
		String line=bf.readLine();
		toks=new String[((N*(N+1))/2)];
		for(int i=0;i<((N*(N+1))/2);i++) {
			toks[i]=line.substring(i,i+1);
		}
		arr=new int[N];
		sum=new int[N];
		
		Do(0,0);
		System.out.print(sb);
	}
}
