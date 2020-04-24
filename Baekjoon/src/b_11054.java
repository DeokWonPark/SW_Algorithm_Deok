import java.util.*;
import java.io.*;
public class b_11054 {

	public static void main(String [] args) throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		int count=Integer.parseInt(bf.readLine());
		String line[]=bf.readLine().split(" ");
		int dp[][]=new int[count][2];
		int tok[]=new int[count];
		int tokr[]=new int[count];
		
		for(int i=0;i<count;i++) {
			tok[i]=Integer.parseInt(line[i]);
		}
		for(int i=0;i<count;i++) {
			tokr[i]=tok[count-i-1];
		}
		int result=0;
		for(int i=0;i<count;i++) {
			dp[i][0]=1;
			dp[i][1]=1;
			int max=0;
			int max2=0;
			for(int j=0;j<i;j++) {
				if(tok[i]>tok[j] && max<(dp[j][0]+1)) {
					max=(dp[j][0]+1);
					dp[i][0]=max;
				}
				if(tokr[i]>tokr[j] && max2<(dp[j][1]+1)) {
					max2=(dp[j][1]+1);
					dp[i][1]=max2;
				}
			}
		}
		for(int i=0;i<count;i++) {
			if(result<(dp[i][0]+dp[count-1-i][1])) {
				result=(dp[i][0]+dp[count-1-i][1]);
			}
		}
		System.out.print(result-1);
	}
}
