import java.io.*;
public class b_1110 {

	public static void main(String[] args)throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		
		String line=bf.readLine();
		if(line.length()==1) {
			line="0"+line;
		}
		int N1=Integer.parseInt(line.substring(0,1));
		int N2=Integer.parseInt(line.substring(1,2));
		int result,count=0;
		result=Integer.parseInt(line);
		
		do {
			N1=result/10;
			N2=result%10;
			result=N1+N2;
			if(result<10) {
				result=(N2*10)+result;
			}
			else {
				result=(N2*10)+(result%10);
			}
			count++;
		} while(result!=Integer.parseInt(line));
		System.out.print(count);
	}
}
