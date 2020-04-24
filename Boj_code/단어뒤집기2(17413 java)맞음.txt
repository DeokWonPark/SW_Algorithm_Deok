import java.io.*;
import java.util.*;
public class b_17413 {

	public static void main(String[] args) throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		Stack<Character>sk=new Stack<Character>();
		
		String line=bf.readLine();
		
		for(int i=0;i<line.length();i++) {
			char item=line.charAt(i);
			if(item=='<') {
				while(!sk.empty()) {
					sb.append(sk.pop());
				}
				sb.append(item);
				while(item!='>') {
					i++;
					item=line.charAt(i);
					sb.append(item);
				}
			}
			else if(item==' ') {
				while(!sk.empty()) {
					sb.append(sk.pop());
				}
				sb.append(item);
			}
			else {
				sk.push(item);
			}
		}
		while(!sk.empty()) {
			sb.append(sk.pop());
		}
		System.out.print(sb);
	}
}
