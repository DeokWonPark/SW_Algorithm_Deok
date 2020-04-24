import java.io.*;
import java.util.*;
public class b_1107_2 {

	public static void main(String[] args)throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		
		int N=Integer.parseInt(bf.readLine());
		int M=Integer.parseInt(bf.readLine());
		boolean ar[]=new boolean[10];
		
		if(M!=0) {
			String arr[]=bf.readLine().split(" ");
			for(int i=0;i<M;i++) {
				ar[Integer.parseInt(arr[i])]=true;
			}
		}
		
		int count=Math.abs(N-100);
		int result=0;
		boolean conti;
		for(int i=0;i<=888888;i++) {
			conti=false;
			String sN=Integer.toString(i);
			for(int j=sN.length();j>0;j--) {
				int tok=Integer.parseInt(sN.substring(j-1,j));
				if(ar[tok]==true) {
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
