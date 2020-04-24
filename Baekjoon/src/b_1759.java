import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
public class b_1759 {
	private static int L,C;
	private static String arr[];
	private static String toks[];
	private static HashSet<String> set;
	private static StringBuilder sb=new StringBuilder();
	
	private static void Password(int start,int value) {
		int mcount=0,count=0;
		String ck="";
		if(start==L) {
			for(int i=0;i<L;i++) {
				ck+=arr[i];
				if(set.add(arr[i])) {
					set.remove(arr[i]);
					count++;
				}
				else {
					mcount++;
				}
			}
			ck+="\n";
			if(mcount>=1 && count>=2) {
				sb.append(ck);
			}
			return;
		}
		
		for(int i=value;i<=C-L+start;i++) {
			arr[start]=toks[i];
			Password(start+1,i+1);
		}
	}

	public static void main (String[] args)throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		
		String line[]=bf.readLine().split(" ");
		L=Integer.parseInt(line[0]);
		C=Integer.parseInt(line[1]);
		toks=bf.readLine().split(" ");
		arr=new String[L];
		set=new HashSet<String>();
		set.add("a");set.add("e");set.add("i");set.add("o");set.add("u");
		
		Arrays.sort(toks);
		Password(0,0);
		System.out.print(sb);
	}
}
