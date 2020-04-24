import java.io.*;
public class b_2556 {

	public static void main(String[] args) throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		
		int count =Integer.parseInt(bf.readLine());

		for(int i=1;i<=count;i++) {
			int length=(2*(i-1))+1;
			for(int j=1;j<=count-i;j++) {
				sb.append(" ");
			}
			sb.append("*");
			if(i==1) {
				sb.append("\n");
				continue;
			}
			for(int j=1;j<=length-2;j++) {
				sb.append(" ");
			}
			sb.append("*\n");
		}
		System.out.print(sb);
	}
}
