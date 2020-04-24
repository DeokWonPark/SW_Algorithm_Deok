import java.util.*;
import java.io.*;

public class b_10451 {

	public static void main(String[] args) throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		int count=Integer.parseInt(bf.readLine());
		StringBuilder sb=new StringBuilder();
		
		for(int c=0;c<count;c++) {
			int vertex=Integer.parseInt(bf.readLine());
			int arr[]=new int[vertex+1];
			boolean check[]=new boolean[vertex+1];
			StringTokenizer st=new StringTokenizer(bf.readLine());
			int i=1;
			while(st.hasMoreTokens()) {
				arr[i++]=Integer.parseInt(st.nextToken());
			}
			int counting=0;
			for(i=1;i<=vertex;i++) {
				if(check[i]==false) {
					counting++;
				}
				int j=i;
				while(check[j]==false) {
					check[j]=true;
					j=arr[j];
				}
			}
			sb.append(counting+"\n");
		}
		System.out.print(sb);
	}
}
