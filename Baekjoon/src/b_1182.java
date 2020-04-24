import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class b_1182 {

	public static void main(String[] args)throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		String line[]=bf.readLine().split(" ");
		int N=Integer.parseInt(line[0]);
		int S=Integer.parseInt(line[1]);
		
		String toks[]=bf.readLine().split(" ");
		int toki[]=new int[N];
		for(int i=0;i<N;i++) {
			toki[i]=Integer.parseInt(toks[i]);
		}
		int value=0;
		for(int i=1;i<=(1<<N)-1;i++) {
			int set=i;
			int sum=0;
			for(int j=0;j<N;j++) {
				if((set & (1<<j))!=0) {
					sum+=toki[j];
				}
			}
			if(sum==S) {
				value++;
			}
		}
		System.out.print(value);
	}
}
