import java.io.*;
import java.util.*;
public class b_2004 {

	public static void main(String[] args)throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		
		String arr[]=bf.readLine().split(" ");
		int n=Integer.parseInt(arr[0]);
		int m=Integer.parseInt(arr[1]);
		int top=0,buttom=0;
		
		int twoc=0,fivec=0;
		for(int i=2;i<=n;i++) {
			int two=2,five=5;
			while(i>=two || i>=five) {
				if(i%two==0) {
					twoc++;
					two*=2;
				}
				else if(i%five==0) {
					fivec++;
					five*=5;
				}
				else
					break;
			}
			if(i==n-m) {
				buttom+=Math.min(twoc, fivec);
			}
			if(i==m) {
				buttom+=Math.min(twoc, fivec);
			}
		}
		
		top=Math.min(twoc, fivec);
		
		System.out.print(top-buttom);
	}
}
