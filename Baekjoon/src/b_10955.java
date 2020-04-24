import java.io.*;
public class b_10955 {

	public static void main(String[] args) throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		
		int count=Integer.parseInt(bf.readLine());
		
		for(int i=0;i<count;i++) {
			for(int j=0;j<count;j++) {
				if(i%2!=0 && j==0) {
					sb.append(" ");
				}
				sb.append("*");
				if(j==count-1)
					break;
				sb.append(" ");
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}
}
