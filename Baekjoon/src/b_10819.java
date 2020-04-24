import java.io.*;
import java.util.Arrays;
import java.util.Stack;
public class b_10819 {
	public static void main(String[] args)throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(bf.readLine());
		int toks[]=new int[N];
		String line[]=bf.readLine().split(" ");
		for(int i=0;i<N;i++) {
			toks[i]=Integer.parseInt(line[i]);
		}
		Arrays.sort(toks);
		int max=0;
		do {
			int sum=0;
			for(int i=0;i<N-1;i++) {
				sum+=Math.abs(toks[i]-toks[i+1]);
			}
			if(max<sum)
				max=sum;
		}while(Next(toks));
		System.out.print(max);
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
		int min=101;
		for(int k=i;k<toks.length;k++) {
			if(toks[i-1]<toks[k]) {
				if(min>toks[k]) {
					min=toks[k];
					j=k;
				}
			}
		}
		toks[j]=toks[i-1];
		toks[i-1]=min;
		Stack<Integer> sk=new Stack<Integer>();
		for(int k=i;k<toks.length;k++) {
			sk.push(toks[k]);
		}
		for(int k=i;k<toks.length;k++) {
			toks[k]=sk.pop();
		}
		return true;
	}
}
