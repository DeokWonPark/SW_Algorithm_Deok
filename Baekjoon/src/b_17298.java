import java.io.*;
import java.util.*;
public class b_17298 {

	public static void main(String[] args) throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		
		Stack<Integer> sk1=new Stack<Integer>();
		Stack<Integer> sk2=new Stack<Integer>();
		Stack<Integer> sk3=new Stack<Integer>();
		bf.readLine();
		
		String line=bf.readLine();
		StringTokenizer st=new StringTokenizer(line," ");
		while(st.hasMoreTokens()) {
			sk1.push(Integer.parseInt(st.nextToken()));
		}
		
		sk2.push(sk1.pop());
		sk3.push(-1);
		while(!sk1.empty()) {
			
			int item=sk1.pop();
			
			if(sk2.empty()) {
				sk3.push(-1);
				sk2.push(item);
				continue;
			}
			
			while(true) {
				if(item<sk2.peek()) {
					sk3.push(sk2.peek());
					sk2.push(item);
					break;
				}
				else {
					sk2.pop();
					if(sk2.empty()) {
						sk3.push(-1);
						sk2.push(item);
						break;
					}
				}
			}
			
		}
		while(!sk3.empty()) {
			sb.append(sk3.pop()+" ");
		}
		System.out.println(sb);
	}
}
