import java.io.*;
public class b_1748 {

	public static void main(String[] args)throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		String line=bf.readLine();
		int c=line.length();
		int result=c;
		int N=Integer.parseInt(line);
		for(;c>=1;c--) {
			int M=(int) Math.pow(10, c-1);
			int tok=N-M;
			result+=(tok*c);
			N=M;
		}
		System.out.print(result);
	}
}
