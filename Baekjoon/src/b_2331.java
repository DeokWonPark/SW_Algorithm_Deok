import java.io.*;
import java.util.*;
public class b_2331 {

	public static void main(String[] args)throws IOException{
		BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
		ArrayList<String> D=new ArrayList<String>();
		String line[]= bf.readLine().split(" ");
		D.add(line[0]);
		int p=Integer.parseInt(line[1]);
		Integer sum=0;
		int sum_temp=0;
		String vertex="";
		while(!D.contains(sum.toString())) {
			sum_temp=0;
			for(int i=0;i<D.get(D.size()-1).length();i++) {
				int c=Integer.parseInt(D.get(D.size()-1).substring(i, i+1));
				sum_temp+=Math.pow(c, p);
			}
			sum=sum_temp;
			if(D.contains(sum.toString())) {
				D.add(sum.toString());
				break;
			}
			D.add(sum.toString());
			sum=0;
		}
		String last=D.get(D.size()-1);
		int index=D.indexOf(last);
		System.out.print(index);
	}
}
