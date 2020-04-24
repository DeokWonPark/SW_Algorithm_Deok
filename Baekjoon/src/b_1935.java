import java.io.*;
import java.text.DecimalFormat;
import java.util.*;
public class b_1935 {

	public static void main(String[] args) throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		Stack<Double>sk=new Stack<Double>();
		
		int count=Integer.parseInt(bf.readLine());
		double arr[]=new double[count+1];
		
		String line=bf.readLine();
		
		for(int i=1;i<=count;i++) {
			arr[i]=Double.parseDouble(bf.readLine());
		}
		
		for(int i=0;i<line.length();i++) {
			char tok=line.charAt(i);
			if(tok>=65 && tok<=90) { //피연산자
				sk.push((arr[tok-64]));
			}
			else {
				switch(tok) {
				case '*':
					double item=sk.pop();
					sk.push(sk.pop()*item);
					break;
				case '/':
					item=sk.pop();
					sk.push(sk.pop()/item);
					break;
				case '+':
					item=sk.pop();
					sk.push(sk.pop()+item);
					break;
				case '-':
					item=sk.pop();
					sk.push(sk.pop()-item);
					break;
				default:
					break;
				}
			}
		}
		
		DecimalFormat form =new DecimalFormat("#.##");
		System.out.printf("%04.2f",sk.pop());
	}
}
