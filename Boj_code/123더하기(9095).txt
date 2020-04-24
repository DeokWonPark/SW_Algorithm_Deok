import java.io.*;
public class b_9095 {

	public static void main(String[] args) throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		
		int count=Integer.parseInt(bf.readLine());
		int memo[]=new int[12];
		memo[1]=1;
		memo[2]=2;
		memo[3]=4;
		for(int i=4;i<=11;i++) {
			memo[i]=memo[i-1]+memo[i-2]+memo[i-3];
		}
		
		for(int i=0;i<count;i++) {
			int num=Integer.parseInt(bf.readLine());
			sb.append(memo[num]+"\n");
		}
		System.out.print(sb);
	}
}
