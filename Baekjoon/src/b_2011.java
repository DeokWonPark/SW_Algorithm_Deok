import java.io.*;
public class b_2011 {

	public static void main(String[] args)throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		String num=bf.readLine();
		if(num.charAt(0)=='0') {
			System.out.print(0);
			return;
		}
		int memo[]=new int[num.length()+1];
		memo[0]=1;
		if(num.charAt(num.length()-1)=='0')
			memo[1]=0;
		else
			memo[1]=1;
		int s=2;
		int r=1000000;
		for(int i=num.length()-1;i>0;i--) {
			if(num.charAt(i)=='0') {
				if(num.charAt(i-1)!=49 && num.charAt(i-1)!=50) {
					System.out.print(0);
					return;
				}
			}
			if(num.charAt(i-1)=='0') {
				memo[s]=0;
				s++;
				continue;
			}
			String n=num.substring(i-1,i+1);
			int in=Integer.parseInt(n);
			if(in<27) {
				memo[s]=((memo[s-1]%r)+(memo[s-2]%r))%r;
			}
			else {
				memo[s]=memo[s-1];
			}
			s++;
		}
		System.out.print(memo[num.length()]);
	}
}
