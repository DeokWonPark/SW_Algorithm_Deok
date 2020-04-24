import java.io.*;
public class b_1463 {

	public static void main(String[] args) throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in)); 
		
		int num=Integer.parseInt(bf.readLine());
		int memo[]=new int[num+1];
		memo[1]=0;
		int count=1000000;
		
		for(int i=2;i<=num;i++) {
			count=1000000;
			if(i%3==0) {
				if(count>memo[i/3]+1)
					count=memo[i/3]+1;
			}
			if(i%2==0) {
				if(count>memo[i/2]+1)
					count=memo[i/2]+1;
			}
			if(count>memo[i-1]+1)
				count=memo[i-1]+1;
			
			memo[i]=count;
		}
		System.out.print(memo[num]);
	}
}
