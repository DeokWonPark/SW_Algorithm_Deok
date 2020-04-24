import java.io.*;
import java.util.Stack;
public class b_10972 {

	public static void main(String[] args)throws IOException{
		BufferedReader bf=new BufferedReader (new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		int N=Integer.parseInt(bf.readLine());
		String line[]=bf.readLine().split(" ");
		int toks[]=new int[N];
		for(int i=0;i<N;i++) {
			toks[i]=Integer.parseInt(line[i]);
		}
	
		boolean result=Next(toks);
		if(result==false) {
			System.out.print(-1);
			return;
		}
		for(int i=0;i<N-1;i++) {
			sb.append(toks[i]+" ");
		}
		sb.append(toks[N-1]);
		System.out.print(sb);
	}
	
	private static boolean Next(int toks[]) {
		int i,j=0;
		for(i=toks.length-1;i>0;i--) {
			if(toks[i-1]<toks[i]) {
				break;
			}
		}
		if(i==0)
			return false;
		
		int min=10001;
		for(int k=i;k<toks.length;k++) {
			if(toks[i-1]<toks[k]) {
				if(toks[k]<min) {
					min=toks[k];
					j=k;
				}
			}
		}
		toks[j]=toks[i-1];
		toks[i-1]=min;
		Stack<Integer>sk=new Stack<Integer>();
		for(int k=i;k<toks.length;k++) {
			sk.push(toks[k]);
		}
		for(int k=i;k<toks.length;k++) {
			toks[k]=sk.pop();
		}
		return true;
	}
}
