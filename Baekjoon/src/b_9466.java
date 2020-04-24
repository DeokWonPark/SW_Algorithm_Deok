import java.io.*;
import java.util.*;
public class b_9466 {

	public static void main(String[] args) throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		int count=Integer.parseInt(bf.readLine());
		for(int i=0;i<count;i++) {
			int vertex=Integer.parseInt(bf.readLine());
			int arr[]=new int[vertex+1];
			boolean check[]=new boolean[vertex+1];
			
			String line[]=bf.readLine().split(" ");
			for(int j=1;j<=vertex;j++) {
				arr[j]=Integer.parseInt(line[j-1]);
			}
			
		}
		System.out.print(sb);
	}
}
