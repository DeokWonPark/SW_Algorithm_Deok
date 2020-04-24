import java.io.*;
public class b_1330 {

	public static void main(String[] args)throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		String line[]=bf.readLine().split(" ");
		int A=Integer.parseInt(line[0]);
		int B=Integer.parseInt(line[1]);
		if(A<B)
			System.out.print("<");
		else if(A>B)
			System.out.print(">");
		else
			System.out.print("==");
		
	}
}
