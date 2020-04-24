import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class b_1182_recursive {
	static int N;
	static int S;
	static int toki[];
	static int value=0;
	
	static void sum(int start, int sum) {
		if(start==N) {
			if(sum==S) {
				value++;
			}
			return;
		}
		
		sum(start+1,sum+toki[start]);
		sum(start+1,sum);
	}

	public static void main(String[] args)throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		String line[]=bf.readLine().split(" ");
		N=Integer.parseInt(line[0]);
		S=Integer.parseInt(line[1]);
		
		String toks[]=bf.readLine().split(" ");
		toki=new int[N];
		for(int i=0;i<N;i++) {
			toki[i]=Integer.parseInt(toks[i]);
		}
		sum(0,0);
		if(S==0)
			value-=1;
		System.out.print(value);
	}
}
