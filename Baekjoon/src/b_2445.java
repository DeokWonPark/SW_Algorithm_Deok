import java.io.*;
public class b_2445 {

	public static void main(String[] agrs) throws IOException{
		BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		
		int count=Integer.parseInt(bf.readLine());
		
		for(int i=1;i<=count;i++) {
			for(int j=0;j<2*count;j++) {
				if(j<i || j>=2*count-i) {
					sb.append("*");
				}
				else {
					sb.append(" ");
				}
			}
			sb.append("\n");
		}
		
		for(int i=count-1;i>=1;i--) {
			for(int j=2*count-1;j>=0;j--) {
				if(j<i || j>=2*count-i) {
					sb.append("*");
				}
				else {
					sb.append(" ");
				}
			}
			sb.append("\n");
		}
		
		System.out.print(sb);
	}
}
