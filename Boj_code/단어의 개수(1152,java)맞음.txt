import java.io.*;
public class b_1152 {

	public static void main(String[] args) throws IOException{
		BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
		String line=bf.readLine();
		if(line.equals(" ")) {
			System.out.print(0);
			return;
		}
		String arr[]=line.split(" ");
		int length=arr.length;
		if(arr[0].length()==0)
			length--;
		if(arr[arr.length-1].length()==0)
			length--;
		
		System.out.print(length);
	}
}
