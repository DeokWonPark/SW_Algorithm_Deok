import java.io.*;
public class b_10996 {

	public static void main(String[] args) throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		
		int count=Integer.parseInt(bf.readLine());
		if(count==1) {
			System.out.print("*");
			return;
		}
		for(int i=0;i<count*2;i++) {
			if(count%2==0) {
				for(int j=0;j<count/2;j++) {
					if(i%2!=0 && j==0) {
						sb.append(" ");
					}
					sb.append("*");
					if(j==count/2-1) {
						break;
					}
					sb.append(" ");
				}
				sb.append("\n");
			}
			else {
				for(int j=0;j<count/2+1;j++) {
					if(i%2!=0 && j==0) {
						sb.append(" ");
					}
					if(j==count/2 && i%2!=0) {
						break;
					}
					sb.append("*");
					if(j==count/2-1 && i%2!=0) {
						break;
					}
					if(j==count/2) {
						break;
					}
					sb.append(" ");
				}
				sb.append("\n");
			}
		}
		System.out.print(sb);
	}
}
