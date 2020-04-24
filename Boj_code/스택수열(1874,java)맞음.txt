import java.io.*;
import java.util.*;
public class b_1874_2 {

	public static void main(String[] args) throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		Stack<Integer> sk=new Stack<Integer>();
		
		int count=Integer.parseInt(bf.readLine());
		int point=1;
		for(int i=1;i<=count;i++) {
			int input=Integer.parseInt(bf.readLine());
			if(input>=point) {
				while(point<=input) {
					sk.push(point++);
					sb.append("+\n");
				}
				sk.pop();
				sb.append("-\n");
			}
			else if(input<point) {
				int item=sk.pop();
				sb.append("-\n");
				if(item!=input) {
					System.out.print("NO");
					return;
				}
			}
		}
		System.out.print(sb);
	}
}
