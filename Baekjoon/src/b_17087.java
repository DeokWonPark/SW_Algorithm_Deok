import java.io.*;
import java.util.*;
public class b_17087 {
	
	static int GCD(int a,int b) {
		if(b==0)
			return a;
		else
			return GCD(b,a%b);
	}

	public static void main(String[] args)throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		
		String arr1[]=bf.readLine().split(" ");
		int bro=Integer.parseInt(arr1[0]);
		int S=Integer.parseInt(arr1[1]);
		
		String Line=bf.readLine();
		
		if(bro==1) {
			System.out.print(Math.abs(S-Integer.parseInt(Line)));
			return;
		}
		StringTokenizer st=new StringTokenizer(Line," ");
		ArrayList<Integer> ar=new ArrayList<Integer>();
		while(st.hasMoreTokens()) {
			ar.add(Math.abs(S-Integer.parseInt(st.nextToken())));
		}
		int gcd=GCD(ar.get(0),ar.get(1));
		for(int i=2;i<ar.size();i++) {
			gcd=GCD(gcd,ar.get(i));
		}
		System.out.print(gcd);
	}
}
