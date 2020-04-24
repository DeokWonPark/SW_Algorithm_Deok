import java.io.*;
import java.util.*;
public class b_1107 {

	public static void main(String[] args)throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		
		int N=Integer.parseInt(bf.readLine());
		int M=Integer.parseInt(bf.readLine());
		ArrayList<String> ar=new ArrayList<String>();
		
		if(M!=0) {
			String arr[]=bf.readLine().split(" ");
			for(int i=0;i<M;i++) {
				ar.add(arr[i]);
			}
		}
		
		int count=Math.abs(N-100);
		int result=0;
		boolean conti;
		for(int i=0;i<=888888;i++) {
			conti=false;
			String sN=Integer.toString(i);
			for(int j=sN.length();j>0;j--) {
				String tok=sN.substring(j-1,j);
				if(ar.contains(tok)) {
					i=(int) (i+(Math.pow(10,(sN.length()-j))));
					conti=true;
					i--;
					break;
				}
			}
			if(conti==true)
				continue;
			sN=Integer.toString(i);
			result=sN.length()+Math.abs((N-i));
			if(result<count) {
				count=result;
			}
		}
		System.out.print(count);
	}
}
