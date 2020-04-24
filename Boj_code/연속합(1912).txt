import java.io.*;
public class b_1912 {

	public static void main(String[] args)throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		
		int N=Integer.parseInt(bf.readLine());
		int memo[]=new int[N];
		String line[]=bf.readLine().split(" ");
		int max=0;
		for(int i=0;i<line.length;i++) {
			int num=Integer.parseInt(line[i]);
			if(i==0) {
				memo[i]=num;
				max=num;
				continue;
			}
			if(num>memo[i-1]+num) {
				memo[i]=num;
			}
			else {
				memo[i]=memo[i-1]+num;
			}
			if(max<memo[i])
				max=memo[i];
		}
		System.out.print(max);
	}
}
