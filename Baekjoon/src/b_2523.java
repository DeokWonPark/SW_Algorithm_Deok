import java.io.*;
public class b_2523 {

	public static void main(String[] args)throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		
		int count=Integer.parseInt(bf.readLine());
		
		for(int i=1;i<=count;i++) {
			for(int j=0;j<i;j++) {
				sb.append("*");
			}
			sb.append("\n");
		}
		for(int i=count-1;i>0;i--) {
			for(int j=0;j<i;j++) {
				sb.append("*");
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}
}
