import java.io.*;
import java.util.*;
public class b_1406_2 {

	public static void main(String[] args)throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb= new StringBuilder();
		
		Stack<Character>sk1=new Stack<Character>();
		Stack<Character>sk2=new Stack<Character>();
		
		String line=bf.readLine();
		for(int i=0;i<line.length();i++) {
			sk1.push(line.charAt(i));
		}
		int count=Integer.parseInt(bf.readLine());
		char item;
		for(int i=0;i<count;i++) {
			String arr[]=bf.readLine().split(" ");
			switch(arr[0]) {
			case"L":
				if(!sk1.empty()) {
					item=sk1.pop();
					sk2.push(item);
				}
				break;
			case"D":
				if(!sk2.empty()) {
					item=sk2.pop();
					sk1.push(item);
				}
				break;
			case"B":
				if(!sk1.empty()) {
					sk1.pop();
				}
				break;
			case"P":
				sk1.push(arr[1].charAt(0));
				break;
			}
		}
		int size=sk1.size();
		for(int i=0;i<size;i++) {
			item=sk1.pop();
			sk2.push(item);
		}
		size=sk2.size();
		for(int i=0;i<size;i++) {
			item=sk2.pop();
			sb.append(item);
		}
		System.out.print(sb);
	}
}
