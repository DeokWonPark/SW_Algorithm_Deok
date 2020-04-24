import java.io.*;
import java.util.StringTokenizer;
public class b_11723 {

	public static void main(String[] args)throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		int N=Integer.parseInt(bf.readLine());
		int S=0;
		
		for(int i=0;i<N;i++) {
			String line=bf.readLine();
			StringTokenizer st=new StringTokenizer(line," ");
			String cmd=st.nextToken();
			int value=0;
			if(st.countTokens()==1) {
				value=Integer.parseInt(st.nextToken());
			}
			switch(cmd) {
			case "add":
				S= S | (1<<value);
				break;
				
			case "remove":
				S= S & (~(1<<value));
				break;
				
			case "check":
				if((S & (1<<value))==0) {
					sb.append(0+"\n");
				}
				else
					sb.append(1+"\n");
				break;
				
			case "toggle":
				S= S ^ (1<<value);
				break;
				
			case "all":
				S=(1<<21)-1;
				break;
				
			case "empty":
				S=0;
				break;
				
			default:
				break;
				
			}
		}
		System.out.print(sb);
	}
}
