import java.io.*;
public class b_13015 {

	public static void main(String[] args) throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb= new StringBuilder();
		
		int count=Integer.parseInt(bf.readLine());
		int end=2*(count-2)+1;

		for(int i=0;i<2*count+end;i++) {
			if(i<count || i>=count+end)
				sb.append("*");
			else
				sb.append(" ");
		}
		sb.append("\n");
		
		int one,two,three,four;
		one=0;two=count-1;three=count+end;four=2*count+end-1;
		for(int i=1;i<=count-1;i++) {
			for(int j=0;j<2*count+end-i;j++) {
				if(j==(one+i) || j==(two+i) || j==three-i || j==four-i) {
					sb.append("*");
				}
				else
					sb.append(" ");
				if(i==count-1 && j==2*count+end-i-1) {
					one=one+i;
					two=two+i;
					three=three-i;
					four=four-i;
				}
			}
			sb.append("\n");
		}
		
		for(int i=1;i<=count-2;i++) {
			for(int j=0;j<four+i+1;j++) {
				if(j==one-i || j==two-i || j==three+i || j==four+i) {
					sb.append("*");
				}
				else
					sb.append(" ");
			}
			sb.append("\n");
			
		}
	
		for(int i=0;i<2*count+end;i++) {
			if(i<count || i>=count+end)
				sb.append("*");
			else
				sb.append(" ");
		}
		
		
		System.out.print(sb);
	}
}
