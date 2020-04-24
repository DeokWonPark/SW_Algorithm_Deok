import java.io.*;
import java.util.Arrays;
public class b_5052 {
	
	public static boolean check(String[] phone_book) {
        boolean answer = true;
        Arrays.sort(phone_book);
        for(int i=0;i<phone_book.length;i++) {
        	String tok=phone_book[i];
        	char firsti=tok.charAt(0);
        	for(int j=i+1;j<phone_book.length;j++) {
        		String test=phone_book[j];
        		char firstj=test.charAt(0);
        		if(firsti!=firstj) {
        			break;
        		}
        		else {
        			if(tok.length()>test.length()) {
        				continue;
        			}
        			String test_tok=test.substring(0,tok.length());
        			if(tok.equals(test_tok)) {
        				answer=false;
        				return answer;
        			}
        		}
        	}
        }
        return answer;
    }

	public static void main(String[] args)throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		
		int test_case=Integer.parseInt(bf.readLine());
		for(int c=0;c<test_case;c++) {
			
			int N=Integer.parseInt(bf.readLine());
			String phone_book[]=new String[N];
			for(int n=0;n<N;n++) {
				phone_book[n]=bf.readLine();
			}
			boolean ck=check(phone_book);
			if(ck==true)
				sb.append("YES\n");
			else
				sb.append("NO\n");
		}
		System.out.print(sb);
	}
}
