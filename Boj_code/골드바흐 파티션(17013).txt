import java.io.*;
import java.util.*;
public class b_17103 {
	public static void main(String[] args) throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		
		int count=Integer.parseInt(bf.readLine());
		boolean check[]=new boolean[1000001];
		check[1]=true;
		for(int i=2;i*i<=1000000;i++) {
			for(int j=i+i;j<=1000000;j+=i) {
				check[j]=true;
			}
		}
		for(int i=0;i<count;i++) {
			int value=0;
			int num=Integer.parseInt(bf.readLine());
			for(int j=2;j*2<=num;j++) {
				if(check[j]==false) {
					if(check[num-j]==false) {
						value++;
					}
				}
			}
			sb.append(value+"\n");
		}
		System.out.print(sb);
	}
}
