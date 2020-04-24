import java.io.*;
public class b_2443 {

	public static void main(String[] args) throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		int count=Integer.parseInt(bf.readLine());
		int N=2*count-1;
		
		for(int i=0;i<count;i++) {
			int cur_N=2*(count-i)-1;
			int check=0;
			for(int j=0;j<N;j++) {
				if(j<i) {
					sb.append(" ");
				}
				else {
					sb.append("*");
					check++;
					if(check==cur_N) {
						break;
					}
				}
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}
}
