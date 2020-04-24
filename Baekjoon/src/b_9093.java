import java.io.*;
public class b_9093 {

	public static void main(String[] args)throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb= new StringBuilder();
		
		int count=Integer.parseInt(bf.readLine());
		for(int i=0;i<count;i++) {
			String arr[]=bf.readLine().split(" ");
			for(int j=0;j<arr.length;j++) {
				for(int k=arr[j].length()-1;k>=0;k--) {
					sb.append(arr[j].charAt(k));
				}
				sb.append(" ");
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}
}
